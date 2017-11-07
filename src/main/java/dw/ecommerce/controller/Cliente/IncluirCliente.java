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

@WebServlet("/IncluirCliente")
public class IncluirCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setCartaoCredito(request.getParameter("cartaoCredito"));
		cliente.setCpf(request.getParameter("cpf"));

		new ClienteDAO(connection).adiciona(cliente);
		request.setAttribute("cliente_nome", request.getParameter("nome"));
		request.getRequestDispatcher("WEB-INF/views/painel-admin/cliente/sucesso.jsp").forward(request, response);

	}
}
