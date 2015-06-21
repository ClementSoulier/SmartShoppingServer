package SmartShopping.OV;

/**
 * La classe OVProduit permet de représenter les produits.
 * @author Team SmartShopping
 */
public class OVProduit extends OVObject{
	
    private String nomProduit; 
    private OVCategorie ovCategorie; 
    private double prix; 
    
    /**
     *
     * @param idProduit
     * @param nomProduit
     * @param ovCategorie
     * @param prix
     */
    public OVProduit(int idProduit, String nomProduit, OVCategorie ovCategorie, double prix) {
        this.id = idProduit;
        this.nomProduit = nomProduit;
        this.ovCategorie = ovCategorie;
        this.prix = prix;
    }
    
    /**
     *
     * @return
     */
    public String getNomProduit() {
        return nomProduit;
    }

    /**
     *
     * @param nomProduit
     */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    /**
     *
     * @return
     */
    public OVCategorie getOvCategorie() {
        return ovCategorie;
    }

    /**
     *
     * @param ovCategorie
     */
    public void setOvCategorie(OVCategorie ovCategorie) {
        this.ovCategorie = ovCategorie;
    }

    /**
     *
     * @return
     */
    public double getPrix() {
        return prix;
    }

    /**
     *
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    @Override
    public String toString(){
    	return this.nomProduit + "\t" + this.prix + "";
    }
    
}
