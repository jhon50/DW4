package dw.ecommerce.controller.Compras;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.ClienteDAO;
import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.dao.ProdutoDAO;
import dw.ecommerce.modelo.Cliente;
import dw.ecommerce.modelo.Compra;
import dw.ecommerce.modelo.Produto;

@WebServlet("/EditarCompra")
public class EditarCompra extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		
		long id = Integer.parseInt(request.getParameter("id"));
		Compra compra = new Compra(id);
		CompraDAO compraDAO = new CompraDAO(connection);
		
		List<Produto> produtos = new ProdutoDAO(connection).getLista();
		List<Cliente> clientes = new ClienteDAO(connection).getLista();
		
		request.setAttribute("produtos", produtos);
		request.setAttribute("clientes", clientes);
		
		compraDAO.getID(compra);
		request.setAttribute("compra", compra);

		request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/editar.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		try {

			long id = Integer.parseInt(request.getParameter("id"));
			String produto = request.getParameter("produto");
			String clienteNome = request.getParameter("cliente");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			//Fazendo a Conversão da Data
			String dataEmTexto = request.getParameter("data");
			Calendar data = null;
			
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			data = Calendar.getInstance();
			data.setTime(date);

			Compra compra = new Compra(id, produto, clienteNome, valor, data);
			
			if (Compra.valida(compra)) {

				request.setAttribute("erro", "Compra inválida");
				request.setAttribute("compra", compra);
				RequestDispatcher rd = request
						.getRequestDispatcher("WEB-INF/views/painel-admin/compra/editar.jsp");
				rd.forward(request, response);

			} else {

				CompraDAO compraDAO = new CompraDAO(connection);
				try {
					compraDAO.atualiza(compra);
					request.setAttribute("tipo", "Compra");
            		request.setAttribute("nome", request.getParameter("id"));
            		request.setAttribute("mensagem", "atualizada com sucesso");
            		request.setAttribute("retorna", "Compra");
            		request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);


				} catch (Exception e) {
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/erro.jsp");
					rd.forward(request, response);
				}

			}

		} catch (Exception e) {
			request.setAttribute("erro", "Compra inválida");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/form.jsp");
			rd.forward(request, response);
		}
	}
}
