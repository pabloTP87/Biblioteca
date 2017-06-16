package Combo;
public class CmbDistribuidor {
    private String nombre;
    private String id;
    
    public CmbDistribuidor(String nombre, String id){
        this.nombre=nombre;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return nombre;
    }
}
