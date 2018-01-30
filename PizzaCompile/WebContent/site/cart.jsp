<%! 
	String title = "Warenkorb";
	String jumbHead = "Mein Warenkorb";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>
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
<%@ include file="./partial/footer.jsp" %>
		