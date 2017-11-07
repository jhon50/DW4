//CRUD ADMINISTRADORES
package dw.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dw.ecommerce.modelo.Administrador;

/**
 *
 * @author Bruno Dutra
 */
public class AdministradorDAO {

	private Connection connection;

	public AdministradorDAO(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Administrador admin) {

		String sql = "insert into administradores(nome, email, senha) values(?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, admin.getNome());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void atualiza(Administrador administrador) {

		String sql = "update administradores set nome=?, email=?, senha=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getEmail());
			stmt.setString(3, administrador.getSenha());
			stmt.setLong(4, administrador.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Administrador administrador) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from administradores where id=?");
			stmt.setLong(1, administrador.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Administrador> getLista() {

		try {
			List<Administrador> administradores = new ArrayList<Administrador>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from administradores order by nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Categoria

				Administrador administrador = new Administrador();
				administrador.setId(rs.getLong("id"));
				administrador.setNome(rs.getString("nome"));
				administrador.setEmail(rs.getString("email"));
				administrador.setSenha(rs.getString("senha"));

				administradores.add(administrador);
			}

			rs.close();
			stmt.close();
			return administradores;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Administrador getID(Administrador admin) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM administradores WHERE ID = ? ");
			sql.setFloat(1, admin.getId());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					admin.setNome(rs.getString("nome"));
					admin.setEmail(rs.getString("email"));
					admin.setSenha(rs.getString("senha"));
				}
			}
			return admin;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
