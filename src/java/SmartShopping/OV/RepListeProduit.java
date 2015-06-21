package SmartShopping.OV;

/**
 * La classe RepListeProduit est la classe de réponses des requêtes utilisant des objets {@link OVListeProduit}.
 * @author Team SmartShopping
 */
public class RepListeProduit extends OVRep{
	
	OVListeProduit lp;
	private int idListeProduit;

    /**
     *
     * @return
     */
    public int getIdListeProduit() {
        return idListeProduit;
    }

    /**
     *
     * @param idListeProduit
     */
    public void setIdListeProduit(int idListeProduit) {
        this.idListeProduit = idListeProduit;
    }
        
    /**
     *
     */
    public RepListeProduit(){
		
	}
}
