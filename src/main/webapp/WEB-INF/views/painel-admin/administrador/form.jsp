<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Administrador</title>
</head>
<script type="text/javascript">
	
	function validaCampos(campoEntrada,textoMsg){

	   if(campoEntrada.value.length == 0 ){
	      textoMsg.innerHTML = "Campo Obrigatório";
	   } 
	   
	   else{
	     textoMsg.innerHTML = "";    
	  }

	}
		
	function validarFormulario() {

		if (form_adm.nome.value.length == 0) {
			alert("FAVOR PREENCHER O CAMPO NOME");
			form_adm.nome.focus();
			return false;
		}

		if (form_adm.email.value.length == 0) {
			alert("FAVOR PREENCHER O CAMPO EMAIL");
			form_adm.email.focus();
			return false;
		}
		
		if (form_adm.senha.value.length == 0) {
			alert("FAVOR PREENCHER O CAMPO SENHA");			
			form_adm.senha.focus();
			return false;
		}

		if (form_adm.senha.value != form_adm.rep_senha.value) {
			alert("SENHAS DIFERENTES! \nFAVOR DIGITAR SENHAS IGUAIS");
			form_adm.rep_senha.focus();
			return false;
		}
		return true;
	}
	
</script>
<body>
	<form action="Admin" method="post" id="form_adm" name="form_adm" onsubmit="return validarFormulario();">
		<div>
			<label for="nome">Nome:</label> 
			<input type="text" id="nome"name="nome" onblur="validaCampos(this,document.getElementById('aviso_nome'))" />
			<br /> 
			<span id="aviso_nome"></span>
		</div>
		<div>
			<label for="email">Email:</label> 
			<input type="text" id="email" name="email" onblur="validaCampos(this,document.getElementById('aviso_email'))" />
			<br /> 
			<span id="aviso_email"></span> 
		</div>
		<div>
			<label for="senha">Senha:</label> 
			<input type="password" id="senha" name="senha" onblur="validaCampos(this,document.getElementById('aviso_senha'))" />
			<br /> 
			<span id="aviso_senha"></span> 
		</div>
		<div>
			<label for="rep_senha">Repetir a senha:</label>
			<input type="password" id="rep_senha" name="rep_senha" onblur="validaCampos(this,document.getElementById('aviso_repSenha'))" /> 
			<br />
			<span id="aviso_repSenha"></span> 
		</div>
		<input type="submit" value="Adicionar" />
	</form>
</body>
</html>