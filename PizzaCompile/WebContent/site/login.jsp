<%! 
	String title = "Login";
	String jumbHead = "Danke f&uml;r Ihre Bestellung";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>
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
		
		<!--  
			hier irgendwie nochmal das include, 
			aber Java weigert sich die Variable jumbHead zu überschreiben
			also doch von Hand
		 -->
		
		<div class="jumbotron">
			<h1>Neuer Kunde</h1>
		</div>
		
		<div class="content">
			<a href="./controller?command=register" class="primaryButton" >Registrierung</a>
		</div>
<%@ include file="./partial/footer.jsp" %>
		