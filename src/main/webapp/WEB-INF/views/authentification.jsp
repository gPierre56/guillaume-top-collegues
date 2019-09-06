<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- pas besoin de définir une action, celle par défaut convient --%>
	<form:form method="post" action = "/auth" modelAttribute="infos">
		<table>
			<tr>
				<td>Nom d'utilisateur ;</td>
				<td><form:input path="nomUtilisateur" /></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><form:input path="motDePasse" /></td>
			</tr>
		</table>
		<input type = "submit" value = "valider"/>
	</form:form>
</body>
</html>