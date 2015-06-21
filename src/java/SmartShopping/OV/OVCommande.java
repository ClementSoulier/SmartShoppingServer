package SmartShopping.OV;

import java.sql.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVCommande permet de représenter les commandes (payées).
 * @author Team SmartShopping
 */
public class OVCommande extends OVObject {
    
    private int idSmartlist;
    private int idUtilisateur;
    private float montant;
    private Date date; 

    /**
     *
     * @param jsonStr
     */
    public OVCommande(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.idUtilisateur = object.getInt("idUtilisateur");
            this.idSmartlist = object.getInt("idSmartlist");
            this.montant = (float)object.getDouble("montant");
           
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     *
     */
    public OVCommande(){}
    
    /**
     *
     * @param id
     * @param idUtilisateur
     * @param idSmartlist
     * @param montant
     * @param date
     */
    public OVCommande(int id, int idUtilisateur, int idSmartlist, float montant, Date date){
        this.id = id;
        this.idUtilisateur = idUtilisateur;
        this.idSmartlist = idSmartlist;
        this.montant = montant;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public float getMontant() {
        return montant;
    }

    /**
     *
     * @param montant
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }
    
    /**
     *
     * @return
     */
    public int getIdSmartlist() {
        return idSmartlist;
    }

    /**
     *
     * @param idSmartlist
     */
    public void setIdSmartlist(int idSmartlist) {
        this.idSmartlist = idSmartlist;
    }

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
    
    
    
}
