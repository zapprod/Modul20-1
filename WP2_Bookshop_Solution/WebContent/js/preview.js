window.onload = function()
{
  configPreViewContainer();
  configLinks();
};

// Konfigurtiert die angezeigetn Links mit
// JavaScript-Funktionalität
function configLinks()
{
  var link1 = document.getElementById("bid1");
  link1.onmouseover = showImage;
  link1.onmouseout = removeImage;

  var link2 = document.getElementById("bid2");
  link2.onmouseover = showImage;
  link2.onmouseout = removeImage;

  var link3 = document.getElementById("bid3");
  link3.onmouseover = showImage;
  link3.onmouseout = removeImage;

  var link4 = document.getElementById("bid4");
  link4.onmouseover = showImage;
  link4.onmouseout = removeImage;

  var link5 = document.getElementById("bid5");
  link5.onmouseover = showImage;
  link5.onmouseout = removeImage;
}

// Konfiguriert einen div-Container, in dem die
// Preview-Bilder angezeigt werden
function configPreViewContainer()
{
  var table = document.getElementById("table");
  var rect = table.getBoundingClientRect();
  var div = document.createElement("div");
  div.id = "preView"
  div.style.position = 'absolute';
  div.style.top = (rect.top) + "px";
  div.style.left = (rect.right + 50) + "px";
  div.style.visibility = "visible";
  document.body.appendChild(div);
}

// Zeigt ein Bild in dem vorbereiteten div-Container an
function showImage(event)
{
  var preview = document.getElementById("preView");

  var image = event.target.id;

  var img = document.createElement("img");
  img.setAttribute("id", "image");
  img.setAttribute("src", "tmp/" + image + ".jpg");
  img.setAttribute("width", "120");
  img.setAttribute("style", "visibility:visible");

  // Alternative Konfiguration
  // img.style.visibility = 'visible';
  // img.id="image";
  // img.src = "tmp/" + image + ".jpg";
  // img.width= "120";
  preview.appendChild(img);
}

// Löscht das angezeigte Bild, falls eines vorhanden ist
function removeImage()
{
  var preview = document.getElementById("preView");
  if (preview.hasChildNodes())
  {
    preview.removeChild(preview.firstChild);
  }
}
