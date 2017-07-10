package vista;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaTrabajador extends JFrame {
    public VentanaTrabajador(){
        this.setTitle("Ingreso de trabajador");
        this.setSize(600, 400);
        PanelTrabajador pt=new PanelTrabajador();
        PanelContactoTrabajador pct=new PanelContactoTrabajador();
        JTabbedPane tb=new JTabbedPane();
        tb.add("Ingresar Trabajador",pt);
        tb.add("Datos de contacto",pct);
        this.add(tb);
    }
}
