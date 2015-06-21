package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVListeProduit permet de représenter élements des produits dans la liste (coché, à supprimer etc...).
 * @author Team SmartShopping
 */
public class OVListeProduit extends OVObject {
	private Boolean coche;
	private Boolean supprime;
	private Integer idProduit;
	private Integer idListe;//idSmartList
	
    /**
     *
     * @return
     */
    public Boolean getCoche() {
		return coche;
	}

    /**
     *
     * @param coche
     */
    public void setCoche(Boolean coche) {
		this.coche = coche;
	}

    /**
     *
     * @return
     */
    public Boolean getSupprime() {
		return supprime;
	}

    /**
     *
     * @param supprime
     */
    public void setSupprime(Boolean supprime) {
		this.supprime = supprime;
	}

    /**
     *
     * @return
     */
    public Integer getIdProduit() {
		return idProduit;
	}

    /**
     *
     * @param idProduit
     */
    public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

    /**
     *
     * @return
     */
    public Integer getIdListe() {
		return idListe;
	}

    /**
     *
     * @param idListe
     */
    public void setIdListe(Integer idListe) {
		this.idListe = idListe;
	}

    /**
     *
     * @param jsonStr
     */
    public OVListeProduit(String jsonStr){

        try 
        {
            JSONObject object;
            object = new JSONObject(jsonStr);
            
            this.setCoche(object.getBoolean("coche"));
            this.setIdListe(object.getInt("idListe"));
            this.setIdProduit(object.getInt("idProduit"));
            this.setSupprime(object.getBoolean("supprime"));
            this.id = object.getInt("id");
        } 
        catch (JSONException ex) 
        {
        }
	}

    /**
     *
     * @param coche
     * @param supprime
     * @param idProduit
     * @param idListe
     */
    public OVListeProduit(Boolean coche, Boolean supprime, Integer idProduit,
			Integer idListe) {
		super();
		this.coche = coche;
		this.supprime = supprime;
		this.idProduit = idProduit;
		this.idListe = idListe;
	}
	
}
