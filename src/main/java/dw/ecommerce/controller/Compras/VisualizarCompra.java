package dw.ecommerce.controller.Compras;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.modelo.Compra;

@WebServlet("/VisualizarCompra")
public class VisualizarCompra extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		
		CompraDAO compraDAO = new CompraDAO(connection);

		try {
			List<Compra> compras = compraDAO.getID(id);
			request.setAttribute("compras", compras);
			
			request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/visualizar.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

}
