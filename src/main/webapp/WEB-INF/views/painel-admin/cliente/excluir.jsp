<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excluir Cliente</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<form action="ExcluirCliente" method="post">
			<input type="hidden" id="id" name="id" value="${cliente.id}" /> <label>Nome:</label>
			<input type="text" value="${cliente.nome}" readonly="true" /> <br />
			<label>Email:</label> <input type="text" value="${cliente.email}"
				readonly="true" /> <br /> <label>CPF:</label> <input type="text"
				value="${cliente.cpf}" readonly="true" /> <br /> <label>Cartão
				de Crédito:</label> <input type="text" value="${cliente.cartao}"
				readonly="true" /> <br /> <label>Senha:</label> <input type="text"
				value="${cliente.senha}" readonly="true" /> <br />
			<div class="row"></div>
			<button class="button button-large" type="submit"
				value="Confirmar exclusão">Confirmar exclusão</button>

		</form>
		<div class="row">
			<a class="button button-large" href="Cliente">Retornar</a>
		</div>
	</div>
</body>
</html>