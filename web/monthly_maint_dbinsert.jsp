<%-- 
    Document   : monthly_maint_dbinsert
    Created on : Nov 11, 2016, 4:26:51 PM
    Author     : Akshay
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Silver Plaza</title>
    </head>
    <body>
        <div class=" jumbotron main_body">
            <%
                
                 DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String sys_dt=dateFormat1.format(date);
                
                String f1=request.getParameter("flats");
                String f2=request.getParameter("maint_mony");
                String f3=request.getParameter("chq_numb");
                String f4=request.getParameter("bank_name");
                String f5=request.getParameter("chq_dt");
                String f6=request.getParameter("brch_nm");
                Class.forName("oracle.jdbc.driver.OracleDriver");  
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
                Statement stmt=con.createStatement();
                ResultSet rs1=stmt.executeQuery("select MAINTENANCE_PENDING from SOC_MEMBERS where FLAT_NO='"+f1+"'");
                
                int mt1=0;
                while(rs1.next())
                {
                    mt1=Integer.parseInt(rs1.getString(1));
                }    
                int zr=0;
                int mt_pend=mt1-Integer.parseInt(f2);
                stmt.executeQuery("update SOC_MEMBERS set MAINTENANCE_PENDING='"+mt_pend+"',MAINTENANCE_PENALTY='"+zr+"' where FLAT_NO='"+f1+"'  ");
            

                 //generate bill number
//        String bill_no="";

          
         stmt.executeQuery("insert into SOC_PAYMENT_INFO values('"+f1+"','"+f3+"','"+f2+"','"+f4+"','"+sys_dt+"','"+f5+"','"+f6+"') ");
            %>

            <h1>Maintainece for Flat No. <%= f1 %> has been successfully UPDATED</h1>  
            <a href="Monthly_Maintenance_update.jsp"><button>Back</button></a>
                    
        </div>
    </body>
</html>
