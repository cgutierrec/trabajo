import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class App extends JPanel implements ActionListener {
    private JLabel App1;
    private JTextField obtenerTiempoApp1;
    private JLabel App2;
    private JTextField obtenerTiempoApp2;
    private JButton GuardarDatos;
    private JTextArea Promedio;
    private JLabel Recordatorio;
    private JButton BotonSeguir;

    public App() {
        //construct components
        App1 = new JLabel ("¿Cuánto tiempo utilizas Instagram diariamente? (Horas)");
        obtenerTiempoApp1 = new JTextField (5);
        App2 = new JLabel ("¿Cuánto tiempo utilizas TikTok diariamente? (Horas)");
        obtenerTiempoApp2 = new JTextField (5);
        GuardarDatos = new JButton ("Guardar");
        Promedio = new JTextArea (5, 5);
        Recordatorio = new JLabel ("¡RECUERDA INGRESAR TU TIEMPO DE USO EN APPS! ");
        BotonSeguir = new JButton("Siguiente");

        //set components properties
        Promedio.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 329));
        setLayout (null);

        //add components
        add (App1);
        add (obtenerTiempoApp1);
        add (App2);
        add (obtenerTiempoApp2);
        add (GuardarDatos);
        add (Promedio);
        add (Recordatorio);
        add (BotonSeguir);

        //set component bounds (only needed by Absolute Positioning)
        App1.setBounds (20, 45, 337, 25);
        obtenerTiempoApp1.setBounds (25, 75, 100, 25);
        App2.setBounds (20, 110, 310, 25);
        obtenerTiempoApp2.setBounds (25, 140, 100, 25);
        GuardarDatos.setBounds (25, 185, 100, 25);
        Promedio.setBounds (25, 235, 231, 30);
        Recordatorio.setBounds (20, 10, 500, 25);
        BotonSeguir.setBounds(385, 235, 100, 25);

        GuardarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tiempoApp1 = obtenerTiempoApp1.getText();
                String tiempoApp2 = obtenerTiempoApp2.getText();

                try {
                    double tiempo1 = Double.parseDouble(tiempoApp1);
                    double tiempo2 = Double.parseDouble(tiempoApp2);
                    double promedio = (tiempo1 + tiempo2) / 2;

                    Promedio.setText("Promedio de tiempo en apps: " + promedio);
                    Promedio.setEnabled(true);
                } catch (NumberFormatException ex) {
                    Promedio.setText("Error: Por favor, ingresa números válidos.");
                    Promedio.setEnabled(true);
                }
            }
        });

        BotonSeguir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(App.this);
                currentFrame.dispose();
            }
        });

        JFrame newFrame = new JFrame("Actividad");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.getContentPane().add(new Actividad());
        newFrame.pack();
        newFrame.setVisible(true);
    }    

    public static void main (String[] args) {
        JFrame frame = new JFrame ("App");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new App());
        frame.pack();
        frame.setVisible (true);
    }
}