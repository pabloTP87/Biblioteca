package vista;
import javax.swing.JFrame;

public class VentanaFactura extends JFrame {
    public VentanaFactura(){
        this.setTitle("Ingreso de factura");
        this.setSize(600, 400);
        PanelFactura vf=new PanelFactura();
        this.add(vf);
    }
}
