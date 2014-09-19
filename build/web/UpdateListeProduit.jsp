<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("ListeProduit") != null){
    
    String listeProduitJson = request.getParameter("ListeProduit");

    OVListeProduit ovListeProduit = new OVListeProduit(listeProduitJson);
    //OVListeProduit ovListeProduit = new OVListeProduit(true,true,1,1);
    //ovListeProduit.setId(3);
    
    //out.println("id : "+ovListeProduit.getIdListe());
    //out.println("coche : "+ovListeProduit.getCoche());
    //out.println("supprime : "+ovListeProduit.getSupprime());
    //out.println("idliste : "+ovListeProduit.getIdListe());
    //out.println("idProduit : "+ovListeProduit.getIdProduit());
    
    RepListeProduit repListeProduit = DaoSmartShopping.UPDATE_LISTE_PRODUIT(ovListeProduit);
    out.print(repListeProduit.toJSON());

    }
    else
    {
        
        out.print("Aucun objet en paramètre");
        
    }
%>
