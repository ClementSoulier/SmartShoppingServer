package SmartShopping.OV;

import java.util.ArrayList;
/**
 * La classe RepProduit est la classe de réponses des requêtes utilisant des objets {@link OVProduit}.
 * @author Team SmartShopping
 */
public class RepProduit extends OVRep {
    
    private ArrayList<OVProduit> listeProduit; 

    /**
     *
     */
    public RepProduit(){
        this.listeProduit = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<OVProduit> getListeProduit() {
        return listeProduit;
    }

    /**
     *
     * @param listeProduit
     */
    public void setListeProduit(ArrayList<OVProduit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    
}
