package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public final class Monthly_005fbills_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <style>\n");
      out.write("            /*            @page {\n");
      out.write("                            size: 21cm 29.7cm;\n");
      out.write("                         margin: 30mm 45mm 30mm 45mm;  change the margins as you want them to be. \n");
      out.write("                        }*/\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("\n");
      out.write("                text-align: center;\n");
      out.write("                /*        border: 1px grey solid;*/\n");
      out.write("                font-family: 'Calibri';\n");
      out.write("                margin:0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .bill_heading\n");
      out.write("            {\n");
      out.write("                border: 1px black solid;\n");
      out.write("                margin: 30px;\n");
      out.write("                background-color: #DCDCDC;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            html\n");
      out.write("            {\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            h5\n");
      out.write("            {\n");
      out.write("                margin: 5px;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table,td,th\n");
      out.write("            {\n");
      out.write("                /*border: 1px solid rgba(169, 169, 169, 1);*/\n");
      out.write("                border:1px black solid;\n");
      out.write("                text-align: left;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th\n");
      out.write("            {\n");
      out.write("                text-align: center;\n");
      out.write("                background-color: #DCDCDC;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .prev_reciept\n");
      out.write("            {\n");
      out.write("                border-top: 2px black dashed;\n");
      out.write("                /*padding-bottom: 107px;*/\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .date_number\n");
      out.write("            {\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("             h2\n");
      out.write("             {\n");
      out.write("                 font-size: 20px;\n");
      out.write("                 font-weight: normal;\n");
      out.write("             }\n");
      out.write("            \n");
      out.write("            td:nth-child(2)\n");
      out.write("            {\n");
      out.write("                text-align: right;\n");
      out.write("            }\n");
      out.write("            /*Experimental*/\n");
      out.write("            .page {\n");
      out.write("                width: 21cm;\n");
      out.write("                min-height: 29cm;\n");
      out.write("                padding: 0.6cm;\n");
      out.write("                margin: 1cm auto;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                background: white;\n");
      out.write("            }\n");
      out.write("            .subpage {\n");
      out.write("                height: 256mm;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @page {\n");
      out.write("                size: A4;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h1\n");
      out.write("            {\n");
      out.write("                margin-bottom: 0px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            h3\n");
      out.write("            {\n");
      out.write("                margin-top: 2px;\n");
      out.write("            }\n");
      out.write("            @media print {\n");
      out.write("                .page {\n");
      out.write("                    margin: 0;\n");
      out.write("                    page-break-after: always;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    ");

        //current date code
        DateFormat dateFormat = new SimpleDateFormat("MMM,yyyy");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM");
        DateFormat dateFormat2 = new SimpleDateFormat("MMM-yyyy");
        Date date = new Date();
        String sys_dt = dateFormat.format(date);
        String sys_dt1 = dateFormat1.format(date);
        String sys_dt_dash = dateFormat2.format(date);
        String array1[] = sys_dt1.split("/");
//        out.print(array1[0] + "/" + (Integer.parseInt(array1[1]) - 1));

//for last month name
            YearMonth thisMonth    = YearMonth.now();
            YearMonth lastMonth    = thisMonth.minusMonths(1);
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");


        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "akshay", "akshay");
        Statement stmt = con.createStatement();

        //variable declarations 
        String bg1 = "";
        String lm1 = "";
        int bill_cnt = 0, arr_cnt = 0;
        String arr_maint_detls[] = new String[720];
        int no_rcpt_cnt=0;

        int ttl_maint = 0;
        String c1=""; //for storing credit
        String c2=""; //for storing arraers
        int max_bill = 1;
        int max_recpt = 1;
        
        ResultSet rs3 = stmt.executeQuery("select count(*),max(BILL_NO),max(RECIEPT_NO) from SOC_MAINT_DETAILS");
        while (rs3.next()) {
            int a1 = Integer.parseInt(rs3.getString(1));
            if (a1 == 0) {
                max_bill = 1;
                max_recpt = 1;
            } else {
                max_bill = Integer.parseInt(rs3.getString(2));
                max_bill++;
                
                
                max_recpt = Integer.parseInt(rs3.getString(2));
                max_recpt++;
            }
        }

        ResultSet rs2 = stmt.executeQuery("select BILLS_GENERATED,LAST_MAINTAINANCE_CAL from SOC_OTHER_INFO");
        while (rs2.next()) {
            bg1 = rs2.getString(1);
            lm1 = rs2.getString(2);
        }

        if (lm1.equals(sys_dt1)) {
            ResultSet rs1 = stmt.executeQuery(" select a.NAME,a.MAINTENANCE_PENDING,a.FLAT_NO,a.MAINTENANCE_PENALTY,b.CHEQUE_NO,b.AMOUNT,b.BANK_NAME,b.PAY_DATE,c.BILL_NO,b.PAY_DATE, a.MAINTENANCE,b.CHEQUE_DATE, b.BRANCH_NAME from SOC_MEMBERS a LEFT OUTER JOIN  SOC_PAYMENT_INFO b  ON a.FLAT_NO = b.FLAT_NO LEFT OUTER JOIN SOC_MAINT_DETAILS c ON b.FLAT_NO = c.FLAT_NO order by a.rowid");
            while (rs1.next()) {
                ttl_maint = 0;
                c1="";c2="";
                ttl_maint = Integer.parseInt(rs1.getString(2)) + Integer.parseInt(rs1.getString(4));

                int amt_pend = Integer.parseInt(rs1.getString(2));

                //adding pay date to array for comparison
                String sys_dt3 = "00/00/0000";
                if (rs1.getString(10) != null) {
                    sys_dt3 = rs1.getString(10);
                }
                String array2[] = sys_dt3.split("/");
//         out.print(array2[2]+"/"+(Integer.parseInt(array2[1])));

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page\">\n");
      out.write("            <div class=\"subpage\">    \n");
      out.write("                <div class=\"bill_heading\">\n");
      out.write("                    <h1>SILVER PLAZA CO-OP HSG. SOC. LTD.</h1>\n");
      out.write("                    <h3>Ramchandra Nagar No.2, E.S.I.S. Road,Thane(West)-400604<br> Regn. No. TNA/(TNA)/HSG/(TC)/17475 &nbsp;&nbsp;&nbsp;&nbsp; Dt.6/7/2006</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"date_number\">\n");
      out.write("                    <h5 style=\"margin-left:1%;\">\n");
      out.write("                    \n");
      out.write("                    ");

                        //logic for 4 digit bills
                        if(max_bill <10 && max_bill > 0)
                    {
                    
      out.write("\n");
      out.write("                        Bill No.-");
      out.print( "000"+max_bill );
      out.write("\n");
      out.write("                    ");
}
                        else if(max_bill >= 10 && max_bill <100)
                        {
                         
      out.write("\n");
      out.write("                        Bill No.-");
      out.print( "00"+max_bill );
      out.write("\n");
      out.write("                    ");
   
                        }
                        else if(max_bill>= 100 && max_bill < 1000)
                        {
                        
      out.write("\n");
      out.write("                                                Bill No.-");
      out.print( "0"+max_bill );
      out.write("\n");
      out.write("                                            ");

                        }
                        else if(max_bill>1000)
                        {
                        
      out.write("\n");
      out.write("                        Bill No.-");
      out.print( max_bill );
      out.write("\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    </h5>\n");
      out.write("                    <h5 style=\"margin-left:50%;\">Bill Date: 01-");
      out.print( sys_dt_dash );
      out.write("</h5>\n");
      out.write("                    <h2 style=\"font-weight: normal; margin:2px;\">Maintenance bill for ");
      out.print( sys_dt);
      out.write("</h2>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <h4 style=\"margin-left: 5%; text-align: left; font-weight: normal; font-size: 20px; margin-top: 5px;\">\n");
      out.write("                        ");
      out.print( rs1.getString(1));
      out.write("<br>\n");
      out.write("                        Flat No. ");
      out.print( rs1.getString(3));
      out.write("\n");
      out.write("                    </h4>\n");
      out.write("                    <center>\n");
      out.write("                        <table style=\" width: 80%;\">\n");
      out.write("                            <tr> \n");
      out.write("                                <th>PARTICULARS</th>\n");
      out.write("                                <th>AMOUNT</th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Sinking Fund</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Repair Fund</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Painting Charges/Fund</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Maintenance Charges</td>\n");
      out.write("                                <td>");
      out.print( rs1.getString(11));
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Welfare Fund</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Non-Occupancy Charges</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Parking Charges - 4 Wheeler</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Parking Charges - 2 Wheeler</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Other Charges</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Education Fund</td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> &nbsp; </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> &nbsp; </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> &nbsp; </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Penalty / Interest </td>\n");
      out.write("                                <td>NA* </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> &nbsp; </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                int arr_crd= Integer.parseInt(rs1.getString(2)) - Integer.parseInt(rs1.getString(4)) - Integer.parseInt(rs1.getString(11));
                                if (Integer.parseInt(rs1.getString(2)) < 0) {
                                    
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Credit Balance </td>\n");
      out.write("                                <td>");
      out.print( arr_crd * (-1));
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Arrears </td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>   \n");
      out.write("                            ");

                                c1=rs1.getString(2);
                            } else {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Credit Balance </td>\n");
      out.write("                                <td>0</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Arrears </td>\n");
      out.write("                                <td>");
      out.print( arr_crd );
      out.write("</td>\n");
      out.write("                            </tr>                \n");
      out.write("                            ");

                                c1=rs1.getString(2);
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td> &nbsp; </td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr style=\"font-weight: bold; font-size: 20px;\">\n");
      out.write("                                \n");
      out.write("                                ");
 if(Integer.parseInt(rs1.getString(2))<0)
                                {
                                
      out.write("\n");
      out.write("                                <td> Credit Balance (Rs.) </td>\n");
      out.write("                                <td>&#8377; ");
      out.print( Integer.parseInt(rs1.getString(2))+ Integer.parseInt(rs1.getString(4)) );
      out.write("</td>\n");
      out.write("                                ");
 }
                                else
                                    {
                                
      out.write("\n");
      out.write("                                <td> Total Amount Due (Rs.) </td>\n");
      out.write("                                <td>&#8377; ");
      out.print( Integer.parseInt(rs1.getString(2))+ Integer.parseInt(rs1.getString(4)) );
      out.write(" </td>\n");
      out.write("                            </tr>\n");
      out.write("                                ");

                                }    
                                
      out.write("\n");
      out.write("                                <tr style=\"font-weight: bold; font-size: 20px;\">\n");
      out.write("                                    <td>PAY BY DATE - 25 ");
      out.print( sys_dt );
      out.write("</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                </tr>    \n");
      out.write("                        </table>\n");
      out.write("                    </center>\n");
      out.write("                    <ul style=\"text-align:left; \">\n");
      out.write("                        <li>Cheque should be drawn in favor of 'Silver Plaza CHS' only</li>\n");
      out.write("                        <li>Please pay your bills before the due date to avoid interest charges @18% p.a.on the outstanding bill.</li>\n");
      out.write("                        <li>Please write Flat No. & Flat Owners name behind the cheque.</li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"prev_reciept\">\n");
      out.write("                        <h2>RECEIPT for ");
      out.print( lastMonth.format(monthYearFormatter) );
      out.write(" </h2>\n");
      out.write("\n");
      out.write("                        ");
 if (!(array1[0] + "/" + (Integer.parseInt(array1[1]) - 1)).equals(array2[2] + "/" + array2[1])) {
                            no_rcpt_cnt = -1; //flag that disables increase in reciept number
                        
      out.write("\n");
      out.write("<!--  Space wasted cz no recipet generated                      <div class=\"date_number\">\n");
      out.write("                            <h5 style=\"margin-left:5%;\">&nbsp;</h5>\n");
      out.write("                            <h5 style=\"margin-left:50%;\">&nbsp;</h5>\n");
      out.write("                        </div> -->\n");
      out.write("                        <p>No payment received during this period</p> \n");
      out.write("                        \n");
      out.write("                        <span style=\"float:left;\">Note- Electronic receipts will be generated from next month</span>  <br><br>                      \n");
      out.write("                        <span style=\"float:left;\">* 18% interest penalty will be applicable from January,2017 </span>\n");
      out.write("                        ");

                        } else {
                        
      out.write("\n");
      out.write("                        <div class=\"date_number\">\n");
      out.write("                            <h5 style=\"margin-left:1%;\">Receipt No-");
      out.print( max_recpt );
      out.write("</h5>\n");
      out.write("                            <h5 style=\"margin-left:60%;\">Date- 01-");
      out.print( sys_dt_dash );
      out.write("</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <p >Received with thanks from ");
      out.print( rs1.getString(1));
      out.write(" , a sum of Rs. ");
      out.print( rs1.getString(6));
      out.write(" vide cheque No.(s) ");
      out.print( rs1.getString(5));
      out.write(" dated ");
      out.print( rs1.getString(12));
      out.write(" drawn from ");
      out.print( rs1.getString(7));
      out.write('-');
      out.print( rs1.getString(13));
      out.write("\n");
      out.write("                            branch towards payment of maintenance and other charges raised against Flat No. ");
      out.print( rs1.getString(3));
      out.write(" vide Bill No ");
      out.print( rs1.getString(9));
      out.write(" issued for the\n");
      out.write("                            month of ");
      out.print( lastMonth.format(monthYearFormatter) );
      out.write(".</p> \n");
      out.write("                        <span style=\"float:right;\">This is subject to realization of cheque amount</span>\n");
      out.write("\n");
      out.write("                        ");

                            no_rcpt_cnt=1; //flag to enable recipet creation
                            }
                        
      out.write(" \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>  \n");
      out.write("        </div>        \n");
      out.write("    </body>\n");
      out.write("    ");

            int zr = 0;

            if (bg1.equals("N")) {
                arr_maint_detls[arr_cnt++] = rs1.getString(3);
                arr_maint_detls[arr_cnt++] = sys_dt1;
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = rs1.getString(2);
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                
                arr_maint_detls[arr_cnt++] = rs1.getString(4); //penalty amount
                arr_maint_detls[arr_cnt++] = arr_crd+""; //arrears and credit
                arr_maint_detls[arr_cnt++] = rs1.getString(2); //total amt due
                arr_maint_detls[arr_cnt++] = (max_bill) + "";
                if(no_rcpt_cnt==1)
                {    
                    arr_maint_detls[arr_cnt++] = (max_recpt)+"";
                    max_recpt++;
                }
                else
                {
                    arr_maint_detls[arr_cnt++] = 0+"";
                }    
                max_bill++;
                bill_cnt++;
                
            }
        }
    } else { 
      out.write("\n");
      out.write("    <script>\n");
      out.write("        alert(\"Maintainence for this month must be calculated first\");\n");
      out.write("        window.location = \"Maintenance_view\";\n");
      out.write("    </script>\n");
      out.write("    ");

        }
        int arr_cnt1 = 0;
        if (bill_cnt >= 38) {
            for (int i = 0; i < 38; i++) {
                stmt.executeQuery("insert into SOC_MAINT_DETAILS values ('" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "') ");
            }

            stmt.executeQuery("update SOC_OTHER_INFO set BILLS_GENERATED='Y'");
        }

    
      out.write("\n");
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
