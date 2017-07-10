package Combo;

/**
 *
 * @author Pablo
 */
public class CmbTrabajador {
    private String idTrabajador;
    private String rut;
    
    public CmbTrabajador(String rut, String idTrabajador){
        this.rut=rut;
        this.idTrabajador=idTrabajador;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    @Override
    public String toString(){
        return rut;
    }
}
