<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de Administração | Formulário Categoria</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<jsp:include page="/master_layout.jsp" />
	<div class="container">
		<h1>Nova categoria</h1>
		<form action="IncluirCategoria" method="post" id="form" name="form">
			<div>
				<label for="nome">Nome:</label>
				<input type="text" id="nome" name="nome" />
				<br /> 
				<span id="aviso_nome"></span>
			</div>
			<span>${erro}</span>
			<br> 
			<button class="button button-large" onclick="validateForm()" type="button">Adicionar</button>
		</form>
	</div>
</body>
</html>