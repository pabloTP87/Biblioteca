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
    JMenu mnuCompra=new JMenu("Compra");
    JMenu mnuPersonas=new JMenu("Personas");
    JMenu mnuVenta=new JMenu("Venta");
    JMenu mnuArriendo=new JMenu("Arriendo");
    JMenu mnuInventario=new JMenu("Inventario");
    
    JMenuItem salir=new JMenuItem("Salir");
    JMenuItem ingresoCompra=new JMenuItem("Ingreso de Compra");
    JMenuItem ingresoDistribuidor=new JMenuItem("Ingreso de distribuidor");
    JMenuItem ingresoFactura=new JMenuItem("Ingreso de Factura");
    JMenuItem ingresoTrabajador=new JMenuItem("Ingreso de Trabajador");
    JMenuItem ingresoCliente=new JMenuItem("Ingreso de Cliente");   
    JMenuItem ingresoBoleta=new JMenuItem("Ingreso de Boleta");
    JMenuItem ingresoVenta=new JMenuItem("Ingreso de Venta");
    JMenuItem ingresoArriendo=new JMenuItem("Ingreso de Arriendo");
    JMenuItem ingresoEditorial=new JMenuItem("Editoriales");
    JMenuItem ingresoInventario=new JMenuItem("Inventario de libros");
    
    VentanaDistribuidor mDistribuidor=new VentanaDistribuidor();
    VentanaFactura mFactura=new VentanaFactura();
    VentanaCompra mCompra= new VentanaCompra();
    VentanaTrabajador mTrabajador=new VentanaTrabajador();
    VentanaCliente mCliente=new VentanaCliente();
    VentanaBoleta mBoleta=new VentanaBoleta();
    VentanaLibro mLibro=new VentanaLibro();
    
    public VentanaPrincipal(){
        barra.add(mnuArchivo);barra.add(mnuCompra);barra.add(mnuPersonas);barra.add(mnuVenta);barra.add(mnuArriendo);barra.add(mnuInventario);
        mnuArchivo.add(salir);
        mnuCompra.add(ingresoCompra);mnuCompra.add(ingresoDistribuidor);mnuCompra.add(ingresoFactura);
        mnuPersonas.add(ingresoTrabajador);mnuPersonas.add(ingresoCliente);
        mnuVenta.add(ingresoBoleta);mnuVenta.add(ingresoVenta);
        mnuArriendo.add(ingresoArriendo);
        mnuInventario.add(ingresoEditorial);mnuInventario.add(ingresoInventario);
        this.setSize(800,600);
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
        OyenteCliente cliente=new OyenteCliente();
        ingresoCliente.addActionListener(cliente);
        OyenteBoleta boleta=new OyenteBoleta();
        ingresoBoleta.addActionListener(boleta);
        OyenteLibro libro= new OyenteLibro();
        ingresoInventario.addActionListener(libro);
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
    class OyenteCliente implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mCliente.setVisible(true);
        }    
    }
    class OyenteBoleta implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mBoleta.setVisible(true);
        }        
    }
    class OyenteLibro implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            mLibro.setVisible(true);
        }        
    }
}
