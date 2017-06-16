package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    String usuario="root";
    String clave="";
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", usuario, clave);
        }
        catch (Exception ex){
            System.out.println("Error de Conexion" + ex.getMessage());
        }
    }
    public void setExecuteUpdate(String sql){
        try{
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    public void setExecuteQuery(String sql){
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
        }
        catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    public ResultSet getRs(){
        return this.rs;
    }
            
}
