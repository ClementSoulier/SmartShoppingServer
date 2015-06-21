package SmartShopping.OV;

/**
 * La classe OVTypePromotion permet de représenter le type des promotions.
 * @author Team SmartShopping
 */
public class OVTypePromotion extends OVObject{

    private String libelleTypePromotion; 

    /**
     *
     * @param libelleTypePromotion
     */
    public OVTypePromotion(String libelleTypePromotion) {
        this.libelleTypePromotion = libelleTypePromotion;
    }

    /**
     *
     * @return
     */
    public String getLibelleTypePromotion() {
        return libelleTypePromotion;
    }

    /**
     *
     * @param libelleTypePromotion
     */
    public void setLibelleTypePromotion(String libelleTypePromotion) {
        this.libelleTypePromotion = libelleTypePromotion;
    }
    
}
