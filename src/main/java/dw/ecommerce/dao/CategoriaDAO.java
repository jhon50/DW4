//CRUD CATEGORIA
package dw.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dw.ecommerce.modelo.Categoria;

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

            stmt.setString(1, categoria.getNome().toUpperCase());

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
            List<Categoria> categorias = new ArrayList<Categoria>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from categorias order by nome");
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
    
    public Categoria buscaId(Categoria categoria) {
		try {
			PreparedStatement sql = this.connection.prepareStatement("SELECT * FROM categorias WHERE ID = ? ");
			sql.setFloat(1, categoria.getId());
			ResultSet rs = sql.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					categoria.setNome(rs.getString("nome"));
					
				}
			}
			return categoria;

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
