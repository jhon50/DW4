<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Editar Administrador</h1>
	<form action="EditarAdmin" method="post">
		<input type="hidden" id="id" name="id" value="${administrador.id}" />
		<div>
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome" value="${administrador.nome}" />
			<br />
		</div>
		<div>
			<label for="email">Email:</label>
			<input type="text" id="email" name="email" value="${administrador.email}" />
			<br />
		</div>
		<div>
			<label for="senha">Senha:</label>
			<input type="text" id="senha" name="senha" value="${administrador.senha}" />
			<br />
		</div>
<!-- 		<div> -->
<!-- 			<label for="rep_senha">Repetir a senha:</label> -->
<!-- 			<input type="password" id="rep_senha" name="rep_senha" /> -->
<!-- 			<br /> -->
<!-- 		</div> -->
		<input type="submit" value="Alterar" />
	</form>
	<a href="Admin">Retornar</a>
</body>
</html>