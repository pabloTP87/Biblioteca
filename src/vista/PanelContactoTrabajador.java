package vista;

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
import negocio.ContactoTrabajador;
import negocio.Trabajador;

/**
 *
 * @author Pablo
 */
public class PanelContactoTrabajador extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    
    JLabel lblId=new JLabel("ID:");
    JLabel lblId_trabajador=new JLabel("Seleccione Rut del Trabajador:");
    JLabel lblDireccion=new JLabel("Direccion:");
    JLabel lblTelefono=new JLabel("Telefono:");
    JLabel lblCorreo=new JLabel("Correo:");
      
    JComboBox cmbId_trabajador=new JComboBox();
    JTextField txtId=new JTextField();
    JTextField txtDireccion=new JTextField();
    JTextField txtTelefono=new JTextField();
    JTextField txtCorreo=new JTextField();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    ContactoTrabajador contactoTrabajador=new ContactoTrabajador();
    Trabajador trabajador=new Trabajador();
    
    DefaultComboBoxModel value= new DefaultComboBoxModel();
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Direciòn");
            modelo.addColumn("Telefono");
            modelo.addColumn("Correo");                 
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelContactoTrabajador(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(5,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //elementos en panel
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblId_trabajador);pnlElementos.add(cmbId_trabajador);      
        pnlElementos.add(lblDireccion);pnlElementos.add(txtDireccion);
        pnlElementos.add(lblTelefono);pnlElementos.add(txtTelefono);
        pnlElementos.add(lblCorreo);pnlElementos.add(txtCorreo);
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
        llenarCombo();
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                cmbId_trabajador.setSelectedItem(""+tabla.getValueAt(row, 1));
                cmbId_trabajador.setSelectedItem(""+tabla.getValueAt(row, 2));
                txtDireccion.setText(""+tabla.getValueAt(row, 3));
                txtTelefono.setText(""+tabla.getValueAt(row, 4));
                txtCorreo.setText(""+tabla.getValueAt(row, 5));
                contactoTrabajador.setId_trabajador((String)tabla.getValueAt(row, 0));
            }
        });
    }
    
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {            
            contactoTrabajador.setDireccion(txtDireccion.getText());
            contactoTrabajador.setTelefono(txtTelefono.getText());
            contactoTrabajador.setCorreo(txtCorreo.getText());
            CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbId_trabajador.getSelectedItem();
            contactoTrabajador.setId_trabajador(CmbTrabajador.getIdTrabajador());
            contactoTrabajador.guardar();
            limpiar();
            llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            contactoTrabajador.eliminar();
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
            contactoTrabajador.setId_contacto(txtId.getText());           
            contactoTrabajador.setDireccion(txtDireccion.getText());
            contactoTrabajador.setTelefono(txtTelefono.getText());
            contactoTrabajador.setCorreo(txtCorreo.getText());
            //Actualizar con datos del combobox
            CmbTrabajador CmbTrabajador=(CmbTrabajador)cmbId_trabajador.getSelectedItem();
            contactoTrabajador.setId_trabajador(CmbTrabajador.getIdTrabajador());
            contactoTrabajador.actualizar();
            limpiar();
            llenarTabla();
        }       
    }
    
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[6];
        contactoTrabajador.show();
        try{
            while(contactoTrabajador.getShow().next()){
                elementos[0]=contactoTrabajador.getShow().getString("id_contacto");
                elementos[1]=contactoTrabajador.getShow().getString("nombre_trabajador");
                elementos[2]=contactoTrabajador.getShow().getString("apepat_trabajador");
                elementos[3]=contactoTrabajador.getShow().getString("direccion");
                elementos[4]=contactoTrabajador.getShow().getString("telefono");
                elementos[5]=contactoTrabajador.getShow().getString("correo");
                modelo.addRow(elementos);
            }
        }
        catch (SQLException ex){
            System.out.println("Error al llenar la tabla!");
        }
    }
    
    public void limpiar(){
        txtId.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");       
    }

    public void llenarCombo(){
       try{
          trabajador.showTrabajador();
          cmbId_trabajador.setModel(value);
          while(trabajador.getShowTrabajador().next()){
              value.addElement(new CmbTrabajador(trabajador.getShowTrabajador().getString("rut_trabajador"),trabajador.getShowTrabajador().getString("id_trabajador")));
          }
        }
       catch(SQLException ex){
           System.out.println("error al llenar combo");
        }
    }
}
