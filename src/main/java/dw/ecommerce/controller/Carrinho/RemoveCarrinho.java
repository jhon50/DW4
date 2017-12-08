package dw.ecommerce.controller.Carrinho;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

@WebServlet("/RemoveCarrinho")
public class RemoveCarrinho extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		System.out.println("RemoveCarrinho");
		session = request.getSession();
		Long id = Long.parseLong(request.getParameter("Produto"));
		Produto produto = new Produto(id);
		
		new ProdutoDAO(connection).buscaId(produto);
		
		List<Produto> produtos = (List<Produto>) session.getAttribute("Produtos");
		
		
		for (Produto p : produtos) {
			if(p.getId() == produto.getId()) {
				produtos.remove(p);
				break;
			}
		}
		session.setAttribute("Produtos", produtos);
		request.getRequestDispatcher("WEB-INF/views/carrinho.jsp").forward(request, response);
		
	}
}