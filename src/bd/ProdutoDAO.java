package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Fornecedor;

import modelos.Produto;

public class ProdutoDAO {

    private final Connection conn;

    public ProdutoDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
    }

    public void incluir(Produto produto) throws SQLException, DAOException {
        String produtoInsert = "INSERT INTO produto(nome, qtdEstoque, idCategoria, idFornecedor, preco) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(produtoInsert);) {
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getQuantidade());
            stm.setInt(3, produto.getCategoria().getIdCategoria());
            stm.setInt(4, produto.getFornecedor().getIdFornecedor());
            stm.setFloat(5, produto.getPreco());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao salvar produtos!");
        }
    }

    public void alterarQuantidade(Produto produto, String tipoAlteracao, int qtdAlteracao) throws SQLException, DAOException {
        String alteracaoEstoque;
        if (tipoAlteracao.equals("entrada")) {
            alteracaoEstoque = "UPDATE produto SET qtdEstoque = qtdEstoque + ? "
                    + "WHERE idProduto = ?";
        } else {
            alteracaoEstoque = "UPDATE produto SET qtdEstoque = qtdEstoque - ? "
                    + "WHERE idProduto = ?";
        }
        
        try (PreparedStatement stm = conn.prepareStatement(alteracaoEstoque);) {
            stm.setInt(1, qtdAlteracao);
            stm.setInt(2, produto.getIdProduto());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao atualizar produtos!");
        }
    }
    
    public void excluir(Produto p) throws SQLException, DAOException {
        String sqlDelete = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, p.getIdProduto());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao excluir produtos!");
        }
    }

    public ArrayList<Produto> buscar() throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM produto "
                + "LEFT JOIN categoria ON categoria.idCategoria = produto.idCategoria "
                + "LEFT JOIN fornecedor ON fornecedor.idFornecedor = produto.idFornecedor";
        ArrayList<Produto> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("produto.idProduto"));
                p.setNome(rs.getString("produto.nome"));
                p.setQuantidade(rs.getInt("produto.qtdEstoque"));
                p.setPreco(rs.getFloat("produto.preco"));

                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("categoria.idCategoria"));
                c.setNome(rs.getString("categoria.nomeCategoria"));
                p.setCategoria(c);

                Fornecedor f = new Fornecedor(
                        rs.getString("fornecedor.nome"),
                        rs.getString("fornecedor.telefone"),
                        rs.getString("fornecedor.email")
                );
                f.SetIdFornecedor(rs.getInt("fornecedor.idFornecedor"));
                f.SetCnpj(rs.getString("fornecedor.cnpj"));
                p.setFornecedor(f);

                lista.add(p);
            }

        }  catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar produtos!");
        }
        return lista;
    }
    
    public ArrayList<Produto> buscarDisponiveis() throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM produto "
                + "LEFT JOIN categoria ON categoria.idCategoria = produto.idCategoria "
                + "LEFT JOIN fornecedor ON fornecedor.idFornecedor = produto.idFornecedor "
                + "WHERE produto.qtdEstoque > 0";
        ArrayList<Produto> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
                ResultSet rs = stm.executeQuery();) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("produto.idProduto"));
                p.setNome(rs.getString("produto.nome"));
                p.setQuantidade(rs.getInt("produto.qtdEstoque"));
                p.setPreco(rs.getFloat("produto.preco"));

                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("categoria.idCategoria"));
                c.setNome(rs.getString("categoria.nomeCategoria"));
                p.setCategoria(c);

                Fornecedor f = new Fornecedor(
                        rs.getString("fornecedor.nome"),
                        rs.getString("fornecedor.telefone"),
                        rs.getString("fornecedor.email")
                );
                f.SetIdFornecedor(rs.getInt("fornecedor.idFornecedor"));
                f.SetCnpj(rs.getString("fornecedor.cnpj"));
                p.setFornecedor(f);

                lista.add(p);
            }

        }  catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao buscar produtos!");
        }
        return lista;
    }
    
    public Produto buscarPorId(int idProduto) throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM produto "
                + "LEFT JOIN categoria ON categoria.idCategoria = produto.idCategoria "
                + "LEFT JOIN fornecedor ON fornecedor.idFornecedor = produto.idFornecedor "
                + "WHERE produto.idPRoduto = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

            stm.setInt(1, idProduto);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("produto.idProduto"));
                p.setNome(rs.getString("produto.nome"));
                p.setQuantidade(rs.getInt("produto.qtdEstoque"));
                p.setPreco(rs.getFloat("produto.preco"));

                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("categoria.idCategoria"));
                c.setNome(rs.getString("categoria.nomeCategoria"));
                p.setCategoria(c);

                Fornecedor f = new Fornecedor(
                        rs.getString("fornecedor.nome"),
                        rs.getString("fornecedor.telefone"),
                        rs.getString("fornecedor.email")
                );
                f.SetIdFornecedor(rs.getInt("fornecedor.idFornecedor"));
                f.SetCnpj(rs.getString("fornecedor.cnpj"));
                p.setFornecedor(f);

                return p;
            }

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao buscar produtos!");
        }
        return null;
    }
}
