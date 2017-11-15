<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Categoria</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Editar Categoria</h1>
		<form action="EditarCategoria" method="post">
			<input type="hidden" id="id" name="id" value="${categoria.id}" />
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" value="${categoria.nome}" /> <br />
			</div>
			<button class="button button-large" type="submit"
				value="Alterar">Alterar</button>
		</form>
		<a class="button button-large" href="Categoria">Retornar</a>
	</div>

</body>
</html>