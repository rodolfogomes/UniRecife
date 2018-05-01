/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) throws SQLException {
     
        Connection con = ConnectionFactory.getConnection();
        System.out.println("Conexão funciona!");
        con.close();
        
    }
    
}
