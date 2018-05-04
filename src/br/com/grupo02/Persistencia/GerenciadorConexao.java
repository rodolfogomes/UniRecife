/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Persistencia;

import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public class GerenciadorConexao implements IGerenciadorConexao{
    
    private static GerenciadorConexao intancia;
    Connection con;
    /**
     * implementando o padrão Singleton. Garante que só haverá uma instância para conexão com o banco de dados.
     * @return Uma instância de conexão com o banco de dados 
     */
    public static GerenciadorConexao getInstance(){
        if(intancia == null){
            intancia = new GerenciadorConexao();
        }
        return intancia;
    }
    
    /**
     * Método para pegar uma conexão com o banco de dados.
     * @return Retorna conexão.
     * @throws ConexaoException 
     */
    @Override
    public Connection getConnection() throws ConexaoException {
          try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;user=projeto;password=projeto");
        } catch (SQLException e) {
                throw new ConexaoException();
        }
          return con;
    }

    /**
     * Recebe uma conexão e fecha.
     * @param c
     * @throws ConexaoException 
     */
    @Override
    public void desconectar(Connection c) throws ConexaoException {
           try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }
    
    
    
}
