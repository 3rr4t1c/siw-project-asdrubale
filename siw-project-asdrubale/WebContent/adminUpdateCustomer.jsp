<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica dati cliente</title>
</head>
<body>
	<f:view>

		<h:form>
			<ul>
				<li><h:commandLink action="adminProfile"
						value="Torna al profilo" /></li>
			</ul>
		</h:form>

		<h:form>
			<h:panelGrid columns="2" border="1" rules="all" title="mainGrid">

				<h:panelGrid columns="2" border="1" rules="all" title="customerGrid">
					<f:facet name="header">
						<h:outputText value="Inserisci i dati del cliente" />
					</f:facet>

					<h:outputText value="Nome: " />
					<h:inputText value="#{customerController.nome}" required="true"
						requiredMessage="Nome obbligatorio" />

					<h:outputText value="Cognome: " />
					<h:inputText value="#{customerController.cognome}" required="true"
						requiredMessage="Cognome obbligatorio" />

					<h:outputText value="E-mail: " />
					<h:inputText value="#{customerController.email}" required="true"
						requiredMessage="Indirizzo E-mail obbligatorio">
					</h:inputText>

					<h:outputText value="Password: " />
					<h:inputText value="#{customerController.password}" required="true"
						requiredMessage="Inserisci una password per questo cliente" />

					<h:outputText value="Data di nascita: " />
					<h:inputText value="#{customerController.dataNascita}">
						<f:convertDateTime pattern="dd-MM-yyyy" />
					</h:inputText>

				</h:panelGrid>

				<h:panelGrid columns="2" border="1" rules="all" title="addressGrid">
					<f:facet name="header">
						<h:outputText value="Inserisci il recapito del cliente" />
					</f:facet>

					<h:outputText value="Strada: " />
					<h:inputText value="#{customerController.strada}" />

					<h:outputText value="Città: " />
					<h:inputText value="#{customerController.citta}" />

					<h:outputText value="Stato: " />
					<h:inputText value="#{customerController.stato}" />

					<h:outputText value="Pese: " />
					<h:inputText value="#{customerController.paese}" />

					<h:outputText value="CAP: " />
					<h:inputText value="#{customerController.cap}" />

				</h:panelGrid>

				<f:facet name="footer">
					<h:commandButton value="Submit"
						action="#{customerController.adminUpdateCustomer}" />
				</f:facet>

			</h:panelGrid>

		</h:form>

		<h:messages style="color:red;margin:8px;" />

	</f:view>
</body>
</html>