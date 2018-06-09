/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.negocio.IGerenciarDados;
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
        String sql = "insert into curso (descricao,id_coordenador,id_vicecoordenador)"
                + "values(?,?,?)";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, curso.getDescricao());
            ps.setString(++index, curso.getCoordenador().getCpf());
            ps.setString(++index, curso.getViceCoordenador().getCpf());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void atualizar(Curso curso) throws ConexaoException {
        String sql = "update curso set curso_tipo = ?,curso_cpf_coordenador=?,curso_cpf_vicecoordenador=?"
                + "where curso_codigo=?";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, curso.getDescricao());
            ps.setString(++index, curso.getCoordenador().getCpf());
            ps.setString(++index, curso.getViceCoordenador().getCpf());
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
        ArrayList<Curso> listaCurso = new ArrayList();
        String sql;
        PreparedStatement ps = null;
        sql ="select * from curso";

        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                // Montando uma referência curso
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("curso_codigo"));
                curso.setDescricao(rs.getString("curso_tipo"));
                curso.getCoordenador().setId(rs.getInt("id_coordenador"));
                curso.getViceCoordenador().setId(rs.getInt("id_vicecoordenador"));

                listaCurso.add(curso);

            }

            ps.execute();
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
               sb.append("select c.id as id,p.id as p_id,c.descricao as descricao,c.id_coordenador AS cpf_coor,")
                .append("c.id_vicecoordenador AS cpf_Vice,p.nome AS nome_prof,p.dep_codigo AS dep_prof,")
                .append("p.telefone AS tel_prof,p.salario AS sal_prof")        
                .append(" from curso c  join professor p")
                .append("on (c.id_coordenador = p.id) ")
                .append("where c.id = ").append(id);
                

        Curso curso = null;

        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sb.toString());

            if (rs.next()) {
                // Montando uma referência curso
                curso = new Curso();
                curso.setCodigo(rs.getInt("id"));
                curso.setDescricao(rs.getString("descricao"));
                curso.getCoordenador().setId(rs.getInt("id_coordenador"));
                curso.getViceCoordenador().setId(rs.getInt("id_vicecoordenador"));
            }
            return curso;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            sb.delete(0, sb.length());
            sb = null;
        }

        return curso;
    }

}
