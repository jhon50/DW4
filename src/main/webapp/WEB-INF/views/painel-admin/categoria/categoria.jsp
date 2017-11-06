<%-- 
    Document   : categorias
    Created on : 28/10/2017, 01:39:55
    Author     : Bruno Dutra
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Categorias</title>
</head>
<body>
	<h1>Categorias</h1>
	<a href="NovaCategoria">Nova Categoria</a>
	<table>
		<tr>

			<th>ID</th>
			<th>Nome</th>

		</tr>
		<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.id}</td>
				<td>${categoria.nome}</td>
				<td><a href="Visualizar?id=${categoria.id}">Visualizar</a> <a
					href="Editar?id=${categoria.id}">Editar</a> <a
					href="Excluir?id=${categoria.id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
