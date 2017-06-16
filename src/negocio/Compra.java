package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Compra {
    private String id_compra;
    private String libro_comprado;
    private String cantidad;
    private String id_distribuidor;
    private String id_factura;
    Conexion con;
    
    public Compra(){
        con=new Conexion();
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public void setLibro_comprado(String libro_comprado) {
        this.libro_comprado = libro_comprado;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setId_distribuidor(String id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getId_compra() {
        return id_compra;
    }

    public String getLibro_comprado() {
        return libro_comprado;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getId_distribuidor() {
        return id_distribuidor;
    }

    public String getId_factura() {
        return id_factura;
    }
    public void guardar(){
        con.setExecuteUpdate("insert into compras(libro_comprado,cantidad,id_distribuidor,id_factura) values('"+this.getLibro_comprado()+"','"+this.getCantidad()+"','"+this.getId_distribuidor()+"','"+this.getId_factura()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from compras where id_compra='"+this.getId_compra()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update compras set libro_comprado='"+this.getLibro_comprado()+"',cantidad='"+this.getCantidad()+"',id_distribuidor='"+this.getId_distribuidor()+"',id_factura='"+this.getId_factura()+"' where id_compra='"+this.getId_compra()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from compras,facturas,distribuidores where compras.id_factura=facturas.id_factura and compras.id_distribuidor=distribuidores.id_distribuidor");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
    
}
