/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.logica.produto;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno Dutra
 */
public class Remove implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));

        Produto produto = new Produto();
        produto.setId(id);

        Connection connection  = (Connection) request.getAttribute("conexao");
        ProdutoDAO dao = new ProdutoDAO(connection);
        dao.remove(produto);

        return "produto?logica=Lista";

    }

}
