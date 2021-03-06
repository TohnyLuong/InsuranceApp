$(document).ready(function(){
	
	let userAndFMBody;
	let enrollmentPlan;
	let severityLevel;
	let familyMemberIndex=0;
	let enrollment="Currently Enrolling";
	showUserAndFM();
	showEnrollmentPlan();
	
	setTimeout(() => {displayUserAndFM()}, 200);
	
	
	
	function displayUserAndFM(){
		console.table(userAndFMBody);
		console.table(enrollmentPlan);
		setSeverityLevel();
		setVaribleStatus();
		if(enrollmentPlan.purchaseStatus != "Awaiting Payment"){
			$("#makePayment").hide();
			$("#alreadyPaidMsg").append("Already paid");
		};
		$(".main-content").append(
			"<fieldset style=border: 1px black solid>"+
				"<legend style=border: 1px black solid;margin-left: 1em; padding: 0.2em 0.8em > "+enrollment+" </legend>"+
				"<table style=width:100% class=style1 border =1 cellpadding=4 cellspacing=0 >"+
					"<tr>"+
						"<th> Plan </th>"+
						"<th>"+enrollmentPlan.coverageTier+"</th"+//+planType+"</th>"+
					"</tr>"+
				"</table>"+
			"</fieldset>"
		);
		$(".style1").append(
			"<tr>"+
				"<td>User Name:</td>"+
				"<td>"+userAndFMBody.userName+"</td>"+
			"</tr>"	+
			"<tr>"+
				"<td>User Address:</td>"+
				"<td>"+
					"Address: "+ userAndFMBody.address.addressLine+"<br/>"+
					"City: "+ userAndFMBody.address.state+"<br/>"+
					"State: "+ userAndFMBody.address.state+"<br/>"+
					"Zipcode: "+ userAndFMBody.address.zipCode+"<br/>"+
					"Country: "+ userAndFMBody.address.country+"<br/>"+
				"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>User Contact Info:</td>"+
				"<td>"+
					"Phone Number: "+userAndFMBody.phone+"<br/>"+
					"Email: "+userAndFMBody.userEmail+"<br/>"+
				"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Family Members:</td>"+
				"<td id=familyMemberCol>"	
		);
		
		for(var i=0; i<userAndFMBody.familyMembers.length; i++) {
			$("#familyMemberCol").append(
				"Family Member "+(i+1)+": "+userAndFMBody.familyMembers[i].firstName+" "+userAndFMBody.familyMembers[i].lastName+"<br/>"+
				"Age: "+userAndFMBody.familyMembers[i].age

			);
			
			for(var j=0; j<userAndFMBody.familyMembers[i].medicalConditions.length; j++){
				var medCons=userAndFMBody.familyMembers[i].medicalConditions[j];
				$("#familyMemberCol").append(
					"<p style=\"text-indent: 40px\">"+(j+1)+". Medical Condition: "+ medCons.conditionName+"</p>"+
					"<p style=\"text-indent: 60px\">"+"Severity Level: "+ medCons.severityLevel+"</p>"
				);
			}
			$("#familyMemberCol").append(
				"Quote: [(Total Severity level) / (Number of Medical conditions)] x 1.2 + Plan:"+enrollmentPlan.coverageTier+" price $"+planPrice(enrollmentPlan.coverageTier)+" = Price <br/>"+
				"Price = $"+(severityLevel*1.2 +planPrice(enrollmentPlan.coverageTier)).toFixed(2)
			);
			$("#familyMemberCol").append(
				"<br/>"+"<br/>"
			);
			setSeverityLevel();
		}
		$(".style1").append(
				"</td>"
		);
		
	};

	function showUserAndFM(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/showUserAndFM",
			dataType: "json",
			data: JSON.stringify({
					"userName":$("#username").text()
				}),		
			cache: false,
			success : function(result) {
				 userAndFMBody = result;
				 //console.log(result);
				 //console.log(userAndFMBody);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: showUserAndFM -> ", e);
			}
		});
	};
	
	function showEnrollmentPlan(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/insuranceGatewaygetEnrollmentPlanByUserId",
			dataType: "json",
			data: JSON.stringify({
					"userName":$("#username").text()
				}),		
			cache: false,
			success : function(result) {
				 enrollmentPlan = result;
				 //console.log(result);
				 //console.log(userAndFMBody);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: showUserAndFM -> ", e);
			}
		});
	};
	
	function planPrice(planType){
		if(planType == "Basic"){
			return 214.63;
		} else if(planType == "Pro"){
			return 247.90;
		} else if(planType == "Premium"){
			return 301.24;
		}
		return null;
	};
	
	function setSeverityLevel(){
		severityLevel=0;
		console.log(userAndFMBody.familyMembers[familyMemberIndex].medicalConditions.length);
		for(var j=0; j<userAndFMBody.familyMembers[familyMemberIndex].medicalConditions.length; j++){
			severityLevel=severityLevel+userAndFMBody.familyMembers[familyMemberIndex].medicalConditions[j].severityLevel;
		}
		
		
		familyMemberIndex++;
	};
	
	function setVaribleStatus(){
		if(enrollmentPlan.purchaseStatus == "Paid"){
			enrollment = "Enrolled";
		}
	};
	
})