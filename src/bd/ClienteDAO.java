package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Cliente;

public class ClienteDAO {

    private final Connection conn;

    public ClienteDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
    }

    public void incluir(Cliente cliente) throws DAOException, SQLException {
        String sqlInsert = "INSERT INTO cliente(nome, telefone, email, rg, cpf, dataNascimento ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getTelefone());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getRg());
            stm.setString(5, cliente.getCpf());
            stm.setString(6, cliente.getDataNascimento());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao inserir cliente no banco!");
        }
    }
    public void excluir(Cliente c) throws DAOException, DAOException, SQLException {
        String sqlDelete = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, c.getIdCliente());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao excluir cliente no banco!");
        }
    }

    public void atualizarTelefone(int idCliente, String novoTelefone) throws DAOException, SQLException {
        String sqlUpdate = "UPDATE cliente SET telefone = ? WHERE ID = ?";

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, novoTelefone);
            stm.setInt(2, idCliente);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao atualizar cliente no banco!");
        }
    }

    public ArrayList<Cliente> buscar() throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM cliente";
        ArrayList<Cliente> lista = new ArrayList<>();
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect); 
             ResultSet rs = stm.executeQuery();
        ) {
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                c.setIdCliente(rs.getInt("idCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar clientes no banco!");
        }
        
        return lista;
    }

    public Cliente buscarPorId(int idCliente) throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM cliente WHERE idCliente = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect))
        {
            stm.setInt(1, idCliente);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente(
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                c.setIdCliente(rs.getInt("idCliente"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                return c;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar clientes no banco!");
        }
    }

}
