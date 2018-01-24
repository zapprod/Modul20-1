document.getElementById("inputPassword").onblur = checkPassword;
document.getElementById("inputPassword").onkeyup = clearPasswordErrorMsg;
document.getElementById("inputPassword").onfocus = clearPasswordErrorMsg;

function checkPassword(event) {

	var pwStrength = new Array ("Unsicher", "Akzeptabel", "Sicher", "Sehr sicher");
	var value = event.target.value;
	var length = value.length;
	var hasUniqueNumbers = value.match(/[0-9](?!\1)/);
	var hasSpecialSigns = value.match(/[!,§,$,&,\?]/);
	var complexity = 0;
	var complexityColor= "red";
	
	if (length <=0){
		return;
	}
	if (length >5){
		complexity++;
		complexityColor= "orange";
	}
	if (length >5 && hasSpecialSigns){
		complexity++;
		complexityColor= "blue";
	}
	if (length >5 && hasSpecialSigns && hasUniqueNumbers){
		complexity++;
		complexityColor= "green";
	}
	
	var div = document.createElement("div");
	div.className = "passwordStrength";
	div.innerHTML = 'Passwordstärke: <span class = "' + complexityColor +'">' + pwStrength[complexity] +'</span>';
	event.target.parentElement.appendChild(div);
	event.target.className = "passwordInfo";
	
}

function clearPasswordErrorMsg (event){
	
	var parent = event.target.parentElement;
	if (parent.querySelector(".passwordStrength") !== null) {

		parent.querySelector(".passwordStrength").remove();
		event.target.className = "";
	}
	
}