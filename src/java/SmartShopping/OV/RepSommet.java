package SmartShopping.OV;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shinthu
 */
public class RepSommet extends OVRep {

    private ArrayList<OVSommet> listeSommet; 

    public RepSommet(){
        this.listeSommet = new ArrayList<OVSommet>();
    }
    
    public ArrayList<OVSommet> getListeSommet() {
        return this.listeSommet;
    }
	
}
