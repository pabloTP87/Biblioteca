package Combo;

public class CmbLibro {
    private String idLibro;
    private String titulo;
    
    public CmbLibro(String titulo, String idLibro){
        this.titulo=titulo;
        this.idLibro=idLibro;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString(){
        return titulo;
    }
}
