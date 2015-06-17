
<%@page import="SmartShopping.DAO.DaoSmartShopping"%>
<%@page import="SmartShopping.OV.*" %>
<%

    if(request.getParameter("Utilisateur") != null) {
    
        String utilisateurJson = request.getParameter("Utilisateur");
        OVUtilisateur ovUtilisateur = new OVUtilisateur(utilisateurJson);
    
        out.print(DaoSmartShopping.GET_PROMOTIONS(ovUtilisateur).toJSON().toString());
   
    } else {
      
        out.print("Aucun objet en paramètre");
       
    }
    
   
    
%>
