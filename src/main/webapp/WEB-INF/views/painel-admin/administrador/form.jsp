<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Administrador</title>
</head>
<script type="text/javascript">

function validarSenha(){
	
	senha = document.form_adm.senha.value;
	rep_senha = document.form_adm.rep_senha.value;
    if (senha != rep_senha){ 
         alert("SENHAS DIFERENTES!\\nFAVOR DIGITAR SENHAS IGUAIS");
         return false;
    }
    return true;
}

</script>
<body>
            <form action="Admin" method="post" id="form_adm" name="form_adm" onsubmit="return validarSenha();" >
	            <label for="nome">Nome:</label>
	            <input type="text" id="nome" name="nome" />
	            <br/>
	            <label for="email">Email:</label>
	            <input type="text" id="email" name="email" />
	            <br/>
	            <label for="senha">Senha:</label>
	            <input type="password" id="senha" name="senha"  />
	            <br/>
	            <label for="rep_senha">Repetir a senha:</label>
	            <input type="password" id="rep_senha" name="rep_senha" />
	            <br/>
	            <input type="submit" value="Adicionar" />
            </form>
</body>
</html>