<%-- 
    Document   : clientes
    Created on : 28/10/2017, 01:40:05
    Author     : Bruno Dutra
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Clientes</title>
</head>
<body>
	<h1>Clientes</h1>
	<br />
	<a href="IncluirCliente">Novo Cliente</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Email</th>
			<th>Senha</th>
			<th>Cartão de Crédito</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="cliente" items="${clientes}">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.cpf}</td>
				<td>${cliente.email}</td>
				<td>${cliente.senha}</td>
				<td>${cliente.cartao}</td>
				<td>
					<a href="VisualizarCliente?id=${cliente.id}">Visualizar</a>
					<a href="EditarCliente?id=${cliente.id}">Editar</a>
					<a href="ExcluirCliente?id=${cliente.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
