package dw.ecommerce.controller.Categoria;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CategoriaDAO;
import dw.ecommerce.modelo.Categoria;

@WebServlet("/ExcluirCategoria")
public class ExcluirCategoria extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		long id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = new Categoria(id);
		CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

		try {
			categoriaDAO.buscaId(categoria);
			request.setAttribute("categoria", categoria);
			request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/excluir.jsp").forward(request,
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

		Categoria categoria = new Categoria(id);
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			try {
				categoriaDAO.remove(categoria);

        		request.setAttribute("tipo", "Categoria");
        		request.setAttribute("nome", request.getParameter("nome"));
        		request.setAttribute("mensagem", "excluida com sucesso");
        		request.setAttribute("retorna", "Categoria");
        		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);
        		
			} catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp").forward(request, response);
		}
	}
}
