<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/10/2024
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sales Report</title>
</head>
<body>
<h1>Sales Report</h1>
<form action="home" method="get">
    <input type="hidden" name="action" value="salesInDateRange">
    <label for="startDate">Start Date:</label>
    <input type="date" id="startDate" name="startDate" required><br>
    <label for="endDate">End Date:</label>
    <input type="date" id="endDate" name="endDate" required><br>
    <input type="submit" value="Get Total Sales">
</form>

<%
    Integer totalSales = (Integer) request.getAttribute("totalSales");
    if (totalSales != null) {
%>
<h2>Total Sales from <%= request.getParameter("startDate") %> to <%= request.getParameter("endDate") %>: <%= totalSales %></h2>
<%
    }
%>
<a href="home?action=list">Back to Products List</a>
</body>
</html>

