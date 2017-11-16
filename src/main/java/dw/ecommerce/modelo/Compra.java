/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.modelo;

import java.util.Calendar;

/**
 *
 * @author Bruno Dutra
 */
public class Compra {
  
    private Long id;
    private int numero;
    private String produto;
    private String clienteNome;
    private Double valor;
    private Calendar data;

    public Compra(){
    	
    }
    public Compra(long id) {
		this.id = id;
	}

	
	public Compra(Long id, String produto, String clienteNome, Double valor, Calendar data) {
		this.id = id;
		this.produto = produto;
		this.clienteNome = clienteNome;
		this.valor = valor;
		this.data = data;
	}
	public Compra(String produto, int numero, String clienteNome, Double valor, Calendar data) {
		this.produto = produto;
		this.numero = numero;
		this.clienteNome = clienteNome;
		this.valor = valor;
		this.data = data;
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
	public static boolean valida(Compra compra) {
		String cliente = compra.getClienteNome();
		String produto = compra.getProduto();
		Calendar data = compra.getData();
		Double valor = compra.getValor();
		
		if ((cliente.isEmpty()) || (produto.isEmpty()) || (data == null) || (valor.isNaN())) {
			return true;
		}
		return false;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
    
    
    
    
}
