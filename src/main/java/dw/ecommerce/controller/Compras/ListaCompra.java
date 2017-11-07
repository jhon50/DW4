package dw.ecommerce.controller.Compras;

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

@WebServlet("/Compra")
public class ListaCompra extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Administrador> administradores = new AdministradorDAO(connection).getLista();
		request.setAttribute("administradores", administradores);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/admin.jsp").forward(request, response);
	}
}
