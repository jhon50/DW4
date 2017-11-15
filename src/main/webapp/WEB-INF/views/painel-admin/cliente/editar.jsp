<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Editar Cliente</h1>
		<form action="EditarCliente" method="post">
			<input type="hidden" id="id" name="id" value="${cliente.id}" />
			<div>
				<label for="nome">Nome:</label>
				<input id="nome" name="nome" type="text" value="${cliente.nome}" />
				<br />
			</div>
			<div>
				<label for="email">Email:</label>
				<input id="email" name="email" type="text" value="${cliente.email}" />
				<br />
			</div>
			<div>
				<label for="cpf">CPF:</label>
				<input id="cpf" name="cpf" type="text" value="${cliente.cpf}" />
				<br />
			</div>
			<div>
			<label for="cartaoCredito">Cartão de Crédito:</label>
			<input id="cartaoCredito" name="cartaoCredito" type="text" value="${cliente.cartao}" />
			<br />
			</div>
			<div>
				<label for="senha">Senha:</label>
				<input id="senha" name="senha" type="text" value="${cliente.senha}" />
				<br />
			</div>
			<!-- 		<label>Repetir a senha:</label> -->
			<%-- 		<input type="password" value="${cliente.repSenha}" /> --%>
			<!-- 		<br /> -->
			<input type="submit" value="Alterar" />
		</form>
		<a href="Cliente">Retornar</a>
	</div>	
</body>
</html>