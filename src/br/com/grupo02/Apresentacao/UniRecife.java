/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Apresentacao;


import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import br.com.grupo02.Persistencia.GerenciadorConexaoMSS;
import java.sql.Connection;
import java.sql.SQLException;
import br.com.grupo02.Persistencia.IGerenciadorConexao;

/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) throws SQLException {
     
        IGerenciadorConexao gc = new GerenciadorConexaoMSS();
        Connection c;
        try {
            c = gc.conectar();
            System.out.println("Conexão funcionando!");
            gc.desconectar(c);
            System.out.println("Conexão fechada!");
            
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão!");
        }
        
    }
    
}
