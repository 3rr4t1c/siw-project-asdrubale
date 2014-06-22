<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo Prodotti</title>
</head>
<body>
	<f:view>

		<h:form>
		
			<ul>
				<li><h:commandLink action="adminProfile"
						value="Torna al profilo" /></li>
			</ul>

			<table border="1" style="width: 300px">

				<caption>Catalogo Prodotti - (Prodotti Totali:
					${productController.sizeOfProducts})</caption>

				<tr>
					<th>Nome:</th>
					<th>Prezzo:</th>
					<th>Codice:</th>
				</tr>
				
				<c:forEach var="product" items="#{productController.allProducts}">
					<tr>
						<td><h:commandLink value="#{product.name}"
								action="#{productController.goToAdminProductDetails }">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.price}$</td>
						<td>${product.code}</td>
						<td><h:commandButton
								action="#{productController.adminDeleteProduct}" value="Delete">
								<f:param name="id" value="#{product.id}" />
							</h:commandButton></td>
						<td><h:commandButton
								action="#{productController.goToAdminUpdateProduct}" value="Update">
								<f:param name="id" value="#{product.id}" />
							</h:commandButton></td>
					</tr>
				</c:forEach>

			</table>

		</h:form>

	</f:view>
</body>
</html>
