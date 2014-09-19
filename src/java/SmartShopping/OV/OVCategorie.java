/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartShopping.OV;

/**
 *
 * @author TheNabo1
 */
public class OVCategorie extends OVObject{
   private String nomCategorie; 

   
   
    public OVCategorie(int idCategorie, String nomCategorie) {
        this.id = idCategorie;
        this.nomCategorie = nomCategorie;
    }


    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
}
