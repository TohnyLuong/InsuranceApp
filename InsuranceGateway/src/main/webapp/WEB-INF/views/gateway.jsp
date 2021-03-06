<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gateway</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Top-Navigation.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/gateway.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath }/js/gateway.js"></script>
</head>

<body>

<h2 style="text-align:center">Health Insurance</h2>

<p>
	<div class="content">
    	<a class="login" href="${pageContext.request.contextPath }/login">Login</a> 
	</div>
	 	Welcome <label id = "username"> ${pageContext.request.userPrincipal.name }</label>  <a href= "${pageContext.request.contextPath }/login?logout"> Logout </a>
	<br/><br/>
	<div class="topnav">
	  	<a class="active" href= "${pageContext.request.contextPath }/home"> Home </a>
	  	<a href= "${pageContext.request.contextPath }/gateway"> Gateway </a>
	  	<a href= "${pageContext.request.contextPath }/gateway/currentenrollment"> Current Enrollment </a>
		<a href= "${pageContext.request.contextPath }/gateway/claims"> Claims </a>
	</div>

</p>

<div>
	<main class="main-content">
	
		<br/>
	
	</main>
	
	<br/>
	<p id="alreadyPaidMsg" style="font-size: 150%;"></p>
	<a id="makePayment" class="button" href="${pageContext.request.contextPath }/gateway/payment"> Make Payment And Submit </a>
</div>

</body>
</html>
