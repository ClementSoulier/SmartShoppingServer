package SmartShopping.OV;

import java.util.ArrayList;

/**
 * La classe RepSommet est la classe de réponses des requêtes utilisant des objets {@link OVSommet}.
 * @author Team SmartShopping
 */
public class RepSommet extends OVRep {

    private ArrayList<OVSommet> listeSommet; 

    /**
     *
     */
    public RepSommet(){
        this.listeSommet = new ArrayList<OVSommet>();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<OVSommet> getListeSommet() {
        return this.listeSommet;
    }
	
}
