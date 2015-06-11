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
public class RepPromotionUtilisateur extends OVRep {
    
    private OVUtilisateur ovUtilisateur;
    private OVPromotion ovPromotion;
    private ArrayList<OVPromotionUtilisateur> promotions;

    public OVUtilisateur getOvUtilisateur() {
        return ovUtilisateur;
    }

    public void setOvUtilisateur(OVUtilisateur ovUtilisateur) {
        this.ovUtilisateur = ovUtilisateur;
    }

    public OVPromotion getOvPromotion() {
        return ovPromotion;
    }

    public void setOvPromotion(OVPromotion ovPromotion) {
        this.ovPromotion = ovPromotion;
    }

    public ArrayList<OVPromotionUtilisateur> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<OVPromotionUtilisateur> promotions) {
        this.promotions = promotions;
    }
    
    
}
