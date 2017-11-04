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
		<thead>
			<tr>
				<th>Selecionar</th>
				<th>Nome</th>

			</tr>
		</thead>
		<tbody>
			<form>
				<c:forEach var="categoria" items="${categorias}">
					<tr>
						<td><input type="radio" id="${categoria.id}" name="option" />
						</td>
						<td><label for="${categoria.id}">${categoria.nome}</label></td>

					</tr>
				</c:forEach>
			</form>
		</tbody>
	</table>

</body>
</html>
