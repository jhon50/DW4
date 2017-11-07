package dw.ecommerce.controller.Produto;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

@WebServlet("/ExcluirProduto")
public class ExcluirProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Produto produto = new Produto(id);
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);

		try {
			produtoDAO.buscaId(produto);
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/excluir.jsp").forward(request,
					response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		int id = Integer.parseInt(request.getParameter("id"));

		Produto produto = new Produto(id);
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			try {
				produtoDAO.remove(produto);
				request.setAttribute("mensagem", "Exclusão Com Sucesso");
				request.setAttribute("retorna", "ListaContato");
				request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/sucesso.jsp").forward(request,response);
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}
	}
}
