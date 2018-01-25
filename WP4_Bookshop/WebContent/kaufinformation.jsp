<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Büchersuche</title>
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
<form action="kaufen">
 <table border="1">
  <c:forEach items="${warenkorb.inhalt}" var="b">
          <tr>
            <td>${b.autorenAsString}</td>
            <td>${b.titel}</td>
          </tr>
        </c:forEach>
  <tr>
    <td width="180"> <button type="button" class="mybutton" onclick="location.href='index.html'">Weiter einkaufen</button> </td> 
    <td>
    <input type="hidden" name="userid" value="${benutzer.userid}"> 
    <input type="submit" class="mybutton" value="Kaufen"/></td> 
  </tr>
  </table>
</form>
</div>
</body>
</html>