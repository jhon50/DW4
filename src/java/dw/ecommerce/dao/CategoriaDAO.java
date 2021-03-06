//CRUD CATEGORIA
package dw.ecommerce.dao;

import dw.ecommerce.modelo.Categoria;
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
public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Categoria categoria) {
        
        String sql = "insert into categorias(nome) values(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void atualiza(Categoria categoria) {
      
        String sql = "update categorias set nome=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());
            stmt.setLong(2, categoria.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void remove(Categoria categoria) {
      
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from categorias where id=?");
            stmt.setLong(1, categoria.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Categoria> getLista() {

        try {
            List<Categoria> categorias = new ArrayList<>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from categorias");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Categoria
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nome"));
                
                categorias.add(categoria);
            }

            rs.close();
            stmt.close();
            return categorias;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
