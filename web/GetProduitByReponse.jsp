<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*"%>
<%
    
    if(request.getParameter("Reponse") != null) {
    
        String reponseJson = request.getParameter("Reponse");
        OVReponse ovReponse = new OVReponse(reponseJson);
    
        RepProduit repProduit = DaoSmartShopping.GET_PRODUIT_BY_REPONSE(ovReponse);
        out.print(repProduit.toJSON());
   
    } else {
      
        out.print("Aucun objet en paramètre");
       
    }
%>
