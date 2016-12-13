<%-- 
    Document   : Maintenance_view
    Created on : Nov 4, 2016, 8:23:30 PM
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
                    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
   
<link rel="stylesheet" type="text/css" href="common_soc_style.css">
<style>
    table th, table td
    {
        text-align: center;
        padding: 10px;
    }

</style>
    </head>
    <body>
         
<!--    Navbar for the screen-->
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">Silver Plaza</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Social<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Events</a></li>
            <li><a href="#">Photos</a></li>
            
          </ul>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Services <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Maintainence</a></li>
            <li><a href="#">Bank Accounts</a></li>
            
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Login_soc.html">Login</a></li>
        <li><a href="#">About Us</a></li>  
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>    
    
        <div class="jumbotron">
            <div style="float:right; color:yellow;  margin-right: 30px;">Welcome! Darshan</div>    
        <h2>Maintainence Info</h2>
        <center>
           <table cellspacing="10">
        <%
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("select * from SOC_MEMBERS");
        %>
                <tr>
                    <th>Flat Number</th>
                    <th>Name</th>
                    <th>Maintenance</th>
                    <th>Maintenance Pending</th>
                    <th>Maintenance Penalty</th>
                    <th>Member Role</th>
                    <th>No. of Penalties</th>
                </tr>
        
        <%
         int maint_sum=0; 
         int maint_pend=0;
         int maint_penl=0;
        while(rs1.next())
        {
            maint_sum=maint_sum+ Integer.parseInt( rs1.getString(4));
            maint_pend=maint_pend+ Integer.parseInt( rs1.getString(5));
            maint_penl=maint_penl+ Integer.parseInt( rs1.getString(6));
            %>
            
                <tr>
                    <td><%= rs1.getString(1) %></td>
                    <td><%= rs1.getString(2) %></td>
                    <td><%= rs1.getString(4) %></td>
                    <td><%= rs1.getString(5) %></td>
                    <td><%= rs1.getString(6) %></td>
                    <td><%= rs1.getString(7) %></td>
                    <td><%= rs1.getString(8) %></td>
                </tr>
            
        <%
        }
        %>
                            
                <tr style="font-size: 20px; color:yellow;">
                    <td colspan="2" >TOTAL</td>
                    
                    <td>&#8377;<%= maint_sum %></td>
                    <td>&#8377;<%= maint_pend %></td>
                    <td>&#8377;<%= maint_penl %></td>
                    <td></td>
                    <td></td>
                </tr>
            

        </table>
                    
         <a href="Monthly_Maintenance_update.jsp"><button type="button" class="btn btn-warning">Monthly Maintenance</button></a>
         <a href="Month_maint_calc.jsp"><button type="button" class="btn btn-warning">Calculate Maintenance</button></a>
         <a href="Monthly_bills.jsp"><button type="button" class="btn btn-warning">Generate Maintenance Bills</button></a><br>               
        </center>
        </div>
        <div class="col-lg-12 footer1">
    &copy; Akshay Agashe
</div> 
                    
         
<script type="text/javascript" src="jquery-3.0.0.js"></script>
<script type="text/javascript"> 
        $(document).ready(function() {
            $(".dropdown-toggle").dropdown();
        });
    </script>            
    
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>                   
    </body>
</html>
