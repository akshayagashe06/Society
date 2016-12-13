package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.*;

public final class Month_005fmaint_005fcalc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
                                
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
                    Date date = new Date();
                    String sys_dt=dateFormat.format(date); //system date 
//                    out.print(sys_dt);
//                    String[] date_maint = sys_dt.split("/");
                    
                   

                Class.forName("oracle.jdbc.driver.OracleDriver");  
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
                Statement stmt=con.createStatement();
                
                ResultSet rs1=stmt.executeQuery("select * from SOC_MEMBERS");
                ResultSet rs2=stmt.executeQuery("select LAST_MAINTAINANCE_CAL from SOC_OTHER_INFO");
                
                String sm5="";
                int cnt=0;
                int maint_cnt=0;
                while(rs2.next())
                {
                   sm5=rs2.getString(1); //last calculation db date 
                   out.print(sm5);
                }    
                
                while(rs1.next())
                {
                    
                    String flt_no=rs1.getString(1); //flat number for a person
                    int sm1=Integer.parseInt(rs1.getString(4)); //maintainence
                    int sm2=Integer.parseInt(rs1.getString(5)); //pending
                    int sm3=Integer.parseInt(rs1.getString(6)); //penalty
                    int sm4=Integer.parseInt(rs1.getString(8)); //penalty_no
                    
                    //for general maintainence per month
                    if(!sm5.equals(sys_dt))
                    {
                        out.print("hey I am in maint part");
                        cnt=1;
                       sm2=sm2+sm1; //the pending value calculated for that month
                       
                       //code for penelty per month
                       if((sm1*3)>=sm2)
                       {
                                Double obj = new Double("sm2*0.015");
                                int i = obj.intValue();
                                 sm3=sm3+i; //new penelty canculated and added to penelty
                                 sm2=sm2+i; //penelty calculated and added to the pending amount
                                 sm4++;
                       }   
                       stmt.executeQuery("update SOC_MEMBERS set MAINTENANCE_PENDING='"+sm2+"',MAINTENANCE_PENALTY='"+sm3+"',PENALTY_NUMBER='"+sm4+"' where FLAT_NO='"+flt_no+"'");
                       maint_cnt++;
                    }    

                }
                
                if(cnt==0)
                {
                                       
      out.write("\n");
      out.write("                    <script>alert(\"Maintainece for this month has already been calculated\");\n");
      out.write("                             windows.location=\"Maintenance_view.jsp\";\n");
      out.write("                    </script>\n");
      out.write("        ");

                }
                
                if(maint_cnt==40)
                {

             stmt.executeQuery("update SOC_OTHER_INFO set LAST_MAINTAINANCE_CAL='"+sys_dt+"' ");
                    
      out.write("\n");
      out.write("                    <script>alert(\"All the maintainece has been successfully calculated\");\n");
      out.write("                    windows.location=\"Maintenance_view.jsp\";\n");
      out.write("                    </script>\n");
      out.write("        ");

                }
        
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
