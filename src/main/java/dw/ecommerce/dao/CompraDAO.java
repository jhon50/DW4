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

    private String produto;
    private String clienteNome;
    private Double valor;
    private Calendar data;

    public CompraDAO(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Compra compra) {

        String sql = "insert into compras(produto, cliente, valor, data) values(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, compra.getProduto());
            stmt.setString(2, compra.getClienteNome());
            stmt.setDouble(3, compra.getValor());
            stmt.setDate(4, new Date(compra.getData().getTimeInMillis()));

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualiza(Compra compra) {

        String sql = "update compras set produto=?, cliente=?, valor=?, data=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, compra.getProduto());
            stmt.setString(2, compra.getClienteNome());
            stmt.setDouble(3, compra.getValor());
            stmt.setDate(4, new Date(compra.getData().getTimeInMillis()));
            stmt.setLong(5, compra.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void remove(Compra compra) {

        try {
            PreparedStatement stmt = connection.prepareStatement("delete from compras where id=?");
            stmt.setLong(1, compra.getId());

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
            stmt = this.connection.prepareStatement("select * from compras");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Categoria

                Compra compra = new Compra();
                compra.setId(rs.getLong("id"));
                compra.setProduto(rs.getString("produto"));
                compra.setClienteNome(rs.getString("cliente"));
                compra.setValor(rs.getDouble("valor"));

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

	public Compra getID(Compra compra) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM compras WHERE ID = ? ");
			sql.setFloat(1, compra.getId());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					compra.setClienteNome(rs.getString("cliente"));
					compra.setProduto(rs.getString("produto"));
					compra.setValor(rs.getDouble("valor"));
					Calendar data = Calendar.getInstance();
	                data.setTime(rs.getDate("data"));
	                compra.setData(data);

				}
			}
			return compra;

		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

}
