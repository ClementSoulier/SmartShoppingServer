package SmartShopping.OV;

/**
 * La classe OVSommet permet de représenter les sommets.
 * @author Team SmartShopping
 */
public class OVSommet extends OVObject {
    private int numSommet;
    private int idCategorie;

    /**
     *
     * @param id
     * @param numSommet
     * @param idCategorie
     */
    public OVSommet(int id, int numSommet, int idCategorie) {
        this.id = id;
        this.numSommet = numSommet;
        this.idCategorie = idCategorie;
    }

    /**
     *
     * @return
     */
    public int getNumSommet() {
        return this.numSommet;
    }

    /**
     *
     * @return
     */
    public int getIdCategorie() {
        return this.idCategorie;
    }

    /**
     *
     * @param numSommet
     */
    public void setNumSommet(int numSommet) {
        this.numSommet = numSommet;
    }

    /**
     *
     * @param idCategorie
     */
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

}
