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

@WebServlet("/ExcluirCliente")
public class ExcluirCliente extends HttpServlet {

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
			request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/excluir.jsp").forward(request,
					response);

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		int id = Integer.parseInt(request.getParameter("id"));

		Cliente cliente = new Cliente(id);
		try {
			ClienteDAO ClienteDAO = new ClienteDAO(connection);
			try {
				ClienteDAO.remove(cliente);

        		request.setAttribute("tipo", "Cliente");
        		request.setAttribute("nome", request.getParameter("nome"));
        		request.setAttribute("mensagem", "excluido com sucesso");
        		request.setAttribute("retorna", "Cliente");
        		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);
        		
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}
	}
}
