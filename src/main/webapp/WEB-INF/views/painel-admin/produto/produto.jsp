<%-- 
    Document   : produtos
    Created on : 28/10/2017, 01:40:20
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Produtos</title>
</head>
<body>
	<h1>Produtos</h1>
	<a href="NovoProduto">Novo Produto</a>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Categoria</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="produto" items="${produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.categoria}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
				<td>
					<a href="Visualizar?id=${produto.id}">Visualizar</a>
					<a href="Editar?id=${produto.id}">Editar</a>
					<a href="Excluir?id=${produto.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
