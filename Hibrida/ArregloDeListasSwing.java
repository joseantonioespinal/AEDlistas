import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArregloDeListasSwing extends JFrame {
    private JTextField nombreTextField;
    private JButton agregarButton;
    private JTextArea mostrarTextArea;
    private JScrollPane scrollPane;
    private ListaEnlazada[] arreglo;

    public ArregloDeListasSwing() {
        // Inicializar la estructura de datos
        arreglo = new ListaEnlazada[26];
        for (int i = 0; i < 26; i++) {
            arreglo[i] = new ListaEnlazada();
        }

        // Configurar el formulario
        setTitle("Arreglo de Listas Enlazadas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Crear componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(100, 100, 100, 25);
        add(nombreLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(100, 10, 200, 25);
        add(nombreTextField);

        agregarButton = new JButton("Agregar");
        agregarButton.setBounds(100, 50, 200, 25);
        add(agregarButton);

        // Crear JTextArea y agregarlo dentro de un JScrollPane
        mostrarTextArea = new JTextArea();
        mostrarTextArea.setEditable(false); // Hacer que el JTextArea sea de solo lectura

        // Crear un JScrollPane para permitir el scroll en el JTextArea
        scrollPane = new JScrollPane(mostrarTextArea);
        scrollPane.setBounds(10, 90, 360, 150);
        add(scrollPane);

        // Acción al presionar el botón "Agregar"
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                if (!nombre.isEmpty()) {
                    insertarEnArreglo(arreglo, nombre);
                    nombreTextField.setText(""); // Limpiar el campo de texto
                    mostrarArregloDeListas(arreglo); // Actualizar la visualización
                }
            }
        });
    }

    // Función para determinar el índice del arreglo basado en la letra inicial
    public static int obtenerIndicePorLetra(char letra) {
        return Character.toLowerCase(letra) - 'a';
    }

    // Insertar un nombre de usuario en la lista correspondiente
    public void insertarEnArreglo(ListaEnlazada[] arreglo, String nombre) {
        int indice = obtenerIndicePorLetra(nombre.charAt(0));
        arreglo[indice].insertar(nombre);
        
    }

    // Mostrar todas las listas enlazadas del arreglo
    public void mostrarArregloDeListas(ListaEnlazada[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].mostrar().length() > 0) {
                sb.append("Lista para la letra ").append((char) ('A' + i)).append(":\n");
                sb.append(arreglo[i].mostrar()).append("\n");
            }
        }
        mostrarTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Iniciar la aplicación Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArregloDeListasSwing().setVisible(true);
            }
        });
    }
}
