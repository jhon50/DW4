package dw.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dw.ecommerce.modelo.Administrador;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter(urlPatterns = {"/Login", "/Painel", "/EditarAdmin", "/ExcluirAdmin", "/IncluirAdmin", "/Admin", "/VisualizarAdmin",
		"/EditarCategoria", "/ExcluirCategoria", "/IncluirCategoria", "/Categoria", "/VisualizarCategoria",
		"/EditarCliente", "/ExcluirCliente", "/IncluirCliente", "/Cliente", "/VisualizarCliente", "/EditarCompra",
		"/ExcluirCompra", "/IncluirCompra", "/Compra", "/VisualizarCompra", "/EditarProduto", "/ExcluirProduto",
		"/IncluirProduto", "/Produto", "/VisualizarProduto" })
public class FiltroLogin implements Filter {

	public FiltroLogin() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
		HttpSession session = httpServletRequest.getSession();
		
		Administrador admin = (Administrador) session.getAttribute("usuarioLogado");
		if(admin == null) {			
			httpServletRequest.getRequestDispatcher("/Login").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}

	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
