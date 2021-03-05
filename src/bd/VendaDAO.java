/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Cliente;
import modelos.EstoqueSaida;
import modelos.ItemVenda;
import modelos.Venda;

/**
 *
 * @author Lauren
 */
public class VendaDAO {
    
    private final Connection conn;
    private final EstoqueSaidaDAO estoqueSaidaDAO;
    
    public VendaDAO() throws SQLException{
        this.conn = ConexaoDB.conectar();
        this.estoqueSaidaDAO = new EstoqueSaidaDAO();
    }

    public void registrarVenda(Venda venda) throws SQLException, DAOException {
        String insert = "INSERT INTO venda(idCliente, dataVenda, valorTotal, "
                + "idProdutoA, quantidadeProdutoA, idProdutoB, quantidadeProdutoB,"
                + "idProdutoC, quantidadeProdutoC, idProdutoD, quantidadeProdutoD,"
                + "idProdutoE, quantidadeProdutoE) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stm = conn.prepareStatement(insert);) {
            stm.setInt(1, venda.getCliente().getIdCliente());
            stm.setString(2, venda.getDataVenda());
            stm.setFloat(3, venda.getPrecoTotal());
            stm.setInt(4, venda.getItens().get(0).getProduto().getIdProduto());
            stm.setInt(5, venda.getItens().get(0).getQuantidade());
            
            if (venda.getItens().size() > 1) {
                stm.setInt(6, venda.getItens().get(1).getProduto().getIdProduto());
                stm.setInt(7, venda.getItens().get(1).getQuantidade());
            } else {
                stm.setNull(6, java.sql.Types.INTEGER);
                stm.setNull(7, java.sql.Types.INTEGER);
            }
            
            if (venda.getItens().size() > 2) {
                stm.setInt(8, venda.getItens().get(2).getProduto().getIdProduto());
                stm.setInt(9, venda.getItens().get(2).getQuantidade());
            } else {
                stm.setNull(8, java.sql.Types.INTEGER);
                stm.setNull(9, java.sql.Types.INTEGER);
            }
            
            if (venda.getItens().size() > 3) {
                stm.setInt(10, venda.getItens().get(3).getProduto().getIdProduto());
                stm.setInt(11, venda.getItens().get(3).getQuantidade());
            } else {
                stm.setNull(10, java.sql.Types.INTEGER);
                stm.setNull(11, java.sql.Types.INTEGER);
            }
            
            if (venda.getItens().size() > 4) {
                stm.setInt(12, venda.getItens().get(4).getProduto().getIdProduto());
                stm.setInt(13, venda.getItens().get(4).getQuantidade());
            } else {
                stm.setNull(12, java.sql.Types.INTEGER);
                stm.setNull(13, java.sql.Types.INTEGER);
            }
            
            stm.execute();
            
            for (ItemVenda item: venda.getItens()) {
                EstoqueSaida saidaEstoque = new EstoqueSaida(
                        item.getProduto(), item.getQuantidade(), venda.getDataVenda(), 
                        "Venda para cliente: " + venda.getCliente().getNome());
                estoqueSaidaDAO.incluir(saidaEstoque);
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao registrar venda!");
        }
    }
    
    public ArrayList<Venda> buscar() throws DAOException, SQLException{
        String sqlSelect = "SELECT * from venda "
                + "LEFT JOIN cliente ON cliente.idCliente = venda.idCliente";
        ArrayList<Venda> vendas = new ArrayList();
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);
                ResultSet rs = stm.executeQuery();) {
            while(rs.next()) {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("venda.idVenda"));
                v.setDataVenda(rs.getString("venda.dataVenda"));
                v.setPrecoTotal(rs.getFloat("venda.valorTotal"));
                
                Cliente c = new Cliente(
                    rs.getString("cliente.nome"),
                    rs.getString("cliente.telefone"),
                    rs.getString("cliente.email")
                );
                v.SetCliente(c);
                       
                vendas.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw new DAOException("Erro ao listar vendas!");
        }
        
        return vendas;
    }
    
}
