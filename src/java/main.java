
import SmartShopping.DAO.DaoSmartShopping;
import SmartShopping.OV.OVNotification;
import SmartShopping.OV.RepNotification;
import static java.lang.System.out;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheNabo1
 */
 

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
       
        String json = "{\"id\":2,\"ovPromotion\":{\"id\":1,\"ovTypePromotion\":{\"libelleTypePromotion\":\"REMISE_EURO\"},\"ovProduit\":{\"id\":3,\"prix\":4,\"ovCategorie\":{\"id\":3,\"nomCategorie\":\"viande\"},\"nomProduit\":\"poulet\"},\"libellePromotion\":\"50 centimes sur le poulet en octobre !\",\"promotion\":0.5,\"dateFin\":\"Oct 31, 2014 12:00:00 AM\",\"dateDebut\":\"Oct 1, 2014 12:00:00 AM\"},\"reponseEnvoye\":{\"id\":192,\"etat\":1},\"distance\":1,\"responseNeeded\":1,\"ovBeacon\":{\"minor\":1,\"major\":2,\"uuid\":\"test\",\"idBeacon\":1},\"texte\":\"Poulet pas cher, mon frere !\"}";
        System.out.println(new OVNotification(json).getOvPromotion().getId());
    }
    
 
 
}
