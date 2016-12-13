<%-- 
    Document   : Monthly_bills
    Created on : Nov 19, 2016, 11:19:15 AM
    Author     : Akshay
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Silver Plaza</title>
        <style>
            /*            @page {
                            size: 21cm 29.7cm;
                         margin: 30mm 45mm 30mm 45mm;  change the margins as you want them to be. 
                        }*/

            body {

                text-align: center;
                /*        border: 1px grey solid;*/
                font-family: 'Calibri';
                margin:0;
            }

            .bill_heading
            {
                border: 1px black solid;
                margin: 30px;
                background-color: #DCDCDC;
                margin-bottom: 10px;
            }

            html
            {
                font-size: 18px;
            }
            h5
            {
                margin: 5px;
                display: inline-block;
                font-size: 16px;
            }

            table,td,th
            {
                /*border: 1px solid rgba(169, 169, 169, 1);*/
                border:1px black solid;
                text-align: left;
                border-collapse: collapse;
                
            }

            th
            {
                text-align: center;
                background-color: #DCDCDC;
            }
            
            .prev_reciept
            {
                border-top: 2px black dashed;
                /*padding-bottom: 107px;*/
            }
            
            .date_number
            {
                font-size: 16px;
            }

             h2
             {
                 font-size: 20px;
                 font-weight: normal;
             }
            
            td:nth-child(2)
            {
                text-align: right;
            }
            /*Experimental*/
            .page {
                width: 21cm;
                min-height: 29cm;
                padding: 0.6cm;
                margin: 1cm auto;
                border-radius: 5px;
                background: white;
            }
            .subpage {
                height: 256mm;
            }

            @page {
                size: A4;
                margin: 0;
            }
            
            h1
            {
                margin-bottom: 0px;
            }
            
            h3
            {
                margin-top: 2px;
            }
            @media print {
                .page {
                    margin: 0;
                    page-break-after: always;
                }
            }
        </style>
    </head>
    <%
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

    %>
    <body>
        <div class="page">
            <div class="subpage">    
                <div class="bill_heading">
                    <h1>SILVER PLAZA CO-OP HSG. SOC. LTD.</h1>
                    <h3>Ramchandra Nagar No.2, E.S.I.S. Road,Thane(West)-400604<br> Regn. No. TNA/(TNA)/HSG/(TC)/17475 &nbsp;&nbsp;&nbsp;&nbsp; Dt.6/7/2006</h3>
                </div>
                <div class="date_number">
                    <h5 style="margin-left:1%;">
                    
                    <%
                        //logic for 4 digit bills
                        if(max_bill <10 && max_bill > 0)
                    {
                    %>
                        Bill No.-<%= "000"+max_bill %>
                    <%}
                        else if(max_bill >= 10 && max_bill <100)
                        {
                         %>
                        Bill No.-<%= "00"+max_bill %>
                    <%   
                        }
                        else if(max_bill>= 100 && max_bill < 1000)
                        {
                        %>
                                                Bill No.-<%= "0"+max_bill %>
                                            <%
                        }
                        else if(max_bill>1000)
                        {
                        %>
                        Bill No.-<%= max_bill %>
                    <%
                        }
                    %>
                    </h5>
                    <h5 style="margin-left:50%;">Bill Date: 01-<%= sys_dt_dash %></h5>
                    <h2 style="font-weight: normal; margin:2px;">Maintenance bill for <%= sys_dt%></h2>
                </div>
                <div>
                    <h4 style="margin-left: 5%; text-align: left; font-weight: normal; font-size: 20px; margin-top: 5px;">
                        <%= rs1.getString(1)%><br>
                        Flat No. <%= rs1.getString(3)%>
                    </h4>
                    <center>
                        <table style=" width: 80%;">
                            <tr> 
                                <th>PARTICULARS</th>
                                <th>AMOUNT</th>
                            </tr>
                            <tr>
                                <td>Sinking Fund</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Repair Fund</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Painting Charges/Fund</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Maintenance Charges</td>
                                <td><%= rs1.getString(11)%></td>
                            </tr>
                            <tr>
                                <td>Welfare Fund</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Non-Occupancy Charges</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Parking Charges - 4 Wheeler</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Parking Charges - 2 Wheeler</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Other Charges</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>Education Fund</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td> &nbsp; </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> &nbsp; </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> &nbsp; </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td> Penalty / Interest </td>
                                <td>NA* </td>
                            </tr>
                            <tr>
                                <td> &nbsp; </td>
                                <td></td>
                            </tr>
                            <%
                                int arr_crd= Integer.parseInt(rs1.getString(2)) - Integer.parseInt(rs1.getString(4)) - Integer.parseInt(rs1.getString(11));
                                if (Integer.parseInt(rs1.getString(2)) < 0) {
                                    
                            %>
                            <tr>
                                <td> Credit Balance </td>
                                <td><%= arr_crd * (-1)%></td>
                            </tr>
                            <tr>
                                <td> Arrears </td>
                                <td>0</td>
                            </tr>   
                            <%
                                c1=rs1.getString(2);
                            } else {
                            %>
                            <tr>
                                <td> Credit Balance </td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td> Arrears </td>
                                <td><%= arr_crd %></td>
                            </tr>                
                            <%
                                c1=rs1.getString(2);
                                }
                            %>

                            <tr>
                                <td> &nbsp; </td>
                                <td></td>
                            </tr>
                            <tr style="font-weight: bold; font-size: 20px;">
                                
                                <% if(Integer.parseInt(rs1.getString(2))<0)
                                {
                                %>
                                <td> Total Credit Balance (Rs.) </td>
                                <td>&#8377; <%= (Integer.parseInt(rs1.getString(2))+ Integer.parseInt(rs1.getString(4)))*(-1) %></td>
                                <% }
                                else
                                    {
                                %>
                                <td> Total Amount Due (Rs.) </td>
                                <td>&#8377; <%= Integer.parseInt(rs1.getString(2))+ Integer.parseInt(rs1.getString(4)) %> </td>
                            </tr>
                                <%
                                }    
                                %>
                                <tr style="font-weight: bold; font-size: 20px; background-color:#DCDCDC; ">
                                    <td>PAY BY DATE - 25 <%= sys_dt %></td>
                                    <td>&nbsp;</td>
                                </tr>    
                        </table>
                    </center>
                    <ul style="text-align:left; ">
                        <li>Cheque should be drawn in favor of 'Silver Plaza CHS' only</li>
                        <li>Please pay your bills before the due date to avoid interest charges @18% p.a.on the outstanding bill.</li>
                        <li>Please write Flat No. & Flat Owners name behind the cheque.</li>
                    </ul>


                    <div class="prev_reciept">
                        <h2>RECEIPT for <%= lastMonth.format(monthYearFormatter) %> </h2>

                        <% if (!(array1[0] + "/" + (Integer.parseInt(array1[1]) - 1)).equals(array2[2] + "/" + array2[1])) {
                            no_rcpt_cnt = -1; //flag that disables increase in reciept number
                        %>
<!--  Space wasted cz no recipet generated                      <div class="date_number">
                            <h5 style="margin-left:5%;">&nbsp;</h5>
                            <h5 style="margin-left:50%;">&nbsp;</h5>
                        </div> -->
                        <p>No payment received during this period</p> 
                        
                        <span style="float:left;">Note- Electronic receipts will be generated from next month</span>  <br><br>                      
                        <span style="float:left;">* 18% interest penalty will be applicable from January,2017 </span>
                        <%
                        } else {
                        %>
                        <div class="date_number">
                            <h5 style="margin-left:1%;">Receipt No-<%= max_recpt %></h5>
                            <h5 style="margin-left:60%;">Date- 01-<%= sys_dt_dash %></h5>
                        </div>
                        <p >Received with thanks from <%= rs1.getString(1)%> , a sum of Rs. <%= rs1.getString(6)%> vide cheque No.(s) <%= rs1.getString(5)%> dated <%= rs1.getString(12)%> drawn from <%= rs1.getString(7)%>-<%= rs1.getString(13)%>
                            branch towards payment of maintenance and other charges raised against Flat No. <%= rs1.getString(3)%> vide Bill No <%= rs1.getString(9)%> issued for the
                            month of <%= lastMonth.format(monthYearFormatter) %>.</p> 
                        <span style="float:right;">This is subject to realization of cheque amount</span>

                        <%
                            no_rcpt_cnt=1; //flag to enable recipet creation
                            }
                        %> 
                    </div>
                </div>

            </div>  
        </div>        
    </body>
    <%
            int zr = 0;

            if (bg1.equals("N")) {
                arr_maint_detls[arr_cnt++] = rs1.getString(3);
                arr_maint_detls[arr_cnt++] = sys_dt1;
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = zr + "";
                arr_maint_detls[arr_cnt++] = rs1.getString(11);
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
    } else { %>
    <script>
        alert("Maintainence for this month must be calculated first");
        window.location = "Maintenance_view";
    </script>
    <%
        }
        int arr_cnt1 = 0;
        if (bill_cnt >= 38) {
            for (int i = 0; i < 38; i++) {
                stmt.executeQuery("insert into SOC_MAINT_DETAILS values ('" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "','" + arr_maint_detls[arr_cnt1++] + "') ");
            }

            stmt.executeQuery("update SOC_OTHER_INFO set BILLS_GENERATED='Y'");
        }

    %>
</html>
