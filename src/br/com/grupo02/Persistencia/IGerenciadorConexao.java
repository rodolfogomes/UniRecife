/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Persistencia;

import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author ADM
 */
public interface IGerenciadorConexao {
    
    public Connection getConnection()throws ConexaoException;
    
    public void closeConnection(Connection c)throws ConexaoException;
    
}
