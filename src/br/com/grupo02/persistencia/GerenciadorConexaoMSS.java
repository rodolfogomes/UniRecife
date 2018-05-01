/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.persistencia;

import br.com.grupo02.erro.ConexaoException;
import br.com.grupo02.interfaces.GerenciadorConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class GerenciadorConexaoMSS implements GerenciadorConexao{

    @Override
    public Connection conectar() throws ConexaoException {
          try {
            return  DriverManager.getConnection("jdbc:sqlserver://localhost;user=projeto;password=projeto");
        } catch (SQLException ex) {
                throw new RuntimeException("ERRO: ",ex);
        }
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
