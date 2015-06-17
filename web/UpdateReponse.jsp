<%@page import="org.json.JSONException"%>
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%

    if (request.getParameter("Notification") != null) {

        String notificationJson = request.getParameter("Notification");
        OVNotification ovNotification = new OVNotification(notificationJson);
        //String json = "{\"id\":2,\"ovPromotion\":{\"ovTypePromotion\":{\"libelleTypePromotion\":\"REMISE_EURO\"},\"ovProduit\":{\"id\":3,\"prix\":4,\"ovCategorie\":{\"id\":3,\"nomCategorie\":\"viande\"},\"nomProduit\":\"poulet\"},\"libellePromotion\":\"50 centimes sur le poulet en octobre !\",\"promotion\":0.5,\"dateFin\":\"Oct 31, 2014 12:00:00 AM\",\"dateDebut\":\"Oct 1, 2014 12:00:00 AM\"},\"reponseEnvoye\":{\"id\":192,\"etat\":1},\"distance\":1,\"responseNeeded\":1,\"ovBeacon\":{\"minor\":1,\"major\":2,\"uuid\":\"test\",\"idBeacon\":1},\"texte\":\"Poulet pas cher, mon frere !}";
        
        RepNotification repNotification = DaoSmartShopping.UPDATE_REPONSE(ovNotification);
        out.print(repNotification.toJSON().toString());
    } else {
        out.print("Aucun objet en paramètre");
    }
%>
