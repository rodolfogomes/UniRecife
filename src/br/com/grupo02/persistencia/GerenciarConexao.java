/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.persistencia;

import br.com.grupo02.negocio.error.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Daniel Medeiros
 */
public class GerenciarConexao implements GerenciadorConexao {

    private final String URL;
    private final String USU;
    private final String SEN;
    private static GerenciarConexao instancia;

    public GerenciarConexao(String URL, String USU, String SEN) {
        this.URL = URL;
        this.USU = USU;
        this.SEN = SEN;
    }

    private GerenciarConexao() {

        ResourceBundle rb = ResourceBundle.getBundle("br.com.grupo02.persistencia.DataBase");
        URL = rb.getString("url");
        USU = rb.getString("usuario");
        SEN = rb.getString("senha");

    }

    public static GerenciarConexao getInstancia() {

        if (instancia == null) {
            instancia = new GerenciarConexao();
        }

        return instancia;
    }

    @Override
    public Connection conectar() throws ConexaoException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USU, SEN);
            return con;

        } catch (SQLException ex) {
          throw new ConexaoException();
            
        }
    }

    ;

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }
};
