package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
    public Image imagen;
    public URL fondo;
    
    public PanelPrincipal(){
        fondo=this.getClass().getResource("/img/fondo.jpg");
        imagen=new ImageIcon(fondo).getImage();
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
    }
}
