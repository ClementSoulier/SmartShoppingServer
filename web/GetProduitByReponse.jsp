<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode GET_PRODUIT_BY_REPONSE (consulter DaoSmartShopping pour plus d'informations) */
    if (request.getParameter("Reponse") != null) {

        String reponseJson = request.getParameter("Reponse");
        OVReponse ovReponse = new OVReponse(reponseJson);

        RepProduit repProduit = DaoSmartShopping.GET_PRODUIT_BY_REPONSE(ovReponse);
        out.print(repProduit.toJSON());

    } else {

        out.print("Aucun objet en paramètre");

    }
%>
