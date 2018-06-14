/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.persistencia.IGerenciarDados;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodolfo Gomes
 */
public class CursoDAO implements IGerenciarDados<Curso> {

    @Override
    public void inserir(Curso curso) throws ConexaoException {
        String sql = "insert into curso (descricao)"
                + "values(?)";
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, curso.getDescricao());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void atualizar(Curso curso) throws ConexaoException {
        String sql = "update curso set descricao = ? where id=?";
                
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, curso.getDescricao());
            ps.setInt(++index, curso.getCodigo());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        String sql = "delete from curso where id = ?";

        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Curso> listarTodos() throws ConexaoException {
        List<Curso> listaCurso = new ArrayList();
        StringBuilder sql = new StringBuilder();
         sql.append("select * from curso ");
        
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql.toString());
            while (rs.next()) {
                
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("id"));
                curso.setDescricao(rs.getString("Descricao"));

                listaCurso.add(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCurso;
    }

    /**
     *
     * @param id
     * @return Uma referência do tipo curso carregada com seus dados.
     * @throws ConexaoException
     */
    @Override
    public Curso buscarPorId(Integer id) throws ConexaoException {
        StringBuilder sb = new StringBuilder();
        sb.append("select c.id as id,c.descricao as descricao")
                .append(" from curso c ")
                .append("where c.id = ").append(id);

        Curso curso = null;

        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sb.toString());

            if (rs.next()) {
                curso = new Curso();
                curso.setCodigo(rs.getInt("id"));
                curso.setDescricao(rs.getString("descricao"));
               
            }
            return curso;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }

        return curso;
    }

}
