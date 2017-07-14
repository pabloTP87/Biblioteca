package vista;

import Combo.CmbDistribuidor;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.Distribuidor;
import negocio.Factura;

public class PanelFactura extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblFolio=new JLabel("Folio:");
    //JLabel lblPrecioN=new JLabel("Precio Neto:");
    JLabel lblPrecioIva=new JLabel("Precio con IVA:");
    //JLabel lblIva=new JLabel("IVA (19%):");
    JLabel lblFecha=new JLabel("Fecha de compra:");
    JLabel lblHora=new JLabel("Hora de compra:");
    JLabel lblMetodo=new JLabel("Metodo de pago:");
    JLabel lblDistribuidor=new JLabel("Distribuidor:");
  
    JTextField txtId=new JTextField();
    JTextField txtFolio=new JTextField();
    //JTextField txtPrecioN=new JTextField();
    JTextField txtPrecioIva=new JTextField();
    //JTextField txtIva=new JTextField();
    JTextField txtFecha=new JTextField();
    JTextField txtHora=new JTextField();
    //JTextField txtMetodo=new JTextField();
    
    String[] metodoPago={"Efectivo","Cheque","Credito","Debito"};
    JComboBox cmbMetodo=new JComboBox(metodoPago);
    
    JComboBox cmbDistribuidor=new JComboBox();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Factura factura=new Factura();
    Distribuidor distribuidor=new Distribuidor();
    
    DefaultComboBoxModel value=new DefaultComboBoxModel();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Folio");
            modelo.addColumn("Precio Neto");
            modelo.addColumn("Precio con IVA");
            modelo.addColumn("IVA 19%");
            modelo.addColumn("Fecha de compra");
            modelo.addColumn("Hora de compra");
            modelo.addColumn("Metodo de pago");
            modelo.addColumn("Distribuidor");                      
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelFactura(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(9,2));
        pnlBotones.setLayout(new GridLayout(4,1,10,10));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblFolio);pnlElementos.add(txtFolio);      
        //pnlElementos.add(lblPrecioN);pnlElementos.add(txtPrecioN);
        pnlElementos.add(lblPrecioIva);pnlElementos.add(txtPrecioIva);
        //pnlElementos.add(lblIva);pnlElementos.add(txtIva);
        pnlElementos.add(lblFecha);pnlElementos.add(txtFecha);
        pnlElementos.add(lblHora);pnlElementos.add(txtHora);
        pnlElementos.add(lblMetodo);pnlElementos.add(cmbMetodo);
        pnlElementos.add(lblDistribuidor);pnlElementos.add(cmbDistribuidor);
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
        llenarCombo();
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
                cmbMetodo.setSelectedItem(""+tabla.getValueAt(row, 7));
                cmbDistribuidor.setSelectedItem(""+tabla.getValueAt(row, 8));
                factura.setId_factura((String) tabla.getValueAt(row, 0));
            }
});
        
    }
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           factura.setFolio_factura(txtFolio.getText());
           factura.setPrecio_neto(factura.getPrecio_neto());
           factura.setPrecio_iva(Double.parseDouble(txtPrecioIva.getText()));
           factura.setCosto_iva(factura.getCosto_iva());
           factura.setFecha_compra(txtFecha.getText());
           factura.setHora_compra(txtHora.getText());
           factura.setMetodo_pago(cmbMetodo.getSelectedItem().toString());
           CmbDistribuidor CmbDistribuidor=(CmbDistribuidor)cmbDistribuidor.getSelectedItem();
           factura.setId_distribuidor(CmbDistribuidor.getId());
           //factura.setId_distribuidor(cmbDistribuidor.getToolTipText()); 
           factura.guardar();
           limpiar();
           llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try{
                factura.eliminar();
                limpiar();
                llenarTabla();
            }
            catch(Exception ex){
                JOptionPane.showInputDialog("error"+ex);
            }
        }        
    }
    class OyenteLimpiar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           limpiar();
        }        
    }
    class OyenteActualizar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           factura.setId_factura(txtId.getText());
           factura.setFolio_factura(txtFolio.getText());
           factura.setPrecio_neto(factura.getPrecio_neto());
           factura.setPrecio_iva(Double.parseDouble(txtPrecioIva.getText()));
           factura.setCosto_iva(factura.getCosto_iva());
           factura.setFecha_compra(txtFecha.getText());
           factura.setHora_compra(txtHora.getText());
           factura.setMetodo_pago(cmbMetodo.getSelectedItem().toString());
           CmbDistribuidor CmbDistribuidor=(CmbDistribuidor)cmbDistribuidor.getSelectedItem();
           factura.setId_distribuidor(CmbDistribuidor.getId());
           factura.actualizar();
           limpiar();
           llenarTabla();
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[9];
        factura.show();
        try{
            while(factura.getShow().next()){
                elementos[0]=factura.getShow().getString("id_factura");
                elementos[1]=factura.getShow().getString("folio_factura");
                elementos[2]=factura.getShow().getString("precio_neto");
                elementos[3]=factura.getShow().getString("precio_iva");
                elementos[4]=factura.getShow().getString("costo_iva");
                elementos[5]=factura.getShow().getString("fecha_compra");
                elementos[6]=factura.getShow().getString("hora_compra");
                elementos[7]=factura.getShow().getString("metodo_pago");
                elementos[8]=factura.getShow().getString("nombre_empresa");                
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

    public void llenarCombo(){
        try{
         distribuidor.showDistribuidor();
         cmbDistribuidor.setModel(value);
         while(distribuidor.getShowDistribuidor().next()){
             value.addElement(new CmbDistribuidor(distribuidor.getShowDistribuidor().getString("nombre_empresa"),distribuidor.getShowDistribuidor().getString("id_distribuidor")));
            }
        }
        catch(SQLException ex){
             System.out.println("Error al llenar la tabla!");
        }
    }
        /*public void mostrarDistribuidor(){
        distribuidor.show();
        try{
            while(distribuidor.getShow().next()){
                cmbDistribuidor.addItem(distribuidor.getShow().getString("nombre_empresa"));
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }*/
}
