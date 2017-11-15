package dw.ecommerce.controller.Compras;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.modelo.Administrador;
import dw.ecommerce.modelo.Compra;

@WebServlet("/Compra")
public class ListaCompra extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		List<Compra> compras = new CompraDAO(connection).getLista();
		
		request.setAttribute("compras", compras);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/compra.jsp").forward(request, response);
	}
}
