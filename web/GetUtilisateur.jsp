<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>

<%
    /* Page d'appel de la méthode GET_UTILISATEUR (consulter DaoSmartShopping pour plus d'informations) */
    if(request.getParameter("IMEI") != null) {
        
        out.print(DaoSmartShopping.GET_UTILISATEUR(request.getParameter("IMEI")).toJSON());
    
    }else{
        out.print("Identifiant IMEI nécessaire.");
    }
%>