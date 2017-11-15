<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Excluir Categoria</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Excluir Categoria</h1>
		<form action="ExcluirCategoria" method="post">
			<div>
				<label for="nome">Nome:</label> <input type="hidden" id="id"
					name="id" value="${categoria.id}" /> <input type="text" id="nome"
					name="nome" value="${categoria.nome}" readonly="true" /> <br />
			</div>
			<div class="row"></div>
			<button class="button button-large" type="submit"
				value="Confirmar exclusão">Confirmar exclusão</button>

		</form>
		<div class="row">
			<a class="button button-large" href="Categoria">Retornar</a>
		</div>
	</div>
</body>
</html>