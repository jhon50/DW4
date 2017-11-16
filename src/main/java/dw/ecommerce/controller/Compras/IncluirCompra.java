package dw.ecommerce.controller.Compras;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

@WebServlet("/IncluirCompra")
public class IncluirCompra extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("conexao");

		List<Produto> produtos = new ProdutoDAO(connection).getLista();
		List<Cliente> clientes = new ClienteDAO(connection).getLista();

		request.setAttribute("produtos", produtos);
		request.setAttribute("clientes", clientes);
		request.getRequestDispatcher("WEB-INF/views/painel-admin/compra/form.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection connection = (Connection) request.getAttribute("conexao");
			
			CompraDAO compraDAO = new CompraDAO(connection);
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
			List<Produto> produtos = null;
			
			String[] p = request.getParameterValues("produto");
			int numero = compraDAO.getNumero() + 1;
			
			for (String string : p) {
				Produto produto = new Produto();
				long id = Integer.parseInt(string);
				produto.setId(id);
				produtoDAO.buscaId(produto);

				String product = produto.getNome();
				String clienteNome = request.getParameter("cliente");
				double valor = produto.getPreco();

				// Fazendo a Conversão da Data
				String dataEmTexto = request.getParameter("data");
				Calendar data = null;

				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				data = Calendar.getInstance();
				data.setTime(date);

				Compra compra = new Compra(product, numero, clienteNome, valor, data);
				compraDAO.adiciona(compra);
			}

			request.setAttribute("tipo", "Compra");
			request.setAttribute("nome", numero);
			request.setAttribute("mensagem", "adicionada com sucesso");
			request.setAttribute("retorna", "Compra");
			request.getRequestDispatcher("WEB-INF/views/painel-admin/sucesso.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Compra inválida");
			doGet(request, response);
		}

	}
}
