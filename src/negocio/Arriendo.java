
package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Arriendo {
    private String id_arriendo;
    private String id_libro;
    private String costo_total;
    private String fecha_arriendo;
    private String fecha_devolucion;
    private String fecha_entrega;
    private String dias_atraso;
    private String multa;
    private String costo_arriendo;
    private String id_cliente;
    private String id_trabajador;
    Conexion con;
    
    public Arriendo(){
        con=new Conexion();
    }

    public String getId_arriendo() {
        return id_arriendo;
    }

    public void setId_arriendo(String id_arriendo) {
        this.id_arriendo = id_arriendo;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(String costo_total) {
        this.costo_total = costo_total;
    }

    public String getFecha_arriendo() {
        return fecha_arriendo;
    }

    public void setFecha_arriendo(String fecha_arriendo) {
        this.fecha_arriendo = fecha_arriendo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDias_atraso() {
        return dias_atraso;
    }

    public void setDias_atraso(String dias_atraso) {
        this.dias_atraso = dias_atraso;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String getCosto_arriendo() {
        return costo_arriendo;
    }

    public void setCosto_arriendo(String costo_arriendo) {
        this.costo_arriendo = costo_arriendo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(String id_trabajador) {
        this.id_trabajador = id_trabajador;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into arriendos(id_libro,costo_total,fecha_arriendo,fecha_devolucion,fecha_entrega,dias_atraso,multa,costo_arriendo,id_cliente,id_trabajador) values('"+this.getId_libro()+"','"+this.getCosto_total()+"','"+this.getFecha_arriendo()+"','"+this.getFecha_devolucion()+"','"+this.getFecha_entrega()+"','"+this.getDias_atraso()+"','"+this.getMulta()+"','"+this.getCosto_arriendo()+"','"+this.getId_cliente()+"','"+this.getId_trabajador()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from arriendos where id_arriendo='"+this.getId_arriendo()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update arriendos set id_libro='"+this.getId_libro()+"',costo_total='"+this.getCosto_total()+"',fecha_arriendo='"+this.getFecha_arriendo()+"',fecha_devolucion='"+this.getFecha_devolucion()+"',fecha_entrega='"+this.getFecha_entrega()+"',dias_atraso='"+this.getDias_atraso()+"',multa='"+this.getMulta()+"',costo_arriendo='"+this.getCosto_arriendo()+"',id_cliente='"+this.getId_cliente()+"',id_trabajador='"+this.getId_trabajador()+"' where id_arriendo='"+this.getId_arriendo()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from arriendos,libros,clientes,trabajadores WHERE arriendos.id_libro=libros.id_libro and arriendos.id_cliente=clientes.id_cliente and arriendos.id_trabajador=trabajadores.id_trabajador");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
