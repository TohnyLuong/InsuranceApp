<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/register.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Top-Navigation.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<script src="${pageContext.request.contextPath }/js/register.js"></script>
</head>
	
	<h2 style="text-align:center" id="headerTitleHome">Health Insurance Registration</h2>
	<p>
		
		Welcome ${pageContext.request.userPrincipal.name } <a href= "${pageContext.request.contextPath }/login?logout"> Logout </a>
		<br/>
		 
		<div class="topnav">
		  	<a class="active" href= "${pageContext.request.contextPath }/home"> Home </a>
		</div>
	</p>
	
	<body>
	
	<form id="regForm" action="${pageContext.request.contextPath }/${planType}/registered">
	  <h1>Register:</h1>
	  <!-- One "tab" for each step in the form: -->
	  <div class="tab">
	  	<!--  Contact Information
	  	<br/><br/>  -->
	  	Name:
	    <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
	    <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
	  </div>
	  <div class="tab">Contact Info:
	    <p><input placeholder="E-mail..." oninput="this.className = ''" name="email"></p>
	    <p><input placeholder="Phone..." oninput="this.className = ''" name="phone"></p>
	    Address:
	    <p><input placeholder="Country..." oninput="this.className = ''" name="country"></p>
    	<p><input placeholder="Address..." oninput="this.className = ''" name="addressLine"></p>
    	<p><input placeholder="City..." oninput="this.className = ''" name="city"></p>
    	<p><input placeholder="State..." oninput="this.className = ''" name="state"></p>
    	<p><input placeholder="Zipcode..." oninput="this.className = ''" name="zipcode"></p>
	  </div>
	  <div class="tab">Age:
	    <p><input placeholder="dd" oninput="this.className = ''" name="dd"></p>
	    <p><input placeholder="mm" oninput="this.className = ''" name="nn"></p>
	    <p><input placeholder="yyyy" oninput="this.className = ''" name="yyyy"></p>
	  </div>
	  <div class="tab" id=familyEnrollment>Insured Enrollment:
	  	<br/><br/>
	  	Family Member 1:
	    <p><input placeholder="Family Member (1): First Name..." oninput="this.className = ''" name="fm1FN"></p>
	    <p><input placeholder="Family Member (1): Last Name..." oninput="this.className = ''" name="fm1LN"></p>
	    Age:
	    <p><input placeholder="Family Member (1): Age..." oninput="this.className = ''" name="fm1Age"></p>
	    Medical Conditions:
		<div class="row">
			<div class="column" >
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCAcne" unchecked>Acne</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCAddisonsdisease" unchecked>Addison's disease</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCAlcoholrelatedliverdisease" unchecked>Alcohol-related liver disease</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCAllergies" unchecked>Allergies</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCBonecancer" unchecked>Bone cancer</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCChestpain" unchecked>Chest pain</p>
	  		</div>
			<div class="column" >
			    <p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCColdSore" unchecked>Cold Sore</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCCough" unchecked>Cough</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCDementia" unchecked>Dementia</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCDiabetes" unchecked>Diabetes</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCFlu" unchecked>Flu</p>
				<p><input style=width:5% type="checkbox" oninput="this.className=''" name="fm1MCHepatitis" unchecked>Hepatitis</p>
			</div>
		</div>
		
	    <button type="button" id="newFamilyMember"  > + Add Family Member</button>   
	  </div>
	  <div class="tab" id=quote>Approximate Quote:
	    <br/><br/>
	    Please login after registration to see costs.
	  </div>
	  <div class="tab">Login Info:
	    <p><input placeholder="Username..." oninput="this.className = ''" name="uname"></p>
	    <p><input placeholder="Password..." oninput="this.className = ''" name="pword" type="password"></p>
	  </div>
	  <div style="overflow:auto;">
	    <div style="float:right;">
	      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
	      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
	    </div>
	  </div>
	  <!-- Circles which indicates the steps of the form: -->
	  <div style="text-align:center;margin-top:40px;">
	    <span class="step"></span>
	    <span class="step"></span>
	    <span class="step"></span>
	    <span class="step"></span>
	    <span class="step"></span>
	    <span class="step"></span>
	  </div>
	</form>
	
	<script>
	var currentTab = 0; // Current tab is set to be the first tab (0)
	showTab(currentTab); // Display the current tab
	
	
	function showTab(n) {
	  // This function will display the specified tab of the form...
	  var x = document.getElementsByClassName("tab");
	  x[n].style.display = "block";
	  //... and fix the Previous/Next buttons:
	  if (n == 0) {
	    document.getElementById("prevBtn").style.display = "none";
	  } else {
	    document.getElementById("prevBtn").style.display = "inline";
	  }
	  if (n == (x.length - 1)) {
	    document.getElementById("nextBtn").innerHTML = "Submit";
	  } else {
	    document.getElementById("nextBtn").innerHTML = "Next";
	  }
	  //... and run a function that will display the correct step indicator:
	  fixStepIndicator(n)
	}
	
	function nextPrev(n) {
	  // This function will figure out which tab to display
	  var x = document.getElementsByClassName("tab");
	  // Exit the function if any field in the current tab is invalid:
	  if (n == 1 && !validateForm()) return false;
	  // Hide the current tab:
	  x[currentTab].style.display = "none";
	  // Increase or decrease the current tab by 1:
	  currentTab = currentTab + n;
	  // if you have reached the end of the form...
	  if (currentTab >= x.length) {
	    // ... the form gets submitted:
	    document.getElementById("regForm").submit();
	  	console.log(document.getElementById("regForm"));
	    return false;
	  }
	  // Otherwise, display the correct tab:
	  showTab(currentTab);
	}
	
	function validateForm() {
	  // This function deals with validation of the form fields
	  var x, y, i, valid = true;
	  x = document.getElementsByClassName("tab");
	  y = x[currentTab].getElementsByTagName("input");
	  // A loop that checks every input field in the current tab:
	  for (i = 0; i < y.length; i++) {
	    // If a field is empty...
	    if (y[i].value == "") {
	      // add an "invalid" class to the field:
	      y[i].className += " invalid";
	      // and set the current valid status to false
	      valid = false;
	    }
	  }
	  // If the valid status is true, mark the step as finished and valid:
	  if (valid) {
	    document.getElementsByClassName("step")[currentTab].className += " finish";
	  }
	  return valid; // return the valid status
	}
	
	function fixStepIndicator(n) {
	  // This function removes the "active" class of all steps...
	  var i, x = document.getElementsByClassName("step");
	  for (i = 0; i < x.length; i++) {
	    x[i].className = x[i].className.replace(" active", "");
	  }
	  //... and adds the "active" class on the current step:
	  x[n].className += " active";
	}
	</script>
	
	</body>
</html>
