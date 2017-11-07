<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Produto</title>
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

		if (form.categoria.value.length == 0) {
			alert("FAVOR SELECIONAR UMA CATEGORIA");
			form.categoria.focus();
			return false;
		}	
		
		if (form.nome.value.length == 0) {
			alert("FAVOR PREENCHER O CAMPO NOME");
			form.nome.focus();
			return false;
		}

		if (form.descricao.value.length == 0) {
			alert("FAVOR INSERIR UMA DESCRIÇÃO");
			form.descricao.focus();
			return false;
		}
		
		if (form.preco.value.length == 0) {
			alert("FAVOR INFORMAR O PREÇO DO PRODUTO");			
			form.preco.focus();
			return false;
		}

		return true;
	}	
	
</script>
<body>			
            <form action="IncluirProduto" method="post" id="form" name="form" onsubmit="return validarFormulario();">
	            <div>
		            <label for="categoria">Categoria:</label>
		            <select id="categoria" name="categoria" onblur="validaCampos(this,document.getElementById('aviso_categoria'))">
			            <option></option>
		            	<c:forEach var="categoria" items="${categorias}" >
		            		<option>${categoria.nome}</option>
		            	</c:forEach>
		            </select>
		            <br/>
		            <span id="aviso_categoria"></span>
	            </div>
	            <div>
		            <label for="nome">Nome:</label>
		            <input type="text" id="nome" name="nome" onblur="validaCampos(this,document.getElementById('aviso_nome'))" />
		            <br/>
		            <span id="aviso_nome"></span>
	            </div>
				<div>
		            <label for="descricao">Descrição:</label>
		            <textarea rows="5" cols="30" id="descricao" name="descricao" onblur="validaCampos(this,document.getElementById('aviso_descricao'))" ></textarea>
		            <br/>
		            <span id="aviso_descricao"></span>
				</div>
				<div>
		            <label for="preco">Preço:</label>
		            <input type="text" id="preco" name="preco" onblur="validaCampos(this,document.getElementById('aviso_preco'))" />
		            <br/>
		            <span id="aviso_preco"></span>
				</div>
	            <input type="submit" value="Adicionar" />
            </form>
</body>
</html>