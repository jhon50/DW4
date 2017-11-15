<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Formulário Compra</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Novo compra</h1>
		<form action="IncluirCompra" method="post" id="form" name="form" onsubmit="return validarFormulario();">
			<div class="row">
				<label for="produto">Produto:</label>
				<select id="produto" name="produto" onblur="validaCampos(this,document.getElementById('aviso_produto'))">
					<option></option>
					<c:forEach var="produto" items="${produtos}">
						<option>${produto.nome}</option>
					</c:forEach>
				</select> <br /> <span id="aviso_produto"></span>
			</div>
			<div class="row">
				<label for="cliente">Cliente:</label>
				<select id="cliente" name="cliente" onblur="validaCampos(this,document.getElementById('aviso_cliente'))">
					<option></option>
					<c:forEach var="cliente" items="${clientes}">
						<option>${cliente.nome}</option>
					</c:forEach>
				</select> <br /> <span id="aviso_cliente"></span>
			</div>			
			<div class="row">
				<label for="valor">Valor:</label>
				<input type="text" id="valor" name="valor" onblur="validaCampos(this,document.getElementById('aviso_valor'))" />
				<br /> <span id="aviso_valor"></span>
			</div>
			<div class="row">
				<label for="data">Data:</label>
				<input type="text" id="data" name="data" onblur="validaCampos(this,document.getElementById('aviso_data'))" />
				<br /> <span id="aviso_data"></span>
			</div>
			<button class="button button-large" onclick="validateForm()" type="button">Adicionar</button>
		</form>
	</div>
</body>
</html>