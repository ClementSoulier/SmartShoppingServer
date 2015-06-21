package SmartShopping.OV;

import java.sql.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVReponse permet de représenter la réponse d'un utilisateur à une notification.
 * @author Team SmartShopping
 */
public class OVReponse extends OVObject {
    
    private int etat;
    private Date dateTime; 

    /**
     *
     */
    public OVReponse(){
        this.id = 1;
        this.etat = 0;
    }
    
    /**
     *
     * @param jsonStr
     */
    public OVReponse(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.etat = object.getInt("etat");
            this.id = object.getInt("id");
        } catch (JSONException ex) {
        }
    }
    
    /**
     *
     * @return
     */
    public int getEtat() {
        return etat;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     *
     * @return
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     *
     * @param dateTime
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    
}
