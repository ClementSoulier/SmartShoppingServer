package SmartShopping.OV;

/**
 * La classe OVCategorie permet de représenter les catégories de produits.
 * @author Team SmartShopping
 */
public class OVCategorie extends OVObject{
   private String nomCategorie; 

    /**
     *
     * @param idCategorie
     * @param nomCategorie
     */
    public OVCategorie(int idCategorie, String nomCategorie) {
        this.id = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    /**
     *
     * @return
     */
    public String getNomCategorie() {
        return nomCategorie;
    }

    /**
     *
     * @param nomCategorie
     */
    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
}
