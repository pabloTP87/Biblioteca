package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Pablo
 */
public class VentanaCliente extends JFrame{
    public VentanaCliente(){
        this.setTitle("Ingreso de cliente");
        this.setSize(600, 600);
        PanelCliente pc=new PanelCliente();
        PanelContactoCliente pcc=new PanelContactoCliente();
        JTabbedPane tb=new JTabbedPane();
        tb.add("Ingresar Cliente",pc);
        tb.add("Datos de contacto",pcc);
        this.add(tb);
    }    
}
