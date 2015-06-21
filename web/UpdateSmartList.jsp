<%@page import="org.json.JSONException"%>
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>

<%
    /* Page d'appel de la méthode UPDATE_SMART_LIST (consulter DaoSmartShopping pour plus d'informations) */
    if (request.getParameter("SmartList") != null) {

        String listeProduitJson = request.getParameter("SmartList");
        OVSmartList ovSmartList = new OVSmartList(listeProduitJson);
        RepSmartList repSmartList = DaoSmartShopping.UPDATE_SMART_LIST(ovSmartList);
        out.print(repSmartList.toJSON().toString());
        
    } else {
        out.print("Aucun objet en paramètre");
    }
%>
