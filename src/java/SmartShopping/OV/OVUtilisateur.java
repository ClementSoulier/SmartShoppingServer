/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author TheNabo1
 */
public class OVUtilisateur extends OVObject {
   
    public OVUtilisateur(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.id = object.getInt("id");
        } catch (JSONException ex) {
        }
    }
    public OVUtilisateur(int id){
        this.id = id;
    }
}
