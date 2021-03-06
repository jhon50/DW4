/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.controllers;

import dw.ecommerce.logica.produto.Logica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno Dutra
 */
@WebServlet("/")
public class ControllerPublico extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parametro = request.getParameter("logica");
        String nomeDaClasse = "dw.ecommerce.logica.produto." + parametro;

        if (parametro == null) {
            request.getRequestDispatcher("WEB-INF/views/publico/index.jsp").forward(request, response);
        } else {
            try {

                Class classe = Class.forName(nomeDaClasse);
                Logica logica = (Logica) classe.newInstance();
                String pagina = logica.executa(request, response);

                request.getRequestDispatcher(pagina).forward(request, response);

            } catch (Exception e) {
                throw new ServletException("O sistema do ecommerce apresentou algum problema.");
            }
        }

    }
}
