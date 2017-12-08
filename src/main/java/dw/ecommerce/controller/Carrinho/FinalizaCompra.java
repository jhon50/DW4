package dw.ecommerce.controller.Carrinho;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw.ecommerce.dao.CompraDAO;
import dw.ecommerce.modelo.Compra;
import dw.ecommerce.modelo.Produto;

@WebServlet("/FinalizaCompra")
public class FinalizaCompra extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/finaliza.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");
		HttpSession session = request.getSession();

		List<Produto> produtos = (List<Produto>) session.getAttribute("Produtos");

		CompraDAO compraDAO = new CompraDAO(connection);
		int numero = compraDAO.getNumero() + 1;

		if (produtos != null) {

			for (Produto produto : produtos) {

				String clienteNome = request.getParameter("nome");

				Calendar c = Calendar.getInstance();

				c.setTime(c.getTime());
				
				Compra compra = new Compra(produto.getNome(), numero, clienteNome, produto.getPreco(), c);
				compraDAO.adiciona(compra);
			}
			
			produtos = new ArrayList<>(); 
			session.setAttribute("Produtos", produtos);
			
			request.setAttribute("tipo", "Compra");
			request.setAttribute("nome", numero);
			request.setAttribute("mensagem", "realizada com sucesso");
			request.setAttribute("retorna", "/LojaDW");
			
			request.getRequestDispatcher("WEB-INF/views/sucesso.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
		}

		
	}
}
