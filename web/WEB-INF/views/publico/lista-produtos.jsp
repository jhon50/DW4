<%-- 
    Document   : lista-produtos
    Created on : 22/10/2017, 15:52:43
    Author     : Bruno Dutra
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Produtos</title>
        <link href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">      
            <br/>
            <div class="page-header">
                <h1>Lista de Produtos</h1>
            </div>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Preço</th>
                        <th scope="col">Comprar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${produtos}" >
                        <tr>
                            <td scope="row">${produto.id}</td>
                            <td>${produto.categoria}</td>
                            <td>${produto.nome}</td>
                            <td>${produto.descricao}</td>
                            <td>R$ ${produto.preco}</td>
                            <td><a href="#">Comprar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
