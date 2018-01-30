<%! 
	String title = "Registrierung";
	String jumbHead = "Wir begrüßen Sie als Neukunden";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>
			<form method="POST" action="./controller" class="contentRegister">
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
					<label for="inputPostalCode">PLZ</label> <input type="text"
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
				<input type="hidden" name="command" value="register">
				<div>
					<button type="submit" id="registerButton" class="primaryButton">Registrieren</button>
				</div>
			</form>
<%@ include file="./partial/footer.jsp" %>
			
