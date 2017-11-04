<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Categoria</title>
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

		if (form.nome.value.length == 0) {
			alert("FAVOR PREENCHER O CAMPO NOME");
			form.nome.focus();
			return false;
		}

		return true;
	}	
	
</script>


<body>
            <form action="Categoria" method="post" id="form" name="form" onsubmit="return validarFormulario();">
	            <div>
	    	        <label for="nome">Nome:</label>
		            <input type="text" id="nome" name="nome" onblur="validaCampos(this,document.getElementById('aviso_nome'))" />
		            <br/>
		            <span id="aviso_nome"></span>
	            </div>	            
	            <input type="submit" value="Adicionar" />
            </form>
</body>
</html>