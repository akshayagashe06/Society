<%-- 
    Document   : maint_update_ajax
    Created on : Nov 11, 2016, 6:52:32 PM
    Author     : Akshay
--%>

<%@page import="java.sql.ResultSet"%>
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
        String f_no=request.getParameter("val");     
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("select NAME,MAINTENANCE_PENDING from SOC_MEMBERS where FLAT_NO='"+f_no+"'");
        
//        int m1=0;
        while(rs1.next())
        {
//            m1=Integer.parseInt(rs1.getString(2));
            %>
            Name:<%= rs1.getString(1) %> <br>
            Pending &#8377; :<%= rs1.getString(2) %>
            <input type="text" value="<%= rs1.getString(2) %>" hidden="true" id="hid_amt">
        <%
            
        }
        %>
    </body>
</html>
