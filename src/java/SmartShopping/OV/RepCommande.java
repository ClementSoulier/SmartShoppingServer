/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

import java.util.ArrayList;

/**
 *
 * @author TheNabo1
 */
public class RepCommande extends OVRep {
 
    private ArrayList<OVCommande> lstCommandes;

    public ArrayList<OVCommande> getLstCommandes() {
        return lstCommandes;
    }

    public void setLstCommandes(ArrayList<OVCommande> lstCommandes) {
        this.lstCommandes = lstCommandes;
    }
    
    
    
}
