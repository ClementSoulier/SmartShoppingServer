package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVUtilisateur permet de représenter un utilisateur.
 * Dans le cas de SmartShopping, l'identifiant de l'utilisateur est lié à l'IMEI du téléphone. 
 * @author Team SmartShopping
 */
public class OVUtilisateur extends OVObject {
   
    /**
     *
     * @param jsonStr
     */
    public OVUtilisateur(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.id = object.getInt("id");
        } catch (JSONException ex) {
        }
    }

    /**
     *
     * @param id
     */
    public OVUtilisateur(int id){
        this.id = id;
    }
}
