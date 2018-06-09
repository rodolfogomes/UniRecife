/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;


import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;


/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {
    // Para realizar os testes criem seus métodos e chamem no main como no exempo abaixo.

    public static void main(String[] args) {
    testaConexao();
    }
        public static void testaConexao(){
        try {
            Connection con =GerenciarConexao.getInstancia().conectar();
            System.out.println("Conexão Funciona!");
            GerenciarConexao.getInstancia().desconectar(con);
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão: " + ex.getMessage());
           ex.printStackTrace();
        }

    }
}
