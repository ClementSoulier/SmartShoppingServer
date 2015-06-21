package SmartShopping.OV;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVSmartList permet de représenter la liste des courses "Smart".
 * @author Team SmartShopping
 */
public class OVSmartList extends OVObject{
	
	private List<OVListeProduit> produitsSmartList;
	private String nom;
	private OVUtilisateur utilisateur;

    /**
     *
     * @return
     */
    public OVUtilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     */
    public void setUtilisateur(OVUtilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     *
     * @param jsonStr
     */
    public OVSmartList(String jsonStr){
         try 
        {
            JSONObject object = new JSONObject(jsonStr);
            if(object.has("smartList")){
             object = new JSONObject(jsonStr).getJSONObject("smartList");
            }
            if(object.has("id")){
             this.id = object.getInt("id");
            }else{
             this.id = 1;
            }
            this.setNom(object.getString("nom"));
            JSONArray smartListArr = object.getJSONArray("produitsSmartList");
            this.produitsSmartList = new ArrayList<OVListeProduit>();
            for(int i=0; i<smartListArr.length();++i){
             OVListeProduit newlistProduit = new OVListeProduit(smartListArr.get(i).toString());
             produitsSmartList.add(newlistProduit);
            }
        }
         catch(JSONException ex){
             
         }
	}
        
    /**
     *
     */
    public OVSmartList(){}
	
    /**
     *
     * @return
     */
    public List<OVListeProduit> getProduitsSmartList() {
		return produitsSmartList;
	}

    /**
     *
     * @param produitsSmartList
     */
    public void setProduitsSmartList(List<OVListeProduit> produitsSmartList) {
		this.produitsSmartList = produitsSmartList;
	}

    /**
     *
     * @return
     */
    public String getNom() {
		return nom;
	}

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
		this.nom = nom;
	}

    /**
     *
     * @param produitsSmartList
     * @param nom
     */
    public OVSmartList(List<OVListeProduit> produitsSmartList, String nom) {
		super();
		this.produitsSmartList = produitsSmartList;
		this.nom = nom;
	}
	
}
