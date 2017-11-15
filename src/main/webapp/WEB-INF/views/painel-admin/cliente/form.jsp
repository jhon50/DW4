<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Cliente</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Novo cliente</h1>
		<form action="" method="post">
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
		<button class="button button-large" onclick="validateForm()" type="button">Adicionar</button>
	</form>
	</div>
</body>
</html>