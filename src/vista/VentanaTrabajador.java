package vista;

import javax.swing.JFrame;

public class VentanaTrabajador extends JFrame {
    public VentanaTrabajador(){
        this.setTitle("Ingreso de trabajador");
        this.setSize(600, 400);
        PanelTrabajador pt=new PanelTrabajador();
        this.add(pt);
    }
}
