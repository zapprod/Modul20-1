<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=VT323"
	rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<title>PizzaCompiler - Login</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a class="" href="./controller?command=start"> <img src="../img/logo2.png"
				height="60" class="" alt=""><span></span>
			</a>
		</nav>
		<form action="controller" method="get">
 				<a href="./controller?command=shoppingcart" id="shoppingCartLink"><img
			src="../img/ShoppingCart.png" height="40" alt="Mein Warenkorb"
			title="Mein Warenkorb"></a>
		</form>
		<div class="jumbotron">
			<h1>Login</h1>
		</div>
		<div class="content">
			<form method="POST" action="./controller" class="loginForm">
				<div>
					<label for="InputUserID">Emailadresse</label> <input type="email"
						id="InputUserID" aria-describedby="emailHelp"
						placeholder="Email-Adresse eingeben">
				</div>
				<div>
					<label for="InputPassword">Passwort</label> <input type="password"
						id="InputPassword" placeholder="Passwort eingeben">
					<div>
						<button type="submit" id="sendDataButton" class="primaryButton">Daten
							senden</button>
					</div>
				</div>
				<input type="hidden" name="command" value="oderinfo">
			</form>
		</div>
		<br />
		<div class="jumbotron">
			<h1>Neuer Kunde</h1>
		</div>
		<div class="content">
			<a href="./controller?command=register" >Registrierung</a>
		</div>
	</div>
</body>
</html>