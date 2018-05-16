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

    public static void main(String[] args) {

        try {
            Connection con =GerenciarConexao.getInstancia().conectar();
            System.out.println("Conexão Funciona!");
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão: " + ex.getMessage());
           ex.printStackTrace();
        }

    }
}
