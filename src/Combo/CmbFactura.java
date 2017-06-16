package Combo;
public class CmbFactura {
    private String folio;
    private String idFactura;
    
    public CmbFactura(String folio, String idFactura){
        this.folio=folio;
        this.idFactura=idFactura;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
    @Override
    public String toString(){
        return folio;
    }
}
