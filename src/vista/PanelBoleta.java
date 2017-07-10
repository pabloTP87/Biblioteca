package vista;

import Combo.CmbCliente;
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
import negocio.Trabajador;

/**
 *
 * @author Pablo
 */
public class PanelBoleta extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblFolio=new JLabel("Folio:");
    //JLabel lblPrecioN=new JLabel("Precio Neto:");
    JLabel lblPrecioIva=new JLabel("Precio total:");
    //JLabel lblIva=new JLabel("IVA (19%):");
    JLabel lblFecha=new JLabel("Fecha de venta:");
    JLabel lblHora=new JLabel("Hora de venta:");
    JLabel lblCliente=new JLabel("Rut cliente:");
    JLabel lblTrabajador=new JLabel("Rut trabajador:");
    JLabel lblMetodo=new JLabel("Metodo de pago:");
    
  
    JTextField txtId=new JTextField();
    JTextField txtFolio=new JTextField();
    //JTextField txtPrecioN=new JTextField();
    JTextField txtPrecioIva=new JTextField();
    //JTextField txtIva=new JTextField();
    JTextField txtFecha=new JTextField();
    JTextField txtHora=new JTextField();
    JComboBox cmbCliente=new JComboBox();
    JComboBox cmbTrabajador=new JComboBox();
    
    DefaultComboBoxModel valueCliente=new DefaultComboBoxModel();
    DefaultComboBoxModel valueTrabajador=new DefaultComboBoxModel();
    
    String[] metodoPago={"Efectivo","Cheque","Credito","Debito"};
    JComboBox cmbMetodo=new JComboBox(metodoPago);
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    Boleta boleta=new Boleta();
    Cliente cliente=new Cliente();
    Trabajador trabajador=new Trabajador();

    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Folio");
            modelo.addColumn("Precio Neto");
            modelo.addColumn("Precio con IVA");
            modelo.addColumn("IVA 19%");
            modelo.addColumn("Fecha de venta");
            modelo.addColumn("Hora de venta");
            modelo.addColumn("Nombre Cliente");
            modelo.addColumn("Apellido");
            modelo.addColumn("Nombre Vendedor");
            modelo.addColumn("Apelido");
            modelo.addColumn("Metodo de pago");                      
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelBoleta(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(8,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblFolio);pnlElementos.add(txtFolio);      
        //pnlElementos.add(lblPrecioN);pnlElementos.add(txtPrecioN);
        pnlElementos.add(lblPrecioIva);pnlElementos.add(txtPrecioIva);
        //pnlElementos.add(lblIva);pnlElementos.add(txtIva);
        pnlElementos.add(lblFecha);pnlElementos.add(txtFecha);
        pnlElementos.add(lblHora);pnlElementos.add(txtHora);
        pnlElementos.add(lblCliente);pnlElementos.add(cmbCliente);
        pnlElementos.add(lblTrabajador);pnlElementos.add(cmbTrabajador);
        pnlElementos.add(lblMetodo);pnlElementos.add(cmbMetodo);
        
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
        llenarComboCliente();
        llenarComboTrabajador();
        
        //mostrarDistribuidor();
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                txtFolio.setText(""+tabla.getValueAt(row, 1));
                //txtPrecioN.setText(""+tabla.getValueAt(row, 2));
                txtPrecioIva.setText(""+tabla.getValueAt(row, 3));
                //txtIva.setText(""+tabla.getValueAt(row, 4));
                txtFecha.setText(""+tabla.getValueAt(row, 5));
                txtHora.setText(""+tabla.getValueAt(row, 6));
                cmbCliente.setSelectedItem(""+tabla.getValueAt(row, 7));
                cmbCliente.setSelectedItem(""+tabla.getValueAt(row, 8));
                cmbTrabajador.setSelectedItem(""+tabla.getValueAt(row, 9));
                cmbTrabajador.setSelectedItem(""+tabla.getValueAt(row, 10));
                cmbMetodo.setSelectedItem(""+tabla.getValueAt(row, 11));                
                boleta.setId_boleta((String) tabla.getValueAt(row, 0));
            }
});
        
    }
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           boleta.setFolio_boleta(txtFolio.getText());
           boleta.setPrecio_neto(boleta.getPrecio_neto());
           boleta.setPrecio_iva(Double.parseDouble(txtPrecioIva.getText()));
           boleta.setCosto_iva(boleta.getCosto_iva());
           boleta.setFecha_venta(txtFecha.getText());
           boleta.setHora_venta(txtHora.getText());
           
           CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
           boleta.setId_cliente(CmbCliente.getIdCliente());
           
           CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
           boleta.setId_trabajador(CmbTrabajador.getIdTrabajador());
           
           boleta.setMetodo_pago(cmbMetodo.getSelectedItem().toString());
           boleta.guardar();
           limpiar();
           llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            boleta.eliminar();
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
           boleta.setId_boleta(txtId.getText());
           boleta.setFolio_boleta(txtFolio.getText());
           boleta.setPrecio_neto(boleta.getPrecio_neto());
           boleta.setPrecio_iva(Double.parseDouble(txtPrecioIva.getText()));
           boleta.setCosto_iva(boleta.getCosto_iva());
           boleta.setFecha_venta(txtFecha.getText());
           boleta.setHora_venta(txtHora.getText());
           
           CmbCliente CmbCliente=(CmbCliente)cmbCliente.getSelectedItem();
           boleta.setId_cliente(CmbCliente.getIdCliente());
           
           CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbTrabajador.getSelectedItem();
           boleta.setId_trabajador(CmbTrabajador.getIdTrabajador());
           
           boleta.setMetodo_pago(cmbMetodo.getSelectedItem().toString());
           boleta.actualizar();
           limpiar();
           llenarTabla();
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[12];
        boleta.show();
        try{
            while(boleta.getShow().next()){
                elementos[0]=boleta.getShow().getString("id_boleta");
                elementos[1]=boleta.getShow().getString("folio_boleta");
                elementos[2]=boleta.getShow().getString("precio_neto");
                elementos[3]=boleta.getShow().getString("precio_iva");
                elementos[4]=boleta.getShow().getString("costo_iva");
                elementos[5]=boleta.getShow().getString("fecha_venta");
                elementos[6]=boleta.getShow().getString("hora_venta");
                elementos[7]=boleta.getShow().getString("nombre_cliente");
                elementos[8]=boleta.getShow().getString("ap_paterno");
                elementos[9]=boleta.getShow().getString("nombre_trabajador");
                elementos[10]=boleta.getShow().getString("ap_paterno");
                elementos[11]=boleta.getShow().getString("metodo_pago");              
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    public void limpiar(){
        txtId.setText("");
        txtFolio.setText("");
        //txtPrecioN.setText("");
        txtPrecioIva.setText("");
        //txtIva.setText("");
        txtFecha.setText(""); 
        txtHora.setText("");
        //txtMetodo.setText(""); 
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
           System.out.println("error al llenar combo");
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
           System.out.println("error al llenar combo");
        }
    }
}
