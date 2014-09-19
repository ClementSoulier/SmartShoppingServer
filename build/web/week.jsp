<%-- 
    Document   : week
    Created on : 10 sept. 2014, 16:24:53
    Author     : TheNabo1
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
    
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        
    %>
    <body>
        <h1>Nous sommes la semaine <% out.print(week); %></h1>
    </body>
</html>
