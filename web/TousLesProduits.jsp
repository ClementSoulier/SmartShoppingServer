
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%

    
    out.print(DaoSmartShopping.GET_PRODUITS().toJSON().toString());
   
    
%>
