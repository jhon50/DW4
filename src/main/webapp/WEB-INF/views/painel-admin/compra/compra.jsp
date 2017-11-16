<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Compras</title>
</head>
<body>
	<fmt:setLocale value="pt-BR" />
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Compras</h1>
		<br /> 
		<a class="button button-large" href="IncluirCompra">Adicionar</a>
		<table>
			<tr>
				<th>ID</th>
				<th>Cliente</th>
				<th>Valor Total</th>
				<th>Data</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="compra" items="${compras}">
				<tr>
					<td>${compra.numero}</td>
					<td>${compra.clienteNome}</td>
					<td><fmt:formatNumber value="${compra.valor}" type="currency"/></td>
					<td><fmt:formatDate value="${compra.data.time}" pattern="dd/MM/yyyy"/></td>
					<td class="action-buttons">
					<a class="button button-small" href="VisualizarCompra?id=${compra.id}">Visualizar</a>
					<a class="button button-small" href="EditarCompra?id=${compra.id}">Editar</a>
					<a class="button button-small" href="ExcluirCompra?id=${compra.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
