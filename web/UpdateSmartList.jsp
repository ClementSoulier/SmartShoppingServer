<%@page import="org.json.JSONException"%>
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("SmartList") != null){
    
    String listeProduitJson = request.getParameter("SmartList");

    OVSmartList ovSmartList = new OVSmartList(listeProduitJson);
    
    RepSmartList repSmartList = DaoSmartShopping.UPDATE_SMART_LIST(ovSmartList);
    
    }
    else
    {
        out.print("Aucun objet en paramètre");  
   }
%>
