<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("ListeProduit") != null){
    
    String listeProduitJson = request.getParameter("ListeProduit");

    OVListeProduit ovListeProduit = new OVListeProduit(listeProduitJson);
    //OVListeProduit ovListeProduit = new OVListeProduit(true,true,1,1); 
    RepListeProduit repListeProduit = DaoSmartShopping.INSERT_LISTE_PRODUIT(ovListeProduit);
    out.print(repListeProduit.toJSON());
    
    }
    else
    {
        
        out.print("Aucun objet en paramètre");
        
    }
%>
