<%@page import="org.json.JSONException"%>
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode UPDATE_REPONSE (consulter DaoSmartShopping pour plus d'informations) */
    if (request.getParameter("Notification") != null) {

        String notificationJson = request.getParameter("Notification");
        OVNotification ovNotification = new OVNotification(notificationJson);

        RepNotification repNotification = DaoSmartShopping.UPDATE_REPONSE(ovNotification);
        out.print(repNotification.toJSON().toString());
    } else {
        out.print("Aucun objet en paramètre");
    }
%>
