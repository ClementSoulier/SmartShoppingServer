package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;

/**
 * La classe OVReq est la classe mère de tous les REQ. 
 * Les REQ servent à demander des données au serveur. 
 * L'OVReq contient souvent un OVObject associé qui contiendra les différents paramètres des requêtes à effectuer.
 * L'utilisation des REQ permettant une meilleure maintenabilité et une meilleure évolutivité des requêtes.
 * Cette utilisation permet notamment la conservation de la signature des méthodes malgré les changements. 
 * @author Team SmartShopping
 */
public class OVReq {

    /**
     * Méthode permettant d'écrire tous les objets REQ sous forme de JSON. 
     * @return Chaîne de caractère JSON formatté dans un JSONObject. (Voir librairie org.json.JSONObject)
     * @throws JSONException
     */
    public JSONObject toJSON() throws JSONException{
		String jsonSTR  = new Gson().toJson(this);
		JSONObject json = new JSONObject(jsonSTR);
		return json;
	}
}