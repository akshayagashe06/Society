<%-- 
    Document   : Member_info_update
    Created on : Dec 2, 2016, 7:21:57 PM
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

<script>
	function showMember(str)
	{
//                document.getElementById("maint_amt").disabled = true;
//            var x = document.getElementById("flat_nos").value;
		var url="Member_info_update_ajax.jsp?val="+str;
                //alert(t);
		if(window.XMLHttpRequest)
		{
			request=new XMLHttpRequest();
		}	
		else if(window.ActiveXObject)
		{
			request=new ActiveXObject("Microsoft.XMLHTTP");
		}	
		
		try
		{
			request.onreadystatechange=getInfo;
			request.open("GET",url,true);
			request.send();
		}
		catch(e)
		{
			alert("Unable to Connect to Server");
		}
				
	}
	
	function getInfo()
	{
		if(request.readyState==4)
		{
			var val=request.responseText;
			document.getElementById('aks').innerHTML=val;
		}
                

        }   
        
        function read_disable()
        {
            $(document).ready(function(){
               $("#nme").removeAttr("readonly");
               $("#flt_area").removeAttr("readonly");
               $("#maint").removeAttr("readonly");
               $("#maint_pend").removeAttr("readonly");
               $("#maint_pen").removeAttr("readonly");
               $("#mem_role").removeAttr("readonly");
            });
        }
         
</script>
<style>
    input,select
    {
        color: black;
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
   

        <div class="main_body">
            <div class="action_area">
               
             <% 
                            
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        
        ResultSet rs1=stmt.executeQuery("select FLAT_NO from SOC_MEMBERS");
        
             %> 
             <form action="Member_info_update_sub.jsp">
                 Flat No <select name="flats" onchange="showMember(this.value)"> 
                     <%
        while(rs1.next())
        {
            %>        
                
            <option value="<%= rs1.getString(1) %>"><%= rs1.getString(1) %></option>

        <%
        }
        %>  
        </select>
        <button type="button" class="btn btn-primary btn-sm" onclick="read_disable();">Edit Info</button>
        <br>
        <div id="aks"></div>
        
        <input type="Submit" class="btn btn-warning">  
        </form>
        <a href="Maintenance_view.jsp"><button type="button" class="btn btn-warning">Calculate Maintenance</button></a>
        </div>
            
        </div>
        
        
        
        <div class="col-lg-12 footer1">
    &copy; Akshay Agashe
</div>    
<!-- Body Ends -->    
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
