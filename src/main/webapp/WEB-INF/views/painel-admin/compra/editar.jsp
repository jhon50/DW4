<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Editar compra</h1>
		<form action="EditarCompra" method="post">
			<input type="hidden" id="id" name="id" value="${compra.id}" />
			
			<div class="row">
				<label for="produto">Produto:</label>
				<select id="produto" name="produto">
					<option>${compra.produto}</option>
					<c:forEach var="produto" items="${produtos}">
						<option>${produto.nome}</option>
					</c:forEach>
				</select> <br /> <span id="aviso_produto"></span>
			</div>
			
			<div class="row">
				<label for="cliente">Cliente:</label>
				<select id="cliente" name="cliente">
					<option>${compra.clienteNome}</option>
					<c:forEach var="cliente" items="${clientes}">
						<option>${cliente.nome}</option>
					</c:forEach>
				</select> <br />
			</div>
			
			<div class="row">
				<label for="valor">Valor:</label>
				<input id="valor" name="valor" type="text" value="${compra.valor}" />
				<br />
			</div>
			
			<div class="row">
				<label for="data">Data:</label>
				<input id="data" name="data" type="text" value="<fmt:formatDate value="${compra.data.time}" pattern="dd/MM/yyyy"/>" />
				<br />
			</div>
			
			<button class="button button-large" type="submit" value="Alterar">Alterar</button>
		</form>
		<a class="button button-large" href="Compra">Retornar</a>
	</div>
</body>
</html>