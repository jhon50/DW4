/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.ecommerce.dao;

import dw.ecommerce.jdbc.ConnectionFactory;
import dw.ecommerce.modelo.Usuario;
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
public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Usuario usuario) {

        String sql = "insert into usuarios(nome,email,senha,cartaoCredito,cpf) values(?,?,?,?,?)";

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

    public void atualiza(Usuario usuario) {

        String sql = "update produtos set nome=?, email=?, senha=?, cartaoCredito=?, cpf=? where id=?";

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

    public void remove(Usuario usuario) {

        try {
            PreparedStatement stmt = connection.prepareStatement("delete from usuarios where id=?");
            stmt.setLong(1, usuario.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getLista() {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from usuarios");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

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
