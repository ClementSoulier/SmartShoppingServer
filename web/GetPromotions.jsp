<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>

<%
    /* Page d'appel de la méthode GET_PROMOTIONS (consulter DaoSmartShopping pour plus d'informations) */
    if (request.getParameter("Utilisateur") != null) {

        String utilisateurJson = request.getParameter("Utilisateur");
        OVUtilisateur ovUtilisateur = new OVUtilisateur(utilisateurJson);

        out.print(DaoSmartShopping.GET_PROMOTIONS(ovUtilisateur).toJSON().toString());

    } else {

        out.print("Aucun objet en paramètre");

    }


%>
