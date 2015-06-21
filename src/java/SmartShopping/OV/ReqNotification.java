package SmartShopping.OV;

/**
 * La classe ReqNotification est la classe de requêtes des demandes utilisant des objets {@link OVNotification}.
 * @author Team SmartShopping
 */
public class ReqNotification extends OVReq {
 
    
    private OVNotification ovNotification;

    /**
     *
     * @return
     */
    public OVNotification getOvNotification() {
        return ovNotification;
    }

    /**
     *
     * @param ovNotification
     */
    public void setOvNotification(OVNotification ovNotification) {
        this.ovNotification = ovNotification;
    }
    
}
