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
			<th>Selecionar</th>
			<th>Nome</th>
			<th>Categoria</th>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
		<c:forEach var="produto" items="${produtos}">
			<tr>
				<td><input type="radio" id="${produto.id}" name="option" /></td>
				<td><label for="${produto.id}">${produto.nome}</label></td>
				<td>${produto.categoria}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
