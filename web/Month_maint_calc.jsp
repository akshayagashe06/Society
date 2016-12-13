<%-- 
    Document   : Month_maint_calc
    Created on : Nov 14, 2016, 10:46:31 AM
    Author     : Akshay
--%>


<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.lang.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Silver Plaza</title>
    </head>
    <body>
        <% 
                                
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
                    Date date = new Date();
                    String sys_dt=dateFormat.format(date); //system date 
                    out.print(sys_dt);
//                  String[] date_maint = sys_dt.split("/");
                    
                   

                Class.forName("oracle.jdbc.driver.OracleDriver");  
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","akshay","akshay");  
                Statement stmt=con.createStatement();
                
                String sm5="";
                int cnt=0;
                int maint_cnt=0,sm1=0,sm2=0,sm3=0,sm4=0;
                String flt_no="";
                String maint_arr[] = new String[160];
                int i1=0;
                int pend_month=0,pntl_sum=0; //for how many months maintenance is pending
                
                ResultSet rs2=stmt.executeQuery("select LAST_MAINTAINANCE_CAL from SOC_OTHER_INFO");
                while(rs2.next())
                {
                   sm5=rs2.getString(1); //last calculation db date 
                   
                }    
                ResultSet rs1=stmt.executeQuery("select * from SOC_MEMBERS");
                while(rs1.next())
                {
                    pntl_sum=0; pend_month=0;
                    flt_no=rs1.getString(1); //flat number for a person
                    sm1=Integer.parseInt(rs1.getString(4)); //maintainence
                    sm2=Integer.parseInt(rs1.getString(5)); //pending
                    sm3=Integer.parseInt(rs1.getString(6)); //penalty
                    sm4=Integer.parseInt(rs1.getString(8)); //penalty_no
                    
                    //for general maintainence per month
                    out.print("This value is of"+ sm5);
                    if(!sm5.equals(sys_dt))
                    {
                        maint_cnt++;
                        out.print("hey I am in maint part");
                        cnt=1;
                       sm2=sm2+sm1; //the pending value calculated for that month
                       
                       //code for penelty per month
                       if((sm1*3)<=sm2)
                       {
                            Float obj = new Float(sm1*0.015);
                            int i = obj.intValue();   //penelty value for maintainence
//                            sm3=sm3+i; //new penelty canculated and added to penelty
//// some chnages in logic                   sm2=sm2+i; //penelty calculated and added to the pending amount
                        
                        //new logic for intrest after 3 months
                        Float obj1 = new Float(sm2/sm1);
                        pend_month = obj1.intValue();   //no of months of pending maintenance
                        
                                for(int j1=pend_month;j1>2;j1--) 
                                {
                                    pntl_sum=pntl_sum + (i*j1);
                                }    

                            sm4++;
                       }   
//                       stmt.executeQuery("update SOC_MEMBERS set MAINTENANCE_PENDING='"+sm2+"',MAINTENANCE_PENALTY='"+sm3+"',PENALTY_NUMBER='"+sm4+"' where FLAT_NO='"+flt_no+"'");
                         maint_arr[i1++]=sm2+""; //pending amount
                         maint_arr[i1++]= 0 +"";           //pntl_sum+""; //penelty amount
                         maint_arr[i1++]=sm4+""; //penelty counter 
                         maint_arr[i1++]=flt_no;
                       out.println("the count of maintaniance is ---- "+maint_cnt);
                    }    
                    out.println("the value of i is :"+i1);
                }
                
                int i3=0;
   
                
                if(cnt==0)
                {
        %>
                    <script>alert("Maintainece for this month has already been calculated");
                             window.location="Maintenance_view.jsp";
                    </script>
        <%
                }
                
                if(maint_cnt==38)
                {

                //code for inserting the calculation in db
                for(int i2=0;i2<38;i2++)
                {
                    stmt.executeQuery("update SOC_MEMBERS set MAINTENANCE_PENDING='"+ maint_arr[i3++]+"',MAINTENANCE_PENALTY='"+ maint_arr[i3++]+"',PENALTY_NUMBER='"+ maint_arr[i3++]+"' where FLAT_NO='"+ maint_arr[i3++]+"'");
                    out.println("hey I am updating"+i2);
                } 
                
                //updating maintainence date
            stmt.executeQuery("update SOC_OTHER_INFO set LAST_MAINTAINANCE_CAL='"+sys_dt+"',BILLS_GENERATED='N' ");
                    %>
                    <script>alert("All the maintainece has been successfully calculated");
                    window.location="Maintenance_view.jsp";
                    </script>
        <%
                }
        %>
    </body>
</html>
