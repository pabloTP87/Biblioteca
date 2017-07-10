package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class ContactoCliente {
    private String id_contacto;
    private String direccion;
    private String telefono;
    private String correo;
    private String id_cliente;
    Conexion con;
    
    public ContactoCliente(){
        con=new Conexion();
    }
    //SET
    public void setId_contacto(String id_contacto) {
        this.id_contacto = id_contacto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    //GET
    public String getId_contacto() {
        return id_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getId_cliente() {
        return id_cliente;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into contacto_clientes(direccion,telefono,correo,id_cliente) values('"+this.getDireccion()+"','"+this.getTelefono()+"','"+this.getCorreo()+"','"+this.getId_cliente()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from contacto_trabajadores where id_contacto='"+this.getId_contacto()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update contacto_clientes set direccion='"+this.getDireccion()+"',telefono='"+this.getTelefono()+"',correo='"+this.getCorreo()+"',id_cliente='"+this.getId_cliente()+"' where id_contacto='"+this.getId_contacto()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from contacto_clientes,clientes where contacto_clientes.id_cliente=clientes.id_cliente");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
