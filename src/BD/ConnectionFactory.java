/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author Rodolfo Gomes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import sun.applet.Main;

public class ConnectionFactory {
    
    /**
     *
     * Método para gerar conexão com o banco de dados.
     * @throws java.sql.SQLException
     */
      public static Connection getConnection() throws SQLException{
        try {
            /* Tenta se conectar */
            return  DriverManager.getConnection("jdbc:sqlserver://localhost;user=projeto;password=projeto");
        } catch (SQLException ex) {
                throw new RuntimeException("ERRO: ",ex);
        }
    }
    
     
}
  