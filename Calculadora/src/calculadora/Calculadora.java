package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField textField;
    private double num1, num2, resultado;
    private char operador;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 10, 270, 40);
        panel.add(textField);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        ActionListener listener = new ButtonClickListener();

        int x = 10, y = 60;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBounds(x, y, 60, 40);

            // Cambiar el color de fondo del botón "=" a azul
            if (label.equals("=")) {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.WHITE); // Color de texto blanco para contraste
            }

            button.addActionListener(listener);
            panel.add(button);
            x += 70;
            if (x > 220) {
                x = 10;
                y += 50;
            }
        }

        this.add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                textField.setText(textField.getText() + command);
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());

                switch (operador) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            textField.setText("Error: División por cero");
                            return;
                        }
                        break;
                    default:
                        return;
                }

                textField.setText(String.valueOf(resultado));
                operador = '\0';
            } else {
                if (!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operador = command.charAt(0);
                    textField.setText("");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}
