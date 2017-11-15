<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Compras</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Compras</h1>
		<br /> 
		<a class="button button-large" href="Novocompra">Adicionar</a>
		<table>
			<tr>
				<th>ID</th>
				<th>Produto</th>
				<th>Cliente</th>
				<th>Valor</th>
				<th>Data</th>
				<th>Ações</th>
			</tr>
			<c:forEach var="compra" items="${compras}">
				<tr>
					<td>${compra.id}</td>
					<td>${compra.produto}</td>
					<td>${compra.clienteNome}</td>
					<td>${compra.valor}</td>
					<td>${compra.data}</td>
					<td class="action-buttons">
					<a class="button button-small" href="Visualizar?id=${compra.id}">Visualizar</a>
					<a class="button button-small" href="Editar?id=${compra.id}">Editar</a>
					<a class="button button-small" href="Excluir?id=${compra.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
