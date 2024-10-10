<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/10/2024
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product Details</h1>
<%
    Product product = (Product) request.getAttribute("product");
    if (product != null) {
%>
<p><strong>ID:</strong> <%= product.getId() %></p>
<p><strong>Name:</strong> <%= product.getName() %></p>
<p><strong>Price:</strong> <%= product.getPrice() %></p>
<p><strong>Discount:</strong> <%= product.getDiscount() %></p>
<p><strong>Inventory:</strong> <%= product.getInventory() %></p>
<%
} else {
%>
<p>Product not found.</p>
<%
    }
%>
<a href="student">Back to Home</a>
</body>
</html>

