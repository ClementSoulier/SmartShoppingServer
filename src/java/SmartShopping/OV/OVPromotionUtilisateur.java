package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVPromotionUtilisateur permet de représenter les promotions validées par un utilisateur.
 * @author Team SmartShopping
 */
public class OVPromotionUtilisateur extends OVObject{
    private int idUtilisateur;
    private int idPromotion;
    
    /**
     *
     * @param jobj
     */
    public OVPromotionUtilisateur (JSONObject jobj){
    	try {
			this.idUtilisateur = jobj.getInt("idUtilisateur");
                        this.idPromotion = jobj.getInt("idPromotion");
                        
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            } 
    }

    /**
     *
     * @param idUtilisateur
     * @param idPromotion
     */
    public OVPromotionUtilisateur(int idUtilisateur, int idPromotion) {
        this.idPromotion = idPromotion;
        this.idUtilisateur = idUtilisateur;
    }
    
    
}
