package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Distribuidor {
    private String id_distribuidor;
    private String nombre_empresa;
    private String rut;
    private String año_venta;
    private String direccion;
    private String telefono;
    Conexion con;
    
    public Distribuidor(){
        con=new Conexion();
    }

    public void setId_distribuidor(String id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }


    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setAño_venta(String año_venta) {
        this.año_venta = año_venta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_distribuidor() {
        return this.id_distribuidor;
    }

    public String getNombre_empresa() {
        return this.nombre_empresa;
    }

    public String getRut() {
        return this.rut;
    }

    public String getAño_venta() {
        return this.año_venta;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }
    
    public void guardar(){
        con.setExecuteUpdate("insert into distribuidores(nombre_empresa,rut,año_venta,direccion,telefono) values('"+this.getNombre_empresa()+"','"+this.getRut()+"','"+this.getAño_venta()+"','"+this.getDireccion()+"','"+this.getTelefono()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from distribuidores where id_distribuidor='"+this.getId_distribuidor()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update distribuidores set nombre_empresa='"+this.getNombre_empresa()+"',rut='"+this.getRut()+"',año_venta='"+this.getAño_venta()+"',direccion='"+this.getDireccion()+"',telefono='"+this.getTelefono()+"' where id_distribuidor='"+this.getId_distribuidor()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from distribuidores");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
    public void showDistribuidor(){
        con.setExecuteQuery("select id_distribuidor, nombre_empresa from distribuidores");
    }
    public ResultSet getShowDistribuidor(){
        return con.getRs();
    }
}
