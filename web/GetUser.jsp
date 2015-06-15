<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%
    
    if(request.getParameter("IMEI") != null) {
        
        out.print(DaoSmartShopping.getUser(request.getParameter("IMEI")).toJSON().toString());
    
    }else{
        out.print("Identifiant IMEI nécessaire.");
    }
%>