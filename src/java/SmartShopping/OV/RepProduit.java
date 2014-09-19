/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartShopping.OV;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author TheNabo1
 */
public class RepProduit extends OVRep {
    
    private ArrayList<OVProduit> listeProduit; 

    public RepProduit(){
        this.listeProduit = new ArrayList<OVProduit>();
    }
    
    public ArrayList<OVProduit> getListeProduit() {
        return listeProduit;
    }

    public void setListeProduit(ArrayList<OVProduit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    
}
