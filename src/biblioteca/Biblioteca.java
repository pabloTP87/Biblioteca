package biblioteca;

import javax.swing.JFrame;
import javax.swing.UIManager;
import vista.VentanaPrincipal;

public class Biblioteca {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        }
        catch(Exception ex){
            
        }
        VentanaPrincipal ventana;
        ventana=new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
