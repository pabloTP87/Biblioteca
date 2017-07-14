
package Combo;

public class CmbEstado {
    private String estado;
    private String idEstado;
    
    public CmbEstado(String estado, String idEstado){
        this.estado=estado;
        this.idEstado=idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
    
    @Override
    public String toString(){
        return estado;
    }

}
