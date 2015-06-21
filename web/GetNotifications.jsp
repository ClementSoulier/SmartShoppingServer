<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode GET_NOTIFICATIONS (consulter DaoSmartShopping pour plus d'informations) */
    if(request.getParameter("Notification") != null) {
    
        String notificationJson = request.getParameter("Notification");
        OVNotification ovNotification = new OVNotification(notificationJson);
    
        RepNotification repNotification = DaoSmartShopping.GET_NOTIFICATIONS(ovNotification);
        out.print(repNotification.toJSON());
   
    } else {
      
        out.print("Aucun objet en paramètre");
       
    }
%>
