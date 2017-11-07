package dw.ecommerce.controller.Cliente;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ClienteDAO;
import dw.ecommerce.modelo.Cliente;

@WebServlet("/VisualizarCliente")
public class VisualizarCliente extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = new Cliente(id);
		ClienteDAO clienteDAO = new ClienteDAO(connection);

		try {
			clienteDAO.buscaId(cliente);
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/visualizar.jsp").forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

}
