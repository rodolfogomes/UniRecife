/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Persistencia;

import Negocio.Exceptions.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class GerenciadorConexaoMSS implements GerenciadorConexao{

    Connection con;
    @Override
    public Connection conectar() throws ConexaoException {
          try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;user=projeto;password=projeto");
        } catch (SQLException e) {
                throw new ConexaoException();
        }
          return con;
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
           try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }
    
    
    
}
