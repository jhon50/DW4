package dw.ecommerce.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
		if(admin == null) {			
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/index.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		AdministradorDAO administradorDAO = new AdministradorDAO(connection);

		Administrador admin = administradorDAO.login(email, senha);
		
		if (admin != null) {
			System.out.println("Login efetuado com sucesso!");
			request.getSession().setAttribute("usuarioLogado", admin);
			request.getRequestDispatcher("/Painel").forward(request, response);
		} else {
			System.err.println("Administrador inválido");
			response.sendRedirect("Login");
		}


	}
}
