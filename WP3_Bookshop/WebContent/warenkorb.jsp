<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>B�chersuche</title>
</head>
<body>
  <div id="Content">
    <h2>Ihr Warenkorb</h2>

    <form action="login.html">
      <table border="1">
        <c:forEach items="${warenkorb.inhalt}" var="b">
          <tr>
            <td>${b.autorenAsString}</td>
            <td>${b.titel}</td>
          </tr>
        </c:forEach>
      </table>
      <p />
      <button type="button" class="mybutton" onclick="location.href='index.html'">Weiter einkaufen</button>
      <input type="submit" class="mybutton" value="Kaufen" />
    </form>
  </div>
</body>
</html>