<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>

<%
    /* Page d'appel de la m�thode FIND_ALL_SOMMETS (consulter DaoSmartShopping pour plus d'informations) */
    out.print(DaoSmartShopping.FIND_ALL_SOMMETS().toJSON().toString());
   
    
%>
