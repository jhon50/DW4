package dw.ecommerce.controller.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ClienteDAO;
import dw.ecommerce.modelo.Cliente;

@WebServlet("/Cliente")
public class ListaCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Cliente> clientes = new ClienteDAO(connection).getLista();
		request.setAttribute("clientes", clientes);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/admin.jsp").forward(request, response);
	}
}
