/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rodolfo Gomes
 */
public class CursoDAO  implements IGerenciarDados<Curso> {

    @Override
    public void inserir(Curso curso) throws ConexaoException {
        String sql = "insert into UniRecife.dbo.curso (curso_tipo,curso_cpf_coordenador,curso_cpf_vicecoordenador)values(?,?,?)";
        int index = 0;
         GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        try (Connection con = gc.conectar()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(++index, curso.getTipo());
            //st.setString(++index, curso.getCoordenador());
            // st.setString(++index, curso.getViceCoordenador());
            st.execute();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void atualizar(Curso obj) throws ConexaoException {

    }

    @Override
    public void deletar(Integer id) throws ConexaoException {

    }

    @Override
    public List<Curso> listarTodos() throws ConexaoException {
        return null;

    }

    @Override
    public Curso buscarPorId(Integer id) throws ConexaoException {
        return null;

    }

}
