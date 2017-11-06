package dw.ecommerce.controller.Admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.modelo.Administrador;

@WebServlet("/Excluir")
public class Excluir extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Administrador admin = new Administrador(id);
		AdministradorDAO administradorDAO = new AdministradorDAO(connection);

		try {
			administradorDAO.getID(admin);
			request.setAttribute("administrador", admin);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/excluir.jsp").forward(request,
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

		Administrador administrador = new Administrador(id);
		try {
			AdministradorDAO administradorDAO = new AdministradorDAO(connection);
			try {
				administradorDAO.remove(administrador);
				request.setAttribute("mensagem", "Exclusão Com Sucesso");
				request.setAttribute("retorna", "ListaContato");
				request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/sucesso.jsp").forward(request,response);
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}
	}
}
