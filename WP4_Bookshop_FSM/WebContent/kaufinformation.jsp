<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Bestellübersicht</title>
</head>
<body>
  <div id="Content">
    <h2>Bestellübersicht</h2>

<table>
<tr>
  <td>Name</td><td> ${benutzer.vorname} ${benutzer.name}</td>
</tr>
<tr>
  <td>Ort</td><td> ${benutzer.plz} ${benutzer.ort}</td>
</tr>
<tr>
  <td>Email</td><td> ${benutzer.email}</td>
</tr>
</table>
<p/>

    <form action="controller">
      <table border="1">
        <c:forEach items="${warenkorb.inhalt}" var="b">
          <tr>
            <td>${b.autorenAsString}</td>
            <td>${b.titel}</td>
          </tr>
        </c:forEach>
      </table>

      <input type="hidden" name="command" value="danke"> <input type="submit" class="mybutton" value="Kaufen" />

    </form>
    <form action="controller">
      <input type="hidden" name="command" value="start"> <input type="submit" class="mybutton"
        value="Weiter einkaufen">
    </form>
  </div>
</body>
</html>