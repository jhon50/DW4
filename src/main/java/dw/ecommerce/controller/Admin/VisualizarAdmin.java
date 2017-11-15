package dw.ecommerce.controller.Admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.modelo.Compra;

@WebServlet("/VisualizarAdmin")
public class VisualizarAdmin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Compra compra = new Compra(id);
		CompraDAO compraDao = new CompraDAO(connection);

		try {
			compraDao.getID(compra);
			request.setAttribute("compra", compra);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/visualizar.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

}
