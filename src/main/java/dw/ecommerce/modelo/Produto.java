/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.modelo;

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

    public Produto(Long id, String categoria, String nome, String descricao, double preco) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

    
	public Produto(String categoria, String nome, String descricao, double preco) {
		super();
		this.categoria = categoria;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(long id) {
    	this.id = id;
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

	public static boolean valida(Produto produto) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    
}
