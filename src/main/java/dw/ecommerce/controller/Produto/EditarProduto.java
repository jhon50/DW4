package dw.ecommerce.controller.Produto;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Produto;

@WebServlet("/EditarProduto")
public class EditarProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Produto produto = new Produto(id);
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);

		produtoDAO.buscaId(produto);
		request.setAttribute("produto", produto);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/editar.jsp").forward(request, response);
		;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));

		Produto produto = new Produto(id, categoria, nome, descricao, preco);

		try {
			if (Produto.valida(produto)) {

				request.setAttribute("erro", "Produto inválido");
				request.setAttribute("produto", produto);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/editar.jsp");
				rd.forward(request, response);

			} else {

				ProdutoDAO produtoDAO = new ProdutoDAO(connection);
				try {
					produtoDAO.atualiza(produto);
					request.setAttribute("mensagem", "Alterado Com Sucesso");
					request.setAttribute("retorna", "ListaContato");
					RequestDispatcher rd = request
							.getRequestDispatcher("WEB-INF/views/painel-admin/produto/sucesso.jsp");
					rd.forward(request, response);

				} catch (Exception e) {
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp");
					rd.forward(request, response);
				}

			}

		} catch (Exception e) {
			request.setAttribute("erro", "Produto inválido");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/form.jsp");
			rd.forward(request, response);
		}
	}
}
