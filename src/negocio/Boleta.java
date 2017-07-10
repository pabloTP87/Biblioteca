package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Pablo
 */
public class Boleta {
    private String id_boleta;
    private String folio_boleta;
    private double precio_neto;
    private double precio_iva;
    private double costo_iva;
    private String fecha_venta;
    private String hora_venta;
    private String id_cliente;
    private String Id_trabajador;
    private String metodo_pago;    
    Conexion con;
    
    public Boleta(){
        con=new Conexion();
    }
    //SET
    public void setId_boleta(String id_boleta) {
        this.id_boleta = id_boleta;
    }

    public void setFolio_boleta(String folio_boleta) {
        this.folio_boleta = folio_boleta;
    }

    public void setPrecio_neto(double precio_neto) {
        this.precio_neto = precio_neto;
    }

    public void setPrecio_iva(double precio_iva) {
        this.precio_iva = precio_iva;
    }

    public void setCosto_iva(double costo_iva) {
        this.costo_iva = costo_iva;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setHora_venta(String hora_venta) {
        this.hora_venta = hora_venta;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_trabajador(String Id_trabajador) {
        this.Id_trabajador = Id_trabajador;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    //GET

    public String getId_boleta() {
        return id_boleta;
    }

    public String getFolio_boleta() {
        return folio_boleta;
    }

    public double getPrecio_neto() {
        precio_neto=precio_iva-costo_iva;
        return precio_neto;
    }

    public double getPrecio_iva() {
        return precio_iva;
    }

    public double getCosto_iva() {
        costo_iva=precio_iva*0.19;
        return costo_iva;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public String getHora_venta() {
        return hora_venta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getId_trabajador() {
        return Id_trabajador;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into boletas(folio_boleta,precio_neto,precio_iva,costo_iva,fecha_venta,hora_venta,id_cliente,id_trabajador,metodo_pago) values('"+this.getFolio_boleta()+"','"+this.getPrecio_neto()+"','"+this.getPrecio_iva()+"','"+this.getCosto_iva()+"','"+this.getFecha_venta()+"','"+this.getHora_venta()+"','"+this.getId_cliente()+"','"+this.getId_trabajador()+"','"+this.getMetodo_pago()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from boletas where id_boleta='"+this.getId_boleta()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update boletas set folio_boleta='"+this.getFolio_boleta()+"',precio_neto='"+this.getPrecio_neto()+"',precio_iva='"+this.getPrecio_iva()+"',costo_iva='"+this.getCosto_iva()+"',fecha_venta='"+this.getFecha_venta()+"',hora_venta='"+this.getHora_venta()+"',id_cliente='"+this.getId_cliente()+"',id_trabajador='"+this.getId_trabajador()+"',metodo_pago='"+this.getMetodo_pago()+"' where id_boleta='"+this.getId_boleta()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from boletas,clientes,trabajadores where boletas.id_cliente=clientes.id_cliente and boletas.id_trabajador=trabajadores.id_trabajador");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
