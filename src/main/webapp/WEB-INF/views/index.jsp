<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loja DW</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="style.css"> -->
</head>
<style>
body {
	font-family: "calibri", Garamond;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111111;
}

select[multiple] {
	width: 7em;
}

.button {
	font-size: 16px;
	background-color: #333333;
	text-align: center;
	border: none;
	color: white;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
}

.button.button-large {
	padding: 12px 30px;
}

.button.button-small {
	padding: 5px 15px;
}

.button:hover, .button-small:hover {
	background-color: grey;
}

.button:active, .button-small:active {
	background-color: lightgrey;
}

.container {
	width: 70%;
	margin: auto;
}

.container table {
	margin-top: 30px;
}

.action-buttons {
	margin-left: 20px;
}

table {
	width: 100%;
	text-align: center;
}

table tr {
	background-color: #c6c3c2;
}

table tr:first-child {
	background-color: lightgrey;
}


.row {
	width: 100%;
	display: inline-block;
	margin: 10px 0 10px 0
}

form input, textarea {
	float: right;
	margin-right: 50%;
	border: 1px solid black;
	border-radius: 5px;
	height: 25px;
}

form button {
	margin-top: 60px;
}

.error {
	border: 4px solid #9b001c;
}
</style>
<script type="text/javascript">
  function adiciona(id) {
    $.post("AdicionaCarrinho?Produto=" + id);
    alert("Produto adicionado ao carrinho");
  }
</script>
<body>
	<div class="container">
		<header>
			LOJA DW
			<a href="Login">Área Restrita</a>
			<br />
			<a href="Carrinho">Meu Carrinho</a>
		</header>
		<br /> <br />
		<ul>
			<c:forEach var="categoria" items="${categorias}">
				<li>
					<a href="?Categoria=${categoria.nome}">${categoria.nome}</a>
				</li>
			</c:forEach>
		</ul>
		<br /> <br />
			<form action="" method="post">
				<div class="row">
					<input type="text" id="nome" name="nome" />
					<input type="submit" value="Pesquisar" />
				</div>
			</form>
		<br /> <br />
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
						<td><a href="" onclick="adiciona(${produto.id})">Comprar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>