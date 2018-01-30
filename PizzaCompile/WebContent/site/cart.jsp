<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=VT323"
	rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">

<title>PizzaCompiler - Warenkorb</title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a class="" href="./controller?command=start"> <img src="./img/logo2.png"
				height="60" class="" alt="Home"><span></span>
			</a>
		</nav>
		<div class="jumbotron">
			<h1>Mein Warenkorb</h1>
		</div>
		<div class="content">
			<form action="controller" method="post">
				<table id="cartTable">
					<tbody>
						<c:forEach items="${warenkorb.inhalt}" var="b">
							<tr>
								<td>${b.autorenAsString}</td>
								<td>${b.titel}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" name="command" value="login"> <input
					type="submit" class="primaryButton" value="Kaufen" />
			</form>
			<a href="./controller?command=configurator" id="backLink">Weiter einkaufen</a>
		</div>
	</div>
</body>
</html>