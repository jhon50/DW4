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
	<a href="NovoAdmin">Novo</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Senha</th>
			<th>Ações</th>
			
		</tr>
		<c:forEach var="administrador" items="${administradores}" >
			<tr>
				<td>${administrador.id}</td>			
				<td>${administrador.nome}</td>
				<td>${administrador.email}</td>
				<td>${administrador.senha}</td>
				<td>
					<a href="Visualizar?id=${administrador.id}">Visualizar</a>
					<a href="Editar?id=${administrador.id}">Editar</a>
					<a href="Excluir?id=${administrador.id}">Excluir</a>
				</td>				
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
