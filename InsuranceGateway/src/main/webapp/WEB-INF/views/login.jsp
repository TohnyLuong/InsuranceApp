<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hotel Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.page.css">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <!-- <img src="D:\Projects\SpringBoot_12Oct2021\BankApp\src\main\resources\static\images\bank.png" id="icon" alt="User Icon" /> -->
      <img src="${pageContext.request.contextPath }/images/login-page-icon.jpg" id="icon" alt="Home Icon" />
    </div>

    <!-- Login Form -->
    
    <form action="login" method="POST"> 
      
      		<input type="text" id="username" class="fadeIn second" name="username" placeholder="Login"><br>
			<input type="password" id="password" class="fadeIn third" name="password" placeholder="Password"> <br>
			<input type="submit" class="fadeIn fourth" value="Log In">
		
    </form>

    <!-- Remind Password -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>

</body>
</html>