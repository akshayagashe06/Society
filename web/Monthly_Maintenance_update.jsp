<%-- 
    Document   : Monthly_Maintenance_update
    Created on : Nov 11, 2016, 10:44:18 AM
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
//function disable_functn() {
//    document.getElementById("maint_amt").disabled = true;
//    
//}

//function enable_functn() {
//    document.getElementById('maint_amt').removeAttribute('disabled');
//}

	function sendInfo()
	{
//                document.getElementById("maint_amt").disabled = true;
            var x = document.getElementById("flat_nos").value;
		var url="maint_update_ajax.jsp?val="+x;
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
                
                var h_a=document.getElementById('hid_amt').value;
                document.getElementById('maint_amt').value=h_a;
        }    
                
       
</script>
    </head>
    <style>
        option
        {
            color:black;
        }
        
        select
        {
            height: 30px;
            color:black;
            width:200px;
        }
        
        .action_area .btn
        {
            margin-top: 20px;
        }
        
        #maint_amt
        {
            margin-top: 20px;
            
        }
        
        #aks
        {
            margin-top: 5px;
            color:yellow;
        }
        
        .input-group
        {
            width: 300px;
        }
    </style>
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
    
        <div class="jumbotron main_body">
            <div class="action_area">
        <%
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("select FLAT_NO from SOC_MEMBERS");
        %>
        <form action="monthly_maint_dbinsert.jsp">
            <select name="flats" id="flat_nos" onchange="sendInfo();">
            <option value="" >Select Flat Number</option>    
            <%
        while(rs1.next())
        {
        %><option value="<%= rs1.getString(1) %>"><%= rs1.getString(1) %></option>
        <%
        }
                  %>
        </select>
            <%
        %>
        <br>
        <span id="aks"></span>
        <br>
        <!--<button type="button" class="btn btn-warning" id="ful_maint" onclick="disable_functn();">Full Maintenance</button>-->
        <!--<button type="button" class="btn btn-warning" id="part_maint" onclick="enable_functn();">Partial Maintenance</button><br>-->
        
        <div class="input-group">
            
            <input type="text" class="form-control" placeholder="Amount" id="maint_amt" name="maint_mony" aria-describedby="basic-addon1">
            <input type="text" class="form-control" style="margin-top: 5px" placeholder="Cheque Number" id="Chq_no" name="chq_numb" aria-describedby="basic-addon1" >
            <input type="text" class="form-control" style="margin-top: 5px" placeholder="Bank Name" id="bank_nm" name="bank_name" aria-describedby="basic-addon1" >
            <input type="text" class="form-control" style="margin-top: 5px" placeholder="Branch Name" id="Brch_nm" name="brch_nm" aria-describedby="basic-addon1" >
            <input type="text" class="form-control" style="margin-top: 5px" placeholder="Cheque Date (dd/mm/yyyy)" id="Chq_dt" name="chq_dt" aria-describedby="basic-addon1" >
            

        </div>
        <input type="Submit" class="btn btn-warning">
        
        
    </form>
        <a href="Maintenance_view.jsp"><button class="btn btn-warning">Maintenance View</button></a>
     
<script type="text/javascript" src="jquery-3.0.0.js"></script>
<script type="text/javascript"> 

        $(document).ready(function() {
            $(".dropdown-toggle").dropdown();
            
//            $("#ful_maint").click(function(){
//        $("#maint_amt").hide();
//    });
//    $("#part_maint").click(function(){
//        $("#maint_amt").show();
//    });
        });
        
       
    </script>            
    
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
               
            </div>
        </div>
        <div class="col-lg-12 footer1">
    &copy; Akshay Agashe
</div>             
  
    </body>
</html>
