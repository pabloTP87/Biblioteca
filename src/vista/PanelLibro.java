package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
    
    String estados[]={"Disponible","Arrendado","Vendido","Mal estado"};
    JComboBox cmbEstado=new JComboBox(estados);
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Libro libro=new Libro();
       

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
           libro.actualizar();
           limpiar();
           llenarTabla();
        }        
    }
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[9];
        libro.show();
        try{
            while(libro.getShow().next()){
                elementos[0]=libro.getShow().getString("id_factura");
                elementos[1]=libro.getShow().getString("folio_factura");
                elementos[2]=libro.getShow().getString("precio_neto");
                elementos[3]=libro.getShow().getString("precio_iva");
                elementos[4]=libro.getShow().getString("costo_iva");
                elementos[5]=libro.getShow().getString("fecha_compra");
                elementos[6]=libro.getShow().getString("hora_compra");
                elementos[7]=libro.getShow().getString("metodo_pago");
                elementos[8]=libro.getShow().getString("nombre_empresa");                
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
}
