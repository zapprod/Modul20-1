<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<title>Büchersuche</title>
</head>
<body>
<div id="Content">
<h2>Danke für Ihre Bestellung</h2>
<form action="controller">
<input type="hidden" name="command" value="start">
<input type="submit" class="mybutton" value="Zurück zur Büchersuche" >
</form>

</div>
<jsp:scriptlet> session.invalidate(); </jsp:scriptlet>
</body>
</html>