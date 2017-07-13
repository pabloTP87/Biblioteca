package vista;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.Distribuidor;

public class PanelDistribuidor extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblid=new JLabel("Id");
    JLabel lblNombre=new JLabel("Nombre Distribuidor:");
    JLabel lblRut=new JLabel("Rut empresa:");
    JLabel lblAñoVenta=new JLabel("Año Venta:");
    JLabel lblDireccion=new JLabel("Direccion:");
    JLabel lblTelefono=new JLabel("Telefono:");
    JTextField txtId=new JTextField();
    JTextField txtNombre=new JTextField();
    JTextField txtRut=new JTextField();
    JTextField txtAñoVenta=new JTextField();
    JTextField txtDireccion=new JTextField();
    JTextField txtTelefono=new JTextField();
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    Distribuidor distribuidor=new Distribuidor();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Nombre Distribuidor");
            modelo.addColumn("Rut Empresa");
            modelo.addColumn("Año Venta");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelDistribuidor(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(6,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //labels y cajas de texto
        pnlElementos.add(lblid);pnlElementos.add(txtId);      
        pnlElementos.add(lblNombre);pnlElementos.add(txtNombre);
        pnlElementos.add(lblRut);pnlElementos.add(txtRut);
        pnlElementos.add(lblAñoVenta);pnlElementos.add(txtAñoVenta);
        pnlElementos.add(lblDireccion);pnlElementos.add(txtDireccion);
        pnlElementos.add(lblTelefono);pnlElementos.add(txtTelefono);
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                txtNombre.setText(""+tabla.getValueAt(row, 1));
                txtRut.setText(""+tabla.getValueAt(row, 2));
                txtAñoVenta.setText(""+tabla.getValueAt(row, 3));
                txtDireccion.setText(""+tabla.getValueAt(row, 4));
                txtTelefono.setText(""+tabla.getValueAt(row, 5));
                distribuidor.setId_distribuidor((String)tabla.getValueAt(row, 0));
            }
        });
    }
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            distribuidor.setNombre_empresa(txtNombre.getText());
            distribuidor.setRut(txtRut.getText());
            distribuidor.setAño_venta(txtAñoVenta.getText());
            distribuidor.setDireccion(txtDireccion.getText());
            distribuidor.setTelefono(txtTelefono.getText());
            distribuidor.guardar();
            limpiar();
            llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            distribuidor.eliminar();
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
            distribuidor.setId_distribuidor(txtId.getText());
            distribuidor.setNombre_empresa(txtNombre.getText());
            distribuidor.setRut(txtRut.getText());
            distribuidor.setAño_venta(txtAñoVenta.getText());
            distribuidor.setDireccion(txtDireccion.getText());
            distribuidor.setTelefono(txtTelefono.getText()); 
            distribuidor.actualizar();
            limpiar();
            llenarTabla();
        }       
    }
    
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[6];
        distribuidor.show();
        try{
            while(distribuidor.getShow().next()){
                elementos[0]=distribuidor.getShow().getString("id_distribuidor");
                elementos[1]=distribuidor.getShow().getString("nombre_empresa");
                elementos[2]=distribuidor.getShow().getString("rut");
                elementos[3]=distribuidor.getShow().getString("año_venta");
                elementos[4]=distribuidor.getShow().getString("direccion");
                elementos[5]=distribuidor.getShow().getString("telefono");
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    
    public void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
        txtRut.setText("");
        txtAñoVenta.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");        
    }
}
