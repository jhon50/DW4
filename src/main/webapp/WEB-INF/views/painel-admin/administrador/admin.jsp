<%-- 
    Document   : administradores
    Created on : 28/10/2017, 01:40:30
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Administradores</title>
</head>
<body>
	<h1>Administradores</h1>
	<a href="NovoAdmin">Novo Administrador</a>
	<table>
		<tr>
			<th>Selecionar</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Senha</th>
			
		</tr>
		<c:forEach var="administrador" items="${administradores}" >
			<tr>
				<td><input type="radio" id="${administrador.id}" name="option" /></td>
				<td><label for="${administrador.id}">${administrador.nome}</label></td>
				<td>${administrador.email}</td>
				<td>${administrador.senha}</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>
