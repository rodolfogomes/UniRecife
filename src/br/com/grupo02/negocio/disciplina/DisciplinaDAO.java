/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
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
 * Implementação dos métodos CRUD com otimizacao utlizando stringBuilder
 *
 * @author Bruno Rodrigues /Git: @Brunojgrc
 */
public class DisciplinaDAO implements IGerenciarDados<Disciplina> {

    @Override
    public void inserir(Disciplina disciplina) throws ConexaoException, DAOException {

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Disciplina ")
                .append("(nome, descricao)")
                .append("VALUES")
                .append("(?,?)");

        int i = 1;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement pst;
            pst = con.prepareStatement(sb.toString());
            pst.setString(i++, disciplina.getNome());
            pst.setString(i++, disciplina.getDescricao());
            //pst.setInt(i++, disciplina.getDepartamento().getId()); //id departamento
            pst.executeUpdate();

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }
    }

    @Override
    public void atualizar(Disciplina disciplina) throws ConexaoException, DAOException {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE DISCIPLINA SET ");
        sb.append("nome=?, descricao=?");
        sb.append("WHERE");
        sb.append(" id=?");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            pst = con.prepareStatement(sql);
            pst.setString(i++, disciplina.getNome());
            pst.setString(i++, disciplina.getDescricao());
           // pst.setInt(i++, disciplina.getDepartamento().getId());
            pst.setInt(i++, disciplina.getId());
            pst.execute();
            pst.close();
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

        String sql = "DELETE FROM DISCIPLINA WHERE id =? ";
        PreparedStatement pst = null;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            pst.close();
        } catch (Exception e) {
            throw new DAOException();
        }
    }

    @Override
    public Disciplina buscarPorId(Integer id) throws ConexaoException, DAOException {

        Disciplina disc = null;
        String sql = "SELECT * FROM DISCIPLINA WHERE id=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //Montando objeto disciplina com consulta no BD
                disc = new Disciplina();
                disc.setId(rs.getInt("id"));
                disc.setNome(rs.getString("nome"));
                disc.setDescricao(rs.getString("descricao"));
                // passando obj departamento
                /*Departamento dept = new Departamento();
                dept.setId(rs.getInt("id_dept"));
               disc.setDepartamento(dept); */
                return disc;
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return disc;
    }

    @Override
    public List<Disciplina> listarTodos() throws ConexaoException, DAOException {

        List<Disciplina> lista = new ArrayList();
        Disciplina disciplina = null;
        String sql = "SELECT * FROM DISCIPLINA";
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                //montando o objeto disciplina com o resultado da consulta do banco
                disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setDescricao(rs.getString("descricao"));
               /* Departamento dept = new Departamento();
                dept.setId(rs.getInt("id_dept"));
                disciplina.setDepartamento(dept);
                */lista.add(disciplina);
            }
            return lista;

        } catch (Exception e) {
            throw new DAOException();
        }

    }

    boolean save(Disciplina disc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean filtrarDisciplina(Disciplina disciplina, String atributo) throws ConexaoException, DAOException {

        String sql = "SELECT * FROM DISCIPLINA WHERE ? = ?";
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement pstm;
            pstm = con.prepareStatement(sql);
            switch (atributo) {
                case "Nome":
                    pstm.setString(1, atributo);
                    pstm.setString(2, disciplina.getNome());
                    break;
                case "descricao":
                    pstm.setString(1, atributo);
                    pstm.setString(2, disciplina.getDescricao());
                    break;
                default:
                    pstm.setString(1, "id");
                    pstm.setInt(2, disciplina.getId());
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
