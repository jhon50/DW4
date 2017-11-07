package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.AdministradorDAO;
import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

@WebServlet("/IncluirCategoria")
public class IncluirCategoria extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		
		Categoria categoria = new Categoria();
		categoria.setNome(request.getParameter("nome"));
		
		new CategoriaDAO(connection).adiciona(categoria);
		request.setAttribute("categoria_nome", request.getParameter("nome"));
		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/sucesso.jsp").forward(request, response);

	}
}
