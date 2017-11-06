<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Cliente/Editar" method="post">
		<label>Nome:</label>
		<input type="text" value="${contato.nome}" />
		<br />
		<label>Email:</label>
		<input type="text" value="${contato.email}" />
		<br />
		<label>CPF:</label>
		<input type="text" value="${contato.cpf}" />
		<br />
		<label>Cartão de Crédito:</label>
		<input type="text" value="${contato.cartaoCredito}" />
		<br />
		<label>Senha:</label>
		<input type="password" value="${contato.senha}" />
		<br />
		<label>Repetir a senha:</label>
		<input type="password" value="${contato.repSenha}" />
		<br />
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>