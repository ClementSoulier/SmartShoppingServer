package SmartShopping.OV;

import java.util.ArrayList;

/**
 * La classe RepNotification est la classe de réponses des requêtes utilisant des objets {@link OVNotification}.
 * @author Team SmartShopping
 */
public class RepNotification extends OVRep {
    
     private ArrayList<OVNotification> listeNotification; 

    /**
     *
     */
    public RepNotification(){
        this.listeNotification = new ArrayList<OVNotification>();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<OVNotification> getListeNotification() {
        return listeNotification;
    }

    /**
     *
     * @param listeNotification
     */
    public void setListeNotification(ArrayList<OVNotification> listeNotification) {
        this.listeNotification = listeNotification;
    }
    
}
