<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link href="https://fonts.googleapis.com/css?family=VT323" rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">


<title>PizzaCompiler - Home</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a class="" href="./index.html"> <img src="./img/logo2.png"
				height="60" class="" alt=""><span></span>
			</a>
		</nav>
		<form action="controller" method="get">
		<input type="hidden" name="command" value="shoppingcart" />
		<input type="image" class="cartButton" src="./img/ShoppingCart.png" alt="Submit" height="40"/>
		<!--<a href="./site/cart.html" id="shoppingCartLink"><img
			src="./img/ShoppingCart.png" height="40" alt="Mein Warenkorb"
			title="Mein Warenkorb"></a>-->
			</form>
		<div class="jumbotron">
			<h1>Willkommen beim PizzaCompiler</h1>
			<!--  <p>Nutzen Sie unseren Konfigurator, um Ihre Wunschpizza
				zusammenzustellen.</p> -->
		</div>
		<div class="content">
		<form action="controller" method="get">
			<h3>Zum Konfigurator</h3>
			<p>Mit unserem Konfigurator k&ouml;nnen Sie Ihre Pizza aus einer
				Vielzahl von Zutaten zusammenstellen.</p>
			<br />
			<input type="hidden" name="command" value="configurator" />
			<input type="image" class="configButton" src="./img/pizzaconf.png" alt="Submit" height="100"/>
			<!--<a href="./site/pizzaconf.html" id="pizzaConfLink"><img
			src="./img/pizzaconf.png" height="100" alt="Konfigurator"
			title="Konfigurator"></a>-->
			</form>
		</div>
	</div>
</body>
</html>