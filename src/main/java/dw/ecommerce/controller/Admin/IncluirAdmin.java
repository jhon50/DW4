package dw.ecommerce.controller.Admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.modelo.Administrador;

@WebServlet("/IncluirAdmin")
public class IncluirAdmin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		Administrador admin = new Administrador();
		
		admin.setNome(request.getParameter("nome"));
		admin.setEmail(request.getParameter("email"));
		admin.setSenha(request.getParameter("senha"));
		
		new AdministradorDAO(connection).adiciona(admin);
		
		
		request.setAttribute("tipo", "Administrador");
		request.setAttribute("nome", request.getParameter("nome"));
		request.setAttribute("mensagem", "adicionado com sucesso");
		request.setAttribute("retorna", "Admin");
		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);

	}
}
