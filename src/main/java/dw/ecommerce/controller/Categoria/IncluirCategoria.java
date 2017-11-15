package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

@WebServlet("/IncluirCategoria")
public class IncluirCategoria extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		try {

			new CategoriaDAO(connection).adiciona(categoria);

			request.setAttribute("tipo", "Categoria");
			request.setAttribute("nome", request.getParameter("nome"));
			request.setAttribute("mensagem", "adicionada com sucesso");
			request.setAttribute("retorna", "Categoria");
			request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Categoria invalida");
        	request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/form.jsp");
            rd.forward(request, response);
		}

	}
}
