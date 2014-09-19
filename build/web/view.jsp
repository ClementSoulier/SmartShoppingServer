<%-- 
    Document   : view
    Created on : 10 sept. 2014, 15:14:14
    Author     : TheNabo1
--%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="toReuse.jsp" %> <br>
        
        <h1>Testing JSP !</h1>
        <%
            System.out.println( "Evaluating date now" );
            java.util.Date date = new java.util.Date();
        %>
        <%
            out.println( String.valueOf( date )); 
            out.println( "<BR>Your machine's address is " );
            out.println( request.getRemoteHost());
        %>
        
        <%
            for(int i=0; i<5; i++) { 
        %>
            <br> The value of i is: <%= i %>
        <% } %>
            
        
        <%
        String userName = request.getParameter("name"); if (userName != null){
        session.setAttribute("sessionUserName", userName);
        application.setAttribute("applicationUserName", userName); }
        %>
        <br>
        <br>
        User name in the request object is <%=userName%>
        <br>User name in the session object is <%=session.getAttribute("sessionUserName")%>
        <br>User name in the application object in <%=application.getAttribute("applicationUserName")%>
        
    </body>
</html>
