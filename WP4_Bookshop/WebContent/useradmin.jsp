<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<script type="application/javascript" src="js/preview.js"></script>
<title>Büchersuche</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
 <div id="Content">
<h2>Datenbank-Verwaltung</h2>

<table id="table" style="width:100%" >
<tr>
<td align="center">   
<form action="admin" method="get">
  <input type="submit" name="dbadmin" value="ClearDB" style="height:25px; width:120px" >
</form>
</td>
<td align="center">   
<form action="admin" method="get">
  <input type="submit" name="dbadmin" value="InitDB" style="height:25px; width:120px">
</form>
</td>
<td align="center">   
<form action="admin" method="get">
  <input type="submit" name="dbadmin" value="Show Content" style="height:25px; width:120px">
</form>
</td>
</tr>
</table>

<h2>Datenbank-Inhalt</h2>

 <table id="table" border="1" style="width:100%" >
 <tr>
 <th>Benutzer</th> <th>Bestellungen</th>
 </tr>
  <c:forEach items="${benutzer}" var="b">
  <tr>
    <td>${b.vorname} ${b.name}</td> 
    <td> <ul><c:forEach items="${b.bestellungen}" var="bestellung">
     <li>${bestellung.datum}
         <ul>
         <c:forEach items="${bestellung.bestellpositionen}" var="pos">
         <li>${pos}</li>
         </c:forEach>
         </ul>
     </li>
    </c:forEach>
    </ul></td> 
  </tr>
  </c:forEach>
  </table>
  <p/>
 </div>
</body>
</html>