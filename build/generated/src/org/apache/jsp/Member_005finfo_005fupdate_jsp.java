package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Member_005finfo_005fupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Silver Plaza</title>\n");
      out.write("            <!-- Latest compiled and minified CSS -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<!-- Optional theme -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("   \n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"common_soc_style.css\">\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\tfunction showMember(str)\n");
      out.write("\t{\n");
      out.write("//                document.getElementById(\"maint_amt\").disabled = true;\n");
      out.write("//            var x = document.getElementById(\"flat_nos\").value;\n");
      out.write("\t\tvar url=\"Member_info_update_ajax.jsp?val=\"+str;\n");
      out.write("                //alert(t);\n");
      out.write("\t\tif(window.XMLHttpRequest)\n");
      out.write("\t\t{\n");
      out.write("\t\t\trequest=new XMLHttpRequest();\n");
      out.write("\t\t}\t\n");
      out.write("\t\telse if(window.ActiveXObject)\n");
      out.write("\t\t{\n");
      out.write("\t\t\trequest=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("\t\t}\t\n");
      out.write("\t\t\n");
      out.write("\t\ttry\n");
      out.write("\t\t{\n");
      out.write("\t\t\trequest.onreadystatechange=getInfo;\n");
      out.write("\t\t\trequest.open(\"GET\",url,true);\n");
      out.write("\t\t\trequest.send();\n");
      out.write("\t\t}\n");
      out.write("\t\tcatch(e)\n");
      out.write("\t\t{\n");
      out.write("\t\t\talert(\"Unable to Connect to Server\");\n");
      out.write("\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction getInfo()\n");
      out.write("\t{\n");
      out.write("\t\tif(request.readyState==4)\n");
      out.write("\t\t{\n");
      out.write("\t\t\tvar val=request.responseText;\n");
      out.write("\t\t\tdocument.getElementById('aks').innerHTML=val;\n");
      out.write("\t\t}\n");
      out.write("                \n");
      out.write("\n");
      out.write("        }   \n");
      out.write("        \n");
      out.write("        function read_disable()\n");
      out.write("        {\n");
      out.write("            $(document).ready(function(){\n");
      out.write("               $(\"#nme\").removeAttr(\"readonly\");\n");
      out.write("               $(\"#flt_area\").removeAttr(\"readonly\");\n");
      out.write("               $(\"#maint\").removeAttr(\"readonly\");\n");
      out.write("               $(\"#maint_pend\").removeAttr(\"readonly\");\n");
      out.write("               $(\"#maint_pen\").removeAttr(\"readonly\");\n");
      out.write("               $(\"#mem_role\").removeAttr(\"readonly\");\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("         \n");
      out.write("</script>\n");
      out.write("<style>\n");
      out.write("    input,select\n");
      out.write("    {\n");
      out.write("        color: black;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--    Navbar for the screen-->\n");
      out.write("    <nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"index.html\">Silver Plaza</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Social<span class=\"caret\"></span></a>\n");
      out.write("          <ul class=\"dropdown-menu\">\n");
      out.write("            <li><a href=\"#\">Events</a></li>\n");
      out.write("            <li><a href=\"#\">Photos</a></li>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Services <span class=\"caret\"></span></a>\n");
      out.write("          <ul class=\"dropdown-menu\">\n");
      out.write("            <li><a href=\"#\">Maintainence</a></li>\n");
      out.write("            <li><a href=\"#\">Bank Accounts</a></li>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        </li>\n");
      out.write("      </ul>\n");
      out.write("      <form class=\"navbar-form navbar-left\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("        </div>\n");
      out.write("        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("      </form>\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"Login_soc.html\">Login</a></li>\n");
      out.write("        <li><a href=\"#\">About Us</a></li>  \n");
      out.write("        \n");
      out.write("      </ul>\n");
      out.write("    </div><!-- /.navbar-collapse -->\n");
      out.write("  </div><!-- /.container-fluid -->\n");
      out.write("</nav>\n");
      out.write("   \n");
      out.write("\n");
      out.write("        <div class=\"main_body\">\n");
      out.write("            <div class=\"action_area\">\n");
      out.write("               \n");
      out.write("             ");
 
                            
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        
        ResultSet rs1=stmt.executeQuery("select FLAT_NO from SOC_MEMBERS");
        
             
      out.write(" \n");
      out.write("             <form action=\"Member_info_update_sub.jsp\">\n");
      out.write("                 Flat No <select name=\"flats\" onchange=\"showMember(this.value)\"> \n");
      out.write("                     ");

        while(rs1.next())
        {
            
      out.write("        \n");
      out.write("                \n");
      out.write("            <option value=\"");
      out.print( rs1.getString(1) );
      out.write('"');
      out.write('>');
      out.print( rs1.getString(1) );
      out.write("</option>\n");
      out.write("\n");
      out.write("        ");

        }
        
      out.write("  \n");
      out.write("        </select>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"read_disable();\">Edit Info</button>\n");
      out.write("        <br>\n");
      out.write("        <div id=\"aks\"></div>\n");
      out.write("        \n");
      out.write("        <input type=\"Submit\" class=\"btn btn-warning\">  \n");
      out.write("        </form>\n");
      out.write("        <a href=\"Maintenance_view.jsp\"><button type=\"button\" class=\"btn btn-warning\">Calculate Maintenance</button></a>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"col-lg-12 footer1\">\n");
      out.write("    &copy; Akshay Agashe\n");
      out.write("</div>    \n");
      out.write("<!-- Body Ends -->    \n");
      out.write("<script type=\"text/javascript\" src=\"jquery-3.0.0.js\"></script>\n");
      out.write("<script type=\"text/javascript\"> \n");
      out.write("        $(document).ready(function() {\n");
      out.write("            $(\".dropdown-toggle\").dropdown();\n");
      out.write("        });\n");
      out.write("    </script>            \n");
      out.write("    \n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
