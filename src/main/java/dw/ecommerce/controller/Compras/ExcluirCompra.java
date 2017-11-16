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

@WebServlet("/ExcluirCompra")
public class ExcluirCompra extends HttpServlet {

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
			
			List<Compra> c = new CompraDAO(connection).getLista();			
			request.setAttribute("c", c);
			
			request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/excluir.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		int id = Integer.parseInt(request.getParameter("id"));

		Compra compra = new Compra(id);
		try {

			try {
				CompraDAO compraDAO = new CompraDAO(connection);
				compraDAO.remove(compra);
				request.setAttribute("mensagem", "Exclusão Com Sucesso");
				request.setAttribute("retorna", "Compra");
				request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}
	}
}
