package SmartShopping.OV;

/**
 * La classe ReqListeProduit est la classe de requêtes des demandes utilisant des objets {@link OVListeProduit}.
 * @author Team SmartShopping
 */
public class ReqListeProduit extends OVReq{

	OVListeProduit ovListeProduit;

    /**
     *
     * @return
     */
    public OVListeProduit getOvListeProduit() {
		return ovListeProduit;
	}

    /**
     *
     * @param ovListeProduit
     */
    public void setOvListeProduit(OVListeProduit ovListeProduit) {
		this.ovListeProduit = ovListeProduit;
	}
	
}
