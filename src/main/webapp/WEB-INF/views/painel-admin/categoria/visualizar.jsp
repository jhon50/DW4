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

		<h1>Dados da Categoria</h1>
		<form action="Categoria" method="post">
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" value="${categoria.nome}" readonly="true" /> <br />
			</div>
		</form>
		<a class="button button-large" href="Categoria">Retornar</a>
	</div>
</body>
</html>