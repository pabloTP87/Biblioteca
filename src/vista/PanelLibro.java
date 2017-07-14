package vista;

import Combo.CmbEditorial;
import Combo.CmbEstado;
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
import negocio.Editorial;
import negocio.Estado;
import negocio.Factura;
import negocio.Libro;

public class PanelLibro extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    
    JLabel lblId=new JLabel("ID:");
    JLabel lblNumSerie=new JLabel("Numero de serie:");
    JLabel lblIsbn=new JLabel("ISBN:");
    JLabel lblTitulo=new JLabel("Titulo:");
    JLabel lblPaginas=new JLabel("Numero de paginas:");
    JLabel lblPrecio=new JLabel("Precio:");
    JLabel lblAño=new JLabel("Año de publicacion:");
    JLabel lblEditorial=new JLabel("Editorial:");
    JLabel lblFactura=new JLabel("Folio Factura:");
    JLabel lblEstado=new JLabel("Estado:");
  
    JTextField txtId=new JTextField();
    JTextField txtNumSerie=new JTextField();
    JTextField txtIsbn=new JTextField();
    JTextField txtTitulo=new JTextField();
    JTextField txtPaginas=new JTextField();
    JTextField txtPrecio=new JTextField();
    JTextField txtAño=new JTextField();
    
    JComboBox cmbEditorial=new JComboBox();
    JComboBox cmbFactura=new JComboBox();
    JComboBox cmbEstado=new JComboBox();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Libro libro=new Libro();
    Factura factura=new Factura();
    Editorial editorial=new Editorial();
    Estado estado=new Estado();
       
    DefaultComboBoxModel modFactura=new DefaultComboBoxModel();
    DefaultComboBoxModel modEditorial=new DefaultComboBoxModel();
    DefaultComboBoxModel modEstado=new DefaultComboBoxModel();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("N° serie");
            modelo.addColumn("ISBN");
            modelo.addColumn("Titulo");
            modelo.addColumn("N° Paginas");
            modelo.addColumn("Precio");
            modelo.addColumn("Año");
            modelo.addColumn("Editorial");
            modelo.addColumn("N° Factura");
            modelo.addColumn("Estado");
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelLibro(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(10,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblNumSerie);pnlElementos.add(txtNumSerie);      
        pnlElementos.add(lblIsbn);pnlElementos.add(txtIsbn);
        pnlElementos.add(lblTitulo);pnlElementos.add(txtTitulo);
        pnlElementos.add(lblPaginas);pnlElementos.add(txtPaginas);
        pnlElementos.add(lblPrecio);pnlElementos.add(txtPrecio);
        pnlElementos.add(lblAño);pnlElementos.add(txtAño);
        pnlElementos.add(lblEditorial);pnlElementos.add(cmbEditorial);
        pnlElementos.add(lblFactura);pnlElementos.add(cmbFactura);
        pnlElementos.add(lblEstado);pnlElementos.add(cmbEstado);
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
        llenarComboFactura();
        llenarComboEditorial();
        llenarComboEstado();
        //mostrarDistribuidor();
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                txtNumSerie.setText(""+tabla.getValueAt(row, 1));
                txtIsbn.setText(""+tabla.getValueAt(row, 2));
                txtTitulo.setText(""+tabla.getValueAt(row, 3));
                txtPaginas.setText(""+tabla.getValueAt(row, 4));
                txtPrecio.setText(""+tabla.getValueAt(row, 5));
                txtAño.setText(""+tabla.getValueAt(row, 6));
                cmbEditorial.setSelectedItem(""+tabla.getValueAt(row, 7));
                cmbFactura.setSelectedItem(""+tabla.getValueAt(row, 8));
                cmbEstado.setSelectedItem(""+tabla.getValueAt(row, 8));
                libro.setId_libro((String) tabla.getValueAt(row, 0));
            }
});
        
    }
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           libro.setNumSerie(txtNumSerie.getText());
           libro.setIsbn(txtIsbn.getText());
           libro.setTitulo(txtTitulo.getText());
           libro.setNumPaginas(txtPaginas.getText());
           libro.setPrecio(txtPrecio.getText());
           libro.setAño(txtAño.getText());
           
           CmbEditorial CmbEditorial=(CmbEditorial)cmbEditorial.getSelectedItem();
           libro.setIdEditorial(CmbEditorial.getIdEditorial());
           
           CmbFactura CmbFactura=(CmbFactura)cmbFactura.getSelectedItem();
           libro.setIdFactura(CmbFactura.getIdFactura());
           
           CmbEstado CmbEstado=(CmbEstado)cmbEstado.getSelectedItem();
           libro.setIdEstado(CmbEstado.getIdEstado());
           
           libro.guardar();
           limpiar();
           llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            libro.eliminar();
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
           libro.setId_libro(txtId.getText());
           libro.setNumSerie(txtNumSerie.getText());
           libro.setIsbn(txtIsbn.getText());
           libro.setTitulo(txtTitulo.getText());
           libro.setNumPaginas(txtPaginas.getText());
           libro.setPrecio(txtPrecio.getText());
           libro.setAño(txtAño.getText());
           
           CmbEditorial CmbEditorial=(CmbEditorial)cmbEditorial.getSelectedItem();
           libro.setIdEditorial(CmbEditorial.getIdEditorial());
           
           CmbFactura CmbFactura=(CmbFactura)cmbFactura.getSelectedItem();
           libro.setIdFactura(CmbFactura.getIdFactura());
           
           CmbEstado CmbEstado=(CmbEstado)cmbEstado.getSelectedItem();
           libro.setIdEstado(CmbEstado.getIdEstado());
           
           libro.actualizar();
           limpiar();
           llenarTabla();
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[10];
        libro.show();
        try{
            while(libro.getShow().next()){
                elementos[0]=libro.getShow().getString("id_libro");
                elementos[1]=libro.getShow().getString("numero_serie");
                elementos[2]=libro.getShow().getString("isbn");
                elementos[3]=libro.getShow().getString("titulo");
                elementos[4]=libro.getShow().getString("numero_paginas");
                elementos[5]=libro.getShow().getString("precio");
                elementos[6]=libro.getShow().getString("año_publicacion");
                elementos[7]=libro.getShow().getString("nombre_editorial");
                elementos[8]=libro.getShow().getString("folio_factura");
                elementos[9]=libro.getShow().getString("estado");                
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    public void limpiar(){
        txtId.setText("");
        txtNumSerie.setText("");
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtPaginas.setText("");
        txtPrecio.setText(""); 
        txtAño.setText(""); 
    }
    
    public void llenarComboFactura(){
        try{
         factura.showFactura();
         cmbFactura.setModel(modFactura);
         while(factura.getShowFactura().next()){
            modFactura.addElement(new CmbFactura(factura.getShowFactura().getString("folio_factura"),factura.getShowFactura().getString("id_factura")));
            }
        }
        catch(SQLException ex){
            System.out.println("Error"+ex);
        }
    }
    public void llenarComboEditorial(){
        try{
         editorial.showEditorial();
         cmbEditorial.setModel(modEditorial);
         while(editorial.getShowEditorial().next()){
            modEditorial.addElement(new CmbEditorial(editorial.getShowEditorial().getString("nombre_editorial"),editorial.getShowEditorial().getString("id_editorial")));
            }
        }
        catch(SQLException ex){
            System.out.println("Error"+ex);
        }
    }
    public void llenarComboEstado(){
        try{
         estado.showEstado();
         cmbEstado.setModel(modEstado);
         while(estado.getShowEstado().next()){
            modEstado.addElement(new CmbEstado(estado.getShowEstado().getString("estado"),estado.getShowEstado().getString("id_estado")));
            }
        }
        catch(SQLException ex){
            System.out.println("Error"+ex);
        }
    }
}
