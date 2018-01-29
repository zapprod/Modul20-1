<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=VT323"
	rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<title>PizzaCompiler - Bestellübersicht</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a href="../index.jsp"> <img src="../img/logo2.png" height="60" class="" alt=""><span></span>
			</a>
		</nav>
		<!-- <a href="./cart.html" id="shoppingCartLink"><img
			src="../img/ShoppingCart.png" height="40" alt="Mein Warenkorb"
			title="Mein Warenkorb"></a>-->
		<form action="controller" method="get">
			<input type="hidden" name="command" value="shoppingcart" /> <input
				type="image" class="cartButton" src="../img/ShoppingCart.png"
				alt="Submit" height="40" />
		</form>
		<div class="jumbotron">
			<h1>Bestellübersicht</h1>
		</div>
		<div class="content">
			<table id="orderTable">
				<tbody>
					<tr>
						<td>Autoren</td>
						<td>Buchtitel</td>
					</tr>
					<tr>
						<td>Autoren</td>
						<td>Buchtitel</td>
					</tr>
					<tr>
						<td>Autoren</td>
						<td>Buchtitel</td>
					</tr>
				</tbody>
			</table>
			<a href="./pizzaconf.html" id="backLink" class="primaryButton">Weiter
				einkaufen</a> 
				<a href="./checkout.html" id="buyLink2"
				class="primaryButton">Kaufen</a>
		</div>
	</div>
</body>
</html>