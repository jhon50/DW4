package dw.ecommerce.controller.Produto;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/Produto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection connection = (Connection) request.getAttribute("conexao");
					
			new ProdutoDAO(connection).adiciona(request);
			
		} catch (Exception e) {
			System.out.println("Erro ao adicionar produto!");
		} finally {
			request.setAttribute("p_nome", request.getParameter("nome"));
			request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/adicionado.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection connection = (Connection) request.getAttribute("conexao");
		
		List<Produto> produtos = new ProdutoDAO(connection).getLista();
		request.setAttribute("produtos", produtos);
		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/produto.jsp").forward(request, response);
	}
}
