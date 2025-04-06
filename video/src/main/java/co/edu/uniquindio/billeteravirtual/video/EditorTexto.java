package co.edu.uniquindio.billeteravirtual.video;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EditorTexto extends JFrame {
    private JTextArea areaTexto;
    private JFileChooser fileChooser;

    public EditorTexto() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        areaTexto = new JTextArea();
        fileChooser = new JFileChooser();

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem abrirItem = new JMenuItem("Abrir");
        abrirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArchivo();
            }
        });

        JMenuItem guardarItem = new JMenuItem("Guardar");
        guardarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });

        menuArchivo.add(abrirItem);
        menuArchivo.add(guardarItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);
    }

    private void abrirArchivo() {
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                StringBuffer contenido = new StringBuffer();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append(System.lineSeparator());
                }
                areaTexto.setText(contenido.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarArchivo() {
        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(archivo)) {
                writer.print(areaTexto.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EditorTexto editor = new EditorTexto();
            editor.setVisible(true);
        });
    }
}
