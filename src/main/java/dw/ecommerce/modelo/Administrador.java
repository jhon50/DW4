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
public class Administrador {
    
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Administrador() {
    	
    }
    
    
    public Administrador(Long id) {
		this.id = id;
	}
    
    

	public Administrador(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Administrador(String email, String senha) {
		this.email = email;
		this.senha = senha;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public static boolean valida(Administrador administrador) {

		if(administrador.getNome().isEmpty() || administrador.getEmail().isEmpty() || administrador.getSenha().isEmpty()) {
			return true;
		}
		return false;
	}

    
    
}
