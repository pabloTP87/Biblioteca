package vista;

import javax.swing.JFrame;

/**
 *
 * @author Pablo
 */
public class VentanaVenta extends JFrame{
    public VentanaVenta(){
        this.setTitle("Ingreso de Venta");
        this.setSize(600, 400);
        PanelVenta pv=new PanelVenta();
        this.add(pv);
    }
}
