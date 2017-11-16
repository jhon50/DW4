<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Visualizar Compra</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Visualizar compra</h1>
		<form action="VisualizarCompra" method="post">
			<div class="row">
				<label for="Produtos">Produtos:</label>
				<c:forEach var="compra" items="${compras}">
					<br />
					<li>${compra.produto}</li>
				</c:forEach>
			</div>
			<div class="row">
				<label for="cliente">Cliente:</label>
				<input type="text" value="${compras[0].clienteNome}" readonly="true" />
			</div>
			<div class="row">
				<label>Valor:</label>
				<c:set var="total" value="${0}" />
				<c:forEach var="compra" items="${compras}">
					<c:set var="total" value="${total + compra.valor}" />
				</c:forEach>
				<input type="text" value="<fmt:formatNumber value="${total}" type="currency"/>" readonly="true" />
				<br />
			</div>
			<div class="row">
				<label for="data">Data:</label>
				<fmt:formatDate value="${compras[0].data.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
				<input type="text" readonly="true" value="${dataFormatada}" />
				<br />
			</div>
		</form>
		<a class="button button-large" href="Compra">Retornar</a>
</body>
</html>