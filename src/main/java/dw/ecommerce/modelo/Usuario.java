/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.modelo;

public class Usuario {
	private Long id;
	private String nome;
	private String senha;
	private boolean valido;

	public Usuario() {

	}

	public Usuario(long id) {
		this.id = id;
	}

	public Usuario(Long id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static boolean valida(Usuario cliente) {

		String nome = cliente.getNome();
		String senha = cliente.getSenha();

		if ((nome.isEmpty()) || (senha.isEmpty())) {
			return true;
		}
		return false;
	}
}
