<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("Notification") != null){
    
    String notifcation = request.getParameter("Notification");

    ReqNotification reqNotification = new ReqNotification(notifcation);
    
    RepNotification repNotification = DaoSmartShopping.GET_NOTIFICATIONS(ovNotification);
    out.print(repNotification.toJSON());
    
    }
    else
    {
        
        out.print("Aucun objet en paramètre");
        
    }
%>
