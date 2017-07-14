
package Combo;

public class CmbBoleta {
    private String idBoleta;
    private String folio;
    
    public CmbBoleta(String folio, String idBoleta){
        this.folio=folio;
        this.idBoleta=idBoleta;
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    @Override
    public String toString(){
        return folio;
    }
}
