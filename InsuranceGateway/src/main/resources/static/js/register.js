$(document).ready(function(){
	var numFamilyMember=2;
	
	$("#headerTitleHome").click(function(){
		window.location.href = "http://localhost:8282/insurance/home";
	})

	$("#newFamilyMember").click(function(){
		$("#familyEnrollment").append(
			"<br/><br/>"+
			"Family Member "+numFamilyMember+ ":"+ 
			"<p><input placeholder=\"Family Member ("+numFamilyMember+"): First Name...\" oninput=this.className = '' name=fm"+numFamilyMember+"FN ></p>"+
		    "<p><input placeholder=\"Family Member ("+numFamilyMember+"): Last Name...\" oninput=this.className = '' name=fm"+numFamilyMember+"LN ></p>"+
		    "Age:"+
		    
		    "<p><input placeholder=\"Family Member ("+numFamilyMember+"): Age...\" oninput=this.className = '' name=fm"+numFamilyMember+"Age></p>"+
		    
		    "<div class=row>"+
				"<div class=column >"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCAcne unchecked>Acne</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCAddisonsdisease unchecked>Addison's disease</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCAlcoholrelatedliverdisease unchecked>Alcohol-related liver disease</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCAllergies unchecked>Allergies</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCBonecancer unchecked>Bone cancer</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCChestpain unchecked>Chest pain</p>"+
		  		"</div>"+
				"<div class=column >"+
				    "<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCColdSore unchecked>Cold Sore</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCCough unchecked>Cough</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCDementia unchecked>Dementia</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCDiabetes unchecked>Diabetes</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCFlu unchecked>Flu</p>"+
					"<p><input style=width:5% type=checkbox oninput=this.className='' name=fm"+numFamilyMember+"MCHepatitis unchecked>Hepatitis</p>"+
				"</div>"+
			"</div>"
		);
		addNewFamilyMemberCount();
		quoteNumFamMem=numFamilyMember-1;
		basicQuote=214.63*quoteNumFamMem;
		proQuote=247.90*quoteNumFamMem;
		premiumQuote=301.24*quoteNumFamMem;
		
		//$("div").remove("#quote");
		
		$("#quote").append(
			"Basic price: "+"$214.63 x"+quoteNumFamMem+"="+basicQuote+"<br/>"
		)
		$("#quote").append(
			"Pro price: "+"$247.90 x"+quoteNumFamMem+"="+proQuote+"<br/>"
		)
		$("#quote").append(
			"Premium price: "+"$301.24 x"+quoteNumFamMem+"="+premiumQuote+"<br/><br/><br/><br/>"
		)
		
	})
	
	/*
	if(==basic && quoteNumFamMem==1){
		$("#quote").append(
			"Basic price: "+"$214.63 x"+quoteNumFamMem+"="+basicQuote+"<br/>"
		)
		$("#quote").append(
			"Pro price: "+"$247.90 x"+quoteNumFamMem+"="+proQuote+"<br/>"
		)
		$("#quote").append(
			"Premium price: "+"$301.24 x"+quoteNumFamMem+"="+premiumQuote+"<br/><br/><br/><br/>"
		)
	}
	*/
	
	
	
	function addNewFamilyMemberCount(){
		numFamilyMember=numFamilyMember+1;	
	}		
	
	
});
