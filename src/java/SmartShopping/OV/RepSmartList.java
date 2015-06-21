package SmartShopping.OV;

/**
 * La classe RepSmartList est la classe de réponses des requêtes utilisant des objets {@link OVSmartList}.
 * @author Team SmartShopping
 */
public class RepSmartList extends OVRep{

	private OVSmartList smartList;
	
    /**
     *
     * @return
     */
    public OVSmartList getSmartList() {
		return smartList;
	}

    /**
     *
     * @param smartList
     */
    public void setSmartList(OVSmartList smartList) {
		this.smartList = smartList;
	}

}
