import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Encuesta extends JPanel {
    private JButton BotonGuardar;
    private JLabel Pregunta1;
    private JLabel Pregunta2;
    private JLabel Pregunta3;
    private JRadioButton Opcion1P1;
    private JRadioButton Opcion2P1;
    private JRadioButton Opcion3P1;
    private JRadioButton Opcion1P2;
    private JRadioButton Opcion2P2;
    private JRadioButton Opcion3P2;
    private JRadioButton Opcion1P3;
    private JRadioButton Opcion2P3;
    private JRadioButton Opcion3P3;

    // Variables para almacenar las opciones seleccionadas
    private String respuestaP1;
    private String respuestaP2;
    private String respuestaP3;

    public Encuesta() {
        //construct components
        BotonGuardar = new JButton ("Guardar");
        Pregunta1 = new JLabel ("1. ¿Con qué frecuencia realizas actividad física?");
        Pregunta2 = new JLabel ("2. ¿Cuántas horas en promedio pasas frente a una pantalla al día?");
        Pregunta3 = new JLabel ("3. ¿Cuántas horas al día pasas en actividades de estudio o trabajo?");
        Opcion1P1 = new JRadioButton ("Todos los días");
        Opcion2P1 = new JRadioButton ("Varios días");
        Opcion3P1 = new JRadioButton ("Nunca");
        Opcion1P2 = new JRadioButton ("Menos de 1 hora");
        Opcion2P2 = new JRadioButton ("De 1 - 4 horas");
        Opcion3P2 = new JRadioButton ("Más de 4 horas");
        Opcion1P3 = new JRadioButton ("Menos de 1 hora");
        Opcion2P3 = new JRadioButton ("De 1 - 4 horas");
        Opcion3P3 = new JRadioButton ("Más de 4 horas");

        // Inicializar variables de respuesta
        respuestaP1 = "";
        respuestaP2 = "";
        respuestaP3 = "";

        // Añadir ActionListeners a los botones
        BotonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes manejar la lógica para guardar las respuestas
                System.out.println("Respuesta 1: " + respuestaP1);
                System.out.println("Respuesta 2: " + respuestaP2);
                System.out.println("Respuesta 3: " + respuestaP3);
            }
        });

        // Añadir ItemListeners a los radio botones
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                if (source == Opcion1P1 || source == Opcion2P1 || source == Opcion3P1) {
                    respuestaP1 = source.getText();
                } else if (source == Opcion1P2 || source == Opcion2P2 || source == Opcion3P2) {
                    respuestaP2 = source.getText();
                } else if (source == Opcion1P3 || source == Opcion2P3 || source == Opcion3P3) {
                    respuestaP3 = source.getText();
                }
            }
        };

        // Añadir ItemListeners a los radio botones
        Opcion1P1.addItemListener(itemListener);
        Opcion2P1.addItemListener(itemListener);
        Opcion3P1.addItemListener(itemListener);
        Opcion1P2.addItemListener(itemListener);
        Opcion2P2.addItemListener(itemListener);
        Opcion3P2.addItemListener(itemListener);
        Opcion1P3.addItemListener(itemListener);
        Opcion2P3.addItemListener(itemListener);
        Opcion3P3.addItemListener(itemListener);

        //adjust size and set layout
        setPreferredSize (new Dimension (482, 329));
        setLayout (null);

        //add components
        add (BotonGuardar);
        add (Pregunta1);
        add (Pregunta2);
        add (Pregunta3);
        add (Opcion1P1);
        add (Opcion2P1);
        add (Opcion3P1);
        add (Opcion1P2);
        add (Opcion2P2);
        add (Opcion3P2);
        add (Opcion1P3);
        add (Opcion2P3);
        add (Opcion3P3);

        //set component bounds (only needed by Absolute Positioning)
        BotonGuardar.setBounds (180, 275, 100, 20);
        Pregunta1.setBounds (25, 15, 305, 25);
        Pregunta2.setBounds (20, 85, 399, 25);
        Pregunta3.setBounds (20, 165, 411, 25);
        Opcion1P1.setBounds (25, 40, 114, 25);
        Opcion2P1.setBounds (175, 40, 100, 25);
        Opcion3P1.setBounds (310, 40, 100, 25);
        Opcion1P2.setBounds (25, 115, 136, 25);
        Opcion2P2.setBounds (175, 120, 114, 25);
        Opcion3P2.setBounds (310, 120, 124, 25);
        Opcion1P3.setBounds (25, 195, 130, 25);
        Opcion2P3.setBounds (175, 195, 113, 25);
        Opcion3P3.setBounds (310, 195, 116, 25);

        BotonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Encuesta.this);
                currentFrame.dispose();
            }
        });

        JFrame newFrame = new JFrame("App");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.getContentPane().add(new App());
        newFrame.pack();
        newFrame.setVisible(true);

    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Encuesta");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Encuesta());
        frame.pack();
        frame.setVisible (true);
    }
}
