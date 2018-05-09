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

        String local = "jdbc:postgresql://localhost:5432/teste";
        String user = "postgres";
        String pass = "postgres";

        try {
            Connection con = DriverManager.getConnection(local, user, pass);
            return con;

        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        return null;
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
