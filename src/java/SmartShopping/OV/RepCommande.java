/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

import java.util.ArrayList;

/**
 * La classe RepCommande est la classe de réponses des requêtes utilisant des objets {@link OVCommande}.
 * @author Team SmartShopping
 */
public class RepCommande extends OVRep {
 
    private ArrayList<OVCommande> lstCommandes;

    /**
     *
     * @return
     */
    public ArrayList<OVCommande> getLstCommandes() {
        return lstCommandes;
    }

    /**
     *
     * @param lstCommandes
     */
    public void setLstCommandes(ArrayList<OVCommande> lstCommandes) {
        this.lstCommandes = lstCommandes;
    }
    
    
    
}
