<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode INSERT_COMMANDE (consulter DaoSmartShopping pour plus d'informations) */
    if(request.getParameter("Commande") != null){
    
    String commandeJson = request.getParameter("Commande");

    OVCommande ovCommande = new OVCommande(commandeJson);

    RepCommande repCommande = DaoSmartShopping.INSERT_COMMANDE(ovCommande);
    out.print(repCommande.toJSON());
    
    }
    else
    {
        
        out.print("Aucun objet en paramètre");
        
    }
%>
