/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.aplicacao.aluno;
import br.com.grupo02.erro.ConexaoException;
import br.com.grupo02.interfaces.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciadorConexaoMSS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanna
 */
public class ProfessorDAO extends GerenciadorConexaoMSS implements GerenciadorConexao {
   @Override
    public void salvar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GerenciadorConexao carregar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professor listar() {
        Professor pl = null;
        String sql = "SELECT * FROM PROFESSOR";
        try {
            Connection con = conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pl = new Professor();
                pl.setNome(rs.getString("nome"));
            }
            st.close();
            return pl;
        } catch (ConexaoException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
    }
    }
