package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Categoria;

public class CategoriaDAO {

    private final Connection conn;

    public CategoriaDAO() throws SQLException {
        this.conn = ConexaoDB.conectar();
    }

    public void incluir(Categoria categoria) throws DAOException, SQLException{
        String sqlInsert = "INSERT INTO categoria(nomeCategoria) VALUES (?)";

        try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, categoria.getNome());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao inserir categoria no banco!");
        }
    }
    
    public void excluir(Categoria c) throws SQLException, DAOException {
        String sqlDelete = "DELETE FROM categoria WHERE id = ?";
        try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, c.getIdCategoria());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao excuir categoria no banco!");
        }
    }

    public ArrayList<Categoria> buscar() throws DAOException, SQLException {
        String sqlSelect = "SELECT * FROM categoria";
        ArrayList<Categoria> lista = new ArrayList<>();
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect); 
             ResultSet rs = stm.executeQuery();
        ) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNome(rs.getString("nomeCategoria"));
                lista.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar categorias no banco!");
        }
        
        return lista;
    }
}
