/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TheNabo1
 */
public class OVUtilisateur extends OVObject {
    
    private String login;
    private String pass;
    private String nom;
    private String prenom;
    private OVSmartList ovSmartList;
    private List<OVPromotion> lstOvPromotion;

    public OVSmartList getOvSmartList() {
        return ovSmartList;
    }

    public void setOvSmartList(OVSmartList ovSmartList) {
        this.ovSmartList = ovSmartList;
    }

    public List<OVPromotion> getLstOvPromotion() {
        return lstOvPromotion;
    }

    public void setLstOvPromotion(List<OVPromotion> lstOvPromotion) {
        this.lstOvPromotion = lstOvPromotion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
}
