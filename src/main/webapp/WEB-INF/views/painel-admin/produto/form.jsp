<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LojaDW | Formulário Produto</title>
</head>
<body>			
            <form action="Produto" method="post">
	            <label for="categoria">Categoria:</label>
	            <select id="categoria" name="categoria">
	            	<c:forEach var="categoria" items="${categorias}" >
	            		<option>${categoria.nome}</option>
	            	</c:forEach>
	            </select>
	            <br/>
	            <label for="nome">Nome:</label>
	            <input type="text" id="nome" name="nome" />
	            <br/>
	            <label for="descricao">Descrição:</label>
	            <textarea rows="5" cols="30" id="descricao" name="descricao"></textarea>
	            <br/>
	            <label for="preco">Preço:</label>
	            <input type="text" id="preco" name="preco" />
	            <br/>
	            <input type="submit" value="Adicionar" />
            </form>
</body>
</html>