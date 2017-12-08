<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	margin-right:50%;
	border:1px solid black;
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
<body>
	<div class="container">
		<h1>Dados do cliente</h1>
		<form action="FinalizaCompra" method="post" id="form" name="form">
			<div class="row">
				<label for="nome">Nome:</label>
				<input id="nome" name="nome" type="text" required/>
			</div>
			<div class="row">
				<label for="email">Email:</label>
				<input id="email" name="email" type="text" required/>
			</div>
			<div class="row">
				<label for="cpf">CPF:</label>
				<input id="cpf" name="cpf" type="text" required/>
			</div>
			<div class="row">
				<label for="cartaoCredito">Cartão de Crédito:</label>
				<input id="cartaoCredito" name="cartaoCredito" type="text" required/>
			</div>
			<div class="row">
				<label for="senha">Senha:</label>
				<input id="senha" name="senha" type="password" required/>
			</div>
			<div class="row">
				<label for="rep_senha">Repetir a senha:</label>
				<input id="rep_senha" name="rep_senha" type="password" required/>
			</div>
			<input type="submit" value="COMPRAR" />
		</form>
	</div>
</body>
</html>