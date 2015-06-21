package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * OVObject est la classe mère de tous les objets à représenter. 
 * Elle définit les attributs obligatoires comme l'identifiant (id) ainsi que la méthode permettant d'écrire l'objet sous forme de chaîne JSON.
 * @author Team SmartShopping
 */
public class OVObject {
 
    /**
     *
     */
    protected int id; 
	
    /**
     *
     * @return
     */
    public int getId() {
		return id;
	}

    /**
     *
     * @param id
     */
    public void setId(int id) {
		this.id = id;
	}

    /**
     *
     * @return
     * @throws JSONException
     */
    public JSONObject toJSON() throws JSONException{
		String jsonSTR  = new Gson().toJson(this);
		JSONObject json = new JSONObject(jsonSTR);
		return json;
	}
	
}
