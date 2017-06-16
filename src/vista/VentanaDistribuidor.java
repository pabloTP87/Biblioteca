package vista;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaDistribuidor extends JFrame{
    public VentanaDistribuidor(){
        this.setTitle("Modulo Compra");
        this.setSize(600, 400);
        PanelDistribuidor pc=new PanelDistribuidor();         
        JTabbedPane tb= new JTabbedPane();
        tb.addTab("Distribuidor", pc);
        this.add(tb);
    }
}
