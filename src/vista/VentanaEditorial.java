package vista;

import javax.swing.JFrame;

public class VentanaEditorial extends JFrame{
    public VentanaEditorial(){
        this.setTitle("Ingreso de editorial");
        this.setSize(400, 200);
        PanelEditorial pe=new PanelEditorial();
        this.add(pe);
    }
}
