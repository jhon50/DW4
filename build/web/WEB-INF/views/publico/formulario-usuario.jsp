<%-- 
    Document   : formulario-usuario
    Created on : 22/10/2017, 14:02:27
    Author     : Bruno Dutra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Usuários</title>
    </head>
    <body>
        <h1>Novo Usuário</h1>
        <form action="AdicionaUsuario" method="post">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome"/><br/>
            
            <label for="email">Email:</label>
            <input type="text" id="email" name="email"/><br/>
            
            <label for="cartaoCredito">Cartão de Crédito</label>
            <input type="text" id="cartaoCredito" name="cartaoCredito" /><br/>
            
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" /><br/>
            
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha"/><br/>
            
            <label for="rep_senha">Repitar a Senha:</label>
            <input type="password" id="rep_senha" name="rep_senha" /><br/>
            
            <input type="submit" value="Gravar" />
            
        </form>
    </body>
</html>
