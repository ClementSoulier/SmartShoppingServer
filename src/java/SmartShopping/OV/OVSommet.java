package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;


public class OVSommet extends OVObject {
    private Integer numSommet;
    private Integer idCategorie;

    public OVSommet(String jsonStr) {
        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.setNumSommet(object.getInt("numSommet"));
            this.setIdCategorie(object.getInt("idCategorie"));
            this.id = object.getInt("id");
        } catch (JSONException ex) {
        }
    }

    public OVSommet(Integer numSommet, Integer idCategorie) {
        super();
        this.numSommet = numSommet;
        this.idCategorie = idCategorie;
    }

    public Integer getNumSommet() {
        return this.numSommet;
    }

    public Integer getIdCategorie() {
        return this.idCategorie;
    }

    public void setNumSommet(Integer numSommet) {
        this.numSommet = numSommet;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

}
