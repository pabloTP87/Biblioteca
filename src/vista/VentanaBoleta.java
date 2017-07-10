package vista;

import javax.swing.JFrame;

/**
 *
 * @author Pablo
 */
public class VentanaBoleta extends JFrame{
    public VentanaBoleta(){
        this.setTitle("Ingreso de boleta");
        this.setSize(1200, 600);
        PanelBoleta pb=new PanelBoleta();
        this.add(pb);
    }
}
