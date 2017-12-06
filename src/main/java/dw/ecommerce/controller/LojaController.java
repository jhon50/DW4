package dw.ecommerce.controller;

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

@WebServlet("/")
public class LojaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Produto> produtos;

		List<Categoria> categorias = new CategoriaDAO(connection).getLista();
		request.setAttribute("categorias", categorias);

		String categoria = request.getParameter("Categoria");

		if (categoria != null) {
			produtos = new ProdutoDAO(connection).getListaCategoria(categoria);
		} else {
			produtos = new ProdutoDAO(connection).getLista();
		}

		request.setAttribute("produtos", produtos);
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Produto> produtos;

		List<Categoria> categorias = new CategoriaDAO(connection).getLista();
		request.setAttribute("categorias", categorias);

		String nome = request.getParameter("nome");

		produtos = new ProdutoDAO(connection).getListaPorNome(nome);
		request.setAttribute("produtos", produtos);

		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);

	}
}
