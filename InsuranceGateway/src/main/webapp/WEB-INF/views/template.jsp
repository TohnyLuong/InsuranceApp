<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Top-Navigation.css">
</head>

<body>

<h2 style="text-align:center">Health Insurance</h2>

<p>
	<div class="content">
    	<a class="login" href="${pageContext.request.contextPath }/login">Login</a> 
	</div>
	Welcome ${pageContext.request.userPrincipal.name } <a href= "${pageContext.request.contextPath }/login?logout"> Logout </a>
	<br/><br/>
	<div class="topnav">
	  	<a class="active" href= "${pageContext.request.contextPath }/home"> Home </a>
		<a href= "${pageContext.request.contextPath }/claims"> Claims </a>
	</div>

</p>


<main class="main-content">



</main>

</body>
</html>
