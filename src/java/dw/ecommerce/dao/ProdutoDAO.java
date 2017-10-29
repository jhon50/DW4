//CRUD Produtos
package dw.ecommerce.dao;

import dw.ecommerce.modelo.Produto;
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
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }
    public boolean adiciona(Produto produto) {

        String sql = "insert into produtos(categoria,nome,descricao,preco) values(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getCategoria());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean atualiza(Produto produto) {

        String sql = "update produtos set categoria=?, nome=?, descricao=?, preco=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getCategoria());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setLong(5, produto.getId());

            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Produto produto) {

        try {
            PreparedStatement stmt = connection.prepareStatement("delete from produtos where id=?");
            stmt.setLong(1, produto.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> getLista() {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from produtos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Produto
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Produto> getListaCategoria(String categoria) {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from produtos where categoria=?");
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Produto
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Produto> getListaPorNome(String nomeProduto) {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement("select * from produtos where nome ilike ?");
            nomeProduto = "%" + nomeProduto + "%";
            stmt.setString(1, nomeProduto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Produto
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
            return produtos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
