<%-- 
    Document   : Member_info_update_sub
    Created on : Dec 4, 2016, 12:21:46 PM
    Author     : Akshay
--%>


<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Silver Plaza</title>
    </head>
    <body>
        <%
         String a0=request.getParameter("flats");   
         String a1=request.getParameter("nme");
         String a2=request.getParameter("flt_area");
         String a3=request.getParameter("maint");
         String a4=request.getParameter("maint_pend");
         String a5=request.getParameter("maint_pen");
         String a6=request.getParameter("mem_role");
            
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        stmt.executeQuery("update SOC_MEMBERS set NAME='"+a1+"', FLAT_AREA='"+a2+"',MAINTENANCE='"+a3+"',MAINTENANCE_PENDING='"+a4+"',MAINTENANCE_PENALTY='"+a5+"',MEMBER_ROLE='"+a6+"' where FLAT_NO='"+a0+"' ");
            
        %>
    </body>
</html>
