<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli prodotto</title>
</head>
<body>
	<f:view>

		<h:form>
			<ul>
				<li><h:commandLink
						action="#{productController.goToAdminProductsList}"
						value="Torna al catalogo prodotti" /></li>
				<li><h:commandLink action="adminProfile"
						value="Torna al profilo" /></li>
				<li><h:commandLink
						action="#{productController.goToAdminUpdateProduct}"
						value="Modifica i dati di questo prodotto">
						<f:param name="id" value="#{productController.product.id}" />
					</h:commandLink></li>
			</ul>
		</h:form>
		<h1>Nome prodotto: ${productController.product.name}</h1>
		<h2>Dettagli prodotto:</h2>
		<ul>
			<li>Codice: ${productController.product.code}</li>
			<li>Quantità: ${productController.product.quantity}</li>
			<li>Prezzo: ${productController.product.price}</li>
			<li>Descrizione: ${productController.product.description}</li>
		</ul>
	</f:view>
</body>
</html>
