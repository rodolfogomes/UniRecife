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
            String local = "jdbc:jtds:sqlserver://sql.locadados.com.br:1433/UniRecife2";
            String base ="UniRecife2";
            String login = "sa";
            String senha = "projeto";
//            String url ="jdbc:sqlserver://localhost:1433;\\\\SQLEXPRESS;databaseName=Tema6\",\"sa\",\"123456\";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println(url);
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=UniRecife2","sa","projeto");
            System.out.println(local+login+senha);
            return con;

        } catch (ClassNotFoundException |SQLException ex) {
            ex.getMessage();
            System.out.println(ex.getMessage());
        } 
        return null;

    }

    protected void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }

}
