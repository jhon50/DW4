<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loja DW</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<script type="text/javascript">
  function adiciona(id) {
    $.post("AdicionaCarrinho?Produto=" + id);
  }
</script>
<body>
	<header>
		LOJA DW
		<a href="Login">Área Restrita</a>
		<br/>
		<a href="Carrinho">Meu Carrinho</a>
	</header>
	<br />
	<br />
		<ul>
		<c:forEach var="categoria" items="${categorias}">
			<li><a href="?Categoria=${categoria.nome}">${categoria.nome}</a></li>		
	</c:forEach>
		</ul>
	
	<br />
	<br />
	<div>
		<form action="" method="post">
			<input type="text" id="nome" name="nome" />
			<input type="submit" value="Pesquisar" />
		</form>
	</div>
	<br />
	<br />
	<div>
		<table>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th></th>
			</tr>
			<c:forEach var="produto" items="${produtos}">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td><fmt:formatNumber value="${produto.preco}" type="currency" /></td>
					<td><a href="" onclick="adiciona(${produto.id})" >Comprar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>