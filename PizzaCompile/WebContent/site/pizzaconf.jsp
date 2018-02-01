<%! 
	String title = "Konfigurator";
	String jumbHead = "Konfigurator";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>

			<fieldset class="checkboxgroup">
				<p>Wählen Sie zuerst eine Pizzagröße</p>
				<div class="clearfix">
					<label><input type="radio" name="pizzasize" value="4.00"> Klein (4€)</label> 
					<label><input type="radio" name="pizzasize" value="5.00"> Mittel (5€)</label> 
					<label><input type="radio" name="pizzasize" value="6.00"> Groß (6€)</label>
				</div>
			</fieldset>
			<p>Alle Pizzen sind mit unserer hauseigenen Tomatensoße
				bestrichen und werden mit Käse Überbacken - die übrigen Zutaten
				können Sie frei wählen.</p>
			<fieldset class="checkboxgroup">
				<p>Kombinieren Sie Ihre Wunschzutaten (pro Belag 0,5€)</p>
				<div class="clearfix">
					<label><input type="checkbox" name="topping" class="topping" value=".5">
						Salami</label> <label><input type="checkbox" name="topping" value=".5">
						Grüne Paprika</label> <label><input type="checkbox"
						name="topping" value=".5"> Tomatenscheiben</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox" name="topping" value=".5">
						Champignons</label> <label><input type="checkbox"
						name="topping" value=".5"> Peperoniwurst</label> <label><input
						type="checkbox" name="topping" value=".5"> Basilikum</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox" name="topping" value=".5"> Petersilie</label> <label><input
						type="checkbox" name="topping" value=".5"> Grüne Oliven</label> <label><input
						type="checkbox" name="topping" value=".5"> Schwarze Oliven</label>
				</div>
				<div class="clearfix">
					<label><input type="checkbox" name="topping" value=".5">
						Extra Käse</label> <label><input type="checkbox" name="topping" value=".5">
						Bacon</label> <label><input type="checkbox" name="topping" value=".5">
						Scampis</label>
				</div>
			</fieldset>
			Preis <input type="text" disabled="disabled" name="total" />
			<a href="./controller?command=shoppingcart" id="backLink" class="primaryButton">Weiter einkaufen</a>
			<a href="./controller?command=login" id="buyLink" class="primaryButton">Kaufen</a>
<%@ include file="./partial/footer.jsp" %>
			