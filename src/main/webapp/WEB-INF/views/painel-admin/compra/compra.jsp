<%-- 
    Document   : compras
    Created on : 28/10/2017, 01:40:12
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel de Administração | Compras</title>
    </head>
    <body>
        <h1>Compras</h1>
        <br />
	<a href="Novocompra">Novo compra</a>
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
				<td>
					<a href="Visualizar?id=${compra.id}">Visualizar</a> 
					<a href="Editar?id=${compra.id}">Editar</a> 
					<a href="Excluir?id=${compra.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
    </body>
</html>
