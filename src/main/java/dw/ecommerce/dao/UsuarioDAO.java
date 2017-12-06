//CRUD CLIENTE
package dw.ecommerce.dao;
import dw.ecommerce.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Usuario buscaPorNome(Usuario usuario) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM usuarios WHERE ID = ? ");
			sql.setString(1, usuario.getNome());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuario.setId(rs.getLong("ID"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
				}
			}
			return usuario;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Usuario buscaId(Usuario usuario) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM usuarios WHERE ID = ? ");
			sql.setFloat(1, usuario.getId());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuario.setId(rs.getLong("ID"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
				}
			}
			return usuario;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
