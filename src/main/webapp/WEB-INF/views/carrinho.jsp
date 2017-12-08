<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu Carrinho</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  function remove(id) {
    $.post("RemoveCarrinho?Produto=" + id);
  }
</script>
<body>
	<div>
		<table>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th></th>
			</tr>
			<c:set var="total" value="${0}" />
			<c:forEach var="produto" items="${produtos}">
				<c:set var="total" value="${total + produto.preco}" />
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td><fmt:formatNumber value="${produto.preco}" type="currency" /></td>
					<td><a href="" onclick="remove(${produto.id})">Remover</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td>Total: <fmt:formatNumber value="${total}" type="currency" /></td>
			</tr>
		</table>
		<br/>
		<a href="FinalizaCompra">Finalizar Comprar</a>
		<br/>
		<a href="/LojaDW">Retornar as Compras</a>
	</div>
</body>
</html>