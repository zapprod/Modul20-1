document.getElementById("inputEmail").onblur = validateEmail;
document.getElementById("inputEmail").onkeyup = clearEmailErrorMsg;
document.getElementById("inputEmail").onfocus = clearEmailErrorMsg;

function validateEmail(event) {

	var value = event.target.value;
	var length = value.length;
	var regExMail = /([a-zA-Z]{4})+([0-9]{4})+@stud\.hs-kl\.de$|([a-zA-Z]{4})+([0-9]{4})+@stud\.fh-kl\.de$/;

	if (length <= 0) {
		return;
	}

	if (!regExMail.test(event.target.value)) {

		var div = document.createElement("div");
		div.className = "inputError";
		div.innerHTML = "Die Email-Adresse hat kein gültiges Format";
		event.target.parentElement.appendChild(div);
		event.target.className = "error";
	}
}

function clearEmailErrorMsg(event) {

	var parent = event.target.parentElement;
	if (parent.querySelector(".inputError") !== null) {

		parent.querySelector(".inputError").remove();
		event.target.className = "";
	}

}