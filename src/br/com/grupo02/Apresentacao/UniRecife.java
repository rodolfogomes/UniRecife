/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Apresentacao;


import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import br.com.grupo02.Persistencia.GerenciadorConexao;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) throws SQLException, ConexaoException {
        Connection con= null;
        try {
            con = GerenciadorConexao.getInstance().getConnection();
            System.out.println("Conexão funcionando!");
            
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão!");
        }finally{ 
            GerenciadorConexao.getInstance().desconectar(con);
            System.out.println("Conexão encerrada!");
        }
    }   
}
