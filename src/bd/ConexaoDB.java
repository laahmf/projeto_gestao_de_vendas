package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDB {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!");
        }
    }

    public static Connection conectar() {
        String servidor = "localhost";
        String porta = "3306";
        String database = "modulo_vendas";
        String usuario = "admin_vendas";
        String senha = "administrador";
        
        String conexao = "jdbc:mysql://" + servidor + ":" + porta + "/" + database;
        // Para corrigir timezone
        conexao += "?useTimezone=true&serverTimezone=UTC";
        
        try {
            return DriverManager.getConnection(conexao, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!");
            return null;
        }
    }

    public static void desconectar(Connection conn) throws SQLException {
        conn.close();
    }

}
