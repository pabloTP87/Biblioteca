package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelTrabajador extends JPanel{
    JPanel pnlElementos=new JPanel();
    JPanel pnlBotones=new JPanel();
    JPanel pnlSuperior=new JPanel();
    JLabel lblId=new JLabel("ID:");
    JLabel lblRut=new JLabel("Rut:");
    JLabel lblNombre=new JLabel("Nombre:");
    JLabel lblApepat=new JLabel("1er apellido:");
    JLabel lblApemat=new JLabel("2do apellido:");
    JLabel lblContrato=new JLabel("Fecha de Contrato:");
  
    JTextField txtId=new JTextField();
    JTextField txtRut=new JTextField();
    JTextField txtNombre=new JTextField();
    JTextField txtApepat=new JTextField();
    JTextField txtApemat=new JTextField();
    JTextField txtCOntrato=new JTextField();
    
    JButton btnLimpiar=new JButton("Limpiar");
    JButton btnGuardar=new JButton("Guardar");
    JButton btnEliminar=new JButton("Eliminar");
    JButton btnActualizar=new JButton("Actualizar");
    
    DefaultTableModel modelo=new DefaultTableModel();
        {
            modelo.addColumn("Id");
            modelo.addColumn("Rut");
            modelo.addColumn("Nombre");
            modelo.addColumn("1er apellido");
            modelo.addColumn("2do apellido");
            modelo.addColumn("Fecha de contrato");
                    
        }
    JTable tabla=new JTable(modelo);
    JScrollPane scroll=new JScrollPane(tabla);

    public PanelTrabajador(){
        txtId.setEditable(false);
        pnlElementos.setLayout(new GridLayout(6,2));
        pnlBotones.setLayout(new GridLayout(4,1));
        pnlSuperior.setLayout(new GridLayout(1,2));
        
        pnlElementos.add(lblId);pnlElementos.add(txtId);
        pnlElementos.add(lblRut);pnlElementos.add(txtRut);      
        pnlElementos.add(lblNombre);pnlElementos.add(txtNombre);
        pnlElementos.add(lblApepat);pnlElementos.add(txtApepat);
        pnlElementos.add(lblApemat);pnlElementos.add(txtApemat);
        pnlElementos.add(lblContrato);pnlElementos.add(txtCOntrato);
        //botones
        pnlBotones.add(btnLimpiar);pnlBotones.add(btnGuardar);     
        pnlBotones.add(btnEliminar);pnlBotones.add(btnActualizar);
                 
        pnlSuperior.add(pnlElementos);pnlSuperior.add(pnlBotones);
        
        this.setLayout(new BorderLayout());
        this.add(pnlSuperior,BorderLayout.NORTH);
        this.add(scroll,BorderLayout.CENTER);
    }
}
