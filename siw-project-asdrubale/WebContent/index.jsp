<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<title>!!! Benvenuto !!!</title>
</head>
<body>
	<f:view>
		<h1>Asdrubale Store Home Page</h1>

		<h:panelGrid columns="2" border="1" rules="all" title="mainGrid">

			<f:facet name="header">
				<h:outputText value="ACCEDI" />
			</f:facet>

			<h:form>
				<h:panelGrid columns="2" border="1" rules="all" title="customerGrid">

					<f:facet name="header">
						<h:outputText value="Area Clienti login" />
					</f:facet>

					<h:outputText value="E-Mail: " />
					<h:inputText value="#{customerController.email}" required="true"
						requiredMessage="Campo E-Mail mancante"
						validatorMessage="Immetti una mail valida invece di perdere tempo">
						<f:validateRegex pattern="([^.@]+)(\.[^.@]+)*@([^.@]+\.)+([^.@]+)" />
					</h:inputText>

					<h:outputText value="Password: " />
					<h:inputSecret value="#{customerController.password}"
						required="true" requiredMessage="Campo password mancante" />

					<f:facet name="footer">
						<h:commandButton value="Submit"
							action="#{customerController.customerLogin}" />
					</f:facet>

				</h:panelGrid>
			</h:form>

			<h:form>
				<h:panelGrid columns="2" border="1" rules="all" title="adminGrid">

					<f:facet name="header">
						<h:outputText value="Area Amministrazione login" />
					</f:facet>

					<h:outputText value="Username: " />
					<h:inputText value="#{adminController.username}" required="true"
						requiredMessage="Campo username mancante" />

					<h:outputText value="Password: " />
					<h:inputSecret value="#{adminController.password}" required="true"
						requiredMessage="Campo password mancante" />

					<f:facet name="footer">
						<h:commandButton value="Submit"
							action="#{adminController.adminLogin}" />
					</f:facet>

				</h:panelGrid>
			</h:form>

			<f:facet name="footer">
				<h:form>
					<h:commandButton action="#{productController.goToUserProductsList}"
						value="Vai al catalogo prodotti" />
				</h:form>
			</f:facet>

		</h:panelGrid>

		<h:messages style="color:red;margin:8px;" />
	</f:view>
</body>
</html>