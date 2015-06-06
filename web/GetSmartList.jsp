<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
}<%
    
    if(request.getParameter("utilisateur") != null) {
        OVUtilisateur user = new OVUtilisateur(request.getParameter("utilisateur"));
        out.print(DaoSmartShopping.GET_LISTE_PRODUIT(user).toJSON().toString());
    
    }else{
        out.print("Identifiant IMEI nécessaire.");
    }
%>