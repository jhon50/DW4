<%-- 
    Document   : formulario-produtos.jsp
    Created on : 22/10/2017, 14:02:11
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Produto</title>
    </head>
    <body>
        <h1>Novo Produto</h1>
        <form action="produto?logica=Adiciona" method="post">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" /><br/>
            
            <label for="categoria">Categoria:</label>
            <select id="categoria" name="categoria">
                <option>Eletrodomesticos</option>
                <option>Eletroportaveis</option>
                <option>Informatica</option>
                <option>Smartphones</option>
            </select><br/>
            
            <label for="descricao">Descrição:</label><br/>
            <textarea id="descricao" name="descricao" rows="5" cols="100"></textarea><br/>
            
            <label for="preco">Preço:</label>
            <input type="text" id="preco" name="preco" /><br/>
            
            <input type="submit" value="Gravar" />
        </form>
    </body>
</html>
