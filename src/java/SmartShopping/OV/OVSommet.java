package SmartShopping.OV;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shinthu
 */
public class OVSommet extends OVObject {
    private int numSommet;
    private int idCategorie;

    public OVSommet(int id, int numSommet, int idCategorie) {
        this.id = id;
        this.numSommet = numSommet;
        this.idCategorie = idCategorie;
    }

    public int getNumSommet() {
        return this.numSommet;
    }

    public int getIdCategorie() {
        return this.idCategorie;
    }

    public void setNumSommet(int numSommet) {
        this.numSommet = numSommet;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

}
