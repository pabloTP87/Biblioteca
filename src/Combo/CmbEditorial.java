
package Combo;

public class CmbEditorial {
    private String editorial;
    private String idEditorial;
    
    public CmbEditorial(String editorial, String idEditorial){
        this.editorial=editorial;
        this.idEditorial=idEditorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIdEditorial(String idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIdEditorial() {
        return idEditorial;
    }
    
    @Override
    public String toString(){
        return editorial;
    }
}
