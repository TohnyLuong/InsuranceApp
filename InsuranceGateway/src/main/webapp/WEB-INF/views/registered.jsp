<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registered</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/registered.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<script src="${pageContext.request.contextPath }/js/registered.js"></script>
</head>

<body>

<h2 style="text-align:center">Health Insurance</h2>

<p>
	<!-- 
	Welcome ${pageContext.request.userPrincipal.name } <a href= "${pageContext.request.contextPath }/login?logout"> Logout </a>
	<br>
	 -->
	<a href= "${pageContext.request.contextPath }/home"> Home </a>
	<a href= "${pageContext.request.contextPath }/claims"> Claims </a>
</p>


<main class="main-content">

				<div class="page">
					<div class="container">
						<h3 class="entry-title">Thank you for enrolling with us!</h3>
						<p>Please relog in to see your coverage plans.</p>
						<p>Please wait while we redirect you to login page.</p>
			
					</div>
				</div> <!-- .page -->
			</main>

</body>
</html>
