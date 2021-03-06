
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageProducer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Alertas {

    private Alertas() {

    }

    public static Alertas obtenerInstancia() {//asi garantizamos que solo aya una ventana
        if (instancia == null) {
            instancia = new Alertas();
        }
        return instancia;
    }//----------------------------------------------------------------------------- FIN obtenerInstancia()

    public void WarningAlert(String mensaje) {
        Ventana.obtenerInstancia().setBarraEstado("Warning " + mensaje);
        final JOptionPane pane = new JOptionPane(mensaje);
        pane.setMessageType(JOptionPane.WARNING_MESSAGE);
        final JDialog d = pane.createDialog((JFrame) null, "Warning");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/warning-icon.png"));
        d.setIconImage(icon);
        d.setLocation(sizeX - (mensaje.length()), sizeY);
        Toolkit.getDefaultToolkit().beep();
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mouseClicked()

            @Override
            public void mousePressed(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mousePressed()
        });
        d.setVisible(true);
        Ventana.obtenerInstancia().setBarraEstadoMensajeAnterior();
    }

    public void CautionAlert(String mensaje) {
        Ventana.obtenerInstancia().setBarraEstado("Alerta " + mensaje);
        final JOptionPane pane = new JOptionPane(mensaje);
        pane.setMessageType(JOptionPane.ERROR_MESSAGE);
        final JDialog d = pane.createDialog((JFrame) null, "Alerta");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/Alerts-icon.png"));
        d.setIconImage(icon);
        d.setLocation(sizeX - (mensaje.length()), sizeY);
        Toolkit.getDefaultToolkit().beep();
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mouseClicked()

            @Override
            public void mousePressed(MouseEvent e) {
                Ventana.obtenerInstancia().alertaTicketsAdmin();
            }//----------------------------------------------------------------------------- FIN mousePressed()
        });
        d.setVisible(true);
        Ventana.obtenerInstancia().setBarraEstadoMensajeAnterior();
    }
    private static Alertas instancia = null;
    private final int sizeY = Toolkit.getDefaultToolkit().getScreenSize().height - 200;
    private final int sizeX = Toolkit.getDefaultToolkit().getScreenSize().width - 300;
}

/*

 final JPanel panel = new JPanel();
 panel.setBackground(Color.red);
        
 //JOptionPane warning = new JOptionPane();
 //Ventana.obtenerInstancia().add(warning);
 //warning.setBounds(200, 200, 100, 15);  
 //warning.setVisible(true);
 //warning.setLocation(100, 100);
 //warning.showMessageDialog(Ventana.obtenerInstancia(), mensaje, "Warning",
 //        JOptionPane.WARNING_MESSAGE);

 JOptionPane mi_jop = new JOptionPane();
 // añadirlo a la lista de componentes de la página 
 //this.add(mi_jop);
 //objecto swing.setBounds(posicion x, posicion y, longitud, anchura) 
 //mi_jop.setBounds(150, 150, 200, 13);
 //mi_jop.setLocation(400, 4000);
 //mi_jop.setLocale(Locale.UK);
 mi_jop.showMessageDialog(panel, mensaje, "Warning",
 JOptionPane.WARNING_MESSAGE);
 JOptionPane.PROPERTIES;

 */
