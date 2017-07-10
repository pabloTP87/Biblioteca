package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class Cliente {
    private String id_cliente;
    private String rut;
    private String nombre_cliente;
    private String apepat;
    private String apemat;
    private String fecha_nac;
    Conexion con;
    
    public Cliente(){
        con=new Conexion();
    }
    //SET

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    //GET

    public String getId_cliente() {
        return id_cliente;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getApepat() {
        return apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into clientes(rut,nombre_cliente,apepat_cliente,apemat_cliente,fecha_nac) values('"+this.getRut()+"','"+this.getNombre_cliente()+"','"+this.getApepat()+"','"+this.getApemat()+"','"+this.getFecha_nac()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from clientes where id_cliente='"+this.getId_cliente()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update clientes set rut='"+this.getRut()+"',nombre_cliente='"+this.getNombre_cliente()+"',apepat_cliente='"+this.getApepat()+"',apemat_cliente='"+this.getApemat()+"',fecha_nac='"+this.getFecha_nac()+"' where id_cliente='"+this.getId_cliente()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from clientes");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
    public void showCliente(){
        con.setExecuteQuery("select id_cliente,rut from clientes");
    }
    public ResultSet getShowCliente(){
        return con.getRs();
    }
}
