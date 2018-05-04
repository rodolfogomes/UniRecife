/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Persistencia;

import Negocio.Exceptions.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author ADM
 */
public interface GerenciadorConexao {
    
    public Connection conectar()throws ConexaoException;
    
    public void desconectar(Connection c)throws ConexaoException;
    
}
