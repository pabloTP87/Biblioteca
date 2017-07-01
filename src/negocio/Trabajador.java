package negocio;
import acceso.Conexion;
import java.sql.ResultSet;
public class Trabajador {
    private String id_trabajador;
    private String rut_trabajador;
    private String nombre_trabajador;
    private String apepat;
    private String apemat;
    private String fecha_contrato;
    Conexion con;
    
    public Trabajador(){
        con=new Conexion();
    }
    //SET
    public void setId_trabajador(String id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public void setFecha_contrato(String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }
    //GET
    public String getId_trabajador() {
        return id_trabajador;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public String getApepat() {
        return apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public String getFecha_contrato() {
        return fecha_contrato;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into trabajadores(rut_trabajador,nombre_trabajador,ap_paterno,ap_materno,fecha_contrato) values('"+this.getRut_trabajador()+"','"+this.getNombre_trabajador()+"','"+this.getApepat()+"','"+this.getApemat()+"','"+this.getFecha_contrato()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from trabajadores where id_trabajador='"+this.getId_trabajador()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update trabajadores set rut_trabajador='"+this.getRut_trabajador()+"',nombre_trabajador='"+this.getNombre_trabajador()+"',ap_paterno='"+this.getApepat()+"',ap_materno='"+this.getApemat()+"',fecha_contrato='"+this.getFecha_contrato()+"' where id_trabajador='"+this.getId_trabajador()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from trabajadores");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
