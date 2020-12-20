<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste de Stock</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
$(document).ready(function(){
    $(".form-control").css({"margin-bottom": "3px", "width": "80%", "margin-left": "auto", "margin-right": "auto"});
    $(".panel1").css({"margin-bottom": "30px", "width": "30%", "margin-left": "auto", "margin-right": "auto"});
    $(".panel2").css({"margin-bottom": "30px", "width": "95%", "margin-left": "auto", "margin-right": "auto"});
    $(".table").css({"width": "100%", "margin-left": "auto", "margin-right": "auto"});
    $(".error").css({"color": "red"});
    $(".footer").css({"background-color": "#3486eb", "margin-top": "30px", "height": "50px", "padding-top" : "15px"});
    $(".dol").css({"margin-top": "10px", "margin-bottom": "10px", "margin-left": "auto", "margin-right": "auto"});
    $(".navbar").css({"background-color": "#3486eb"});
    $(".nvc").css({"color": "white", "background-color": "#3486eb", "margin-left": "4px"});
    $(".nvc").hover(function(){
  	  $(this).css("background-color", "#2456a6");
  	}, function(){
	  $(this).css("background-color", "#3486eb");
	});
});
</script>
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
	<s:form action="save" method="post" theme="simple"> 
	    <div class="form-group">
			<s:label key="CODE" value="Code" />
			<s:textfield id="CODE" name="produitStock.codePdt" cssClass="form-control" placeholder="code" readonly="editMode" type="number" min="0" required="true"></s:textfield>
  			<s:label cssClass="error" value="%{codeErr}"/><br>
			<s:label key="NOM" value="Nom" />
			<s:textfield id="NOM" name="produitStock.nomPdt" cssClass="form-control" placeholder="nom" required="true"></s:textfield>
			<s:label key="DESCRIPTION" value="Description" />
			<s:textfield id="DESCRIPTION" name="produitStock.descPdt" cssClass="form-control" placeholder="description" required="true"></s:textfield>
			<s:label key="PRIX" value="Prix" />
			<s:textfield id="PRIX" type="number" name="produitStock.prixPdt" cssClass="form-control" placeholder="prix" min="1" required="true"></s:textfield>
			<s:label key="QUANTITE" value="Quantité" />
			<s:textfield id="QUANTITE" type="number" name="produitStock.qtePdt" cssClass="form-control" placeholder="quantité" min="1" required="true"></s:textfield>
			<s:hidden name="editMode"></s:hidden>
			<center><s:submit value="Save" cssClass="btn btn-primary"></s:submit></center>
		</div>
	</s:form>
    </div>
  </div>
  </div>
  
  
  <div class="panel2">
  <div class="panel panel-primary">
    <div class="panel-heading"><center>Liste des produits de stock</center>
    
    </div>
    
    <div class="panel-body">
  
      <s:form method="post" action="downloadPDFFileAction">
		<s:submit cssClass="btn btn-success dol" value="Situation de Stock PDF" />
	</s:form>
  <div class="table-responsive">
  <table class="table">
		  <tr>
		  <th>code Produit </th><th>Nom</th><th>Descrp</th><th>Prix</th><th>Quantite</th><th>Supprimer</th><th>Modifier</th>
		  </tr>
		  <s:iterator value="listPStock">
		  <tr>
		  <td><s:property value="codePdt"/></td>
		  <td><s:property value="nomPdt"/></td>
		  <td><s:property value="descPdt"/></td>
		  <td><s:property value="prixPdt"/></td>
		  <td><s:property value="qtePdt"/></td>
		  <s:url namespace="/" action="delete" var="lien1">
		  <s:param name="codeP">
		  <s:property value="codePdt"/>
		  </s:param>
		  </s:url>
		  <s:url namespace="/" action="edit" var="lien2">
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