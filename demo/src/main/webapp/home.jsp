<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Management Home</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    h1, h2 {
      color: #333;
    }
    .button {
      padding: 10px 20px;
      margin: 5px;
      border: none;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
      text-decoration: none;
      border-radius: 5px;
    }
    .button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<h1>Welcome to the Product Management System</h1>
<h2>Date: <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></h2>

<a class="button" href="home?action=add">Add New Product</a>
<a class="button" href="home?action=list">View Products</a>
<a class="button" href="home?action=bestSelling">Best Selling Products</a>
<a class="button" href="home?action=salesInDateRange">Sales Report</a>

<h2>Products</h2>
<div id="productList">
  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null && !products.isEmpty()) {
      for (Product product : products) {
  %>
  <div><%= product.getName() + " - " + product.getPrice() %></div>
  <%
    }
  } else {
  %>
  <div>No products available.</div>
  <%
    }
  %>
</div>
</body>
</html>
