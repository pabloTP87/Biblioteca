package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class Venta {
    private String id_venta;
    private String id_libro;
    private String id_cliente;
    private String id_trabajador;
    private String id_boleta;
    Conexion con;
    
    public Venta(){
        con=new Conexion();
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_trabajador(String id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public void setId_boleta(String id_boleta) {
        this.id_boleta = id_boleta;
    }

    public String getId_venta() {
        return id_venta;
    }

    public String getId_libro() {
        return id_libro;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getId_trabajador() {
        return id_trabajador;
    }

    public String getId_boleta() {
        return id_boleta;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into Ventas(id_libro,id_cliente,id_trabajador,id_boleta) values('"+this.getId_libro()+"','"+this.getId_cliente()+"','"+this.getId_trabajador()+"','"+this.getId_boleta()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from Ventas where id_venta='"+this.getId_venta()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update Ventas set id_libro='"+this.getId_libro()+"',id_cliente='"+this.getId_cliente()+"',id_trabajador='"+this.getId_trabajador()+"',id_boleta='"+this.getId_boleta()+"' where id_venta='"+this.getId_venta()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from Ventas");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
