package dw.ecommerce.controller.Cliente;

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

@WebServlet("/Editar")
public class Editar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Connection connection = (Connection) request.getAttribute("conexao");
		
		long id = Integer.parseInt(request.getParameter("id"));
		Administrador admin = new Administrador(id);
		AdministradorDAO administradorDAO = new AdministradorDAO(connection);
		
		administradorDAO.getID(admin);
		request.setAttribute("administrador", admin);
		
		request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/editar.jsp").forward(request, response);;
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = (Connection) request.getAttribute("conexao");

        long id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Administrador administrador = new Administrador(id, nome,email, senha);
        
        try {
            if (Administrador.valida(administrador)){
            	
            	request.setAttribute("erro", "Administrador inválido");
                request.setAttribute("administrador", administrador);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/editar.jsp");
                rd.forward(request, response);
                
            } else {

            	AdministradorDAO administradorDAO = new AdministradorDAO(connection);
                try {
                	administradorDAO.atualiza(administrador);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/sucesso.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
        	request.setAttribute("erro", "Administrador inválido");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/administrador/form.jsp");
            rd.forward(request, response);
        }
	}
}
