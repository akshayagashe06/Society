package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Maintenance_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <!-- Latest compiled and minified CSS -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<!-- Optional theme -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("   \n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"common_soc_style.css\">\n");
      out.write("<style>\n");
      out.write("    table th, table td\n");
      out.write("    {\n");
      out.write("        text-align: center;\n");
      out.write("        padding: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("<!--    Navbar for the screen-->\n");
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
      out.write("</nav>    \n");
      out.write("    \n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <div style=\"float:right; color:yellow;  margin-right: 30px;\">Welcome! Darshan</div>    \n");
      out.write("        <h2>Maintainence Info</h2>\n");
      out.write("        <center>\n");
      out.write("           <table cellspacing=\"10\">\n");
      out.write("        ");

        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("select * from SOC_MEMBERS");
        
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>Flat Number</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Maintenance</th>\n");
      out.write("                    <th>Maintenance Pending</th>\n");
      out.write("                    <th>Maintenance Penalty</th>\n");
      out.write("                    <th>Member Role</th>\n");
      out.write("                    <th>No. of Penalties</th>\n");
      out.write("                </tr>\n");
      out.write("        \n");
      out.write("        ");

         int maint_sum=0; 
         int maint_pend=0;
         int maint_penl=0;
        while(rs1.next())
        {
            maint_sum=maint_sum+ Integer.parseInt( rs1.getString(4));
            maint_pend=maint_pend+ Integer.parseInt( rs1.getString(5));
            maint_penl=maint_penl+ Integer.parseInt( rs1.getString(6));
            
      out.write("\n");
      out.write("            \n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs1.getString(1) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(2) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(4) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(5) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(6) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(7) );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs1.getString(8) );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("        ");

        }
        
      out.write("\n");
      out.write("                            \n");
      out.write("                <tr style=\"font-size: 20px; color:yellow;\">\n");
      out.write("                    <td colspan=\"2\" >TOTAL</td>\n");
      out.write("                    \n");
      out.write("                    <td>&#8377;");
      out.print( maint_sum );
      out.write("</td>\n");
      out.write("                    <td>&#8377;");
      out.print( maint_pend );
      out.write("</td>\n");
      out.write("                    <td>&#8377;");
      out.print( maint_penl );
      out.write("</td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("                    \n");
      out.write("         <a href=\"Monthly_Maintenance_update.jsp\"><button type=\"button\" class=\"btn btn-warning\">Monthly Maintenance</button></a>\n");
      out.write("         <a href=\"Month_maint_calc.jsp\"><button type=\"button\" class=\"btn btn-warning\">Calculate Maintenance</button></a>\n");
      out.write("         <a href=\"Monthly_bills.jsp\"><button type=\"button\" class=\"btn btn-warning\">Generate Maintenance Bills</button></a><br>               \n");
      out.write("        </center>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-12 footer1\">\n");
      out.write("    &copy; Akshay Agashe\n");
      out.write("</div> \n");
      out.write("                    \n");
      out.write("         \n");
      out.write("<script type=\"text/javascript\" src=\"jquery-3.0.0.js\"></script>\n");
      out.write("<script type=\"text/javascript\"> \n");
      out.write("        $(document).ready(function() {\n");
      out.write("            $(\".dropdown-toggle\").dropdown();\n");
      out.write("        });\n");
      out.write("    </script>            \n");
      out.write("    \n");
      out.write("<!-- Latest compiled and minified JavaScript -->\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>                   \n");
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
