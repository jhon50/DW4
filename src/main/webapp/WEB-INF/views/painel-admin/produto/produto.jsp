<%-- 
    Document   : produtos
    Created on : 28/10/2017, 01:40:20
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Produtos</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
	<h1>Produtos</h1>
	<a class="button button-large" href="IncluirProduto">Adicionar</a>
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
					<td><fmt:formatNumber value="${produto.preco}" type="currency"/></td>
					<td>
						<a class="button button-small" href="VisualizarProduto?id=${produto.id}">Visualizar</a>
						<a class="button button-small" href="EditarProduto?id=${produto.id}">Editar</a>
						<a class="button button-small" href="ExcluirProduto?id=${produto.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
