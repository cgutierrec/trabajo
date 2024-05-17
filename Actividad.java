import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Actividad extends JPanel implements ActionListener{
    private JLabel ActividadFisica;
    private JTextField obtenerTiempoActividadFisica;
    private JLabel ActividadExtra;
    private JTextField obtenerTiempoActividadExtra;
    private JButton guardar;
    private JLabel TipoActividadesExtra;
    private JTextArea obtenerTipoActividadExtra;
    private JLabel Recordatorio;
    private JLabel Datos;
    private JTextArea DatosGuardados;
    private JButton BotonFin; 

    public Actividad() {
        //construct components
        ActividadFisica = new JLabel ("¿Cuánto tiempo realizas actividad física diariamente? (Horas)");
        obtenerTiempoActividadFisica = new JTextField (5);
        ActividadExtra = new JLabel ("¿Cuánto tiempo realizas actividades extras diariamente? (Horas)");
        obtenerTiempoActividadExtra = new JTextField (5);
        guardar = new JButton ("Guardar");
        TipoActividadesExtra = new JLabel ("¿Qué actividades extra realiza? ");
        obtenerTipoActividadExtra = new JTextArea (5, 5);
        Recordatorio = new JLabel ("¡RECUERDA INGRESAR TU TIEMPO DEDICADO A ACTIVIDADES!");
        Datos = new JLabel ("Datos guardados");
        DatosGuardados = new JTextArea (5, 5);
        BotonFin = new JButton("Finalizar");

        //set components properties
        DatosGuardados.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 329));
        setLayout (null);

        //add components
        add (ActividadFisica);
        add (obtenerTiempoActividadFisica);
        add (ActividadExtra);
        add (obtenerTiempoActividadExtra);
        add (guardar);
        add (TipoActividadesExtra);
        add (obtenerTipoActividadExtra);
        add (Recordatorio);
        add (Datos);
        add (DatosGuardados);
        add (BotonFin);

        //set component bounds (only needed by Absolute Positioning)
        ActividadFisica.setBounds (25, 50, 400, 25);
        obtenerTiempoActividadFisica.setBounds (25, 85, 100, 25);
        ActividadExtra.setBounds (25, 115, 400, 25);
        obtenerTiempoActividadExtra.setBounds (25, 150, 100, 25);
        guardar.setBounds (25, 270, 100, 25);
        TipoActividadesExtra.setBounds (25, 180, 450, 25);
        obtenerTipoActividadExtra.setBounds (25, 210, 370, 45);
        Recordatorio.setBounds (25, 20, 500, 25);
        Datos.setBounds (25, 315, 158, 25);
        DatosGuardados.setBounds (25, 340, 365, 75);
        BotonFin.setBounds(410, 360, 100, 25);

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tiempoActividadFisica = obtenerTiempoActividadFisica.getText();
                String tiempoActividadExtra = obtenerTiempoActividadExtra.getText();
                String tipoActividadesExtra = obtenerTipoActividadExtra.getText();

                String datos = "Tiempo actividad física: " + tiempoActividadFisica + "\n" +
                               "Tiempo actividades extras: " + tiempoActividadExtra + "\n" +
                               "Tipo de actividades extras: " + tipoActividadesExtra + "\n";

                DatosGuardados.setText(datos);
                DatosGuardados.setEnabled(true);
            }
        });

        BotonFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Actividad.this);
                currentFrame.dispose();
            }
        });
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Actividad");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Actividad());
        frame.pack();
        frame.setVisible (true);
    }
}