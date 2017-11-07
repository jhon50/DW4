package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

@WebServlet("/VisualizarCategoria")
public class VisualizarCategoria extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = new Categoria(id);
		CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

		try {
			categoriaDAO.getID(categoria);
			request.setAttribute("categoria", categoria);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/visualizar.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

}
