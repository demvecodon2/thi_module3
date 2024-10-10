<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Management System</title>
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

<a class="button" href="add.jsp">Add New Product</a>
<a class="button" href="student?action=view">View Products</a>
<a class="button" href="student?action=list">List of Products</a>

<h2>Products</h2>
<div id="productList">

</div>
</body>
</html>