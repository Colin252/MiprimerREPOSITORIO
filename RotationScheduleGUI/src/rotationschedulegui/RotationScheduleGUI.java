import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotationScheduleGUI {
    private static String[][] rotation = {
        {"X43", "X41", "S2", "X8", "BK"}, // COLOR CELESTE
        {"6", "X4", "X5", "2", "BK"}, // COLOR VERDE
        {"X23", "X42", "SH A-B", "X11", "BK"}, // COLOR CELESTE
        {"X50", "X13", "P2", "X21", "BK"}, // COLOR VERDE
        {"J2", "S1", "29", "17", "BK"}, // COLOR CELESTE
        {"X35", "X22", "SH VIP", "X19", "BK"}, // COLOR VERDE
        {"X12", "X27", "X26", "X3", "BK"}, // COLOR CELESTE
        {"X15", "X53", "SH B-C", "B2", "BK"} // COLOR VERDE
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotation Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700); // Aumentamos el tamaño del frame para acomodar las configuraciones

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(rotation.length, rotation[0].length + 1));
        JTextField[][] textFields = new JTextField[rotation.length][rotation[0].length];

        for (int i = 0; i < rotation.length; i++) {
            JLabel rowLabel = new JLabel(String.valueOf(i + 1));
            rowLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gridPanel.add(rowLabel);
            for (int j = 0; j < rotation[i].length; j++) {
                textFields[i][j] = new JTextField(rotation[i][j]);
                textFields[i][j].setFont(new Font("Arial", Font.BOLD, 12)); // Texto en negrita
                if (i % 2 == 0) { // Filas pares (0, 2, 4, 6) - COLOR CELESTE
                    textFields[i][j].setBackground(new Color(173, 216, 230)); // Celeste
                } else { // Filas impares (1, 3, 5, 7) - COLOR VERDE
                    textFields[i][j].setBackground(Color.GREEN);
                }
                gridPanel.add(textFields[i][j]);
            }
        }

        JTextArea commentsArea = new JTextArea(5, 30);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(commentsArea);

        // Panel para cambiar el tamaño y el color de la letra
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new FlowLayout());

        JLabel fontSizeLabel = new JLabel("Tamaño de letra:");
        JComboBox<Integer> fontSizeComboBox = new JComboBox<>(new Integer[]{10, 12, 14, 16, 18, 20});
        fontSizeComboBox.setSelectedItem(12);

        JLabel fontColorLabel = new JLabel("Color de letra:");
        JComboBox<String> fontColorComboBox = new JComboBox<>(new String[]{"Negro", "Rojo", "Azul", "Verde"});
        fontColorComboBox.setSelectedItem("Negro");

        JButton applyButton = new JButton("Aplicar");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fontSize = (int) fontSizeComboBox.getSelectedItem();
                String fontColor = (String) fontColorComboBox.getSelectedItem();
                Color color;

                switch (fontColor) {
                    case "Rojo":
                        color = Color.RED;
                        break;
                    case "Azul":
                        color = Color.BLUE;
                        break;
                    case "Verde":
                        color = Color.GREEN;
                        break;
                    default:
                        color = Color.BLACK;
                        break;
                }

                for (int i = 0; i < rotation.length; i++) {
                    for (int j = 0; j < rotation[i].length; j++) {
                        textFields[i][j].setFont(new Font("Arial", Font.BOLD, fontSize));
                        textFields[i][j].setForeground(color);
                    }
                }

                commentsArea.setFont(new Font("Arial", Font.BOLD, fontSize));
                commentsArea.setForeground(color);
            }
        });

        settingsPanel.add(fontSizeLabel);
        settingsPanel.add(fontSizeComboBox);
        settingsPanel.add(fontColorLabel);
        settingsPanel.add(fontColorComboBox);
        settingsPanel.add(applyButton);

        panel.add(gridPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.NORTH); // Añadir el área de comentarios en la parte superior
        panel.add(settingsPanel, BorderLayout.SOUTH); // Añadir el panel de configuración en la parte inferior
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
