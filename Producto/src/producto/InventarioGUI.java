import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventarioGUI {
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventario de Bodega");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nombreLabel = new JLabel("Nombre del producto:");
        nombreLabel.setBounds(10, 20, 150, 25);
        panel.add(nombreLabel);

        JTextField nombreText = new JTextField(20);
        nombreText.setBounds(160, 20, 165, 25);
        panel.add(nombreText);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(10, 50, 150, 25);
        panel.add(categoriaLabel);

        JTextField categoriaText = new JTextField(20);
        categoriaText.setBounds(160, 50, 165, 25);
        panel.add(categoriaText);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setBounds(10, 80, 150, 25);
        panel.add(precioLabel);

        JTextField precioText = new JTextField(20);
        precioText.setBounds(160, 80, 165, 25);
        panel.add(precioText);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(10, 110, 150, 25);
        panel.add(cantidadLabel);

        JTextField cantidadText = new JTextField(20);
        cantidadText.setBounds(160, 110, 165, 25);
        panel.add(cantidadText);

        JButton ingresarButton = new JButton("Ingresar producto");
        ingresarButton.setBounds(10, 140, 180, 25);
        panel.add(ingresarButton);

        JButton retirarButton = new JButton("Retirar producto");
        retirarButton.setBounds(200, 140, 180, 25);
        panel.add(retirarButton);

        JButton actualizarButton = new JButton("Actualizar producto");
        actualizarButton.setBounds(10, 170, 180, 25);
        panel.add(actualizarButton);

        JButton consultarNombreButton = new JButton("Consultar por nombre");
        consultarNombreButton.setBounds(200, 170, 180, 25);
        panel.add(consultarNombreButton);

        JButton consultarCantidadButton = new JButton("Consultar cantidad");
        consultarCantidadButton.setBounds(10, 200, 180, 25);
        panel.add(consultarCantidadButton);

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setBounds(10, 230, 560, 100);
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ingresarButton) {
                    String nombre = nombreText.getText();
                    String categoria = categoriaText.getText();
                    double precio = Double.parseDouble(precioText.getText());
                    int cantidad = Integer.parseInt(cantidadText.getText());
                    inventario.add(new Producto(nombre, categoria, precio, cantidad));
                    resultadoArea.setText("Producto ingresado: " + nombre);
                } else if (e.getSource() == retirarButton) {
                    String nombre = nombreText.getText();
                    for (Producto producto : inventario) {
                        if (producto.getNombre().equals(nombre)) {
                            inventario.remove(producto);
                            resultadoArea.setText("Producto retirado: " + nombre);
                            break;
                        }
                    }
                } else if (e.getSource() == actualizarButton) {
                    String nombre = nombreText.getText();
                    for (Producto producto : inventario) {
                        if (producto.getNombre().equals(nombre)) {
                            double nuevoPrecio = Double.parseDouble(precioText.getText());
                            int nuevaCantidad = Integer.parseInt(cantidadText.getText());
                            producto.setPrecio(nuevoPrecio);
                            producto.setCantidad(nuevaCantidad);
                            resultadoArea.setText("Producto actualizado: " + nombre);
                            break;
                        }
                    }
                } else if (e.getSource() == consultarNombreButton) {
                    String nombre = nombreText.getText();
                    for (Producto producto : inventario) {
                        if (producto.getNombre().equals(nombre)) {
                            resultadoArea.setText("Producto encontrado: \nNombre: " + producto.getNombre() +
                                    "\nCategoría: " + producto.getCategoria() +
                                    "\nPrecio: $" + producto.getPrecio() +
                                    "\nCantidad: " + producto.getCantidad());
                            break;
                        }
                    }
                } else if (e.getSource() == consultarCantidadButton) {
                    resultadoArea.setText("Inventario: ");
                    for (Producto producto : inventario) {
                        resultadoArea.append("\nNombre: " + producto.getNombre() + " - Cantidad: " + producto.getCantidad());
                    }
                }
            }
        };

        ingresarButton.addActionListener(actionListener);
        retirarButton.addActionListener(actionListener);
        actualizarButton.addActionListener(actionListener);
        consultarNombreButton.addActionListener(actionListener);
        consultarCantidadButton.addActionListener(actionListener);
    }
}
