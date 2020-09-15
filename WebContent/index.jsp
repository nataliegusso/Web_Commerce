<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
   	import="javax.naming.*,
                 java.text.*,
                 java.util.*,
                 com.commerce.dao.impl.*,
                 com.commerce.dao.*,
                 com.commerce.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=="UTF-8">
<title>Login</title>

<style>
body {
	background-color: #363636; 
	margin: 30px;
}
h1 {
	color: white;
}
h3 {
	color: white; 
	font-size: 18px;
}
p {
	color: white;
}
label {
	color: white;
}
a:link {
	color: white; 
	background-color: transparent; 
	text-decoration: none;
}
a:visited {
	color: white; 
	background-color: transparent; 
	text-decoration: none;
}
a:hover {
	text-decoration: underline;
}
ul {
	list-style-type: none; 
	margin: 0; 
	padding: 0; 
	hidden; 
	background-color: #363636;
}
li {
	float: left;
}
li a {
	display: block; 
	color: white; 
	text-align: center; 
	padding: 14px 16px; 
	text-decoration: none;
}
li a:hover {
	background-color: #555;  
	color: white; 
}

</style>

<script>
  function myFunction() {
    var email = document.getElementById("email").value;
    var pwd = document.getElementById("pwd").value;
    
    alert("You typed:\nEmail: " + email + "\nPassword: " + pwd);
    <!-- window.location="C:/Users/h_mit/eclipse-workspace/commerce/index2.html"; -->
    window.location="C:/Users/h_mit/eclipse-workspace/web_commerce/WebContent/index2.jsp";
  }
</script>

<h1>NOME DA EMPRESA</h1>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

</head>

<body>
<ul id="menu">
  <li><a href="index2.html">Home</a></li>
  <li><a href="contact.html">Contact</a></li>
  <li><a href="about.html">About</a></li>
</ul>

<br>
<br>
<br>


 
<h3>LOGIN</h3>
  <form action="index" method="post">  <!-- Envio de parâmetros (action) para log -->
  <div>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" value="email"><br>
  </div>
  <div>
    <label for="pwd">Password:</label><br>
    <input type="password" id="pwd" name="pwd" value="password"><br><br>
  </div>
  <div>
    <input type="submit" value="Login"> <!-- onclick="myFunction()" Botão que envia o parâmentro -->
  </div>
  </form>


  <p><a href="C:\Users\h_mit\eclipse-workspace\web_commerce\WebContent\register.jsp">Create an account</a> </p>

  <a href="http://www.facebook.com" class="fab fa-facebook-f" style="position:absolute;bottom:15px;right:80px;font-size:20px;color:white;" data-count="horizontal"></a>
  <a href="http://www.whatsapp.com" class="fab fa-whatsapp" style="position:absolute;bottom:15px;right:45px;font-size:22px;color:white;" data-count="horizontal"></a>
  <a href="https://www.instangram.com" class="fab fa-instagram" style="position:absolute;bottom:15px;right:15px;font-size:22px;color:white;" data-count="horizontal"></a>
</body>
</html>