<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

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

</head>
<body>
<ul>
  <li><a href="index.html">Home</a></li>
  <li><a href="contact.html">Contact</a></li>
  <li><a href="about.html">About</a></li>
</ul>

<br>
<br>
<br>

<h3>REGISTER</h3>
<form action="/action_page.php">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" value="first name"><br>
  <label for="surname">Surname:</label><br>
  <input type="text" id="surname" name="surname" value="surname"><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email" value="email"><br>
  <label for="pwd">Password (size: 6-8):</label><br>
  <input type="password" id="pwd" name="pwd" value="password" pattern="[0-9a-fA-F]{6,8}"><br>
  <label for="pwd2">Confirm the Password:</label><br>
  <input type="password" id="pwd2" name="pwd2" value="password" pattern="[0-9a-fA-F]{6,8}"><br><br>
  <input type="button" onclick="return myFunction()" value="Ok">
</form>

<script language="javascript" type="text/javascript">
function myFunction() {
  var name = document.getElementById("name").value;
  var surname = document.getElementById("surname").value;
  var email = document.getElementById("email").value;
  var pwd = document.getElementById("pwd").value;
  var pwd2 = document.getElementById("pwd2").value;
  
  if(name == ""){
    alert("Fill in name field.");
    document.getElementById("name").focus();
    return false;
  }
  if(surname == ""){
    alert("Fill in surname field.");
    document.getElementById("surname").focus();
    return false;
  }
  if(email == ""){
    alert("Fill in email field.");
    document.getElementById("email");
    return false;
  }
  if(pwd == ""){
    alert("Fill in password field.");
    document.getElementById("pwd");
    return false;
  }
  if (pwd.length < 6) {
    alert("The password must be between 6 and 8 characters.");
    document.getElementById("pwd");
  return false;
  }
  if (pwd.length > 8) {
    alert("The password must be between 6 and 8 characters.");
    document.getElementById("pwd");
  return false;
  }
  if(pwd2 == ""){
    alert("Fill in password confirmation field.");
    document.getElementById("pwd2");
    return false;
  }
  if (pwd != pwd2){
    alert("The passwords are different.");
    document.getElementById("pwd2");
    return false;
  }
  alert("You typed:\nName: " + name + "\nSurname: " + surname + "\nEmail: " + email);
  window.location="C:/Users/h_mit/eclipse-workspace/commerce/index2.html";
}
</script>

</body>
</html>