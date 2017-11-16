//CRUD COMPRAS
package dw.ecommerce.dao;

import dw.ecommerce.modelo.Compra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Bruno Dutra
 */
public class CompraDAO {

	private Connection connection;

	public CompraDAO(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Compra compra) {

		String sql = "insert into compras(produto, numero, cliente, valor, data) values(?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, compra.getProduto());
			stmt.setInt(2, compra.getNumero());
			stmt.setString(3, compra.getClienteNome());
			stmt.setDouble(4, compra.getValor());
			stmt.setDate(5, new Date(compra.getData().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void atualiza(Compra compra) {

		String sql = "update compras set cliente=?, data=? where numero=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, compra.getClienteNome());
			stmt.setDate(2, new Date(compra.getData().getTimeInMillis()));
			stmt.setLong(3, compra.getNumero());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Compra compra) {

		try {
			PreparedStatement stmt = connection.prepareStatement("delete from compras where numero=?");
			stmt.setLong(1, compra.getNumero());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Compra> getLista() {

		try {
			List<Compra> compras = new ArrayList<Compra>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("SELECT NUMERO, CLIENTE, SUM(VALOR), DATA FROM COMPRAS GROUP BY CLIENTE, NUMERO, DATA ORDER BY NUMERO");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Categoria

				Compra compra = new Compra();
				compra.setNumero(rs.getInt("numero"));
				compra.setClienteNome(rs.getString("cliente"));
				compra.setValor(rs.getDouble("sum"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				compra.setData(data);

				compras.add(compra);

			}

			rs.close();
			stmt.close();
			return compras;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Compra> getID(Long numero) {
		try {
			List<Compra> compras = new ArrayList<Compra>();
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM compras WHERE numero = ? ");
			sql.setFloat(1, numero);
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					Compra compra = new Compra();
					
					compra.setClienteNome(rs.getString("cliente"));
					compra.setNumero(rs.getInt("numero"));
					compra.setProduto(rs.getString("produto"));
					compra.setValor(rs.getDouble("valor"));
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data"));
					compra.setData(data);
					
					compras.add(compra);

				}
			}
			
			rs.close();
			sql.close();
			return compras;

		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	public Integer getNumero() {
		int numero = 0;
		try {
			PreparedStatement sql = this.connection.prepareStatement("select max(numero) from compras");
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					numero = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return numero;

	}

}
