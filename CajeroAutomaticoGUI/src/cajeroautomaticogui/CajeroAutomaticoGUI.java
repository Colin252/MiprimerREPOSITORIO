package cajeroautomaticogui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajeroAutomaticoGUI {
    private static double saldo = 1000.00;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cajero Automático");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel saldoLabel = new JLabel("Saldo actual: $" + saldo);
        saldoLabel.setBounds(10, 20, 200, 25);
        panel.add(saldoLabel);

        JButton consultarButton = new JButton("Consultar Saldo");
        consultarButton.setBounds(10, 50, 150, 25);
        panel.add(consultarButton);

        JLabel retirarLabel = new JLabel("Cantidad a retirar:");
        retirarLabel.setBounds(10, 90, 150, 25);
        panel.add(retirarLabel);

        JTextField retirarText = new JTextField(20);
        retirarText.setBounds(150, 90, 165, 25);
        panel.add(retirarText);

        JButton retirarButton = new JButton("Retirar");
        retirarButton.setBounds(10, 120, 150, 25);
        panel.add(retirarButton);

        JLabel depositarLabel = new JLabel("Cantidad a depositar:");
        depositarLabel.setBounds(10, 160, 150, 25);
        panel.add(depositarLabel);

        JTextField depositarText = new JTextField(20);
        depositarText.setBounds(150, 160, 165, 25);
        panel.add(depositarText);

        JButton depositarButton = new JButton("Depositar");
        depositarButton.setBounds(10, 190, 150, 25);
        panel.add(depositarButton);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == consultarButton) {
                    saldoLabel.setText("Saldo actual: $" + saldo);
                } else if (e.getSource() == retirarButton) {
                    double cantidad = Double.parseDouble(retirarText.getText());
                    if (cantidad <= saldo) {
                        saldo -= cantidad;
                        saldoLabel.setText("Saldo actual: $" + saldo);
                    } else {
                        JOptionPane.showMessageDialog(panel, "Fondos insuficientes. Intente con una cantidad menor.");
                    }
                } else if (e.getSource() == depositarButton) {
                    double cantidad = Double.parseDouble(depositarText.getText());
                    saldo += cantidad;
                    saldoLabel.setText("Saldo actual: $" + saldo);
                }
            }
        };

        consultarButton.addActionListener(actionListener);
        retirarButton.addActionListener(actionListener);
        depositarButton.addActionListener(actionListener);
    }
}
