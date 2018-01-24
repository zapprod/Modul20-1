<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<script type="application/javascript" src="js/preview.js"></script>
<title>B�chersuche</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
 <div id="Content">
<h2>Folgende B�cher wurden gefunden</h2>

 <table id="table" border="1">
 <tr>
 <th>Autor(en)</th> <th>Buchtitel</th>
 </tr>
  <c:forEach items="${buecher}" var="b">
  <tr>
    <td>${b.autorenAsString}</td> <td><a id='${b.id}' href="detail?buchid=${b.id}"> ${b.titel}</a></td> 
  </tr>
  </c:forEach>
  </table>
  <p/>
  <button type="button" class="mybutton" onclick="location.href='index.html'">Zur�ck zur B�chersuche</button>
  </div>
</body>
</html>