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
    <h2>Willkommen beim HS-KL-Buchladen</h2>

    <form action="controller" method="get">
      <table>
      
        <tr>
          <td><strong>Autorenname:</strong></td>
          <td><input type="text" name="autorname" size="30" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>
             <input type="hidden" name="command" value="suchen" />
             <input class="mybutton" type="submit" value="Suchen" />
          </td>
        </tr>
     </table>
    </form>
    <hr>
    <form action="controller" method="get">
      <input type="hidden" name="command" value="warenkorb" />
      <input class="mybutton" type="submit" value="Mein Warenkorb" />
    </form>
  </div>
</body>
</html>