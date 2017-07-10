package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class ContactoTrabajador {
    private String id_contacto;
    private String direccion;
    private String telefono;
    private String correo;
    private String id_trabajador;
    Conexion con;
    
    public ContactoTrabajador(){
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

    public void setId_trabajador(String id_trabajador) {
        this.id_trabajador = id_trabajador;
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

    public String getId_trabajador() {
        return id_trabajador;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into contacto_trabajadores(direccion,telefono,correo,id_trabajador) values('"+this.getDireccion()+"','"+this.getTelefono()+"','"+this.getCorreo()+"','"+this.getId_trabajador()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from contacto_trabajadores where id_contacto='"+this.getId_contacto()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update contacto_trabajadores set direccion='"+this.getDireccion()+"',telefono='"+this.getTelefono()+"',correo='"+this.getCorreo()+"',id_trabajador='"+this.getId_trabajador()+"' where id_contacto='"+this.getId_contacto()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from contacto_trabajadores,trabajadores where contacto_trabajadores.id_trabajador=trabajadores.id_trabajador");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
