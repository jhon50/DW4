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
	<table>
		<tr>
			<th>ID</th>
			<th>Categoria</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
		<c:forEach var="produto" items="${produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.categoria}</td>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
