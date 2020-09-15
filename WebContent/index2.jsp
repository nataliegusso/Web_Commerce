<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {background-color: #363636; margin: 30px;}
h1   {color: white;}
h3   {color: white;}
p    {color: white;}
label {color: white;}
a:link {color: white; background-color: transparent; text-decoration: none;}
a:visited {color: white; background-color: transparent; text-decoration: none;}
a:hover {text-decoration: underline;}

ul {list-style-type: none; margin: 0; padding: 0; width: hidden; background-color: #363636;}
li {float: left;}
li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
li a:hover {background-color: #555;  color: white;}
</style>

<h1>NOME DA EMPRESA</h1>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>

<body>
<ul id="menu">
  <li><a href="index2.html">Home</a></li>
  <li><a href="contact2.html">Contact</a></li>
  <li><a href="about2.html">About</a></li>
</ul>

<br>
<br>
<br>

  <%= "Hello " %>
  <%
    String name = (String)request.getAttribute("name"); 
  %>
  <%= name%>
  <%= "!" %>

<p> Coisas do site...</p>

<a href="http://www.facebook.com" class="fab fa-facebook-f" style="position:absolute;bottom:15px;right:80px;font-size:20px;color:white;" data-count="horizontal"></a>
<a href="http://www.whatsapp.com" class="fab fa-whatsapp" style="position:absolute;bottom:15px;right:45px;font-size:22px;color:white;" data-count="horizontal"></a>
<a href="https://www.instangram.com" class="fab fa-instagram" style="position:absolute;bottom:15px;right:15px;font-size:22px;color:white;" data-count="horizontal"></a>
</body>
</html>