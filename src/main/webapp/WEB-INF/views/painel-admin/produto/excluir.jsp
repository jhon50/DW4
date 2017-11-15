<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Excluir Produto</h1>
		<form action="ExcluirProduto" method="post">
			<input type="hidden" id="id" name="id" value="${produto.id}"
				readonly="true" />
			<div>
				<label for="nome">Categoria:</label> <input type="text"
					id="categoria" name="categoria" value="${produto.categoria}"
					readonly="true" /> <br />
			</div>
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" value="${produto.nome}" readonly="true" /> <br />
			</div>
			<div>
				<label for="email">Descrição:</label>
				<textarea rows="5" cols="30" id="descricao" name="descricao"
					readonly="true">${produto.descricao}</textarea>
				<br />
			</div>
			<div>
				<label for="senha">Preço:</label> <input type="text" id="preco"
					name="preco" value="${produto.preco}" readonly="true" /> <br />
			</div>
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