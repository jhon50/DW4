<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EditarProduto" method="post">
		<input type="hidden" id="id" name="id" value="${produto.id}" />
		<div>
			<label for="categoria">Categoria:</label>
			<select id="categoria" name="categoria">
				<option>${produto.categoria}</option>
				<c:forEach var="categoria" items="${categorias}">
					<option>${categoria.nome}</option>
				</c:forEach>
			</select> <br />
		</div>
		<div>
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome" value="${produto.nome}" />
			<br />
		</div>
		<div>
			<label for="descricao">Descrição:</label>
			<textarea rows="5" cols="30" id="descricao" name="descricao" >${produto.descricao}</textarea>
			<br />
		</div>
		<div>
			<label for="preco">Preço:</label>
			<input type="text" id="preco" name="preco" value="${produto.preco}" />
			<br />
		</div>
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>