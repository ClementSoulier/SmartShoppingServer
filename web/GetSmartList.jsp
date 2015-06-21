<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>

<%
    /* Page d'appel de la méthode GET_LISTE_PRODUIT (consulter DaoSmartShopping pour plus d'informations) */
    if(request.getParameter("utilisateur") != null) {
        OVUtilisateur user = new OVUtilisateur(request.getParameter("utilisateur"));
        out.print(DaoSmartShopping.GET_SMARTLIST(user).toJSON().toString());
    
    }else{
        out.print("Identifiant IMEI nécessaire.");
    }
%>