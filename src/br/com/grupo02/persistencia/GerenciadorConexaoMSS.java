/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.persistencia;

import br.com.grupo02.erro.ConexaoException;
import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADM
 */
public abstract class GerenciadorConexaoMSS {

    private static Connection conectar() throws ConexaoException {
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

    public void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }

}
