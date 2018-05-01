/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.aplicacao;


import br.com.grupo02.erro.ConexaoException;
import br.com.grupo02.interfaces.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciadorConexaoMSS;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) throws SQLException {
     
        GerenciadorConexao gc = new GerenciadorConexaoMSS();
        Connection c;
        try {
            c = gc.conectar();
            System.out.println("Conexão funcionando!");
            gc.desconectar(c);
            
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão!");
        }
        
    }
    
}
