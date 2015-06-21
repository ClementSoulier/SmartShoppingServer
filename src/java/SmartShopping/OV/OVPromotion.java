package SmartShopping.OV;

import java.sql.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVPromotion permet de représenter les promotions liés à un produit.
 * @author Team SmartShopping
 */
public class OVPromotion extends OVObject{
	 
    private OVTypePromotion ovTypePromotion; 
    private OVProduit ovProduit; 
    private String libellePromotion; 
    private float promotion;
    private Date dateDebut;
    private Date dateFin;

    /**
     *
     * @param jsonStr
     */
    public OVPromotion(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.id = object.getInt("id");
            this.ovTypePromotion = new OVTypePromotion(object.getJSONObject("ovTypePromotion").toString());
            //this.ovProduit = new OVProduit(object.getJSONObject("ovProduit").toString());
            this.libellePromotion = object.getString("libellePromotion");
            this.promotion = (float)object.getDouble("promotion");
         
        } catch (JSONException ex) {
            System.out.println("Exception " + ex.getMessage());
        }
    }
    
    /**
     *
     * @param id
     * @param ovTypePromotion
     * @param ovProduit
     * @param libellePromotion
     * @param promotion
     * @param dateDebut
     * @param dateFin
     */
    public OVPromotion(int id, OVTypePromotion ovTypePromotion, OVProduit ovProduit, 
            String libellePromotion, float promotion, Date dateDebut, 
            Date dateFin) {
        this.id = id;
        this.ovTypePromotion = ovTypePromotion;
        this.ovProduit = ovProduit;
        this.libellePromotion = libellePromotion;
        this.promotion = promotion;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    /**
     *
     * @return
     */
    public OVTypePromotion getOvTypePromotion() {
        return ovTypePromotion;
    }

    /**
     *
     * @return
     */
    public OVProduit getOvProduit() {
        return ovProduit;
    }

    /**
     *
     * @return
     */
    public String getLibellePromotion() {
        return libellePromotion;
    }

    /**
     *
     * @return
     */
    public float getPromotion() {
        return promotion;
    }

    /**
     *
     * @return
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     *
     * @return
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     *
     * @param ovTypePromotion
     */
    public void setOvTypePromotion(OVTypePromotion ovTypePromotion) {
        this.ovTypePromotion = ovTypePromotion;
    }

    /**
     *
     * @param ovProduit
     */
    public void setOvProduit(OVProduit ovProduit) {
        this.ovProduit = ovProduit;
    }

    /**
     *
     * @param libellePromotion
     */
    public void setLibellePromotion(String libellePromotion) {
        this.libellePromotion = libellePromotion;
    }

    /**
     *
     * @param promotion
     */
    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }

    /**
     *
     * @param dateDebut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     *
     * @param dateFin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
   
}
