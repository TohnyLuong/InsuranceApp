$(document).ready(function(){
	
	
	$("#headerTitleHome").click(function(){
		window.location.href = "http://localhost:8282/insurance/home";
	})
	
	

	
	const url = new URL(window.location);
	console.log(url);
	console.log(url.href); //good
	console.log(url.hostname); //no need
	console.log(url.pathname); //good
	console.log(url.search);
	
	
	let familyMemberSize=1
	//console.log(url.searchParams.get('fm'+ familyMemberSize +'FN'));
	while(url.searchParams.get('fm'+ familyMemberSize +'FN')!=null){
		familyMemberSize++;
	}
	//console.log((familyMemberSize-1));
	
	/*
	$.when.apply($,main()).promise().done(function(){
		//window.location.reload();
		setUserAndFamilyMemberRelation()
	});
	*/
	
	
	$($,main()).promise().done(function(){
		const myTimeout = setTimeout(setUserAndFamilyMemberRelation, 500);
	}).done(function(){
		const myTimeout = setTimeout(setFMmedCondition, 500);
		setEnrollmentPlan();
	});
	
	const myTimeout = setTimeout(myGreeting, 10000);

	function myGreeting() {
	  window.location.href = "http://localhost:8282/insurance/home";
	}
	
	function myStopFunction() {
	  clearTimeout(myTimeout);
	}
	
	function main(){
		return [
			checkIfExistingUserName(),
			saveUser(),
			saveFamilyMember(familyMemberSize)
			//setUserAndFamilyMemberRelation()	
		];
	}
	
	
	
	function checkIfExistingUserName(){
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/checkIfExistingUserName",
			dataType: "json",	
			data: JSON.stringify({
				"userName":url.searchParams.get('uname')
			}),	
			cache: false,
			success : function(result) {
				alert("Existing UserName in Database - Please register with another userName");
				//window.location.href = "http://localhost:8282/insurance/plans";
			},
			error : function(e) {
				console.log("No existing UserName in Database: ",e);
			}
		});
	}
	
	
	function saveUser(){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/saveUser",
			dataType: "json",	
			data: JSON.stringify({
				"userName":url.searchParams.get('uname'),
				"userPassword":url.searchParams.get('pword'),
				"userEmail":url.searchParams.get('email'),
				"phone":url.searchParams.get('phone'),
				
				"country":url.searchParams.get('country'),
				"addressLine":url.searchParams.get('addressLine'),
				"city":url.searchParams.get('city'),
				"state":url.searchParams.get('state'),
				"zipCode":url.searchParams.get('zipcode')
				
			}),	
			cache: false,
			success : function(result) {
				 console.log("User saved : Success!");
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: saveUser->", e);
			}
		});
	}		
	
	function saveFamilyMember(fmSize){
		for(var i=1; i<fmSize; i++){
			/*
			console.log(url.searchParams.get('fm'+i+'FN'));
			console.log(url.searchParams.get('fm'+i+'LN'));
			console.log(url.searchParams.get('fm'+i+'Age'));
			*/
		
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "http://localhost:8282/insurance/saveFamilyMember",
				dataType: "json",	
				data: JSON.stringify({
					//"familyMemberSize": fmSize,
					"firstName":url.searchParams.get('fm'+i+'FN'),
					"lastName":url.searchParams.get('fm'+i+'LN'),
					"age":url.searchParams.get('fm'+i+'Age')
				}),	
				cache: false,
				success : function(result) {
					 console.log("FamilyMember saved : Success!");
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: saveFamilyMember->", e);
				}
			});
		}
	}
	
	function setUserAndFamilyMemberRelation(){

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/setUserAndFamilyMemberRelation",
			dataType: "json",	
			data: JSON.stringify({
				"userName":url.searchParams.get('uname'),
				
				"familyMemberSize":familyMemberSize-1
			}),	
			cache: false,
			success : function(result) {
				 console.log("FamilyMember saved : Success!");
			},
			error : function(e) {
				alert("setUserAndFamilyMemberRelation Error!")
				console.log("ERROR: setUserAndFamilyMemberRelation->", e);
			}
		});
	}
	
	function setFMmedCondition(){

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/setFMmedCondition",
			dataType: "json",	
			data: JSON.stringify({
				"userName":url.searchParams.get('uname'),
				
				"familyMemberSize":familyMemberSize-1,
				
				"url":url.href,
				"urlPath":url.pathname,
				"urlParams":url.search
				
			}),	
			cache: false,
			success : function(result) {
				 console.log("setFMmedCondition saved : Success!");
			},
			error : function(e) {
				alert("setFMmedCondition Error!")
				console.log("ERROR: setFMmedCondition->", e);
			}
		});
	}
	
	function setEnrollmentPlan(){

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8282/insurance/insuranceGatewaysaveEnrollmentPlan",
			dataType: "json",	
			data: JSON.stringify({
				"userName":url.searchParams.get('uname'),
				"urlPath":url.pathname
			}),	
			cache: false,
			success : function(result) {
				 console.log("setFMmedCondition saved : Success!");
			},
			error : function(e) {
				alert("setFMmedCondition Error!")
				console.log("ERROR: setFMmedCondition->", e);
			}
		});
	}
	
});