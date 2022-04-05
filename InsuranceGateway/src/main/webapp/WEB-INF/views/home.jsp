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
		<!-- <a href= "${pageContext.request.contextPath }/claims"> Claims </a> -->
		<a href= "${pageContext.request.contextPath }/gateway"> Gateway </a>
	</div>

</p>


<main class="main-content">

				<div class="page">
					<div class="container">
						<h3 class="entry-title">Choose your own insurance plan</h3>
						<p>Nam posuere purus vitae est sollicitudin placerat. Praesent posuere porta dignissim. Phasellus viverra, urna a convallis tincidunt, ante mi tempor turpis, nec tempor mauris ligula ut sapien. Etiam euismod mi eu ante mollis commodo. Suspendisse porta nisi vitae dui hendrerit, eget ornare orci semper. Phasellus pharetra, erat sit amet rutrum porttitor, est eros consectetur elit, molestie consequat erat tellus in dui. Vestibulum a vehicula sem. Nullam commodo quis purus in volutpat. Integer semper lacus a lorem efficitur auctor curabitur tincidunt ligula non.</p>

						<div class="filter-links filterable-nav">
							<select class="mobile-filter">
								<option value="*">Show all</option>
								<option value=".skyscraper">skyscraper</option>
								<option value=".shopping-center">shopping-center</option>
								<option value=".apartment">apartment</option>
							</select>
							<strong>Select Category: </strong>
							<a href="#" class="current wow fadeInRight" data-filter="*">Show all</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".2s" data-filter=".skyscraper">skyscraper</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".4s" data-filter=".shopping-center">shopping-center</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".6s" data-filter=".apartment">apartment</a>
						</div>

						<div class="filterable-items">
							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-nurse"></i></div>
									<h3 class="insurance-title">Medical Insurance</h3>
									<p>Health insurance covers medical expenses for illnesses, injuries and conditions.</p>
									<a href="${pageContext.request.contextPath }/plans" class="button">See details</a>
								</div>
							</div>
						</div>
						
					</div>
				</div> <!-- .page -->
			</main>

</body>
</html>
