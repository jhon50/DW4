package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

@WebServlet("/Categoria")
public class ListaCategoria extends HttpServlet {

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

		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/categoria.jsp").forward(request, response);
	}
}
