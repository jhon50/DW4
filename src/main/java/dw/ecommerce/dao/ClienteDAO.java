//CRUD CLIENTE
package dw.ecommerce.dao;

import dw.ecommerce.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Dutra
 */
public class ClienteDAO {

	private Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Cliente usuario) {

		String sql = "insert into clientes(nome,email,senha,cartaoCredito,cpf) values(?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getCartaoCredito());
			stmt.setString(5, usuario.getCpf());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void atualiza(Cliente usuario) {

		String sql = "update clientes set nome=?, email=?, senha=?, cartaoCredito=?, cpf=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getCartaoCredito());
			stmt.setString(5, usuario.getCpf());
			stmt.setLong(6, usuario.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Cliente usuario) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?");
			stmt.setLong(1, usuario.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> getLista() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId(rs.getLong("ID"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCartaoCredito(rs.getString("cartaoCredito"));
				cliente.setCpf(rs.getString("cpf"));

				clientes.add(cliente);
			}

			rs.close();
			stmt.close();
			return clientes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Cliente buscaId(Cliente cliente) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM clientes WHERE ID = ? ");
			sql.setFloat(1, cliente.getId());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					cliente.setId(rs.getLong("ID"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setCartaoCredito(rs.getString("cartaoCredito"));
					cliente.setCpf(rs.getString("cpf"));
				}
			}
			return cliente;

		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

}
