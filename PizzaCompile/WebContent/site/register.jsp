<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=VT323"
	rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">
<title>PizzaCompiler - Registrierung</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a class="" href="./controller?command=start"> <img
				src="./img/logo2.png" height="60" class="" alt="Home"><span></span>
			</a>
		</nav>
		<div class="jumbotron">
			<h1>Wir begrüßen Sie als Neukunden</h1>
		</div>
		<div class="content contentRegister">
			<form method="POST" action="./controller">
				<div>
					<label for="inputLastName">Nachname</label> <input type="text"
						id="inputLastName" placeholder="Nachname">
				</div>
				<div>
					<label for="inputFirstName">Vorname</label> <input type="text"
						id="inputFirstName" placeholder="Vorname">
				</div>
				<div>
					<label for="inputEmail">Email</label> <input type="email"
						id="inputEmail" placeholder="Email">
				</div>
				<div>
					<label for="inputPostalCode">PLZ</label> <input type="number"
						id="inputPostalCode" placeholder="PLZ">
				</div>
				<div>
					<label for="inputCity">Wohnort</label> <input type="text"
						id="inputCity" placeholder="Wohnort">
				</div>
				<div>
					<label for="inputUserID">User-ID</label> <input type="text"
						id="inputUserID" placeholder="User-ID">
				</div>
				<div>
					<label for="inputPassword">Password</label> <input type="password"
						id="inputPassword" placeholder="Password">
				</div>
				<input type="hidden" name="command" value="regjster">
				<div>
					<button type="submit" id="registerButton" class="primaryButton">Registrieren</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="./js/EmailValidation.js"></script>
	<script type="text/javascript" src="./js/PasswordStrength.js"></script>
	<script type="text/javascript" src="./js/AutoComplete.js"></script>
</body>
</html>