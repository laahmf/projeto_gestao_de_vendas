package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Fornecedor;

public class FornecedorDAO {

    private final Connection conn;

    public FornecedorDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
    }

    public void incluir(Fornecedor fornecedor) 
        throws DAOException, SQLException {
        String sqlInsert
                = "INSERT INTO fornecedor(cnpj, nome, telefone, email) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, fornecedor.getCnpj());
            stm.setString(2, fornecedor.getNome());
            stm.setString(3, fornecedor.getTelefone());
            stm.setString(4, fornecedor.getEmail());
            stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao inserir fornecedor no banco!");
        }
    }

    public void excluir(Fornecedor f) throws DAOException, SQLException {
        String sqlDelete = "DELETE FROM fornecedor WHERE idFornecedor = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setString(1, f.getCnpj());

            stm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao excluir fornecedor no banco!");
        }
    }

    public void atualizarTelefone(int idFornecedor, String novoTelefone) throws DAOException, SQLException {
        String sqlUpdate = "UPDATE fornecedor SET telefone = ? WHERE idFornecedor = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, novoTelefone);
            stm.setInt(2, idFornecedor);
            stm.execute();
        }  catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao atualizar fornecedor no banco!");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Fornecedor> buscar() throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM fornecedor";
        ArrayList<Fornecedor> lista = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.SetIdFornecedor(rs.getInt("idFornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.SetCnpj(rs.getString("cnpj"));
                lista.add(f);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao buscar fornecedores no banco");
        }
        return lista;
    }
    
    public Fornecedor buscarPorId(int idFornecedor) throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM fornecedor WHERE idFornecedor = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
            stm.setInt(1, idFornecedor);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.SetIdFornecedor(rs.getInt("idFornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.SetCnpj(rs.getString("cnpj"));
                return f;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao buscar fornecedor no banco com id: " + idFornecedor);
        }
        return null;
    }
}
