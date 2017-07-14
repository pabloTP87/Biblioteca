
package vista;

import javax.swing.JFrame;

public class VentanaArriendo extends JFrame{
    public VentanaArriendo(){
        this.setTitle("Ingresar Arriendo");
        this.setSize(1200, 900);
        PanelArriendo va=new PanelArriendo();
        this.add(va);
    }
}
