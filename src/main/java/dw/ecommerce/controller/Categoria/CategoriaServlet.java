package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		new CategoriaDAO(connection).adiciona(request);
		request.setAttribute("c_nome", request.getParameter("nome"));
		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/adicionado.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Categoria> categorias = new CategoriaDAO(connection).getLista();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/categoria.jsp").forward(request, response);

	}

}
