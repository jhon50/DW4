package dw.ecommerce.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.modelo.Administrador;

@WebServlet("/Login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		AdministradorDAO administradorDAO = new AdministradorDAO(connection);

		Administrador login = administradorDAO.login(email, senha);
		
		if (login != null) {
			System.out.println("Login efetuado com sucesso!");
		} else {
			System.err.println("Administrador inválido");
		}

		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

	}
}
