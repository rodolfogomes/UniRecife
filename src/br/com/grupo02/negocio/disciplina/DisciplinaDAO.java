/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.negocio.departamento.Departamento;
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
 * Implementação dos métodos CRUD
 * @author Bruno Rodrigues
 */
public class DisciplinaDAO implements IGerenciarDados <Disciplina> {
    
    
    @Override
    public void inserir(Disciplina disciplina) throws ConexaoException {
        String sql = "insert into UniRecife.dbo.disciplina (disciplina_codigo_disciplina,"
                + "disciplina_nome, disciplina_descricao, disciplina_dep_codigo)"
                + "values(?,?,?,?)";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, disciplina.getIdDisciplina());
            ps.setString(++index, disciplina.getNome());
            ps.setString(++index, disciplina.getDescricao());
            ps.setInt(++index, disciplina.getDepartamento().getIdDept());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
     }
    
      
    @Override
     public void atualizar(Disciplina disciplina) throws ConexaoException {
     String sql = "update UniRecife.dbo.disciplina set disciplina_nome = ?,"
                + "disciplina_descricao = ?, disciplina_dep_codigo =?"
                + "where disciplina_codigo_disciplina=?";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, disciplina.getNome());
            ps.setString(++index, disciplina.getDescricao());
            ps.setInt(++index, disciplina.getDepartamento().getIdDept());
            ps.setInt(++index, disciplina.getIdDisciplina());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
     
    @Override
    public void deletar(Integer id) throws ConexaoException {
        String sql = "delete from UniRecife.dbo.disciplina where disciplina_codigo_disciplina ="+id;
        
        try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // Revisar Método
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
                disc.setDescricao (rs.getString("descrição"));
                //disc.setDepartamento(rs.getInt("departamento"));
            return disc;
            }
            st.close();

        }catch (SQLException ex) {
            ex.getMessage();

        }
        return disc;
    }
     // Revisar Método
    @Override
    public List<Disciplina> listarTodos() throws ConexaoException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<Disciplina> lista = new ArrayList();
        String sql = "SELECT disciplina_codigo_disciplina,"
                + "disciplina_nome, disciplina_descricao, disciplina_dep_codigo FROM disciplina";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             Disciplina disc = new Disciplina();
                disc.setIdDisciplina(rs.getInt("cógido disciplina") );
                disc.setNome( rs.getString("nome") );
                disc.setDescricao( rs.getString("descrição") );
                //disc.setDepartamento(rs.getInt("departamento"));
                lista.add(disc);
            }
            return lista;
        }catch(SQLException ex){
             ex.getMessage();
        }finally{
            GerenciarConexao.getInstancia().desconectar(c);
        }        
           return lista;  
    }
}
        