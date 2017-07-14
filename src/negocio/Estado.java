package negocio;

import acceso.Conexion;
import java.sql.ResultSet;

public class Estado {
    private String id_estado;
    private String estado;
    Conexion con;
    
    public Estado(){
        con=new Conexion();
    }
    //SET
    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //GET
    public String getId_estado() {
        return id_estado;
    }

    public String getEstado() {
        return estado;
    }
    //SQL
    public void guardar(){
        con.setExecuteUpdate("insert into estados (estado) values('"+this.getEstado()+"')");
    }
    public void eliminar(){
        con.setExecuteUpdate("delete from estados where id_estado='"+this.getId_estado()+"'");
    }
    public void actualizar(){
        con.setExecuteUpdate("update estados set estado='"+this.getEstado()+"' where id_estado='"+this.getId_estado()+"'");
    }
    public void show(){
        con.setExecuteQuery("select * from estados");
    }
    public ResultSet getShow(){
        return con.getRs();
    }
}
