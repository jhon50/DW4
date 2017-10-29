/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.modelo;

import dw.ecommerce.dao.ProdutoDAO;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Bruno Dutra
 */
public class Produto {
    
    private Long id;
    private String categoria;
    private String nome;
    private String descricao;
    private double preco;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Produto(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public static boolean add(HttpServletRequest request){
        Produto produto = new Produto();
        produto.setNome(request.getParameter("p_nome"));
        produto.setCategoria(request.getParameter("p_categoria"));
        produto.setDescricao(request.getParameter("p_descricao"));
        produto.setPreco(Double.parseDouble(request.getParameter("p_preco")));
        
        Connection connection  = (Connection) request.getAttribute("conexao");
        ProdutoDAO dao = new ProdutoDAO(connection);
        return dao.adiciona(produto);
    }
    
    public static boolean update(HttpServletRequest request){
        Produto produto = new Produto();
        produto.setId(Long.parseLong(request.getParameter("id")));
        produto.setNome(request.getParameter("nome"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setPreco(Double.parseDouble(request.getParameter("preco")));

        Connection connection = (Connection) request.getAttribute("conexao");
        ProdutoDAO dao = new ProdutoDAO(connection);
        return dao.atualiza(produto);

    }
    
    
}
