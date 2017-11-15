<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Categorias</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Categorias</h1>
		<a class="button button-large" href="IncluirCategoria">Adicionar</a>
		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="categoria" items="${categorias}">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.nome}</td>
					<td class="action-buttons">
						<a class="button button-small" href="VisualizarCategoria?id=${categoria.id}">Visualizar</a>
						<a class="button button-small" href="EditarCategoria?id=${categoria.id}">Editar</a>
						<a class="button button-small" href="ExcluirCategoria?id=${categoria.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
