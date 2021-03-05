package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.EstoqueEntrada;
import modelos.Produto;

public class EstoqueEntradaDAO {

    private final Connection conn;
    private final ProdutoDAO produtoDAO;

    public EstoqueEntradaDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
        this.produtoDAO = new ProdutoDAO();
    }

    public void incluir(EstoqueEntrada estoque)
            throws DAOException, SQLException {
        String sqlInsert = "INSERT INTO EstoqueEntrada(idProduto,quantidade,dataEntrada) "
                + "VALUES (?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setInt(1, estoque.getProduto().getIdProduto());
            stm.setInt(2, estoque.getQuantidade());
            stm.setString(3, estoque.getDataEntrada());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao salvar entrada de estoque!");
        }

        produtoDAO.alterarQuantidade(estoque.getProduto(), "entrada", estoque.getQuantidade());
    }

    public ArrayList<EstoqueEntrada> buscar() throws DAOException, SQLException {
        String sqlSelect
                = "SELECT * FROM EstoqueEntrada "
                + "JOIN produto ON produto.idProduto = EstoqueEntrada.idProduto";
        ArrayList<EstoqueEntrada> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("produto.idProduto"));
                p.setNome(rs.getString("produto.nome"));

                EstoqueEntrada e = new EstoqueEntrada();
                e.setIdEstoque(rs.getInt("EstoqueEntrada.idEstoqueEntrada"));
                e.setProduto(p);
                e.setQuantidade(rs.getInt("EstoqueEntrada.quantidade"));
                e.setDataEntrada(rs.getString("EstoqueEntrada.dataEntrada"));

                lista.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao buscar entradas de estoque!");
        }

        return lista;
    }

}
