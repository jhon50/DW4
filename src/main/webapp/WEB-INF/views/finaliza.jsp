<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="container">
		<h1>Dados do cliente</h1>
		<form action="FinalizaCompra" method="post" id="form" name="form">
			<div class="row">
				<label for="nome">Nome:</label>
				<input id="nome" name="nome" type="text" />
			</div>
			<div class="row">
				<label for="email">Email:</label>
				<input id="email" name="email" type="text" />
			</div>
			<div class="row">
				<label for="cpf">CPF:</label>
				<input id="cpf" name="cpf" type="text" />
			</div>
			<div class="row">
				<label for="cartaoCredito">Cartão de Crédito:</label>
				<input id="cartaoCredito" name="cartaoCredito" type="text" />
			</div>
			<div class="row">
				<label for="senha">Senha:</label>
				<input id="senha" name="senha" type="password" />
			</div>
			<div class="row">
				<label for="rep_senha">Repetir a senha:</label>
				<input id="rep_senha" name="rep_senha" type="password" />
			</div>
			<input type="submit" value="COMPRAR" />
		</form>
	</div>
</body>
</html>