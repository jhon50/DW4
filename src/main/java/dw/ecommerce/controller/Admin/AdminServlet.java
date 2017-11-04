package dw.ecommerce.controller.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.modelo.Administrador;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Administrador> administradores = new AdministradorDAO(connection).getLista();
		request.setAttribute("nome", "bruno dutra");
		request.setAttribute("administradores", administradores);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/admin.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		new AdministradorDAO(connection).adiciona(request);
		request.setAttribute("adm_nome", request.getParameter("nome"));
		request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/sucesso.jsp").forward(request, response);
		
	}
}