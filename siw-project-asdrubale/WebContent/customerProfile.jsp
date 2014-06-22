<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo Cliente</title>
</head>
<body>
	<f:view>
		<h1>Welcome: ${customerController.nome}</h1>
		<ul>
			<li><h:form>
					<h:commandLink action="#{productController.goToCustomerProductsList}"
						value="Vai al catalogo prodotti" />
				</h:form></li>
			<li><h:form>
					<h:commandLink action="#{orderController.goToCustomerOrdersList}"
						value="Visualizza ordini effettuati" />
				</h:form></li>
			<li><h:form>
					<h:commandLink action="#{orderController.goToCustomerNewOrder}"
						value="Crea nuovo ordine" />
				</h:form></li>
			<li><h:form>
					<li><h:commandLink action="#{customerController.customerLogout}"
							value="Esci dal sistema" />
				</h:form></li>
		</ul>
	</f:view>
</body>
</html>