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
public class Adiciona implements Logica {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();
        produto.setNome(request.getParameter("p_nome"));
        produto.setCategoria(request.getParameter("p_categoria"));
        produto.setDescricao(request.getParameter("p_descricao"));
        produto.setPreco(Double.parseDouble(request.getParameter("p_preco")));
        
        Connection connection  = (Connection) request.getAttribute("conexao");
        ProdutoDAO dao = new ProdutoDAO(connection);
        dao.adiciona(produto);
  
        return "produto?logica=Lista";
    }

}
