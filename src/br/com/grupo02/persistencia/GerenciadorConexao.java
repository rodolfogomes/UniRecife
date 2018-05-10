/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.persistencia;

import br.com.grupo02.negocio.error.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author Daniel
 */
public interface GerenciadorConexao {
    
    /**
     * Estabelece uma conexao com o BD
     * @return Objeto de conexao com o BD
     */
    public Connection conectar()throws ConexaoException;
    
    /**
     * Encerra uma conexao ativa
     * @param c Objeto com a conexao a ser fechada
     */
    public void desconectar(Connection c)throws ConexaoException;
}