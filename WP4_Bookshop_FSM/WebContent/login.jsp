<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="expires" content="0">
<meta http-equiv="cache-control" content="no-cache, must-revalidate, no-store">
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/hs-kl-style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Büchersuche</title>
</head>
<body>
  <div id="Content">
    <div class="error"> ${error.message} </div>
    <h2>Login</h2>
    <form action="controller">
      <fieldset>
        <legend>Logindaten</legend>
        <div>
          <label for="user">User-ID: </label> <input type="text"
            name="user" />
        </div>
        <div>
          <label for="passwd">Password: </label> <input type="password"
            name="passwd">
        </div>
        <p/>
        <input type="hidden" name="command" value="login" />
      <input class="mybutton" type="submit" value="Daten senden" />
      </fieldset>

      

    </form>

    <h2>Neuer Kunde</h2>
    <fieldset>
        <legend>Kundenregistrierung</legend>
        <form action="controller">
        <input type="hidden" name="command" value="registerdata">
        <input type="submit" class="mybutton" value="Registrierung">
        </form>
    
    </fieldset>
  </div>
</body>
</html>