<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="ISO-8859-1">
	<title>Claims</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/home.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Top-Navigation.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath }/js/claims.js"></script>
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


<main class="main-content">
<br/>
<div>
     <h3>Upload Multiple Files</h3>
     <!-- <form id="uploadFiles" name="uploadFiles" method="post" action="${pageContext.request.contextPath }/insuranceGatewayUploadFileToClaim" encType="multipart/form-data"> -->
     <form id="uploadFiles" name="uploadFiles" method="post" action="${pageContext.request.contextPath }/insuranceGatewayUploadFileToClaim" encType="multipart/form-data">
       <input type="file" name="files" multiple required />
       <button id="subBtn" type="submit">Submit</button>
     </form>
   </div>
   </br></br>
   <div>
     <h3>List of Documents</h3>
     <table>
       <thead>
         <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Download Link</th>
         </tr>
       </thead>
       <tbody>
         <tr th:each="doc:${docs}">
           <td th:text="${doc.Id}" />
           <td th:text="${doc.docName}"/>
           <td><a href="${pageContext.request.contextPath }/insuranceGatewayDownloadFileFromClaim/${pageContext.request.userPrincipal.name}">Download</a></td>
         </tr>
       </tbody>
     </table>
     </br> <p>Awaiting Approval</p>
   </div>
   
</main>

</body>
</html>
