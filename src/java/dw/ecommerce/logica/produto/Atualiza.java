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
public class Atualiza  implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return Produto.update(request) ? "produto?logica=Lista" : "index";
    }
    
}
