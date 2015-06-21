<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode UPDATE_LISTE_PRODUIT (consulter DaoSmartShopping pour plus d'informations) */
    if(request.getParameter("ListeProduit") != null){
    
    String listeProduitJson = request.getParameter("ListeProduit");

    OVListeProduit ovListeProduit = new OVListeProduit(listeProduitJson);

    RepListeProduit repListeProduit = DaoSmartShopping.UPDATE_LISTE_PRODUIT(ovListeProduit);
    out.print(repListeProduit.toJSON());

    }
    else
    {
        
        out.print("Aucun objet en paramètre");
        
    }
%>
