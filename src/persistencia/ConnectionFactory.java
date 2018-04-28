/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
    
      /* Configura os parâmetros da conexão */
           private static final String  URL = "jdbc:mysql:ip:porta/schema";
           private static final String  USERNAME = "projeto"; 
           private static final String  PASSWORD = "projeto";
    
    
    public static Connection getConnection() throws SQLException{
        try {
            /* Tenta se conectar */
            return  DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
                throw new RuntimeException("ERRO: ",ex);
        }
    }
    
     
}
  