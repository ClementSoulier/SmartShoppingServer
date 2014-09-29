/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartShopping.OV;

import java.sql.Date;

/**
 *
 * @author Shinthu
 */
public class OVPromotion extends OVObject{
	 
    private OVTypePromotion ovTypePromotion; 
    private OVProduit ovProduit; 
    private String libellePromotion; 
    private float promotion;
    private Date dateDebut;
    private Date dateFin;

    public OVPromotion(OVTypePromotion ovTypePromotion, OVProduit ovProduit, 
            String libellePromotion, float promotion, Date dateDebut, 
            Date dateFin) {
        this.ovTypePromotion = ovTypePromotion;
        this.ovProduit = ovProduit;
        this.libellePromotion = libellePromotion;
        this.promotion = promotion;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public OVTypePromotion getOvTypePromotion() {
        return ovTypePromotion;
    }

    public OVProduit getOvProduit() {
        return ovProduit;
    }

    public String getLibellePromotion() {
        return libellePromotion;
    }

    public float getPromotion() {
        return promotion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setOvTypePromotion(OVTypePromotion ovTypePromotion) {
        this.ovTypePromotion = ovTypePromotion;
    }

    public void setOvProduit(OVProduit ovProduit) {
        this.ovProduit = ovProduit;
    }

    public void setLibellePromotion(String libellePromotion) {
        this.libellePromotion = libellePromotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
   
}
