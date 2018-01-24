<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<script type="application/javascript" src="js/preview.js"></script>
<title>Büchersuche</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
  <div id="Content">
    <h2>Folgende Bücher wurden gefunden</h2>

    <table id="table" border="1">
      <tr>
        <th>Autor(en)</th>
        <th>Buchtitel</th>
      </tr>
      <c:forEach items="${buecher}" var="b">
        <tr>
          <td>${b.autorenAsString}</td>
          <td><a id='${b.id}' href="controller?buchid=${b.id}&command=detail"> ${b.titel}</a></td>
        </tr>
      </c:forEach>
    </table>
    <p />
    <form action="controller">
      <input type="hidden" name="command" value="start" /> <input type="submit" class="mybutton"
        value="Zurück zur Büchersuche" />
    </form>
  </div>
</body>
</html>