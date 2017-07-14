
package vista;

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
import negocio.Arriendo;
import negocio.Cliente;
import negocio.Libro;
import negocio.Trabajador;

public class PanelArriendo extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    
    JLabel lblId=new JLabel("ID:");
    JLabel lblLibro=new JLabel("Titulo:");
    JLabel lblTotal=new JLabel("Costo Total:");
    JLabel lblArriendo=new JLabel("Fecha de arriendo:");
    JLabel lblDevolucion=new JLabel("Fecha de Devolucion):");
    JLabel lblEntrega=new JLabel("Fecha de Entrega:");
    JLabel lblAtraso=new JLabel("Dias de atraso:");
    JLabel lblMulta=new JLabel("Multa:");
    JLabel lblCosto=new JLabel("Costo de arriendo:");
    JLabel lblCliente=new JLabel("Rut Cliente:");
    JLabel lblTrabajador=new JLabel("Rut Trabajador:");
    
  
    JTextField txtId=new JTextField();
    JTextField txtTotal=new JTextField();
    JTextField txtArriendo=new JTextField();
    JTextField txtDevolucion=new JTextField();
    JTextField txtEntrega=new JTextField();
    JTextField txtAtraso=new JTextField();
    JTextField txtMulta=new JTextField();
    JTextField txtCosto=new JTextField();
    
    JComboBox cmbLibro=new JComboBox();
    JComboBox cmbCliente=new JComboBox();
    JComboBox cmbTrabajador=new JComboBox();
    
    DefaultComboBoxModel valueLibro=new DefaultComboBoxModel();
    DefaultComboBoxModel valueCliente=new DefaultComboBoxModel();
    DefaultComboBoxModel valueTrabajador=new DefaultComboBoxModel();
    
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Arriendo arriendo=new Arriendo();
    Libro libro=new Libro();
    Cliente cliente=new Cliente();
    Trabajador trabajador=new Trabajador();

    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Titulo");
            modelo.addColumn("Costo Total");
            modelo.addColumn("Fecha de arriendo");
            modelo.addColumn("Fecha de devolucion");
            modelo.addColumn("Fecha de entrega");
            modelo.addColumn("Dias de atraso");
            modelo.addColumn("Multa");
            modelo.addColumn("Costo de arriendo");
            modelo.addColumn("Rut cliente");
            modelo.addColumn("Rut Trabajador");
                                 
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelArriendo(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(11,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblLibro);pnlElementos.add(cmbLibro);      
        pnlElementos.add(lblTotal);pnlElementos.add(txtTotal);
        pnlElementos.add(lblArriendo);pnlElementos.add(txtArriendo);
        pnlElementos.add(lblDevolucion);pnlElementos.add(txtDevolucion);
        pnlElementos.add(lblEntrega);pnlElementos.add(txtEntrega);
        pnlElementos.add(lblAtraso);pnlElementos.add(txtAtraso);
        pnlElementos.add(lblMulta);pnlElementos.add(txtMulta);
        pnlElementos.add(lblCosto);pnlElementos.add(txtCosto);
        pnlElementos.add(lblCliente);pnlElementos.add(cmbCliente);
        pnlElementos.add(lblTrabajador);pnlElementos.add(cmbTrabajador);
        
        
        //botones
        pnlBotones.add(btnLimpiar);pnlBotones.add(btnGuardar);     
        pnlBotones.add(btnEliminar);pnlBotones.add(btnActualizar);
                 
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
        
        //mostrarDistribuidor();
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                cmbLibro.setSelectedItem(""+tabla.getValueAt(row, 1));
                txtTotal.setText(""+tabla.getValueAt(row, 2));
                txtArriendo.setText(""+tabla.getValueAt(row, 3));
                txtDevolucion.setText(""+tabla.getValueAt(row, 4));
                txtEntrega.setText(""+tabla.getValueAt(row, 5));
                txtAtraso.setText(""+tabla.getValueAt(row, 6));
                txtMulta.setText(""+tabla.getValueAt(row, 7));
                txtCosto.setText(""+tabla.getValueAt(row, 8));                
                cmbCliente.setSelectedItem(""+tabla.getValueAt(row, 9));               
                cmbTrabajador.setSelectedItem(""+tabla.getValueAt(row, 10));
              
                arriendo.setId_arriendo((String) tabla.getValueAt(row, 0));
            }
});
        
    }
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           arriendo.setCosto_total(txtTotal.getText());
           arriendo.setFecha_arriendo(txtArriendo.getText());
           arriendo.setFecha_devolucion(txtDevolucion.getText());
           arriendo.setFecha_entrega(txtEntrega.getText());
           arriendo.setDias_atraso(txtAtraso.getText());
           arriendo.setMulta(txtMulta.getText());
           arriendo.setCosto_arriendo(txtCosto.getText());
           
           CmbLibro CmbLibro=(CmbLibro)cmbLibro.getSelectedItem();
           arriendo.setId_libro(CmbLibro.getIdLibro());
           
           CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
           arriendo.setId_cliente(CmbCliente.getIdCliente());
           
           CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
           arriendo.setId_trabajador(CmbTrabajador.getIdTrabajador());
           arriendo.guardar();
           limpiar();
           llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            arriendo.eliminar();
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
           arriendo.setId_arriendo(txtId.getText());
           arriendo.setCosto_total(txtTotal.getText());
           arriendo.setFecha_arriendo(txtArriendo.getText());
           arriendo.setFecha_devolucion(txtDevolucion.getText());
           arriendo.setFecha_entrega(txtEntrega.getText());
           arriendo.setDias_atraso(txtAtraso.getText());
           arriendo.setMulta(txtMulta.getText());
           arriendo.setCosto_arriendo(txtCosto.getText());
           
           CmbLibro CmbLibro=(CmbLibro)cmbLibro.getSelectedItem();
           arriendo.setId_libro(CmbLibro.getIdLibro());
           
           CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
           arriendo.setId_cliente(CmbCliente.getIdCliente());
           
           CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
           arriendo.setId_trabajador(CmbTrabajador.getIdTrabajador());
           arriendo.actualizar();
           limpiar();
           llenarTabla();
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[11];
        arriendo.show();
        try{
            while(arriendo.getShow().next()){
                elementos[0]=arriendo.getShow().getString("id_Arriendo");
                elementos[1]=arriendo.getShow().getString("titulo");
                elementos[2]=arriendo.getShow().getString("costo_total");
                elementos[3]=arriendo.getShow().getString("fecha_arriendo");
                elementos[4]=arriendo.getShow().getString("fecha_devolucion");
                elementos[5]=arriendo.getShow().getString("fecha_entrega");
                elementos[6]=arriendo.getShow().getString("dias_atraso");
                elementos[7]=arriendo.getShow().getString("multa");
                elementos[8]=arriendo.getShow().getString("costo_arriendo");
                elementos[9]=arriendo.getShow().getString("rut");
                elementos[10]=arriendo.getShow().getString("rut_trabajador");
                             
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    public void limpiar(){
        txtId.setText("");
        txtTotal.setText("");
        txtArriendo.setText("");
        txtDevolucion.setText("");
        txtEntrega.setText("");
        txtAtraso.setText(""); 
        txtMulta.setText("");
        txtCosto.setText(""); 
    }
    public void llenarComboLibro(){
        try{
         libro.showLibro();
         cmbLibro.setModel(valueLibro);
         while(libro.getShowLibro().next()){
            valueLibro.addElement(new CmbLibro(libro.getShowLibro().getString("titulo"),libro.getShowLibro().getString("id_libro")));
            }
        }
        catch(SQLException ex){
            System.out.println("Error"+ex);
        }
    }
    public void llenarComboCliente(){
       try{
          cliente.showCliente();
          cmbCliente.setModel(valueCliente);
          while(cliente.getShowCliente().next()){
              valueCliente.addElement(new CmbCliente(cliente.getShowCliente().getString("rut"),cliente.getShowCliente().getString("id_cliente")));
          }
        }
       catch(SQLException ex){
           System.out.println("Error"+ex);
        }
    }
    public void llenarComboTrabajador(){
       try{
          trabajador.showTrabajador();
          cmbTrabajador.setModel(valueTrabajador);
          while(trabajador.getShowTrabajador().next()){
              valueTrabajador.addElement(new CmbTrabajador(trabajador.getShowTrabajador().getString("rut_trabajador"),trabajador.getShowTrabajador().getString("id_trabajador")));
          }
        }
       catch(SQLException ex){
           System.out.println("Error"+ex);
        }
    }
}
