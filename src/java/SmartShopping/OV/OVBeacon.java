package SmartShopping.OV;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * La classe OVBeacon permet de représenter les capteurs beacons.
 * Le minor et le major sont des données fixes du capteur. 
 * @author Team SmartShopping
 */
public class OVBeacon extends OVObject {

    private Integer idBeacon;
    private String uuid;
    private int major;
    private int minor;

    /**
     * Constructeur d'OVBeacon à partir d'une chaîne JSON.
     * @param jsonStr
     */
    public OVBeacon(String jsonStr) {

        try {
            JSONObject object;
            object = new JSONObject(jsonStr);

            this.uuid = object.getString("uuid");
            this.major = object.getInt("major");
            this.minor = object.getInt("minor");
            this.idBeacon = object.getInt("id");
        } catch (JSONException ex) {
        }
    }
    
    /**
     * Constructeur par défaut. 
     */
    public OVBeacon() {
        this.id = 1;
        this.uuid = "test";
        this.major = 2;
        this.minor = 1;
    }

    /**
     *
     * @param idBeacon
     * @param uuid
     * @param major
     * @param minor
     */
    public OVBeacon(Integer idBeacon, String uuid, int major, int minor) {
        this.idBeacon = idBeacon;
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return idBeacon;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.idBeacon = id;
    }

    /**
     *
     * @return
     */
    public String getUuid() {
        return uuid;
    }

    /**
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     *
     * @return
     */
    public int getMajor() {
        return major;
    }

    /**
     *
     * @param major
     */
    public void setMajor(int major) {
        this.major = major;
    }

    /**
     *
     * @return
     */
    public int getMinor() {
        return minor;
    }

    /**
     *
     * @param minor
     */
    public void setMinor(int minor) {
        this.minor = minor;
    }

}
