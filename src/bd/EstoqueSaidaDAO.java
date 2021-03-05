package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.EstoqueSaida;
import modelos.Produto;

public class EstoqueSaidaDAO {

    private final Connection conn;
    private final ProdutoDAO produtoDAO;

    public EstoqueSaidaDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
        this.produtoDAO = new ProdutoDAO();
    }

    public void incluir(EstoqueSaida estoque) throws DAOException, SQLException {
        String sqlInsert  = "INSERT INTO EstoqueSaida(idProduto,quantidade,dataSaida, motivo) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setInt(1, estoque.getProduto().getIdProduto());
            stm.setInt(2, estoque.getQuantidade());
            stm.setString(3, estoque.getDataSaida());
            stm.setString(4, estoque.getMotivoSaida());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao salvar saida de estoque!");
        }
        
        produtoDAO.alterarQuantidade(estoque.getProduto(), "saida", estoque.getQuantidade());
    }

    public ArrayList<EstoqueSaida> buscar() throws SQLException, DAOException {
        String sqlSelect
                = "SELECT * FROM EstoqueSaida "
                + "JOIN produto ON produto.idProduto = EstoqueSaida.idProduto";
        ArrayList<EstoqueSaida> lista = new ArrayList<>();
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect); ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("produto.idProduto"));
                p.setNome(rs.getString("produto.nome"));
                
                EstoqueSaida e = new EstoqueSaida();
                e.setIdEstoque(rs.getInt("EstoqueSaida.idEstoqueSaida"));
                e.setProduto(p);
                e.setQuantidade(rs.getInt("EstoqueSaida.quantidade"));
                e.setDataSaida(rs.getString("EstoqueSaida.dataSaida"));
                e.setMotivoSaida(rs.getString("EstoqueSaida.motivo"));
                
                lista.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar saidas de estoque!");
        }
        
        return lista;
    }

}
