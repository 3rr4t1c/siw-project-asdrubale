<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco Ordini</title>
</head>
<body>
	<f:view>
		<h:form>
			<ul>
				<li><h:commandLink action="adminProfile"
						value="Torna al profilo" /></li>
			</ul>
		</h:form>
		
		<table border="1" style="width: 300px">

				<caption>Lista Ordini - (Ordini Totali:
					${orderController.size})</caption>

				<tr>
					<th>ID:</th>
					<th>Cliente:</th>
					<th>Cognome:</th>
				</tr>
				
				<c:forEach var="order" items="#{orderController.allOrders}">
					<tr>
						<td><h:commandLink value="#{order.id}"
								action="#{orderController.goToAdminOrderDetails }">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
						<td>${order.cliente.nome}$</td>
						<td>${order.cliene.cognome}</td>
						<td><h:commandButton
								action="#{orderController.adminDeleteOrder}" value="Delete">
								<f:param name="id" value="#{order.id}" />
							</h:commandButton></td>
						<td><h:commandButton
								action="#{orderController.adminEvadiOrder}" value="Evadi">
								<f:param name="id" value="#{order.id}" />
							</h:commandButton></td>
					</tr>
				</c:forEach>

			</table>

	</f:view>
</body>
</html>
