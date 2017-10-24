/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.logica.produto;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno Dutra
 */
public class Lista implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Connection connection = (Connection) request.getAttribute("conexao");
        String categoria = request.getParameter("categoria");
        if (categoria != null) {
            List<Produto> produtos = new ProdutoDAO(connection).getListaCategoria(categoria);
            request.setAttribute("produtos", produtos);
            return "/WEB-INF/views/lista-produtos.jsp";
        } else {
            String nomeProduto = request.getParameter("nomeProduto");
            if (nomeProduto != null) {
                List<Produto> produtos = new ProdutoDAO(connection).getListaPorNome(nomeProduto);
                request.setAttribute("produtos", produtos);
                return "/WEB-INF/views/lista-produtos.jsp";
            } else {
                List<Produto> produtos = new ProdutoDAO(connection).getLista();
                request.setAttribute("produtos", produtos);
                return "/WEB-INF/views/lista-produtos.jsp";
            }

        }

    }

}
