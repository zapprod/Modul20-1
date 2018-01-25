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
    <div class="error"> ${error.errorMessage} </div>
    <h2>Login</h2>
    <form action="login">
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
      <input class="mybutton" type="submit" value="Daten senden" />
      </fieldset>

      

    </form>

    <h2>Neuer Kunde</h2>
    <fieldset>
        <legend>Kundenregistrierung</legend>
    <button type="button" class="mybutton" onclick="location.href='registrierung.jsp'">Registrierung</button>
    </fieldset>
  </div>
</body>
</html>