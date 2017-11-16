<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Editar Compra</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Editar compra</h1>
		<form action="EditarCompra" method="post">
			<input type="hidden" id="id" name="id" value="${compras[0].numero}" />
						
			<div class="row">
				<label for="cliente">Cliente:</label>
				<select id="cliente" name="cliente">
					<option>${compras[0].clienteNome}</option>
					<c:forEach var="cliente" items="${clientes}">
						<option>${cliente.nome}</option>
					</c:forEach>
				</select> <br />
			</div>
			
			
			<div class="row">
				<label for="data">Data:</label>
				<input id="data" name="data" type="text" value="<fmt:formatDate value="${compras[0].data.time}" pattern="dd/MM/yyyy"/>" />
				<br />
			</div>
			
			<button class="button button-large" type="submit" value="Alterar">Alterar</button>
		</form>
		<a class="button button-large" href="Compra">Retornar</a>
	</div>
</body>
</html>