package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class OVObject {
	protected int id; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JSONObject toJSON() throws JSONException{
		String jsonSTR  = new Gson().toJson(this);
		JSONObject json = new JSONObject(jsonSTR);
		return json;
	}
	
}
