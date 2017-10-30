<%-- 
    Document   : index
    Created on : 28/10/2017, 01:37:33
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	font-family: arial, helvetica, sans-serif;
	font-size: 12px;
}

.menu {
	list-style: none;
	border: 1px solid #c0c0c0;
	float: left;
}

.menu li {
	position: relative;
	float: left;
	border-right: 1px solid #c0c0c0;
}

.menu li a {
	color: #333;
	text-decoration: none;
	padding: 5px 10px;
	display: block;
}

.menu li a:hover {
	background: #333;
	color: #fff;
	-moz-box-shadow: 0 3px 10px 0 #CCC;
	-webkit-box-shadow: 0 3px 10px 0 #ccc;
	text-shadow: 0px 0px 5px #fff;
}

.menu li  ul {
	position: absolute;
	top: 25px;
	left: 0;
	background-color: #fff;
	display: none;
}

.menu li:hover ul, .menu li.over ul {
	display: block;
}

.menu li ul li {
	border: 1px solid #c0c0c0;
	display: block;
	width: 150px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração</title>
</head>
<body>
	<h1>Painel de Administração</h1>
	<ul class="menu">
		<li>
			<a href="categoria/categoria.jsp">Categorias</a>
			<ul>
				<li><a href="#">Exibir todas</a></li>
				<li><a href="#">Adicionar</a></li>
				<li><a href="#">Atualizar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</li>

		<li>
			<a href="cliente/cliente.jsp">Clientes</a>
			<ul>
				<li><a href="#">Exibir todos</a></li>
				<li><a href="#">Adicionar</a></li>
				<li><a href="#">Atualizar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</li>
		<li>
			<a href="compra/compra.jsp">Compras</a>
			<ul>
				<li><a href="#">Exibir todas</a></li>
				<li><a href="#">Adicionar</a></li>
				<li><a href="#">Atualizar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</li>
		<li>
			<a href="produto/produto.jsp">Produtos</a>
			<ul>
				<li><a href="#">Exibir todos</a></li>
				<li><a href="#">Adicionar</a></li>
				<li><a href="#">Atualizar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</li>
		<li>
			<a href="administrador/admin.jsp">Administradores</a>
			<ul>
				<li><a href="#">Exibir todos</a></li>
				<li><a href="#">Adicionar</a></li>
				<li><a href="#">Atualizar</a></li>
				<li><a href="#">Remover</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>
