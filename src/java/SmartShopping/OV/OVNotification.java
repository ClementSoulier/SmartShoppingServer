package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVNotification permet de représenter les notifications à afficher sur le téléphone.
 * @author Team SmartShopping
 */
public class OVNotification extends OVObject {

    private OVPromotion ovPromotion;
    private int idPromotion;
    private OVBeacon ovBeacon;
    private int distance;
    private int responseNeeded;
    private String texte;
    private OVReponse reponseEnvoye;
    private int idUtilisateur;

    /**
     *
     * @return
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     *
     * @param idUtilisateur
     */
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     *
     * @return
     */
    public int getIdPromotion() {
        return idPromotion;
    }

    /**
     *
     * @param idPromotion
     */
    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    /**
     *
     * @param jsonStr
     */
    public OVNotification(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.distance = object.getInt("distance");
            this.id = object.getInt("id");
            this.idUtilisateur = object.getInt("idUtilisateur");
            this.responseNeeded = object.getInt("responseNeeded");
            this.texte = object.getString("texte");
            this.ovBeacon = new OVBeacon(object.getJSONObject("ovBeacon").toString());
            this.reponseEnvoye = new OVReponse(object.getJSONObject("reponseEnvoye").toString());
            this.ovPromotion = new OVPromotion(object.getJSONObject("ovPromotion").toString());
            System.out.println(object.getJSONObject("ovPromotion").toString());
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param idNotification
     * @param distance
     * @param responseNeeded
     * @param texte
     * @param idPromotion
     */
    public OVNotification(int idNotification, int distance, int responseNeeded, String texte, int idPromotion) {
        this.id = idNotification;
        this.distance = distance;
        this.responseNeeded = responseNeeded;
        this.texte = texte;
        this.ovBeacon = new OVBeacon();
        this.reponseEnvoye = new OVReponse();
        this.idPromotion = idPromotion;
    }

    /**
     *
     * @return
     */
    public OVPromotion getOvPromotion() {
        return ovPromotion;
    }

    /**
     *
     * @param ovPromotion
     */
    public void setOvPromotion(OVPromotion ovPromotion) {
        this.ovPromotion = ovPromotion;
    }

    /**
     *
     * @return
     */
    public OVBeacon getOvBeacon() {
        return ovBeacon;
    }

    /**
     *
     * @param ovBeacon
     */
    public void setOvBeacon(OVBeacon ovBeacon) {
        this.ovBeacon = ovBeacon;
    }

    /**
     *
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public int isResponseNeeded() {
        return responseNeeded;
    }

    /**
     *
     * @param responseNeeded
     */
    public void setResponseNeeded(int responseNeeded) {
        this.responseNeeded = responseNeeded;
    }

    /**
     *
     * @return
     */
    public String getTexte() {
        return texte;
    }

    /**
     *
     * @param texte
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     *
     * @return
     */
    public OVReponse getReponseEnvoye() {
        return reponseEnvoye;
    }

    /**
     *
     * @param reponseEnvoye
     */
    public void setReponseEnvoye(OVReponse reponseEnvoye) {
        this.reponseEnvoye = reponseEnvoye;
    }

}
