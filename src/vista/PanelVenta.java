package vista;

import Combo.CmbBoleta;
import Combo.CmbCliente;
import Combo.CmbLibro;
import Combo.CmbTrabajador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.Boleta;
import negocio.Cliente;
import negocio.Libro;
import negocio.Trabajador;
import negocio.Venta;

/**
 *
 * @author Pablo
 */
public class PanelVenta extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblLibro=new JLabel("Sellecionar Libro:");
    JLabel lblCliente=new JLabel("Rut Cliente:");
    JLabel lblTrabajador=new JLabel("Rut Trabajador:");
    JLabel lblBoleta=new JLabel("N° Boleta:");
    
    JTextField txtId=new JTextField();
    
    JComboBox cmbLibro=new JComboBox();
    JComboBox cmbCliente=new JComboBox();
    JComboBox cmbTrabajador=new JComboBox();
    JComboBox cmbBoleta=new JComboBox();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Venta venta=new Venta();
    Libro libro=new Libro();
    Cliente cliente=new Cliente();
    Trabajador trabajador=new Trabajador();
    Boleta boleta=new Boleta();
    
    DefaultComboBoxModel modLibro=new DefaultComboBoxModel();
    DefaultComboBoxModel modCliente=new DefaultComboBoxModel();
    DefaultComboBoxModel modTrabajador=new DefaultComboBoxModel();
    DefaultComboBoxModel modBoleta=new DefaultComboBoxModel();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Titulo");
            modelo.addColumn("Rut Cliente");
            modelo.addColumn("Rut Trabajador");
            modelo.addColumn("N° boleta");                                
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);

    public PanelVenta(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(5,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //elementos en panel
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblLibro);pnlElementos.add(cmbLibro);      
        pnlElementos.add(lblCliente);pnlElementos.add(cmbCliente);
        pnlElementos.add(lblTrabajador);pnlElementos.add(cmbTrabajador);
        pnlElementos.add(lblBoleta);pnlElementos.add(cmbBoleta);
        
        //botones
        pnlBotones.add(btnLimpiar);pnlBotones.add(btnGuardar);     
        pnlBotones.add(btnEliminar);pnlBotones.add(btnActualizar);
        //panel superior        
        pnlSuperior.add(pnlElementos);pnlSuperior.add(pnlBotones);
        
        this.setLayout(new BorderLayout());
        this.add(pnlSuperior,BorderLayout.NORTH);
        this.add(scroll,BorderLayout.CENTER);
        
        OyenteGuardar guardar=new OyenteGuardar();
        btnGuardar.addActionListener(guardar);
        OyenteLimpiar limpiar=new OyenteLimpiar();
        btnLimpiar.addActionListener(limpiar);
        OyenteEliminar eliminar=new OyenteEliminar();
        btnEliminar.addActionListener(eliminar);
        OyenteActualizar actualizar=new OyenteActualizar();
        btnActualizar.addActionListener(actualizar);
        llenarTabla();
        llenarComboLibro();
        llenarComboCliente();
        llenarComboTrabajador();
        llenarComboBoleta();
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                cmbLibro.setSelectedItem(""+tabla.getValueAt(row, 1));
                cmbCliente.setSelectedItem(""+tabla.getValueAt(row, 2));
                cmbTrabajador.setSelectedItem(""+tabla.getValueAt(row, 3));
                cmbBoleta.setSelectedItem(""+tabla.getValueAt(row, 4));                
                venta.setId_venta((String)tabla.getValueAt(row, 0));
            }
        });
    }
    
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            CmbLibro CmbLibro=(CmbLibro)cmbLibro.getSelectedItem();
            venta.setId_libro(CmbLibro.getIdLibro());

            CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
            venta.setId_cliente(CmbCliente.getIdCliente());

            CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
            venta.setId_trabajador(CmbTrabajador.getIdTrabajador());

            CmbBoleta CmbBoleta=(CmbBoleta)cmbBoleta.getSelectedItem();
            venta.setId_boleta(CmbBoleta.getIdBoleta());
           
            venta.guardar();
            limpiar();
            llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            venta.eliminar();
            limpiar();
            llenarTabla();
        }   
    }
    class OyenteLimpiar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            limpiar();
        }
        
    }
    class OyenteActualizar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            venta.setId_trabajador(txtId.getText());
            
            CmbLibro CmbLibro=(CmbLibro)cmbLibro.getSelectedItem();
            venta.setId_libro(CmbLibro.getIdLibro());

            CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
            venta.setId_cliente(CmbCliente.getIdCliente());

            CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
            venta.setId_trabajador(CmbTrabajador.getIdTrabajador());

            CmbBoleta CmbBoleta=(CmbBoleta)cmbBoleta.getSelectedItem();
            venta.setId_boleta(CmbBoleta.getIdBoleta());
            
            venta.actualizar();
            limpiar();
            llenarTabla();
        }       
    }
    
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[5];
        venta.show();
        try{
            while(venta.getShow().next()){
                elementos[0]=venta.getShow().getString("id_venta");
                elementos[1]=venta.getShow().getString("titulo");
                elementos[2]=venta.getShow().getString("rut");
                elementos[3]=venta.getShow().getString("rut_trabajador");
                elementos[4]=venta.getShow().getString("folio_boleta");            
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    
    public void limpiar(){
        txtId.setText("");       
    }
    
    public void llenarComboLibro(){
        try{
         libro.showLibro();
         cmbLibro.setModel(modLibro);
         while(libro.getShowLibro().next()){
            modLibro.addElement(new CmbLibro(libro.getShowLibro().getString("titulo"),libro.getShowLibro().getString("id_libro")));
            }
        }
        catch(SQLException ex){
            System.out.println("Error"+ex);
        }
    }
    public void llenarComboCliente(){
       try{
          cliente.showCliente();
          cmbCliente.setModel(modCliente);
          while(cliente.getShowCliente().next()){
              modCliente.addElement(new CmbCliente(cliente.getShowCliente().getString("rut"),cliente.getShowCliente().getString("id_cliente")));
          }
        }
       catch(SQLException ex){
           System.out.println("error"+ex);
        }
    }
    public void llenarComboTrabajador(){
       try{
          trabajador.showTrabajador();
          cmbTrabajador.setModel(modTrabajador);
          while(trabajador.getShowTrabajador().next()){
              modTrabajador.addElement(new CmbTrabajador(trabajador.getShowTrabajador().getString("rut_trabajador"),trabajador.getShowTrabajador().getString("id_trabajador")));
          }
        }
       catch(SQLException ex){
           System.out.println("error"+ex);
        }
    }
    public void llenarComboBoleta(){
       try{
          boleta.showBoleta();
          cmbBoleta.setModel(modBoleta);
          while(boleta.getShowBoleta().next()){
              modBoleta.addElement(new CmbBoleta(boleta.getShowBoleta().getString("folio_boleta"),boleta.getShowBoleta().getString("id_boleta")));
          }
        }
       catch(SQLException ex){
           System.out.println("error"+ex);
        }
    }
}
