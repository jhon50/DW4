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

@WebServlet("/EditarCategoria")
public class EditarCategoria extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Connection connection = (Connection) request.getAttribute("conexao");
		
		long id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = new Categoria(id);
		CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
		
		categoriaDAO.getID(categoria);
		request.setAttribute("categoria", categoria);
		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/editar.jsp").forward(request, response);;
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = (Connection) request.getAttribute("conexao");

        long id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        
        Categoria categoria = new Categoria(id, nome);

        
        try {
            if (Categoria.valida(categoria)){
            	
            	request.setAttribute("erro", "Categoria invalida");
            	request.setAttribute("categoria", categoria);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/editar.jsp");
                rd.forward(request, response);
                
            } else {
            	CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
                try {
                	categoriaDAO.atualiza(categoria);
                    request.setAttribute("mensagem", "Alterada Com Sucesso");
                    request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/sucesso.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
        	request.setAttribute("erro", "Categoria invalida");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/categoria/form.jsp");
            rd.forward(request, response);
        }
	}
}
