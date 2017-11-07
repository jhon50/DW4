<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Cliente/Editar" method="post">
		<input type="hidden" id="id" name="id" value="${cliente.id}" />
		<label>Nome:</label>
		<input type="text" value="${cliente.nome}" />
		<br />
		<label>Email:</label>
		<input type="text" value="${cliente.email}" />
		<br />
		<label>CPF:</label>
		<input type="text" value="${cliente.cpf}" />
		<br />
		<label>Cartão de Crédito:</label>
		<input type="text" value="${cliente.cartaoCredito}" />
		<br />
		<label>Senha:</label>
		<input type="password" value="${cliente.senha}" />
		<br />
		<label>Repetir a senha:</label>
		<input type="password" value="${cliente.repSenha}" />
		<br />
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>