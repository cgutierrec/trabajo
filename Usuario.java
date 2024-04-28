import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Usuario extends JPanel implements ActionListener{
    private JLabel Nombre;
    private JTextField obtenerNombre;
    private JLabel Edad;
    private JTextField obtenerEdad;
    private JLabel Peso;
    private JTextField obtenerPeso;
    private JButton Guardar;
    private JLabel Aficiones;
    private JTextArea DatosGuardados;
    private JLabel Estudio;
    private JTextField obtenerEstudio;
    private JLabel Trabajo;
    private JTextField obtnerTrabajo;
    private JLabel Datos;
    private JTextField obtenerAficiones;
    private JButton BotonSeguir; 

    public Usuario() {
        //construct components
        Nombre = new JLabel ("Ingrese su nombre:");
        obtenerNombre = new JTextField (11);
        Edad = new JLabel ("Ingrese su edad:");
        obtenerEdad = new JTextField (5);
        Peso = new JLabel ("Ingrese su peso (Kg)");
        obtenerPeso = new JTextField (5);
        Guardar = new JButton ("Guardar");
        Aficiones = new JLabel ("Escriba sus aficiones:");
        DatosGuardados = new JTextArea (5, 5);
        Estudio = new JLabel ("Estudio:");
        obtenerEstudio = new JTextField (5);
        Trabajo = new JLabel ("Trabajo");
        obtnerTrabajo = new JTextField (5);
        Datos = new JLabel ("Datos del usuario guardados");
        obtenerAficiones = new JTextField (5);
        BotonSeguir = new JButton("Siguiente");

        //set components properties
        DatosGuardados.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 329));
        setLayout (null);

        //add components
        add (Nombre);
        add (obtenerNombre);
        add (Edad);
        add (obtenerEdad);
        add (Peso);
        add (obtenerPeso);
        add (Guardar);
        add (Aficiones);
        add (DatosGuardados);
        add (Estudio);
        add (obtenerEstudio);
        add (Trabajo);
        add (obtnerTrabajo);
        add (Datos);
        add (obtenerAficiones);
        add (BotonSeguir);

        //set component bounds (only needed by Absolute Positioning)
        Nombre.setBounds (25, 15, 182, 25);
        obtenerNombre.setBounds (25, 40, 132, 25);
        Edad.setBounds (25, 80, 163, 25);
        obtenerEdad.setBounds (25, 110, 68, 25);
        Peso.setBounds (25, 150, 132, 25);
        obtenerPeso.setBounds (25, 180, 68, 25);
        Guardar.setBounds (25, 230, 100, 25);
        Aficiones.setBounds (265, 15, 149, 25);
        DatosGuardados.setBounds (30, 305, 400, 115);
        Estudio.setBounds (265, 115, 100, 25);
        obtenerEstudio.setBounds (265, 145, 152, 25);
        Trabajo.setBounds (265, 175, 100, 25);
        obtnerTrabajo.setBounds (265, 200, 152, 25);
        Datos.setBounds (150, 275, 175, 25);
        obtenerAficiones.setBounds (265, 40, 155, 75);
        BotonSeguir.setBounds(460, 345, 111, 25);

        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = obtenerNombre.getText();
                String edad = obtenerEdad.getText();
                String peso = obtenerPeso.getText();
                String estudio = obtenerEstudio.getText();
                String trabajo = obtnerTrabajo.getText();
                String aficiones = obtenerAficiones.getText();
        
                String datos = "Nombre: " + nombre + "\n" +
                               "Edad: " + edad + "\n" +
                               "Peso: " + peso + "\n" +
                               "Estudio: " + estudio + "\n" +
                               "Trabajo: " + trabajo + "\n" +
                               "Aficiones: " + aficiones + "\n";
        
                DatosGuardados.setText(datos);
                DatosGuardados.setEnabled(true);
            }
        });
        
        BotonSeguir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Usuario.this);
                currentFrame.dispose();
            }
        });

    }   
    public static void main (String[] args) {
        JFrame newFrame = new JFrame("App");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.getContentPane().add(new App());
        newFrame.pack();
        newFrame.setVisible(true);

        JFrame frame = new JFrame ("Usuario");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Usuario());
        frame.pack();
        frame.setVisible (true);
    }
}
