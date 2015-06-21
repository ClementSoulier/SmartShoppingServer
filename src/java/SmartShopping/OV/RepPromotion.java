package SmartShopping.OV;

import java.util.ArrayList;

/**
 * La classe RepPromotion est la classe de réponses des requêtes utilisant des objets {@link OVPromotion}.
 * @author Team SmartShopping
 */
public class RepPromotion extends OVRep {

    private final ArrayList<OVPromotion> listePromotion; 

    /**
     *
     */
    public RepPromotion(){
        this.listePromotion = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<OVPromotion> getListePromotion() {
        return this.listePromotion;
    }
	
}
