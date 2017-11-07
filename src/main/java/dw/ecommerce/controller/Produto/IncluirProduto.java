package dw.ecommerce.controller.Produto;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Categoria;
import dw.ecommerce.modelo.Produto;

@WebServlet("/IncluirProduto")
public class IncluirProduto extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		List<Categoria> categorias = new CategoriaDAO(connection).getLista();
		request.setAttribute("categorias", categorias);

		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/produto/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));

		Produto produto = new Produto(categoria, nome, descricao, preco);
		
		new ProdutoDAO(connection).adiciona(produto);
		
		request.setAttribute("tipo", "Produto");
		request.setAttribute("nome", request.getParameter("nome"));
		request.setAttribute("mensagem", "adicionado com sucesso");
		request.setAttribute("retorna", "Produto");
		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);


	}
}
