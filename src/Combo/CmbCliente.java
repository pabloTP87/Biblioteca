package Combo;

/**
 *
 * @author Pablo
 */
public class CmbCliente {
    private String idCliente;
    private String rut;
    
    public CmbCliente(String rut, String idCliente){
        this.rut=rut;
        this.idCliente=idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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
