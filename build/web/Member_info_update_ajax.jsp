<%-- 
    Document   : Member_info_update_ajax
    Created on : Dec 2, 2016, 8:41:32 PM
    Author     : Akshay
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="common_soc_style.css">
        <style>
            tr, td
            {
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <% 
        String v1=request.getParameter("val");
        
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        
        String a1="",a2="",a3="",a4="",a5="",a6="";
        ResultSet rs1=stmt.executeQuery("select * from SOC_MEMBERS where FLAT_NO='"+v1+"'");
        while(rs1.next())
        {
            a1=rs1.getString(2);
            a2=rs1.getString(3);
            a3=rs1.getString(4);
            a4=rs1.getString(5);
            a5=rs1.getString(6);
            a6=rs1.getString(7);
        }
        %>
        
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="nme" id="nme" value="<%= a1%>" readonly></td>
            </tr>
            <tr>
                <td>Flat Area</td>
                <td><input type="text" name="flt_area" id="flt_area" value="<%= a2%>" readonly></td>
            </tr> 
            <tr>
                <td>Maintenance</td>
                <td><input type="text" name="maint" id="maint" value="<%= a3%>" readonly></td>
            </tr>
            <tr>
                <td>MAINTENANCE_PENDING</td>
                <td><input type="text" name="maint_pend" id="maint_pend" value="<%= a4%>" readonly></td>
            </tr>     
            <tr>
                <td>MAINTENANCE_PENALTY</td>
                <td><input type="text" name="maint_pen" id="maint_pen" value="<%= a5%>" readonly></td>
            </tr> 
            <tr>
                <td>MEMBER_ROLE</td>
                <td><input type="text" name="mem_role" id="mem_role" value="<%= a6%>" readonly></td>
            </tr>             
        </table>
    </body>
</html>
