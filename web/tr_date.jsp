<%-- 
    Document   : tr_date
    Created on : Dec 5, 2016, 8:55:27 PM
    Author     : Akshay
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.util.Calendar"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
YearMonth thisMonth    = YearMonth.now();
YearMonth lastMonth    = thisMonth.minusMonths(1);
DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");


out.print( lastMonth.format(monthYearFormatter));
//System.out.printf("Two Months Ago: %s\n", twoMonthsAgo.format(monthYearFormatter))
        %>
    </body>
</html>
