<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%
    /* Page d'appel de la méthode FIND_ALL_PRODUITS (consulter DaoSmartShopping pour plus d'informations) */
    out.print(DaoSmartShopping.FIND_ALL_PRODUITS().toJSON().toString());
    
%>
