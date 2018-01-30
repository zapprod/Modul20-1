<%! 
	String title = "Home";
	String jumbHead = "Willkommen beim PizzaCompiler";
	String jumbClaim = "";
%>
<%@ include file="./site/partial/header.jsp" %>

<h3>Zum Konfigurator</h3>
<p>Mit unserem Konfigurator k&ouml;nnen Sie Ihre Pizza aus einer
	Vielzahl von Zutaten zusammenstellen.</p>
<br />
<a href="./controller?command=configurator" id="pizzaConfLink"><img
src="./img/pizzaconf.png" height="100" alt="Konfigurator"
title="Konfigurator"></a>
			
<%@ include file="./site/partial/footer.jsp" %>
			
