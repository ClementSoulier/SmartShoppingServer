<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("Notification") != null) {
    
        String notificationJson = request.getParameter("Notification");
        OVNotification ovNotification = new OVNotification(notificationJson);
    
        RepNotification repNotification = DaoSmartShopping.GET_NOTIFICATIONS(ovNotification);
        out.print(repNotification.toJSON());
   
    } else {
      
        out.print("Aucun objet en paramètre");
       
    }
%>
