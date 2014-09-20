package SmartShopping.OV;

import java.util.ArrayList;

public class RepSommet extends OVReq{

    private ArrayList<OVSommet> listeSommet; 

    public RepSommet(){
        this.listeSommet = new ArrayList<OVSommet>();
    }
    
    public ArrayList<OVSommet> getListeSommet() {
        return this.listeSommet;
    }

    public void setListeProduit(ArrayList<OVSommet> listeSommet) {
        this.listeSommet = listeSommet;
    }
	
}
