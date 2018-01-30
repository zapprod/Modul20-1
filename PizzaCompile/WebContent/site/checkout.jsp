<%! 
	String title = "Danke";
	String jumbHead = "Danke f&uml; Ihre Bestellung";
	String jumbClaim = "";
%>
<%@ include file="./partial/header.jsp" %>
<form method="POST" action="./index.html">
  <a href="./controller?command=start" id="backButton" class="primaryButton">Zurück zur Startseite</a>
</form>
<%@ include file="./partial/footer.jsp" %>
