<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%
    
    if(request.getParameter("IMEI") != null) {
        
        String IMEI = request.getParameter("IMEI");
        int id = Integer.parseInt(IMEI.replace("\"", ""));
        out.print(DaoSmartShopping.getUser(id).toJSON());
    
    }else{
        out.print("Identifiant IMEI nécessaire.");
    }
%>