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
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Administradores</h1>
		<a class="button button-large" href="IncluirAdmin">Adicionar</a>
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="administrador" items="${administradores}">
				<tr>
					<td>${administrador.id}</td>
					<td>${administrador.nome}</td>
					<td>${administrador.email}</td>
					<td>${administrador.senha}</td>
					<td><a class="button button-small" href="VisualizarAdmin?id=${administrador.id}">Visualizar</a>
						<a class="button button-small" href="EditarAdmin?id=${administrador.id}">Editar</a>
						<a class="button button-small" href="ExcluirAdmin?id=${administrador.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
