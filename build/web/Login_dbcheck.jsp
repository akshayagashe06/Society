<%-- 
    Document   : admin_pg
    Created on : Nov 4, 2016, 12:27:51 PM
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
     String au=request.getParameter("auser");
     String ap=request.getParameter("apass");
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("select ADMIN,PASSWORD from SOC_OTHER_INFO");
        String a1="";
        String a2="";
        while(rs1.next())
        {
            a1=rs1.getString(1);
            a2=rs1.getString(2);

        }    
        
     if(au.equals(a1) && ap.equals(a2))
     {
          %>
          <jsp:forward page="admin_panel.html" />
  <% 
     }
         else
         {
            %>
        <script>
            alert("Enter valid username or password !");
            window.location="Login_soc.html";
            </script>
           <%     
          }

    %>
    </body>
</html>
