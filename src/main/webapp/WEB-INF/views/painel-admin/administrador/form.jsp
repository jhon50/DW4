<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Formulário Administrador</title>
</head>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">	
	<h1>Novo administrador</h1>
		<form action="IncluirAdmin" method="post" id="form_adm" name="form_adm" onsubmit="return validarFormulario();">
			<div class="row">
				<label for="nome">Nome:</label> 
				<input type="text" id="nome" name="nome" onblur="validaCampos(this,document.getElementById('aviso_nome'))" />
				<br /> 
				<span id="aviso_nome"></span>
			</div>
			<div class="row">
				<label for="email">Email:</label> 
				<input type="text" id="email" name="email" onblur="validaCampos(this,document.getElementById('aviso_email'))" />
				<br /> 
				<span id="aviso_email"></span> 
			</div>
			<div class="row">
				<label for="senha">Senha:</label> 
				<input type="password" id="senha" name="senha" onblur="validaCampos(this,document.getElementById('aviso_senha'))" />
				<br /> 
				<span id="aviso_senha"></span> 
			</div>
			<div class="row">
				<label for="rep_senha">Repetir a senha:</label>
				<input type="password" id="rep_senha" name="rep_senha" onblur="validaCampos(this,document.getElementById('aviso_repSenha'))" /> 
				<br />
				<span id="aviso_repSenha"></span> 
			</div>
			<button class="button button-large" onclick="validateForm()" type="button">Adicionar</button>
		</form>
	</div>
</body>
</html>