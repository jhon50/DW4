package dw.ecommerce.controller.Carrinho;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

@WebServlet("/AdicionaCarrinho")
public class AdicionaCarrinho extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		session = request.getSession();
		Long id = Long.parseLong(request.getParameter("Produto"));
		Produto produto = new Produto(id);
		
		List<Produto> produtos = (List<Produto>) session.getAttribute("Produtos");
		if(produtos == null) {
			produtos = new ArrayList<>(); 			
		}
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);
		
		produtoDAO.buscaId(produto);
		produtos.add(produto);
		
		session.setAttribute("Produtos", produtos);
		
		
	}
}