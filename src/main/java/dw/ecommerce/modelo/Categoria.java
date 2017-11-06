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
public class Categoria {

	private Long id;
	private String nome;

	public Categoria() {

	}

	public Categoria(long id) {
		this.id = id;
	}

	public Categoria(long id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public static boolean valida(Categoria categoria) {
		String nome = categoria.getNome();

		if (nome.isEmpty()) {
			return true;
		}
		return false;

	}

}
