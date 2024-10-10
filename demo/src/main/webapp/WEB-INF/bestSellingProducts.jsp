<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/10/2024
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<html>
<head>
    <title>Best Selling Products</title>
</head>
<body>
<h1>Best Selling Products</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Inventory</th>
        <th>Sales</th>
    </tr>
    <%
        List<Product> bestSellingProducts = (List<Product>) request.getAttribute("bestSellingProducts");
        for (Product product : bestSellingProducts) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td><%= product.getDiscount() %></td>
        <td><%= product.getInventory() %></td>
        <td><%= product.getSales() %></td> <!-- Giả định bạn có phương thức getSales() -->
    </tr>
    <%
        }
    %>
</table>
<a href="home?action=list">Back to Product List</a>
</body>
</html>

