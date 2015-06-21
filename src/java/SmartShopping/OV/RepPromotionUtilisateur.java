/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartShopping.OV;

import java.util.ArrayList;

/**
 * La classe RepPromotionUtilisateur est la classe de réponses des requêtes utilisant des objets {@link OVPromotionUtilisateur}.
 * @author Team SmartShopping
 */
public class RepPromotionUtilisateur extends OVRep {
    
    private OVUtilisateur ovUtilisateur;
    private OVPromotion ovPromotion;
    private ArrayList<OVPromotionUtilisateur> promotions;

    /**
     *
     * @return
     */
    public OVUtilisateur getOvUtilisateur() {
        return ovUtilisateur;
    }

    /**
     *
     * @param ovUtilisateur
     */
    public void setOvUtilisateur(OVUtilisateur ovUtilisateur) {
        this.ovUtilisateur = ovUtilisateur;
    }

    /**
     *
     * @return
     */
    public OVPromotion getOvPromotion() {
        return ovPromotion;
    }

    /**
     *
     * @param ovPromotion
     */
    public void setOvPromotion(OVPromotion ovPromotion) {
        this.ovPromotion = ovPromotion;
    }

    /**
     *
     * @return
     */
    public ArrayList<OVPromotionUtilisateur> getPromotions() {
        return promotions;
    }

    /**
     *
     * @param promotions
     */
    public void setPromotions(ArrayList<OVPromotionUtilisateur> promotions) {
        this.promotions = promotions;
    }
    
    
}
