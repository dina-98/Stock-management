<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index </title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script>
  $( function() {
    $( "#DATE" ).datepicker();
  } );
  $(document).ready(function(){
	  	$("p").css({"font-size": "30px"});
	  	$(".choix").css({"margin-bottom": "130px"});
	    $(".form-control").css({"margin-bottom": "3px", "width": "80%", "margin-left": "auto", "margin-right": "auto"});
	    $(".imgPS").css({"margin-bottom": "30px", "width": "180px", "height": "180px"});
	    $(".panel1").css({"margin-bottom": "30px", "width": "30%", "margin-left": "5%", "margin-right": "auto"});
	    $(".panel2").css({"margin-bottom": "30px", "width": "95%", "margin-left": "auto", "margin-right": "auto"});
	    $(".table").css({"width": "100%", "margin-left": "auto", "margin-right": "auto"});
	    $(".footer").css({"background-color": "#3486eb", "margin-top": "30px", "height": "50px", "padding-top" : "15px"});
	    $(".navbar").css({"background-color": "#3486eb"});
	    $(".nvc").css({"color": "white", "background-color": "#3486eb", "margin-left": "4px"});
	    $(".nvc").hover(function(){
	  	  $(this).css("background-color", "#2456a6");
	  	}, function(){
		  $(this).css("background-color", "#3486eb");
		});
	});
  </script>
</head>
<body>


<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
    	<s:url action="index" var="home"></s:url>
  		<s:a href="%{home}"><img src="css/img/shop.png" style="height: 50px; border-radius: 25px;" alt="Produits du stock"/></s:a>
    </div>
    <ul class="nav navbar-nav">
    	<li><s:url action="pStock" var="pstock"></s:url>
  		<s:a cssClass="nvc" href="%{pstock}">Produit Stock</s:a></li>
    	<li><s:url action="pApprov" var="papprv"></s:url>
  		<s:a cssClass="nvc" href="%{papprv}">Produit Approvisionnement</s:a></li>
    </ul>
  </div>
</nav>


	<center><h2>Bienvenue</h2></center>
	<center><h3>Choisir un service</h3></center>

  <center>
  
  <s:url namespace="/" action="pStock" var="lien1"></s:url>
 
  <s:url namespace="/" action="pApprov" var="lien2"></s:url>
  <table class="choix">
  	<tr>
  		<td style="padding:0 70px;"><center><s:a href="%{lien1}"><img src="css/img/stock.png" class="imgPS" alt="Produits du stock"/><br><p>Produits du stock</p></s:a></center></td>
  		<td style="padding:0 30px;"><center><s:a href="%{lien2}"><img src="css/img/apprv.png" class="imgPS" alt="Produits du stock"/><br><p>Produits d'approvisionement</p></s:a></center></td>
  	</tr>
  </table>
   
  </center>
  	<div class="footer">
		<div class="footer-copyright text-center py-3">© 2020 Copyright</div>
	</div>
</body>
</html>