
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%

    
    out.print(DaoSmartShopping.GET_ALL_SOMMETS().toJSON().toString());
   
    
%>
