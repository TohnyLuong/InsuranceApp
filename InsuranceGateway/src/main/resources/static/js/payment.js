$(document).ready(function(){
	
	let userAndFMBody;
	let enrollmentPlan;
	let familyMemberIndex=0;
	let severityLevel;
	let totalPrice=0;
	showUserAndFM();
	showEnrollmentPlan();

	setTimeout(() => {displayUserAndFM()}, 200);
	
	$("#checkoutBtn").click(function(){
		paidEnrollmentPlan();
	});
	
	function displayUserAndFM(){
		console.table(userAndFMBody);
		console.table(enrollmentPlan);
		$("#cartNumFM").append(userAndFMBody.familyMembers.length);
		
		for(var i=0; i<userAndFMBody.familyMembers.length; i++){
			setSeverityLevel();	
			$("#cartBody").append(
				userAndFMBody.familyMembers[i].firstName+" "+userAndFMBody.familyMembers[i].lastName +"     <b>  $"+(severityLevel*1.2 +planPrice(enrollmentPlan.coverageTier)).toFixed(2)+"</b>"+
				"<br/>"
			);
			totalPrice+=(severityLevel*1.2 +planPrice(enrollmentPlan.coverageTier));
		}
		$("#cartTotalPrice").append(
			"$"+totalPrice
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
	
	function paidEnrollmentPlan(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/insuranceGatewayPaidEnrollmentPlan",
			dataType: "json",
			data: JSON.stringify({
					"userName":$("#username").text()
				}),		
			cache: false,
			success : function(result) {
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: paidEnrollmentPlan -> ", e);
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
	
})