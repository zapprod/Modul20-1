document.getElementById("inputPostalCode").onblur = cityCompletion;

function cityCompletion(event)
{  
  var value = event.target.value;
  var length = value.length;
    
  if( (length != 5) || (isNaN(value) == true) )
  {
    clearCity();
    return;
  }
   
  var httpRequest = new XMLHttpRequest();
  
  httpRequest.onreadystatechange = function(e)
  {
     if (e.target.readyState == XMLHttpRequest.DONE ) 
     {
        var orte = e.target.responseText.split(";");
        var firstCity = orte[0].substring(5, orte[0].length).trim();
        var cityInput  = document.getElementById("inputCity");
        cityInput.value = firstCity;
     }
  };
  
  var url = "../ort?plz=" + value;
  httpRequest.open("GET", url );
  httpRequest.send();
}

function clearCity()
{ 
  document.getElementById("inputCity").value = "";
}