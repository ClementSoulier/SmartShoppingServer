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
   
   public static RepSmartList GET_LISTE_PRODUIT(OVUtilisateur user) throws SQLException {
       
       RepSmartList rep = new RepSmartList();
       Connection connexion = GET_Connection();
       OVSmartList ovSmartList = new OVSmartList();
       
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT * FROM smartliste where idUtilisateur = '"+user.getId()+"' ORDER BY id LIMIT 1" );
           
            while (resultat.next()) 
            {
                ovSmartList = new OVSmartList(
                    new ArrayList<OVListeProduit>(),
                    resultat.getString("nom")
                ); 
                
                ovSmartList.setId(resultat.getInt("id"));
            }
            ovSmartList.setUtilisateur(user);
 
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
    
    public static RepNotification GET_NOTIFICATIONS(OVNotification oVNotification) throws SQLException {
        RepNotification rep = new RepNotification();
        Connection connexion = GET_Connection();

        try {
            int distance = oVNotification.getDistance();
            int major = oVNotification.getOvBeacon().getMajor();
            
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT notification.id," + 
                "notification.distance, notification.reponseNeeded, notification.texte " + 
                "FROM notification\n" +
                "INNER JOIN beacon on (notification.idBeacon = beacon.id)\n" +
                "WHERE distance = " + distance + " and major = " + major);

            while (resultat.next()) {
                OVNotification ovNotif = new OVNotification(
                        resultat.getInt("notification.id"),
                        resultat.getInt("notification.distance"),
                        resultat.getInt("notification.reponseNeeded"),
                        resultat.getString("notification.texte")
                );

                rep.getListeNotification().add(ovNotif);
            }
            
            // Traitement des notifications qui ont besoin d'une réponse 
            
            if(rep.getListeNotification().size() > 0 && rep.getListeNotification().get(0).isResponseNeeded() == 1){
                statement.close();
                statement = connexion.createStatement();
                OVReponse ovReponse = new OVReponse();
                ovReponse.setEtat(0);
                int resultatInsert = statement.executeUpdate("INSERT INTO reponse (etat, idNotification) VALUES (0, "+rep.getListeNotification().get(0).getId()+");",Statement.RETURN_GENERATED_KEYS );
           
                if(resultatInsert == 0)
                {
                    rep.erreur = true;
                    rep.messageErreur = "Aucune ligne inséré!";
                }
                else{
                    ResultSet gk = statement.getGeneratedKeys();
                    if (gk.next()) {
                        ovReponse.setId(gk.getInt(1));
                    }
                    else 
                    {
                        rep.messageErreur = "Creating user failed, no ID obtained.";
                    }
                }
                rep.getListeNotification().get(0).setReponseEnvoye(ovReponse);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }
    
    public static RepNotification UPDATE_REPONSE(OVNotification ovNotification) throws SQLException {
       
       RepNotification rep = new RepNotification();
       Connection connexion = GET_Connection();
       
       try{
          
                Statement statement = connexion.createStatement();
                int resultat = statement.executeUpdate("UPDATE reponse SET etat = "+ovNotification.getReponseEnvoye().getEtat()+" WHERE idReponse = "+ovNotification.getReponseEnvoye().getId()+";");

                 if(resultat == 0)
                 {
                     rep.erreur = true;
                     rep.messageErreur = "Aucune ligne mise à jour!";
                 }
          
                 // Ajout de la promotion //
                 
                 if(ovNotification.getReponseEnvoye().getEtat() == 1 && ovNotification.getOvPromotion() != null){
                     resultat = statement.executeUpdate("INSERT INTO promotionUtilisateur (idUtilisateur, idPromotion) VALUES (0,"+ovNotification.getOvPromotion().getId()+");",Statement.RETURN_GENERATED_KEYS );
           
                        if(resultat == 0)
                        {
                            rep.erreur = true;
                            rep.messageErreur = "Aucune ligne inséré!";
                        }
                 }
 
       }
       catch(SQLException ex){
           rep.erreur = true;
           rep.messageErreur = ex.getMessage();
       }
      
       return rep;
   }
    
    public static RepProduit GET_PRODUIT_BY_REPONSE(OVReponse ovReponse) throws SQLException {
       RepProduit rep = new RepProduit();
       Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT produit.id, categorie.id, " + 
                "produit.nom, categorie.nom, produit.prix FROM produit\n" +
                "INNER JOIN categorie on (produit.idCategorie = categorie.id)\n" +
                "INNER JOIN promotion on (produit.id = promotion.idProduit)\n" +
                "INNER JOIN notification on (notification.idPromotion = promotion.id)\n" +
                "INNER JOIN reponse on (reponse.idNotification = notification.id)\n" +
                "WHERE idReponse = " + ovReponse.getId() );
           
            while (resultat.next()) {
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
    
    public static RepUtilisateur getUser(String imei) throws SQLException{
        RepUtilisateur utilisateurRep = new RepUtilisateur();
        
        Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           ResultSet resultat = statement.executeQuery( "SELECT * from utilisateur "+
                "WHERE IMEI = " + imei);
           int lineCounter = 0; 
            while (resultat.next()) {
                OVUtilisateur ovUser = new OVUtilisateur(
                    resultat.getInt("id"), 
                    resultat.getString("imei")
                ); 
                utilisateurRep.setUtilisateur(ovUser);
                lineCounter++;
            }
            if(lineCounter == 0){
                int result = statement.executeUpdate("INSERT INTO utilisateur(imei) VALUES(" + imei + ")");
                if(result == 0){
                    utilisateurRep.erreur = true;
                    utilisateurRep.messageErreur = "Add new user failed";
                    return utilisateurRep;
                } else {
                    utilisateurRep =  getUser(imei); //appel recursive...
                    statement.executeUpdate("INSERT INTO smartliste(nom, idUtilisateur) VALUES('-'," + utilisateurRep.getUtilisateur().getId() + ")");
                    return utilisateurRep;
                }
            }
            
       }
       catch(SQLException ex){
           utilisateurRep.erreur = true;
           utilisateurRep.messageErreur = ex.getMessage();
       }
       
       return utilisateurRep; 
    }
    
    public static RepPromotionUtilisateur INSERT_PROMOTION_UTILISATEUR(int IdUtilisateur, int idPromotion) throws SQLException{
        RepPromotionUtilisateur repPromoUtilisateur = new RepPromotionUtilisateur();
        
        Connection connexion = GET_Connection();
       
       try{
           
           Statement statement = connexion.createStatement();
           int resultat = statement.executeUpdate("INSERT INTO PromotionUtilisateur(idUtilisateur, idPromotion) VALUES ( "+
                   IdUtilisateur+", "+idPromotion+
                   ") ");
           
            if(resultat == 0)
            {
                repPromoUtilisateur.erreur = true;
                repPromoUtilisateur.messageErreur = "Aucune ligne inséré!";
            }
            else{
                ResultSet gk = statement.getGeneratedKeys();
                if (gk.next()) {
                    ArrayList<OVPromotionUtilisateur> promotions = new ArrayList<OVPromotionUtilisateur>();
                    promotions.add(new OVPromotionUtilisateur(IdUtilisateur, idPromotion));
                    repPromoUtilisateur.setPromotions(promotions);
                }
                else 
                {
                    repPromoUtilisateur.messageErreur = "Insert promotion utilisateur faield.";
                }
            }
            
       }
       catch(SQLException ex){
           repPromoUtilisateur.erreur = true;
           repPromoUtilisateur.messageErreur = ex.getMessage();
       }
       
       return repPromoUtilisateur;
    }
}