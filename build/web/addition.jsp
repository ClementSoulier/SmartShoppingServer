
       <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.*"%>
<% 
           try {
             Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException e) { }
       
        String url = "jdbc:mysql://localhost/smartshopping";
        String utilisateur = "manager";
        String motDePasse = "rudba?noimjustthemanager";
        Connection connexion = null;

        
        
        try 
        {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        } 
        catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        } 
        
        
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery( "SELECT * from produit;" );

        while (resultat.next()) 
            {
                
                    out.print(resultat.getInt("id")); 
                    out.print(resultat.getString("nom"));
                    out.print(resultat.getInt("idCategorie")); 
                    out.print(resultat.getDouble("prix"));
               
            }
           
        
         %>  

