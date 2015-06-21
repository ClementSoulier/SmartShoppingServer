package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;

/**
 * La classe OVRep est la classe mère de toutes les REP. 
 * Les REP servent à renvoyer des données vers le client. 
 * L'OVRep contient de base un message d'erreur et un boolean permettant de savoir si une erreur est survenue.
 * @author Team SmartShopping
 */
public class OVRep {

    /**
     * Permet de définir si une erreur a eu lieu durant l'appel d'une requête.
     * Ce boolean est également mis à jour dans les "catch{}" afin d'être capté par le téléphone.
     * Cette utilisation permet un meilleur débuguage du serveur lors de l'utilisation de l'application.
     */
    public boolean erreur; 

    /**
     * Le message d'erreur peut être définit par les développeurs mais il peut également s'agir d'un message d'erreur lié à une exception.
     */
    public String messageErreur; 
    
    /**
     * Méthode permettant d'écrire tous les objets REP sous forme de JSON pour les retours vers le client. 
     * @return Chaîne de caractère JSON formatté dans un JSONObject. (Voir librairie org.json.JSONObject)
     * @throws JSONException
     */
    public JSONObject toJSON() throws JSONException{
		String jsonSTR  = new Gson().toJson(this);
		JSONObject json = new JSONObject(jsonSTR);
		return json;
	}
}
