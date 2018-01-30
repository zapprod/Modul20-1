<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=VT323"
	rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">

<title>PizzaCompiler - Konfigurator</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a href="./controller?command=start"> <img src="./img/logo2.png"
				height="60" class="" alt="Home"><span></span>
			</a>
		</nav>
		<a href="./controller?command=shoppingcart" id="shoppingCartLink" class="cartButton"><img
			src="./img/ShoppingCart.png" height="40" alt="Mein Warenkorb"
			title="Mein Warenkorb"></a>
		<div class="jumbotron">
			<h1>Konfigurator</h1>
		</div>
		<div class="content">
			<fieldset class="checkboxgroup">
				<p>Wählen Sie zuerst eine Pizzagröße</p>
				<div class="clearfix">
					<label><input type="radio" name="pizzasize"> Klein (4€)</label> 
					<label><input type="radio" name="pizzasize"> Mittel (5€)</label> 
					<label><input type="radio" name="pizzasize"> Groß (6€)</label>
				</div>
			</fieldset>
			<p>Alle Pizzen sind mit unserer hauseigenen Tomatensoße
				bestrichen und werden mit Käse überbacken - die übrigen Zutaten
				können Sie frei wählen.</p>
			<fieldset class="checkboxgroup">
				<p>Kombinieren Sie Ihre Wunschzutaten (pro Belag 0,5€)</p>
				<div class="clearfix">
					<label><input type="checkbox" name="ingredient">
						Salami</label> <label><input type="checkbox" name="ingredient">
						Grüne Paprika</label> <label><input type="checkbox"
						name="ingredient"> Tomatenscheiben</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox" name="ingredient">
						Champignons</label> <label><input type="checkbox"
						name="ingredient"> Peperoniwurst</label> <label><input
						type="checkbox" name="ingredient"> Basilikum</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox"> Petersilie</label> <label><input
						type="checkbox" name="ingredient"> Grüne Oliven</label> <label><input
						type="checkbox" name="ingredient"> Schwarze Oliven</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox" name="ingredient">
						Extra Käse</label> <label><input type="checkbox" name="ingredient">
						Bacon</label> <label><input type="checkbox" name="ingredient">
						Scampis</label>
				</div>
			</fieldset>
			<a href="./controller?command=shoppingcart" id="backLink" class="primaryButton">Weiter einkaufen</a>
			<a href="./controller?command=login" id="buyLink" class="primaryButton">Kaufen</a>
		</div>
	</div>
</body>
</html>