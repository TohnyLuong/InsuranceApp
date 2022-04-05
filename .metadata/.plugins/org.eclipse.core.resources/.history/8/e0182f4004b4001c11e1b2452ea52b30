$(document).ready(function(){
	
	
	
	
	
	
	
	
	
	downloadDocuments()
	
	
	
	
	
	
	
	
	function downloadDocuments(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/insuranceGatewayDownloadFileFromClaim",
			dataType: "json",
			data: JSON.stringify({
					"userName":$("#username").text()
				}),		
			cache: false,
			success : function(result) {
			},
			error : function(e) {
				alert("Error! ->uploadDocuments")
				console.log("ERROR: paidEnrollmentPlan -> ", e);
			}
	});
	
	
	
	
	
	
	
	
	
	
	/*
	$("#subBtn").click(function(){
		uploadDocuments();
	});
	
	
	
	
	
	
	function uploadDocuments(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/insuranceGatewayUploadFileToClaim",
			dataType: "json",
			data: JSON.stringify({
					"userName":$("#username").text()
				}),		
			cache: false,
			success : function(result) {
			},
			error : function(e) {
				alert("Error! ->uploadDocuments")
				console.log("ERROR: paidEnrollmentPlan -> ", e);
			}
		});
		
	}
	*/
	
})