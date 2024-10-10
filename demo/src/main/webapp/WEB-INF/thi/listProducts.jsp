<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/10/2024
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Products</title>
</head>
<body>
<h1>List of Products</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Inventory</th>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td><%= product.getDiscount() %></td>
        <td><%= product.getInventory() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No products found.</td>
    </tr>
    <%
        }
    %>
</table>
<br>
<a href="student">Back to Home</a>
</body>
</html>
