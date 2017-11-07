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

@WebServlet("/Produto")
public class ListaProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Produto> produtos = new ProdutoDAO(connection).getLista();
		request.setAttribute("produtos", produtos);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/produto.jsp").forward(request, response);
	}
}
