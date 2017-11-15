<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Produto</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Novo produto</h1>
		<form action="IncluirProduto" method="post" id="form" name="form" onsubmit="return validarFormulario();">
			<div class="row">
				<label for="categoria">Categoria:</label>
				<select id="categoria" name="categoria" onblur="validaCampos(this,document.getElementById('aviso_categoria'))">
					<option></option>
					<c:forEach var="categoria" items="${categorias}">
						<option>${categoria.nome}</option>
					</c:forEach>
				</select> <br /> <span id="aviso_categoria"></span>
			</div>
			<div class="row">
				<label for="nome">Nome:</label>
				<input type="text" id="nome" name="nome" onblur="validaCampos(this,document.getElementById('aviso_nome'))" />
				<br /> <span id="aviso_nome"></span>
			</div>
			<div class="row">
				<label for="descricao">Descrição:</label>
				<textarea rows="5" cols="30" id="descricao" name="descricao" onblur="validaCampos(this,document.getElementById('aviso_descricao'))"></textarea>
				<br /> <span id="aviso_descricao"></span>
			</div>
			<div class="row">
				<label for="preco">Preço:</label>
				<input type="text" id="preco" name="preco" onblur="validaCampos(this,document.getElementById('aviso_preco'))" />
				<br /> <span id="aviso_preco"></span>
			</div>
			<button class="button button-large" onclick="validateForm()" type="button">Adicionar</button>
		</form>
	</div>
</body>
</html>