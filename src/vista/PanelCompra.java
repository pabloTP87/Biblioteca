package vista;

import Combo.CmbDistribuidor;
import Combo.CmbFactura;
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
import negocio.Compra;
import negocio.Distribuidor;
import negocio.Factura;

public class PanelCompra extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblLibro=new JLabel("Libro:");
    JLabel lblCantidad=new JLabel("Cantidad:");
    JLabel lblDistribuidor=new JLabel("Distribuidor");
    JLabel lblFactura=new JLabel("Folio de Factura");
  
    JTextField txtId=new JTextField();
    JTextField txtLibro=new JTextField();
    JTextField txtCantidad=new JTextField();

    JComboBox cmbDist=new JComboBox();
    JComboBox cmbFactura=new JComboBox();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Factura factura=new Factura();
    Distribuidor distribuidor=new Distribuidor();
    Compra compra=new Compra();
    DefaultComboBoxModel value=new DefaultComboBoxModel();
    DefaultComboBoxModel valueFactura=new DefaultComboBoxModel();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Libro");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Factura");
            modelo.addColumn("Distribuidor");                       
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
        public PanelCompra(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(5,2));
        pnlBotones.setLayout(new GridLayout(4,1,10,10));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblLibro);pnlElementos.add(txtLibro);      
        pnlElementos.add(lblCantidad);pnlElementos.add(txtCantidad);
        pnlElementos.add(lblDistribuidor);pnlElementos.add(cmbDist);
        pnlElementos.add(lblFactura);pnlElementos.add(cmbFactura);
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
        llenarComboDist();
        llenarComboFact();
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                txtLibro.setText(""+tabla.getValueAt(row, 1));
                txtCantidad.setText(""+tabla.getValueAt(row, 2));
                cmbDist.setSelectedItem(""+tabla.getValueAt(row, 3));
                cmbFactura.setSelectedItem(""+tabla.getValueAt(row, 4));
                compra.setId_compra((String) tabla.getValueAt(row, 0));
            }
});
    }
        
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           compra.setLibro_comprado(txtLibro.getText());
           compra.setCantidad(txtCantidad.getText());
           CmbDistribuidor CmbDistribuidor=(CmbDistribuidor)cmbDist.getSelectedItem();
           compra.setId_distribuidor(CmbDistribuidor.getId());
           CmbFactura CmbFactura=(CmbFactura)cmbFactura.getSelectedItem();
           compra.setId_factura(CmbFactura.getIdFactura());
           compra.guardar();
           limpiar();
           llenarTabla(); 
        }
        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            compra.eliminar();
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
           compra.setId_factura(txtId.getText());
           compra.setLibro_comprado(txtLibro.getText());
           compra.setCantidad(txtCantidad.getText());
           
           CmbDistribuidor CmbDistribuidor=(CmbDistribuidor)cmbDist.getSelectedItem();
           compra.setId_distribuidor(CmbDistribuidor.getId());
           
           CmbFactura CmbFactura=(CmbFactura)cmbFactura.getSelectedItem();
           compra.setId_factura(CmbFactura.getIdFactura());
           
           compra.actualizar();
           limpiar();
           llenarTabla(); 
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[5];
        compra.show();
        try{
            while(compra.getShow().next()){
                elementos[0]=compra.getShow().getString("id_compra");
                elementos[1]=compra.getShow().getString("libro_comprado");
                elementos[2]=compra.getShow().getString("cantidad");
                elementos[3]=compra.getShow().getString("folio_factura");
                elementos[4]=compra.getShow().getString("nombre_empresa");
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    public void limpiar(){
        txtId.setText("");
        txtLibro.setText("");
        txtCantidad.setText("");
    }
    public void llenarComboDist(){
        try{
         distribuidor.showDistribuidor();
         cmbDist.setModel(value);
         while(distribuidor.getShowDistribuidor().next()){
             value.addElement(new CmbDistribuidor(distribuidor.getShowDistribuidor().getString("nombre_empresa"),distribuidor.getShowDistribuidor().getString("id_distribuidor")));
         }
        }
        catch(SQLException ex){
             System.out.println("Ergdgror al llenar la tabla!");
        }
    }
        public void llenarComboFact(){
        try{
         factura.showFactura();
         cmbFactura.setModel(valueFactura);
         while(factura.getShowFactura().next()){
             valueFactura.addElement(new CmbFactura(factura.getShowFactura().getString("folio_factura"),factura.getShowFactura().getString("id_factura")));
         }
        }
        catch(SQLException ex){
             System.out.println("Ergdgror al llenar la tabla!");
        }
    }
}
