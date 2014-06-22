<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli</title>
</head>
<body>
	<f:view>

		<h:form>
			<ul>
				<li><h:commandLink
						action="#{customerController.goToAdminCustomersList}"
						value="Torna all'elenco clienti" /></li>
				<li><h:commandLink action="adminProfile"
						value="Torna al profilo" /></li>
				<li><h:commandLink action="#{customerController.goToAdminUpdateCustomer}"
						value="Modifica i dati di questo cliente" /></li>
			</ul>
		</h:form>

		<h1>Cliente: ${customerController.customer.nome}
			${customerController.customer.cognome}</h1>
		<h2>Dettagli cliente:</h2>
		<ul>
			<li>E-mail: ${customerController.customer.email}</li>
			<li>Nome: ${customerController.customer.nome}</li>
			<li>Cognome: ${customerController.customer.cognome}</li>
			<li>Data di nascita: <h:outputText
					value="#{customerController.customer.dataNascita}">
					<f:convertDateTime pattern="dd/MM/yyyy" />
				</h:outputText></li>
			<li>Data registrazione: <h:outputText
					value="#{customerController.customer.dataRegistrazione}">
					<f:convertDateTime pattern="dd/MM/yyyy HH:mm" />
				</h:outputText></li>
		</ul>
		<h3>Recapito cliente:</h3>
		<ul>
			<li>Indirizzo: ${customerController.customer.indirizzo.strada},
				${customerController.customer.indirizzo.cap},
				${customerController.customer.indirizzo.citta}</li>
			<li>Stato: ${customerController.customer.indirizzo.stato}</li>
			<li>Paese: ${customerController.customer.indirizzo.paese}</li>
		</ul>
	</f:view>
</body>
</html>
