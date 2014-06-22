<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Prodotto</title>
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
		
			<h:panelGrid columns="2" border="1" rules="all" title="productGrid">

				<f:facet name="header">
					<h:outputText value="Inserisci i dati del prodotto" />
				</f:facet>

				<h:outputText value="Nome: " />
				<h:inputText value="#{productController.name}" required="true"
					requiredMessage="Inserire un nome per il prodotto" />

				<h:outputText value="Quantità: " />
				<h:inputText value="#{productController.quantity}" required="true"
					requiredMessage="Inserire le unità di prodotto disponibili"
					validatorMessage="Inserisci una quantià seria per favore">
					<f:validateLongRange minimum="1" maximum="9999" />
				</h:inputText>

				<h:outputText value="Prezzo: " />
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Inserire un prezzo per il prodotto">
					<f:validator validatorId="priceValidator" />
				</h:inputText>

				<h:outputText value="Codice: " />
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Codice obbligatorio"
					validatorMessage="Il codice deve avere minimo 3 e massimo 6 caratteri"
					style="text-transform:uppercase">
					<f:validateLength minimum="3" maximum="6" />
				</h:inputText>

				<h:outputText value="Descrizione: " />
				<h:inputTextarea value="#{productController.desc}" required="false"
					rows="5" cols="15" />

				<f:facet name="footer">
					<h:commandButton value="Submit"
						action="#{productController.adminCreateNewProduct}" />
				</f:facet>

			</h:panelGrid>

		</h:form>

		<h:messages style="color:red;margin:8px;" />

	</f:view>
</body>
</html>