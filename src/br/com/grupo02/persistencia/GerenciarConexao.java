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

/**
 *
 * @author Daniel Medeiros
 */
public abstract class GerenciarConexao {

    protected Connection conectar() throws ConexaoException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String local = "jdbc:sqlserver://localhost";
            String login = "projeto";
            String senha = "projeto";
            Connection con = DriverManager.getConnection(local, login, senha);
            return con;

        } catch (ClassNotFoundException ex) {
            throw new ConexaoException();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }

    }

    protected void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }

}
