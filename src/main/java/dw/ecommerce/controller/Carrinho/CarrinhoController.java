package dw.ecommerce.controller.Carrinho;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

@WebServlet("/Carrinho")
public class CarrinhoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		session = request.getSession();
		
		
		List<Produto> produtos = (List<Produto>) session.getAttribute("Produtos");
		
		if(produtos == null) {
			produtos = new ArrayList<>();
		}

		request.setAttribute("produtos", produtos);
		
		request.getRequestDispatcher("WEB-INF/views/carrinho.jsp").forward(request, response);

	}
	
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