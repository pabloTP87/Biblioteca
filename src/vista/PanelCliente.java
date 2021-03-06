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
import negocio.Cliente;

/**
 *
 * @author Pablo
 */
public class PanelCliente extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblRut=new JLabel("Rut:");
    JLabel lblNombre=new JLabel("Nombre:");
    JLabel lblApepat=new JLabel("1er apellido:");
    JLabel lblApemat=new JLabel("2do apellido:");
    JLabel lblFecha=new JLabel("Fecha de nacimiento:");
  
    JTextField txtId=new JTextField();
    JTextField txtRut=new JTextField();
    JTextField txtNombre=new JTextField();
    JTextField txtApepat=new JTextField();
    JTextField txtApemat=new JTextField();
    JTextField txtFecha=new JTextField();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    Cliente trabajador=new Cliente();
    
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Rut");
            modelo.addColumn("Nombre");
            modelo.addColumn("1er apellido");
            modelo.addColumn("2do apellido");
            modelo.addColumn("Fecha de nacimiento");                    
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);
    
    public PanelCliente(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(6,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        //elementos en panel
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblRut);pnlElementos.add(txtRut);      
        pnlElementos.add(lblNombre);pnlElementos.add(txtNombre);
        pnlElementos.add(lblApepat);pnlElementos.add(txtApepat);
        pnlElementos.add(lblApemat);pnlElementos.add(txtApemat);
        pnlElementos.add(lblFecha);pnlElementos.add(txtFecha);
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
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row=tabla.getSelectedRow();
                System.out.println("Tabla Presionada"+tabla.getValueAt(row, 0));
                txtId.setText(""+tabla.getValueAt(row, 0));
                txtRut.setText(""+tabla.getValueAt(row, 1));
                txtNombre.setText(""+tabla.getValueAt(row, 2));
                txtApepat.setText(""+tabla.getValueAt(row, 3));
                txtApemat.setText(""+tabla.getValueAt(row, 4));
                txtFecha.setText(""+tabla.getValueAt(row, 5));
                trabajador.setId_cliente((String)tabla.getValueAt(row, 0));
            }
        });
    }
    
    class OyenteGuardar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            trabajador.setNombre_cliente(txtNombre.getText());
            trabajador.setRut(txtRut.getText());
            trabajador.setNombre_cliente(txtNombre.getText());
            trabajador.setApepat(txtApepat.getText());
            trabajador.setApemat(txtApemat.getText());
            trabajador.setFecha_nac(txtFecha.getText());
            trabajador.guardar();
            limpiar();
            llenarTabla();
        }        
    }
    class OyenteEliminar implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            trabajador.eliminar();
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
            trabajador.setId_cliente(txtId.getText());
            trabajador.setRut(txtRut.getText());
            trabajador.setNombre_cliente(txtNombre.getText());
            trabajador.setApepat(txtApepat.getText());
            trabajador.setApemat(txtApemat.getText());
            trabajador.setFecha_nac(txtFecha.getText()); 
            trabajador.actualizar();
            limpiar();
            llenarTabla();
        }       
    }
    
    public void llenarTabla(){
        modelo.setNumRows(0);
        Object[] elementos=new Object[6];
        trabajador.show();
        try{
            while(trabajador.getShow().next()){
                elementos[0]=trabajador.getShow().getString("id_cliente");
                elementos[1]=trabajador.getShow().getString("rut");
                elementos[2]=trabajador.getShow().getString("nombre_cliente");
                elementos[3]=trabajador.getShow().getString("apepat_cliente");
                elementos[4]=trabajador.getShow().getString("apemat_cliente");
                elementos[5]=trabajador.getShow().getString("fecha_nac");
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
        txtApepat.setText("");
        txtApemat.setText("");
        txtFecha.setText("");        
    }
}
