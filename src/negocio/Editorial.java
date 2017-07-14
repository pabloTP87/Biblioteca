package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Editorial {
    private String id_editorial;
    private String nombre_editorial;
    Conexion con;
    
    public Editorial(){
        con=new Conexion();
    }
    //SET
    public void setId_editorial(String id_editorial) {
        this.id_editorial = id_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }
    //GET
    public String getId_editorial() {
        return id_editorial;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into editoriales (nombre_editorial) values('"+this.getNombre_editorial()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from editoriales where id_editorial='"+this.getId_editorial()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update editoriales set nombre_editorial='"+this.getNombre_editorial()+"' where id_editorial='"+this.getId_editorial()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from editoriales");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
