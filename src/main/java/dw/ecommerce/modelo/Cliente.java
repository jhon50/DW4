/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.modelo;

public class Cliente {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cartao;
	private String cpf;

	public Cliente() {

	}

	public Cliente(long id) {
		this.id = id;
	}

	public Cliente(Long id, String nome, String email, String senha, String cartaoCredito, String cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cartao = cartaoCredito;
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static boolean valida(Cliente cliente) {

		String nome = cliente.getNome();
		String email = cliente.getEmail();
		String senha = cliente.getSenha();
		String cpf = cliente.getCpf();
		String cartao = cliente.getCartao();

		if ((email.isEmpty()) || (nome.isEmpty()) || (senha.isEmpty()) || (cpf.isEmpty()) || (cartao.isEmpty())) {
			return true;
		}
		return false;
	}

}
