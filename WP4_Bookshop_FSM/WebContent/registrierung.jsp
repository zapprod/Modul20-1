<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<script type="application/javascript" src="js/emailValidator.js"></script>
<script type="application/javascript" src="js/passwordValidator.js"></script>
<script type="application/javascript" src="js/autocompletion.js"></script>
<script type="application/javascript" src="js/initScriptOnRegistration.js"></script>
<title>B�chersuche</title>
</head>
<body>
<div id="Content">
<h2>Wir begr��en Sie als Neukunden</h2>

<form action="controller">
 <table>
  <tr>
    <td>Nachname:</td> <td><input type="text" name="nachname" size="30" /></td> 
  </tr>
  <tr>
    <td>Vorname:</td> <td><input type="text" name="vorname" size="30"/></td> 
  </tr>
  <tr>
    <td>Email:</td> <td><input id="email" type="text" name="email" size="30"/></td> 
  </tr>
   <tr>
    <td>PLZ:</td> <td><input id="plz" type="text" name="plz" size="30" autocomplete="off"/></td> 
  </tr>
   <tr>
    <td>Wohnort:</td> <td><input id="ort" type="text" name="ort" size="30"/></td> 
  </tr>
  <tr>
    <td>User-ID:</td> <td><input type="text" name="user" size="30"/></td> 
  </tr>
  <tr>
    <td>Passwort:</td> <td><input id="passwd" type="password" name="passwd" size="30"/></td> 
  </tr>
  <tr>
    <td> &nbsp; </td> <td>
    <input type="hidden" name="command" value="register" /><input type="submit" class="mybutton" value="Registrieren"/></td> 
  </tr>
 
  </table>
</form>
</div>
</body>
</html>