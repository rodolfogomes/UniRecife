/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 *
 * @author Bruno Rodrigues
 */
public class DisciplinaDAO implements IGerenciarDados <Disciplina> {
    
    @Override
    public void inserir(Disciplina obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Disciplina obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List <Disciplina> listarTodos() throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
    @Override
    public Disciplina buscarPorId(Integer id) throws ConexaoException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Disciplina disc;
        String sql = "SELECT * FROM DISCIPLINA WHERE codigo disciplina=" + id;
        disc = new Disciplina();
        try (Connection con = gc.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                disc.setIdDisciplina(rs.getInt("idDisciplina"));
                disc.setNome(rs.getString("nome"));
//              disc.setDescricao (rs.getString("descrição"));
//              disc.setIdDept(rs.getInt("idDepto"));
                return disc;
            }
            st.close();

        } catch (SQLException ex) {
            ex.getMessage();

        }
        return disc;
    }
}
