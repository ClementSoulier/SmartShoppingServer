package SmartShopping.DAO;

import SmartShopping.OV.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * La classe DAO fait le lien entre les objets et la base de données mySQL.
 * Cette classe est composée des différentes fonctionnalités d'insertion, de récupération et mise à jour des données.
 * @author Team SmartShopping
 */
public class DaoSmartShopping {

    private static Connection GET_CONNECTION() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }

        String url = "jdbc:mysql://localhost/smartshopping";
        String utilisateur = "manager";
        String motDePasse = "rudba?noimjustthemanager";
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (SQLException ex) {
            throw ex;
        }

        return connexion;
    }

    
    //Méthodes de récupération des données *
    
    /**
     * Méthodes de récupération de tous les produits 
     *
     * @return Objet de type {@link RepProduit} comprenant une
     * {@link ArrayList} d'objets {@link OVProduit}.
     * @throws SQLException
     */
    public static RepProduit FIND_ALL_PRODUITS() throws SQLException {
        RepProduit rep = new RepProduit();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT produit.id, categorie.id, produit.nom, categorie.nom, produit.prix FROM produit, categorie WHERE produit.idCategorie = categorie.id;");

            while (resultat.next()) {
                OVProduit ovProduit = new OVProduit(
                        resultat.getInt("produit.id"),
                        resultat.getString("produit.nom"),
                        new OVCategorie(resultat.getInt("categorie.id"), resultat.getString("categorie.nom")),
                        resultat.getDouble("produit.prix")
                );

                rep.getListeProduit().add(ovProduit);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthodes de récupération des commandes (payés) de l'utilisateur.
     *
     * @param ovUtilisateur Objet de type {@link OVUtilisateur} permettant de
     * récupérer les commandes associées à l'utilisateur.
     * @return Objet de type {@link RepCommande} comprenant une
     * {@link ArrayList} d'objets {@link OVCommande}.
     * @throws SQLException
     */
    public static RepCommande GET_COMMANDES(OVUtilisateur ovUtilisateur) throws SQLException {

        RepCommande rep = new RepCommande();
        Connection connexion = GET_CONNECTION();
        ArrayList<OVCommande> lstCommande = new ArrayList<>();
        OVCommande ovCommande;

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT id, idUtilisateur, idSmartliste, montant, date FROM commande where idUtilisateur = " + ovUtilisateur.getId());

            while (resultat.next()) {
                ovCommande = new OVCommande(
                        resultat.getInt("id"),
                        resultat.getInt("idUtilisateur"),
                        resultat.getInt("idSmartliste"),
                        (float) resultat.getDouble("montant"),
                        resultat.getDate("date")
                );

                lstCommande.add(ovCommande);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        rep.setLstCommandes(lstCommande);
        return rep;

    }

    /**
     * Méthodes de récupération de la SmartListe de l'utilisateur.
     *
     * @param ovUtilisateur Objet de type {@link OVUtilisateur} permettant de
     * récupérer la SmartListe associée à l'utilisateur.
     * @return Objet de type {@link RepSmartList} comprenant l'objet
     * {@link OVSmartList} associé à l'utilisateur.
     * @throws SQLException
     */
    public static RepSmartList GET_SMARTLIST(OVUtilisateur ovUtilisateur) throws SQLException {

        RepSmartList rep = new RepSmartList();
        Connection connexion = GET_CONNECTION();
        OVSmartList ovSmartList = new OVSmartList();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT * FROM smartliste where idUtilisateur = '" + ovUtilisateur.getId() + "' ORDER BY id LIMIT 1");

            while (resultat.next()) {
                ovSmartList = new OVSmartList(
                        new ArrayList<OVListeProduit>(),
                        resultat.getString("nom")
                );

                ovSmartList.setId(resultat.getInt("id"));
            }
            ovSmartList.setUtilisateur(ovUtilisateur);

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        try {

            Statement statement2 = connexion.createStatement();
            ResultSet resultat2 = statement2.executeQuery("select * from listeproduit where idListe = " + ovSmartList.getId() + " and supprime = 0;");

            while (resultat2.next()) {
                OVListeProduit ovListeProduit = new OVListeProduit(
                        resultat2.getBoolean("coche"),
                        resultat2.getBoolean("supprime"),
                        resultat2.getInt("idProduit"),
                        1
                );

                ovListeProduit.setId(resultat2.getInt("id"));
                ovSmartList.getProduitsSmartList().add(ovListeProduit);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }
        rep.setSmartList(ovSmartList);
        return rep;

    }

    /**
     * Méthodes permettant de récupérer tous les sommets
     *
     * @return Objet de type {@link RepSommet} comprenant une liste d'objets
     * {@link OVSommet}.
     * @throws SQLException
     */
    public static RepSommet FIND_ALL_SOMMETS() throws SQLException {

        RepSommet rep = new RepSommet();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT id, numSommet, idCategorie FROM sommet;");

            while (resultat.next()) {
                OVSommet ovSommet = new OVSommet(
                        resultat.getInt("id"),
                        resultat.getInt("numSommet"),
                        resultat.getInt("idCategorie")
                );

                rep.getListeSommet().add(ovSommet);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthodes permettant de récupérer les promotions acceptés par
     * l'utilisateur.
     *
     * @param ovUtilisateur Objet de type {@link OVUtilisateur} permettant de
     * récupérer les promotions associées à l'utilisateur.
     * @return Objet de type {@link RepPromotion} comprenant une
     * {@link ArrayList} d'objets {@link OVPromotion}.
     * @throws SQLException
     */
    public static RepPromotion GET_PROMOTIONS(OVUtilisateur ovUtilisateur) throws SQLException {
        RepPromotion rep = new RepPromotion();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT \n"
                    + "promotion.id, promotion.libellePromotion, promotion.promotion, promotion.dateDebut, promotion.dateFin, \n"
                    + "typepromotion.id, typepromotion.libelleTypePromotion,\n"
                    + "produit.id, produit.nom, produit.prix,\n"
                    + "categorie.id,  categorie.nom\n"
                    + "FROM promotion, typepromotion, produit, categorie, promotionutilisateur\n"
                    + "WHERE promotion.idTypePromotion = typepromotion.id \n"
                    + "AND promotionutilisateur.idPromotion = promotion.id\n"
                    + "AND promotionutilisateur.idUtilisateur = " + ovUtilisateur.getId() + "\n"
                    + "AND promotion.idProduit = produit.id\n"
                    + "AND produit.idCategorie = categorie.id;");

            while (resultat.next()) {
                OVProduit ovProduit = new OVProduit(
                        resultat.getInt("produit.id"),
                        resultat.getString("produit.nom"),
                        new OVCategorie(resultat.getInt("categorie.id"), resultat.getString("categorie.nom")),
                        resultat.getDouble("produit.prix")
                );

                OVTypePromotion ovTypePromotion = new OVTypePromotion(resultat.getString("typepromotion.libelleTypePromotion"));

                OVPromotion ovPromotion = new OVPromotion(resultat.getInt("promotion.id"), ovTypePromotion, ovProduit, resultat.getString("promotion.libellePromotion"), resultat.getFloat("promotion.promotion"), resultat.getDate("promotion.dateDebut"), resultat.getDate("promotion.dateFin"));

                rep.getListePromotion().add(ovPromotion);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    private static RepPromotion GET_PROMOTIONS_BY_ID(int idPromotion) throws SQLException {
        RepPromotion rep = new RepPromotion();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT \n"
                    + "promotion.id, promotion.libellePromotion, promotion.promotion, promotion.dateDebut, promotion.dateFin, \n"
                    + "typepromotion.id, typepromotion.libelleTypePromotion,\n"
                    + "produit.id, produit.nom, produit.prix,\n"
                    + "categorie.id,  categorie.nom\n"
                    + "FROM promotion, typepromotion, produit, categorie\n"
                    + "WHERE promotion.idTypePromotion = typepromotion.id \n"
                    + "AND promotion.idProduit = produit.id\n"
                    + "AND promotion.id = " + idPromotion + "\n"
                    + "AND produit.idCategorie = categorie.id;");

            while (resultat.next()) {
                OVProduit ovProduit = new OVProduit(
                        resultat.getInt("produit.id"),
                        resultat.getString("produit.nom"),
                        new OVCategorie(resultat.getInt("categorie.id"), resultat.getString("categorie.nom")),
                        resultat.getDouble("produit.prix")
                );

                OVTypePromotion ovTypePromotion = new OVTypePromotion(resultat.getString("typepromotion.libelleTypePromotion"));

                OVPromotion ovPromotion = new OVPromotion(resultat.getInt("promotion.id"), ovTypePromotion, ovProduit, resultat.getString("promotion.libellePromotion"), resultat.getFloat("promotion.promotion"), resultat.getDate("promotion.dateDebut"), resultat.getDate("promotion.dateFin"));

                rep.getListePromotion().add(ovPromotion);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant de récupérer des notifications en fonction d'un
     * beacon.
     *
     * @param oVNotification Objet de type {@link OVNotification} permettant de
     * récupérer les notifications associées à l'objet {@link OVBeacon}.
     * @return Objet de type {@link RepNotification} comprenant une
     * {@link ArrayList} d'objets {@link OVNotification}.
     * @throws SQLException
     */
    public static RepNotification GET_NOTIFICATIONS(OVNotification oVNotification) throws SQLException {
        RepNotification rep = new RepNotification();
        Connection connexion = GET_CONNECTION();

        try {
            int distance = oVNotification.getDistance();
            int major = oVNotification.getOvBeacon().getMajor();

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT notification.id,"
                    + "notification.distance, notification.reponseNeeded, notification.texte, notification.idPromotion "
                    + "FROM notification\n"
                    + "INNER JOIN beacon on (notification.idBeacon = beacon.id)\n"
                    + "WHERE distance = " + distance + " and major = " + major);

            while (resultat.next()) {
                OVNotification ovNotif = new OVNotification(
                        resultat.getInt("notification.id"),
                        resultat.getInt("notification.distance"),
                        resultat.getInt("notification.reponseNeeded"),
                        resultat.getString("notification.texte"),
                        resultat.getInt("notification.idPromotion")
                );

                rep.getListeNotification().add(ovNotif);
            }

            // Traitement des notifications qui ont besoin d'une réponse 
            if (rep.getListeNotification().size() > 0 && rep.getListeNotification().get(0).isResponseNeeded() == 1) {
                statement.close();
                statement = connexion.createStatement();
                OVReponse ovReponse = new OVReponse();
                ovReponse.setEtat(0);
                int resultatInsert = statement.executeUpdate("INSERT intO reponse (etat, idNotification) VALUES (0, " + rep.getListeNotification().get(0).getId() + ");", Statement.RETURN_GENERATED_KEYS);

                if (resultatInsert == 0) {
                    rep.erreur = true;
                    rep.messageErreur = "Aucune ligne inséré!";
                } else {
                    ResultSet gk = statement.getGeneratedKeys();
                    if (gk.next()) {
                        ovReponse.setId(gk.getInt(1));
                    } else {
                        rep.messageErreur = "Creating user failed, no ID obtained.";
                    }
                }
                rep.getListeNotification().get(0).setReponseEnvoye(ovReponse);
                rep.getListeNotification().get(0).setOvPromotion(GET_PROMOTIONS_BY_ID(rep.getListeNotification().get(0).getIdPromotion()).getListePromotion().get((0)));
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant d'obtenir un produit en fonction d'une réponse.
     *
     * @param ovReponse Objet de type {@link OVReponse} permettant de récupérer
     * le produit associé.
     * @return Objet de type {@link RepProduit} comprenant un objet
     * {@link OVProduit}.
     * @throws SQLException
     */
    public static RepProduit GET_PRODUIT_BY_REPONSE(OVReponse ovReponse) throws SQLException {
        RepProduit rep = new RepProduit();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT produit.id, categorie.id, "
                    + "produit.nom, categorie.nom, produit.prix FROM produit\n"
                    + "INNER JOIN categorie on (produit.idCategorie = categorie.id)\n"
                    + "INNER JOIN promotion on (produit.id = promotion.idProduit)\n"
                    + "INNER JOIN notification on (notification.idPromotion = promotion.id)\n"
                    + "INNER JOIN reponse on (reponse.idNotification = notification.id)\n"
                    + "WHERE idReponse = " + ovReponse.getId());

            while (resultat.next()) {
                OVProduit ovProduit = new OVProduit(
                        resultat.getInt("produit.id"),
                        resultat.getString("produit.nom"),
                        new OVCategorie(resultat.getInt("categorie.id"), resultat.getString("categorie.nom")),
                        resultat.getDouble("produit.prix")
                );

                rep.getListeProduit().add(ovProduit);
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant d'obtenir un utilisateur en fonction de son
     * identifiant (IMEI téléphone) Si l'utilisateur n'existe par il est créé.
     *
     * @param id Identifiant de l'utilisateur.
     * @return Objet de type {@link RepUtilisateur} comprenant un objet
     * {@link OVUtilisateur}.
     * @throws SQLException
     */
    public static RepUtilisateur GET_UTILISATEUR(String id) throws SQLException {
        RepUtilisateur utilisateurRep = new RepUtilisateur();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery("SELECT * from utilisateur "
                    + "WHERE id = " + id);
            System.out.println("SELECT * from utilisateur "
                    + "WHERE id = " + id);
            int lineCounter = 0;
            while (resultat.next()) {
                OVUtilisateur ovUser = new OVUtilisateur(
                        resultat.getInt("id")
                );
                utilisateurRep.setUtilisateur(ovUser);
                lineCounter++;
            }
            if (lineCounter == 0) {
                int result = statement.executeUpdate("INSERT intO utilisateur(id) VALUES(" + id + ")");
                System.out.println("INSERT intO utilisateur(id) VALUES(" + id + ")");
                if (result == 0) {
                    utilisateurRep.erreur = true;
                    utilisateurRep.messageErreur = "Add new user failed";
                    return utilisateurRep;
                } else {
                    utilisateurRep = GET_UTILISATEUR(id); //appel recursive...
                    statement.executeUpdate("INSERT intO smartliste(nom, idUtilisateur) VALUES('-'," + utilisateurRep.getUtilisateur().getId() + ")");
                    System.out.println("INSERT intO smartliste(nom, idUtilisateur) VALUES('-'," + utilisateurRep.getUtilisateur().getId() + ")");
                    return utilisateurRep;
                }
            }

        } catch (SQLException ex) {
            utilisateurRep.erreur = true;
            utilisateurRep.messageErreur = ex.getMessage();
        }

        return utilisateurRep;
    }

    // Méthodes d'insertions en base de données
    
    /**
     * Méthode permettant l'insertion d'une liste de produit en base.
     * 
     * @param ovListeProduit Objet de type {@link OVListeProduit} avec les informations nécessaire à l'insertion.
     * @return Objet de type {@link RepListeProduit} permettant de connaître le résultat de l'exécution.
     * @throws SQLException
     */
    public static RepListeProduit INSERT_LISTE_PRODUIT(OVListeProduit ovListeProduit) throws SQLException {

        RepListeProduit rep = new RepListeProduit();
        Connection connexion = GET_CONNECTION();
        try {

            Statement statement = connexion.createStatement();

            int resultat = statement.executeUpdate("INSERT intO listeproduit (idProduit, idListe) VALUES (" + ovListeProduit.getIdProduit() + "," + ovListeProduit.getIdListe() + ");", Statement.RETURN_GENERATED_KEYS);

            if (resultat == 0) {
                rep.erreur = true;
                rep.messageErreur = "Aucune ligne inséré!";
            } else {
                ResultSet gk = statement.getGeneratedKeys();
                if (gk.next()) {
                    rep.setIdListeProduit(gk.getInt(1));
                } else {
                    rep.messageErreur = "Creating user failed, no ID obtained.";
                }
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant l'insertion d'une commande en base (Commande = liste de course payée).
     * 
     * @param ovCommande Objet de type {@link OVCommande} avec les informations nécessaire à l'insertion.
     * @return Objet de type {@link RepCommande} permettant de connaître le résultat de l'exécution.
     * @throws SQLException
     */
    public static RepCommande INSERT_COMMANDE(OVCommande ovCommande) throws SQLException {

        Connection connexion = GET_CONNECTION();
        RepCommande repCommande = new RepCommande();
        try {

            Statement statement = connexion.createStatement();
            int resultat = statement.executeUpdate("INSERT into commande(idUtilisateur, idSmartliste, montant) VALUES ( "
                    + ovCommande.getIdUtilisateur() + ", " + ovCommande.getIdSmartlist() + ", " + ovCommande.getMontant()
                    + ") ");

            if (resultat == 0) {
                repCommande.erreur = true;
                repCommande.messageErreur = "Aucune ligne inséré!";
            }

        } catch (SQLException ex) {
            repCommande.erreur = true;
            repCommande.messageErreur = ex.getMessage();
        }

        return repCommande;
    }

    // Méthodes de mise à jour des données
    
    /**
     * Méthode permettant de mettre à jour la liste des produits d'un utilisateur en base. 
     * 
     * @param ovListeProduit Objet de type {@link OVListeProduit} avec les informations nécessaire à la mise à jour.
     * @return Objet de type {@link RepListeProduit} permettant de connaître le résultat de l'exécution.
     * @throws java.sql.SQLException *
     */
    public static RepListeProduit UPDATE_LISTE_PRODUIT(OVListeProduit ovListeProduit) throws SQLException {

        RepListeProduit rep = new RepListeProduit();
        Connection connexion = GET_CONNECTION();
        int coche = 0;
        int supprime = 0;

        if (ovListeProduit.getCoche()) {
            coche = 1;
        }
        if (ovListeProduit.getSupprime()) {
            supprime = 1;
        }

        try {

            Statement statement = connexion.createStatement();
            int resultat = statement.executeUpdate("UPDATE listeproduit SET coche = " + coche + ", supprime = " + supprime + " WHERE id = " + ovListeProduit.getId() + ";");

            if (resultat == 0) {
                rep.erreur = true;
                rep.messageErreur = "Aucune ligne mise à jour!";
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant de mettre à jour la Smart Liste d'un utilisateur en base. 
     * 
     * @param ovSmartList Objet de type {@link OVSmartList} avec les informations nécessaire à la mise à jour.
     * @return Objet de type {@link RepSmartList} permettant de connaître le résultat de l'exécution.
     * @throws java.sql.SQLException *
     */
    public static RepSmartList UPDATE_SMART_LIST(OVSmartList ovSmartList) throws SQLException {

        RepSmartList rep = new RepSmartList();
        Connection connexion = GET_CONNECTION();

        try {

            for (OVListeProduit ovListeProduit : ovSmartList.getProduitsSmartList()) {

                int coche = 0;
                int supprime = 0;

                if (ovListeProduit.getCoche()) {
                    coche = 1;
                }
                if (ovListeProduit.getSupprime()) {
                    supprime = 1;
                }

                Statement statement = connexion.createStatement();
                int resultat = statement.executeUpdate("UPDATE listeproduit SET coche = " + coche + ", supprime = " + supprime + " WHERE id = " + ovListeProduit.getId() + ";");

                if (resultat == 0) {
                    rep.erreur = true;
                    rep.messageErreur = "Aucune ligne mise à jour!";
                }
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

    /**
     * Méthode permettant de mettre à jour la réponse d'un utilisateur à une notification pour faire des statistiques.
     * 
     * @param ovNotification Objet de type {@link OVNotification} avec les informations nécessaire à la mise à jour.
     * @return Objet de type {@link RepNotification} permettant de connaître le résultat de l'exécution.
     * @throws java.sql.SQLException *
     */
    public static RepNotification UPDATE_REPONSE(OVNotification ovNotification) throws SQLException {

        RepNotification rep = new RepNotification();
        Connection connexion = GET_CONNECTION();

        try {

            Statement statement = connexion.createStatement();
            int resultat = statement.executeUpdate("UPDATE reponse SET etat = " + ovNotification.getReponseEnvoye().getEtat() + " WHERE idReponse = " + ovNotification.getReponseEnvoye().getId() + ";");

            if (resultat == 0) {
                rep.erreur = true;
                rep.messageErreur = "Aucune ligne mise à jour!";
            }

                 // Ajout de la promotion //
            if (ovNotification.getReponseEnvoye().getEtat() == 1 && ovNotification.getOvPromotion() != null) {
                resultat = statement.executeUpdate("INSERT intO promotionutilisateur (idUtilisateur, idPromotion) VALUES (" + ovNotification.getIdUtilisateur() + "," + ovNotification.getOvPromotion().getId() + ");", Statement.RETURN_GENERATED_KEYS);

                if (resultat == 0) {
                    rep.erreur = true;
                    rep.messageErreur = "Aucune ligne inséré!";
                }
            }

        } catch (SQLException ex) {
            rep.erreur = true;
            rep.messageErreur = ex.getMessage();
        }

        return rep;
    }

}
