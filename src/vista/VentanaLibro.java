package vista;

import javax.swing.JFrame;

public class VentanaLibro extends JFrame{
    public VentanaLibro(){
        this.setTitle("Inventario");
        this.setSize(1200, 600);
        PanelLibro pl=new PanelLibro();
        this.add(pl); 
    }
}
