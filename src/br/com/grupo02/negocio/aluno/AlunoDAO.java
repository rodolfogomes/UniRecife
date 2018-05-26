package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.curso.Curso;
import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class AlunoDAO implements IGerenciarDados<Aluno> {

    @Override
    public void inserir(Aluno aluno) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ALUNO");
        sb.append("(aluno_matricula,aluno_nome,aluno_CPF,aluno_rua,aluno_cidade,");
        sb.append("aluno_CEP,aluno_telefone1,aluno_telefone2,aluno_datanasc,aluno_sexo,");
        sb.append("aluno_dep_codigo,aluno_curso_codigo)");
        sb.append("VALUES");
        sb.append("(?,?,?,?,?,?,?,?,?,?,?,?)");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(i++, aluno.getMatricula());
            pst.setString(i++, aluno.getNome());
            pst.setString(i++, aluno.getCpf());
            pst.setString(i++, aluno.getRua());
            pst.setString(i++, aluno.getCidade());
            pst.setString(i++, aluno.getCep());
            pst.setString(i++, aluno.getTelefone1());
            pst.setString(i++, aluno.getTelefone2());
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
            //pst.setInt(i++, aluno.getDepartamento().getIdDept()); // id dpt
            pst.setInt(i++, aluno.getCurso().getCodigo()); // id curso
            pst.executeUpdate();

        } catch (Exception e) {
            throw new DAOException();
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }

    }

    @Override
    public void atualizar(Aluno aluno) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ALUNO SET ");
        sb.append("aluno_nome=?,aluno_CPF=?,aluno_rua=?,aluno_cidade=?,");
        sb.append("aluno_CEP=?,aluno_telefone1=?,aluno_telefone2=?,aluno_datanasc=?,aluno_sexo=?,");
        sb.append("aluno_dep_codigo=?,aluno_curso_codigo=?");
        sb.append(" WHERE");
        sb.append(" aluno_matricula=?");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setString(i++, aluno.getNome());
            pst.setString(i++, aluno.getCpf());
            pst.setString(i++, aluno.getRua());
            pst.setString(i++, aluno.getCidade());
            pst.setString(i++, aluno.getCep());
            pst.setString(i++, aluno.getTelefone1());
            pst.setString(i++, aluno.getTelefone2());
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
            pst.setInt(i++, aluno.getDepartamento().getId()); // id dpt
            pst.setInt(i++, aluno.getCurso().getCodigo()); // id curso
            pst.setInt(i++, aluno.getMatricula());
            pst.executeUpdate();

        } catch (Exception e) {
            throw new DAOException();
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }
    }

    @Override
    public void deletar(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        String sql = "DELETE FROM ALUNO WHERE aluno_matricula=?";
        PreparedStatement pstm;
        try (Connection con = gc.conectar()) {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
        } catch (Exception e) {
            throw new DAOException();
        }
    }

    @Override
    public List<Aluno> listarTodos() throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        List<Aluno> lista = new ArrayList();
        Aluno alun = null;
        String sql = "SELECT * FROM ALUNO";
        try (Connection con = gc.conectar()) {
            try (Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    //montando o objeto aluno com o resultado da consulta do banco
                    alun = new Aluno();
                    alun.setMatricula(rs.getInt("aluno_matricula"));
                    alun.setNome(rs.getString("aluno_nome"));
                    alun.setRua(rs.getString("aluno_rua"));
                    alun.setCpf(rs.getString("aluno_CPF"));
                    alun.setCep(rs.getString("aluno_CEP"));
                    alun.setCidade(rs.getString("aluno_cidade"));
                    alun.setDatnasc(rs.getDate("aluno_datanasc"));
                    alun.setSexo(rs.getString("aluno_sexo"));
                    alun.setTelefone1(rs.getString("aluno_telefone1"));
                    alun.setTelefone2(rs.getString("aluno_telefone2"));
                    // passando obj departamento 
                    Departamento dpt = new Departamento();
                    dpt.setIdDept(rs.getInt("aluno_dep_codigo"));
                    alun.setDepartamento(dpt);
                     //passando obj curso 
                    Curso crs = new Curso();
                    crs.setCodigo(rs.getInt("aluno_curso_codigo"));
                    alun.setCurso(crs);
                    lista.add(alun);
                }

                return lista;
            }

        } catch (Exception e) {
            throw new DAOException();
        }

    }

    @Override
    public Aluno buscarPorId(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Aluno al;
        String sql = "SELECT * FROM ALUNO WHERE matricula=" + id;
        al = new Aluno();
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    //montando o objeto aluno com o resultado da consulta do banco
                    al.setMatricula(rs.getInt("aluno_matricula"));
                    al.setNome(rs.getString("aluno_nome"));
                    al.setRua(rs.getString("aluno_rua"));
                    al.setCpf(rs.getString("aluno_CPF"));
                    al.setCep(rs.getString("aluno_CEP"));
                    al.setCidade(rs.getString("aluno_cidade"));
                    al.setDatnasc(rs.getDate("aluno_datanasc"));
                    al.setSexo(rs.getString("aluno_sexo"));
                    al.setTelefone1(rs.getString("aluno_telefone1"));
                    al.setTelefone2(rs.getString("aluno_telefone2"));
                    // passando obj departamento 
                    Departamento dpt = new Departamento();
                    dpt.setIdDept(rs.getInt("aluno_dep_codigo"));
                    al.setDepartamento(dpt);
                    //passando obj curso 
                    Curso crs = new Curso();
                    crs.setCodigo(rs.getInt("aluno_curso_codigo"));
                    al.setCurso(crs);
                    
                    
                    return al;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return al;

    }
}
