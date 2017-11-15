<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualizar Administrador</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">

		<h1>Dados do Administrador</h1>
		<form action="Admin" method="post">
			<input type="hidden" id="nome" name="nome"
				value="${administrador.id}" readonly="true" />
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" value="${administrador.nome}" readonly="true" /> <br />
			</div>
			<div>
				<label for="email">Email:</label> <input type="text" id="email"
					name="email" value="${administrador.email}" readonly="true" /> <br />
			</div>
			<div>
				<label for="senha">Senha:</label> <input type="text" id="senha"
					name="senha" value="${administrador.senha}" readonly="true" /> <br />
			</div>
		</form>
		<a class="button button-large" href="Admin">Retornar</a>
	</div>
</body>
</html>