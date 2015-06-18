
import SmartShopping.DAO.DaoSmartShopping;
import SmartShopping.OV.OVCommande;
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
        
       // test
        OVCommande ovCommande = new OVCommande("{\"montant\":0,\"idUtilisateur\":52915155,\"idSmartlist\":3}");
        System.out.println(ovCommande.getIdUtilisateur());
    }
    
 
 
}
