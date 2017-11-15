package dw.ecommerce.controller.Compras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.modelo.Compra;

@WebServlet("/IncluirCompra")
public class IncluirCompra extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection connection = (Connection) request.getAttribute("conexao");

			long id = Integer.parseInt(request.getParameter("id"));
			String produto = request.getParameter("produto");
			String clienteNome = request.getParameter("clienteNome");
			Double valor = Double.parseDouble(request.getParameter("valor"));
			Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("data"));
			Calendar data = Calendar.getInstance();
			data.setTime(date);

			Compra compra = new Compra(id, produto, clienteNome, valor, data);
			new CompraDAO(connection).adiciona(compra);
		
			request.setAttribute("tipo", "Compra");
			request.setAttribute("nome", request.getParameter("id"));
			request.setAttribute("mensagem", "adicionada com sucesso");
			request.setAttribute("retorna", "Compra");
			request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("erro", "Compra inválida");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/form.jsp");
			rd.forward(request, response);
		}

	}
}
