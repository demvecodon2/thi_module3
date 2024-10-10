<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 10/10/2024
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add New Product</h1>
<form action="home" method="post">
    <input type="hidden" name="action" value="add">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required><br>

    <label for="discount">Discount:</label>
    <input type="text" id="discount" name="discount"><br>

    <label for="inventory">Inventory:</label>
    <input type="number" id="inventory" name="inventory" required><br>

    <input type="submit" value="Add Product">
</form>
<a href="home">Back to Home</a>
</body>
</html>
