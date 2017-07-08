package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
    JMenuBar barra=new JMenuBar();
    JMenu mnuArchivo=new JMenu("Archivo");
    JMenu mnuComprar=new JMenu("Comprar");
    JMenu mnuTrabajador=new JMenu("Trabajadores");
    JMenuItem salir=new JMenuItem("Salir");
    JMenuItem ingresoCompra=new JMenuItem("Ingreso de Compra");
    JMenuItem ingresoDistribuidor=new JMenuItem("Ingreso de distribuidor");
    JMenuItem ingresoFactura=new JMenuItem("Ingreso de Factura");
    JMenuItem ingresoTrabajador=new JMenuItem("Ingreso Trabajador");
    VentanaDistribuidor mDistribuidor=new VentanaDistribuidor();
    VentanaFactura mFactura=new VentanaFactura();
    VentanaCompra mCompra= new VentanaCompra();
    VentanaTrabajador mTrabajador=new VentanaTrabajador();
    
    public VentanaPrincipal(){
        barra.add(mnuArchivo);barra.add(mnuComprar);barra.add(mnuTrabajador);
        mnuArchivo.add(salir);
        mnuComprar.add(ingresoCompra);mnuComprar.add(ingresoDistribuidor);mnuComprar.add(ingresoFactura);
        mnuTrabajador.add(ingresoTrabajador);
        this.setSize(600,400);
        this.setTitle("Sistema Biblioteca");
        this.add(barra,BorderLayout.NORTH);
        this.setLocationRelativeTo(null);
        PanelPrincipal panel1=new PanelPrincipal();
        this.add(panel1,BorderLayout.CENTER); 
        Container contenedor=getContentPane();
        contenedor.add(panel1);
        //
        OyenteSalir out=new OyenteSalir();
        salir.addActionListener(out);
        OyenteDistribuidor distribuidor=new OyenteDistribuidor();
        ingresoDistribuidor.addActionListener(distribuidor);
        OyenteFactura factura=new OyenteFactura();
        ingresoFactura.addActionListener(factura);
        OyenteCompra compra=new OyenteCompra();
        ingresoCompra.addActionListener(compra);
        OyenteTrabajador trabajador=new OyenteTrabajador();
        ingresoTrabajador.addActionListener(trabajador);
    }
    class OyenteSalir implements ActionListener{        
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }     
    }
    class OyenteDistribuidor implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mDistribuidor.setVisible(true);
        }        
    }
    class OyenteFactura implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mFactura.setVisible(true);
        }        
    }
    class OyenteCompra implements ActionListener{
        public void actionPerformed(ActionEvent e) {
          mCompra.setVisible(true);
        }        
    }
    class OyenteTrabajador implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mTrabajador.setVisible(true);
        }
        
    }
}
