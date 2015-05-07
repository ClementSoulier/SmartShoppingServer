package SmartShopping.DAO;


import SmartShopping.OV.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TheNabo1
 */
public class DaoSmartShopping {
    
   public static Connection GET_Connection() throws SQLException {
       
       try {
        Class.forName("com.mysql.jdbc.Driver");

} catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
}
       
        String url = "jdbc:mysql://localhost/smartshopping";
        String utilisateur = "manager";
        String motDePasse = "rudba?noimjustthemanager";
        Connection connexion = null;

        try 
        {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } 
        catch (SQLException ex) 
        {
            throw ex;
        }  
        
        return connexion;
   }
   
   public static RepProduit GET_PRODUITS() throws SQLException
   {
       RepProduit rep = new RepProduit();
       Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT produit.id, categorie.id, produit.nom, categorie.nom, produit.prix FROM produit, categorie WHERE produit.idCategorie = categorie.id;" );
           
            while (resultat.next()) 
            {
                OVProduit ovProduit = new OVProduit(
                    resultat.getInt("produit.id"), 
                    resultat.getString("produit.nom"), 
                    new OVCategorie(resultat.getInt("categorie.id"),resultat.getString("categorie.nom")), 
                    resultat.getDouble("produit.prix")
                ); 
                               
                rep.getListeProduit().add(ovProduit);  
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       
       return rep; 
   }
   
   public static RepSmartList GET_LISTE_PRODUIT() throws SQLException {
       
       RepSmartList rep = new RepSmartList();
       Connection connexion = GET_Connection();
       OVSmartList ovSmartList = new OVSmartList();
       
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT * FROM smartliste ORDER BY id LIMIT 1" );
           
            while (resultat.next()) 
            {
                ovSmartList = new OVSmartList(
                    new ArrayList<OVListeProduit>(),
                    resultat.getString("nom")
                ); 
                
                ovSmartList.setId(resultat.getInt("id"));
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       
       try{
           
           Statement statement2 = connexion.createStatement();
           ResultSet resultat2 = statement2.executeQuery( "select * from listeproduit where idListe = 1 and supprime = 0;" );
           
            while (resultat2.next()) 
            {
                OVListeProduit ovListeProduit = new OVListeProduit(
                    resultat2.getBoolean("coche"), 
                    resultat2.getBoolean("supprime"), 
                    resultat2.getInt("idProduit"),
                    1
                ); 
                
                ovListeProduit.setId(resultat2.getInt("id"));
                                
                ovSmartList.getProduitsSmartList().add(ovListeProduit);
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       rep.setSmartList(ovSmartList);
       return rep; 
       
   }
   
   public static RepListeProduit INSERT_LISTE_PRODUIT(OVListeProduit ovListeProduit) throws SQLException {
       
       RepListeProduit rep = new RepListeProduit();
       Connection connexion = GET_Connection();
       try{
          
           Statement statement = connexion.createStatement();
           
           int resultat = statement.executeUpdate("INSERT INTO listeproduit (idProduit, idListe) VALUES ("+ovListeProduit.getIdProduit()+","+ovListeProduit.getIdListe()+");",Statement.RETURN_GENERATED_KEYS );
           
            if(resultat == 0)
            {
                rep.erreur = true;
                rep.messageErreur = "Aucune ligne inséré!";
            }
            else{
                ResultSet gk = statement.getGeneratedKeys();
                if (gk.next()) {
                    rep.setIdListeProduit(gk.getInt(1));
                }
                else 
                {
                    rep.messageErreur = "Creating user failed, no ID obtained.";
                }
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
      
       return rep;
    }
   
   public static RepListeProduit UPDATE_LISTE_PRODUIT(OVListeProduit ovListeProduit) throws SQLException {
       
       RepListeProduit rep = new RepListeProduit();
       Connection connexion = GET_Connection();
       int coche = 0;
       int supprime = 0;
       
       if(ovListeProduit.getCoche()){ coche = 1; }
       if(ovListeProduit.getSupprime()){ supprime = 1; }
       
       try{
          
           Statement statement = connexion.createStatement();
           int resultat = statement.executeUpdate("UPDATE listeproduit SET coche = "+coche+", supprime = "+supprime+" WHERE id = "+ovListeProduit.getId()+";");
           
            if(resultat == 0)
            {
                rep.erreur = true;
                rep.messageErreur = "Aucune ligne mise à jour!";
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
      
       return rep;
    }

   public static RepSmartList UPDATE_SMART_LIST(OVSmartList ovSmartList) throws SQLException {
       
       RepSmartList rep = new RepSmartList();
       Connection connexion = GET_Connection();
       
       
       try{
          
           for(OVListeProduit ovListeProduit : ovSmartList.getProduitsSmartList()){
                
                int coche = 0;
                int supprime = 0;
       
                if(ovListeProduit.getCoche()){ coche = 1; }
                if(ovListeProduit.getSupprime()){ supprime = 1; }
               
                Statement statement = connexion.createStatement();
                int resultat = statement.executeUpdate("UPDATE listeproduit SET coche = "+coche+", supprime = "+supprime+" WHERE id = "+ovListeProduit.getId()+";");

                 if(resultat == 0)
                 {
                     rep.erreur = true;
                     rep.messageErreur = "Aucune ligne mise à jour!";
                 }
           }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
      
       return rep;
   }
   
    public static RepSommet GET_ALL_SOMMETS() throws SQLException {
       
       RepSommet rep = new RepSommet();
       Connection connexion = GET_Connection();
       
       try {
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT id, numSommet, idCategorie FROM sommet;" );
           
            while (resultat.next()) {
                OVSommet ovSommet = new OVSommet(
                    resultat.getInt("id"), 
                    resultat.getInt("numSommet"), 
                    resultat.getInt("idCategorie")
                ); 
                               
                rep.getListeSommet().add(ovSommet);  
            }
 
       } catch(SQLException ex) {
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       
       return rep; 
   }  
    
    public static RepPromotion GET_PROMOTIONS() throws SQLException
   {
       RepPromotion rep = new RepPromotion();
       Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT \n" +
            "promotion.id, promotion.libellePromotion, promotion.promotion, promotion.dateDebut, promotion.dateFin, \n" +
            "typepromotion.id, typepromotion.libelleTypePromotion,\n" +
            "produit.id, produit.nom, produit.prix,\n" +
            "categorie.id,  categorie.nom\n" +
            "FROM promotion, typepromotion, produit, categorie\n" +
            "WHERE promotion.idTypePromotion = typepromotion.id \n" +
            "AND promotion.idProduit = produit.id\n" +
            "AND produit.idCategorie = categorie.id;;" );
           
            while (resultat.next()) 
            {
                OVProduit ovProduit = new OVProduit(
                    resultat.getInt("produit.id"), 
                    resultat.getString("produit.nom"), 
                    new OVCategorie(resultat.getInt("categorie.id"),resultat.getString("categorie.nom")), 
                    resultat.getDouble("produit.prix")
                ); 
                
                OVTypePromotion ovTypePromotion = new OVTypePromotion(resultat.getString("typepromotion.libelleTypePromotion"));
                
                OVPromotion ovPromotion = new OVPromotion(ovTypePromotion, ovProduit,resultat.getString("promotion.libellePromotion"), resultat.getFloat("promotion.promotion"), resultat.getDate("promotion.dateDebut"), resultat.getDate("promotion.dateFin"));
                
                
                               
                rep.getListePromotion().add(ovPromotion);  
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       
       return rep; 
   }
    
    public static RepNotification GET_NOTIFICATIONS(OVNotification ovNotification) throws SQLException
   {
       RepNotification rep = new RepNotification();
       Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT produit.id, categorie.id, produit.nom, categorie.nom, produit.prix FROM produit, categorie WHERE produit.idCategorie = categorie.id;" );
           
            while (resultat.next()) 
            {
                OVNotification ovNotification = new OVNotification(
                    resultat.getInt("notification.id"), 
                    resultat.getInt("notification.distance"),
                    resultat.getBoolean("notification.responseNeeded"),
                    resultat.getString("notification.texte")
                ); 
                               
                rep.getListeNotification().add(ovNotification);  
            }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
       
       return rep; 
   }
    
    
}