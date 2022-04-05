<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Plans</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/plans.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Top-Navigation.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath }/js/plans.js"></script>
</head>

<body>

<h2 style="text-align:center" id="headerTitleHome">Health Insurance Pricing Table</h2>
<p> 
	Welcome ${pageContext.request.userPrincipal.name } <a href= "${pageContext.request.contextPath }/login?logout"> Logout </a>
	<br>
	<div class="topnav">
	  	<a class="active" href= "${pageContext.request.contextPath }/home"> Home </a>
	</div>
</p>

<form id="regForm" action="/register">
	<div class="columns">
	  <ul class="price">
	    <li class="header">Basic</li>
	    <li class="grey">$ 214.63 / year</li>
	    <li>Deductible Per Person: $2,500.00</li>
	    <li>Primary Care: $20</li>
	    <li>Generic Rx: $10</li>
	    <li>MOOP Individual: $5.850.00</li>
	    <li>Specialist Visit: $60</li>
	    <li>ER: $400 Copay after deductible</li>
	    <li class="grey"><a href="${pageContext.request.contextPath }/basic/register" class="button" >ENROLL</a></li>
	    <!-- <li class="grey"><input type="button" id="basic" class="button">ENROLL</input></li> -->
	  </ul>
	</div>
	
	<div class="columns">
	  <ul class="price">
	    <li class="header" style="background-color:#04AA6D">Pro</li>
	    <li class="grey">$ 247.90 / year</li>
	    <li>Deductible Per Person: $800.00</li>
	    <li>Primary Care: $25/50% Coinsurance after deductible</li>
	    <li>Generic Rx: $5</li>
	    <li>MOOP Individual: $5.850.00</li>
	    <li>Specialist Visit: 50% Coinsurance after deductible</li>
	    <li>ER: $950 Copay with deductible/50% Coinsurance after deductible</li>
	    <li class="grey"><a href="${pageContext.request.contextPath }/pro/register" class="button">ENROLL</a></li>
	  </ul>
	</div>
	
	<div class="columns">
	  <ul class="price">
	    <li class="header">Premium</li>
	    <li class="grey">$ 301.24 / year</li>
	    <li>Deductible Per Person: $1,000.00</li>
	    <li>Primary Care: $10</li>
	    <li>Generic Rx: $5</li>
	    <li>MOOP Individual: $5.850.00</li>
	    <li>Specialist Visit: 50% Coinsurance after deductible</li>
	    <li>ER: $950 Copay with deductible/50% Coinsurance after deductible</li>
	    <li class="grey"><a href="${pageContext.request.contextPath }/premium/register" class="button">ENROLL</a></li>
	  </ul>
	</div>
</form>

</body>
</html>
