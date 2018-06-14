package br.com.grupo02.negocio.aluno;

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
        sb.append("(matricula,nome,CPF,rua,cidade,");
        sb.append("CEP,telefone,datanasc,sexo,");
        sb.append("VALUES");
        sb.append("(?,?,?,?,?,?,?,?,?)");
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
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
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
        sb.append("nome=?,CPF=?,rua=?,cidade=?,");
        sb.append("CEP=?,telefone=?,datanasc=?,sexo=?,");
        sb.append(" WHERE");
        sb.append(" matricula=?");
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
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
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
        String sql = "DELETE FROM ALUNO WHERE matricula=?";
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
                    alun.setMatricula(rs.getInt("matricula"));
                    alun.setNome(rs.getString("nome"));
                    alun.setRua(rs.getString("rua"));
                    alun.setCpf(rs.getString("CPF"));
                    alun.setCep(rs.getString("CEP"));
                    alun.setCidade(rs.getString("cidade"));
                    alun.setDatnasc(rs.getDate("datanasc"));
                    alun.setSexo(rs.getString("sexo"));
                    alun.setTelefone1(rs.getString("telefone"));
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
        String sql = "SELECT * FROM ALUNO WHERE id=" + id;
        al = new Aluno();
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    //montando o objeto aluno com o resultado da consulta do banco
                    al.setMatricula(rs.getInt("matricula"));
                    al.setNome(rs.getString("nome"));
                    al.setRua(rs.getString("rua"));
                    al.setCpf(rs.getString("CPF"));
                    al.setCep(rs.getString("CEP"));
                    al.setCidade(rs.getString("cidade"));
                    al.setDatnasc(rs.getDate("datanasc"));
                    al.setSexo(rs.getString("sexo"));
                    al.setTelefone1(rs.getString("telefone"));

                    return al;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return al;

    }

    public boolean filtrarAluno(Aluno al, String atributo) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();

        String sql = "SELECT * FROM ALUNO WHERE ? = ?";
        try (Connection con = gc.conectar()) {
            PreparedStatement pstm;
            pstm = con.prepareStatement(sql);
            switch (atributo) {
                case "nome":
                    pstm.setString(1, atributo);
                    pstm.setString(2, al.getNome());
                    break;
                case "cpf":
                    pstm.setString(1, atributo);
                    pstm.setString(2, al.getCpf());
                    break;
                case "matricula":
                    pstm.setString(1, atributo);
                    pstm.setInt(2, al.getMatricula());
                    break;
                default:
                    pstm.setString(1, "id");
                    pstm.setInt(2, al.getId());
            }
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return false;
    }
}
