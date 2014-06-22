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

			<table border="1">

				<caption>Anagrafica Clienti - Clienti Totali:
					${customerController.sizeOfCustomers}</caption>

				<tr>
					<th>ID:</th>
					<th>Nome:</th>
					<th>Data Registrazione</th>
				</tr>

				<c:forEach var="customer" items="#{customerController.allCustomers}">
					<tr>
						<td>${customer.id}</td>
						<td><h:commandLink value="#{customer.nome}"
								action="#{customerController.goToAdminCustomerDetails}">
								<f:setPropertyActionListener value="#{customer}"
									target="#{customerController.customer}" />
							</h:commandLink></td>
						<td><h:outputText value="#{customer.dataRegistrazione}">
								<f:convertDateTime pattern="dd.MM.yyyy HH:mm" />
							</h:outputText></td>
						<td><h:commandButton
								action="#{customerController.adminDeleteCustomer}"
								value="Delete">
								<f:setPropertyActionListener value="#{customer}"
									target="#{customerController.customer}" />
							</h:commandButton></td>
						<td><h:commandButton
								action="#{customerController.goToAdminUpdateCustomer}"
								value="Update">
								<f:setPropertyActionListener value="#{customer}"
									target="#{customerController.customer}" />
							</h:commandButton></td>
					</tr>
				</c:forEach>

			</table>

		</h:form>

	</f:view>
</body>
</html>