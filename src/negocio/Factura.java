package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Factura {
    private String id_factura;
    private String folio_factura;
    private String precio_neto;
    private String precio_iva;
    private String costo_iva;
    private String fecha_compra;
    private String hora_compra;
    private String metodo_pago;
    private String id_distribuidor;
    Conexion con;
    
    public Factura(){
        con=new Conexion();
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public void setFolio_factura(String folio_factura) {
        this.folio_factura = folio_factura;
    }

    public void setPrecio_neto(String precio_neto) {
        this.precio_neto = precio_neto;
    }

    public void setPrecio_iva(String precio_iva) {
        this.precio_iva = precio_iva;
    }

    public void setCosto_iva(String costo_iva) {
        this.costo_iva = costo_iva;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setHora_compra(String hora_compra) {
        this.hora_compra = hora_compra;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setId_distribuidor(String id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getId_factura() {
        return id_factura;
    }

    public String getFolio_factura() {
        return folio_factura;
    }

    public String getPrecio_neto() {
        return precio_neto;
    }

    public String getPrecio_iva() {
        return precio_iva;
    }

    public String getCosto_iva() {
        return costo_iva;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public String getHora_compra() {
        return hora_compra;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }
   
    public String getId_distribuidor() {
        return id_distribuidor;
    }
    
    public void guardar(){
        con.setExecuteUpdate("insert into facturas(folio_factura,precio_neto,precio_iva,costo_iva,fecha_compra,hora_compra,metodo_pago,id_distribuidor) values('"+this.getFolio_factura()+"','"+this.getPrecio_neto()+"','"+this.getPrecio_iva()+"','"+this.getCosto_iva()+"','"+this.getFecha_compra()+"','"+this.getHora_compra()+"','"+this.getMetodo_pago()+"','"+this.getId_distribuidor()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from facturas where id_factura='"+this.getId_factura()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update facturas set folio_factura='"+this.getFolio_factura()+"',precio_neto='"+this.getPrecio_neto()+"',precio_iva='"+this.getPrecio_iva()+"',costo_iva='"+this.getCosto_iva()+"',fecha_compra='"+this.getFecha_compra()+"',hora_compra='"+this.getHora_compra()+"',metodo_pago='"+this.getMetodo_pago()+"',id_distribuidor='"+this.getId_distribuidor()+"' where id_factura='"+this.getId_factura()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from facturas,distribuidores where facturas.id_distribuidor=distribuidores.id_distribuidor order by id_factura");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
            
    public void showFactura(){
        con.setExecuteQuery("select id_factura, folio_factura from facturas");
    }

    public ResultSet getShowFactura(){
        return con.getRs();
    }
    
}
