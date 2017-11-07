package dw.ecommerce.controller.Cliente;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ClienteDAO;
import dw.ecommerce.modelo.Cliente;

@WebServlet("/EditarCliente")
public class EditarCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = new Cliente(id);
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		clienteDAO.buscaId(cliente);
		request.setAttribute("cliente", cliente);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/editar.jsp").forward(request, response);
		;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String cartao = request.getParameter("cartaoCredito");
		String cpf = request.getParameter("cpf");

		Cliente cliente = new Cliente(id, nome, email, senha, cartao, cpf);

		try {
			if (Cliente.valida(cliente)) {

				request.setAttribute("erro", "Cliente inválido");
				request.setAttribute("cliente", cliente);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/editar.jsp");
				rd.forward(request, response);

			} else {
				ClienteDAO clienteDAO = new ClienteDAO(connection);
				
				try {
					clienteDAO.atualiza(cliente);

            		request.setAttribute("tipo", "Cliente");
            		request.setAttribute("nome", request.getParameter("nome"));
            		request.setAttribute("mensagem", "atualizado com sucesso");
            		request.setAttribute("retorna", "Cliente");
            		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);


				} catch (Exception e) {
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp");
					rd.forward(request, response);
				}

			}

		} catch (Exception e) {
			request.setAttribute("erro", "Cliente inválido");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/form.jsp");
			rd.forward(request, response);
		}
	}
}
