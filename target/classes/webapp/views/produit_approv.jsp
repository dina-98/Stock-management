<%@page import="org.sid.web.PApprovAction"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produit d'approvisionement</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
  <script>
  $( function() {
    $( "#DATE" ).datepicker();
  } );
  $(document).ready(function(){
	    $(".form-control").css({"margin-bottom": "3px", "width": "80%", "margin-left": "auto", "margin-right": "auto"});
	    $(".panel1").css({"margin-bottom": "30px", "width": "30%", "margin-left": "auto", "margin-right": "auto"});
	    $(".panel2").css({"margin-bottom": "30px", "width": "95%", "margin-left": "auto", "margin-right": "auto"});
	    $(".table").css({"width": "100%", "margin-left": "auto", "margin-right": "auto"});
	    $(".error").css({"color": "red"});
	    $(".footer").css({"background-color": "#3486eb", "margin-top": "30px", "height": "50px", "padding-top" : "15px"});
	    $(".navbar").css({"background-color": "#3486eb"});
	    $(".nvc").css({"color": "white", "background-color": "#3486eb", "margin-left": "4px"});
	    $(".nvc").hover(function(){
	  	  $(this).css("background-color", "#2456a6");
	  	}, function(){
		  $(this).css("background-color", "#3486eb");
		});
	});
  $( "#myform" ).validate();
		
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


<div class="panel1">
<h3>Ajouter/Modifier Produit</h3>
  <div class="panel panel-danger">
    <div class="panel-body">
	<s:form action="saveA" method="post" theme="simple"> 
	    <div class="form-group">
			<s:label key="CODE" value="Code" />
			<s:textfield id="CODE" name="produitApprov.codePdt" cssClass="form-control" placeholder="code" readonly="editMode" min="0" type="number" required="true"></s:textfield>
  			<s:label cssClass="error" value="%{codeErr}"/><br>
			<s:label key="qteCommande" value="Quantité" />
			<s:textfield id="qteCommande" name="produitApprov.qteCommande" cssClass="form-control" placeholder="Quantité" min="1" type="number" required="true"></s:textfield>
			<s:label key="DATE" value="Date" /><br>
			<s:textfield id="DATE" name="produitApprov.datePrevueLivraison" cssClass="form-control" placeholder="Date" required="true"></s:textfield>
			<s:hidden name="editMode"></s:hidden>
			<center><s:submit value="Save" cssClass="btn btn-primary"></s:submit></center>
     </div>
  </s:form>
  </div></div></div>
  
 <div class="panel2">
  <div class="panel panel-primary">
    <div class="panel-heading">Liste des produits de stock</div>
    <div class="panel-body">
  
  <div class="table-responsive">
  <table class="table">
		  <tr>
		  <th>code Produit </th><th>Quantite Commandé</th><th>Date de livraison</th><th>Supprimer</th><th>Modifier</th>
		  </tr>
		  <s:iterator value="listPApprov">
		  <tr>
		  <td><s:property value="codePdt"/></td>
		  <td><s:property value="qteCommande"/></td>
		  <td><s:property value="datePrevueLivraison"/></td>
		  
		  <s:url namespace="/" action="deleteA" var="lien1">
		  <s:param name="codeP">
		  <s:property value="codePdt"/>
		  </s:param>
		  </s:url>
		  <s:url namespace="/" action="editA" var="lien2">
		  <s:param name="codeP">
		  <s:property value="codePdt"/>
		  </s:param>
		  </s:url>
		  <td><s:a href="%{lien1}" cssClass="btn btn-danger">supprimer</s:a></td>
		  <td><s:a href="%{lien2}" cssClass="btn btn-warning">modifier</s:a></td>
		  </tr>
		  </s:iterator>
		  </table>
		  </div>
		  </div></div></div>
		  
	<div class="footer">
		<div class="footer-copyright text-center py-3">© 2020 Copyright</div>
	</div>
</body>
</html>