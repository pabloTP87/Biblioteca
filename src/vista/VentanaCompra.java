package vista;
import javax.swing.JFrame;

public class VentanaCompra extends JFrame {
        public VentanaCompra(){
        this.setTitle("Ingresar Compra");
        this.setSize(600, 400);
        PanelCompra vc=new PanelCompra();
        this.add(vc);
    }
}
