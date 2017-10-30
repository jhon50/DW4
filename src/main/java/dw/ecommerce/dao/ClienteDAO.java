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
            List<Cliente> usuarios = new ArrayList<Cliente>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from clientes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente usuario = new Cliente();

                usuario.setId(rs.getLong("ID"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }

            rs.close();
            stmt.close();
            return usuarios;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
