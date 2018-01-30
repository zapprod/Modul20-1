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


<title>PizzaCompiler - <%= title %></title>
</head>
<body>
	<div id="containerContent">
		<nav>
			<a href="./controller?command=start"> <img src="./img/logo2.png"
				height="60" class="" alt=""><span></span>
			</a>
		</nav>
		<a href="./controller?command=shoppingcart" id="shoppingCartLink" class="cartButton"><img
			src="./img/ShoppingCart.png" height="40" alt="Mein Warenkorb"
			title="Mein Warenkorb"></a>
		<%@ include file="./jumb.jsp" %>
		
		<div class="content">
		