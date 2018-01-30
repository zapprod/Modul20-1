<%! 
	String title = "Bestellübersicht";
	String jumbHead = "Bestellübersicht";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>
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
			<a href="./controller?command=configurator" id="backLink" class="primaryButton">Weiter
				einkaufen</a> 
				<a href="./controller?command=checkout" id="buyLink2"
				class="primaryButton">Kaufen</a>
<%@ include file="./partial/footer.jsp" %>
				