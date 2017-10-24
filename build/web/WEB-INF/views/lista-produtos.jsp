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
        <title>Lista de Produtos</title>
    </head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <body>
        <jsp:include page="header.jsp" />

        <table>
            <tr>
                <th>Categoria</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Comprar</th>
            </tr>
            <c:forEach var="produto" items="${produtos}" >
                <tr>
                <a href="index.jsp"></a>
                <td>${produto.categoria}</td>
                <td>${produto.nome}</td>
                <td>${produto.descricao}</td>
                <td>R$ ${produto.preco}</td>
                <td><a href="#">Comprar</a></td>
            </tr>

        </c:forEach>

    </table>
</body>
</html>
