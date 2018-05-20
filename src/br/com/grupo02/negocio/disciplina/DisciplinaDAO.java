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
        String sql = "insert into UniRecife.dbo.disciplina (id,"
                + "nome, descricao, id_dept)"
                + "values(?,?,?,?)";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, disciplina.getIdDisciplina());
            ps.setString(++index, disciplina.getNome());
            ps.setString(++index, disciplina.getDescricao());
            ps.setInt(++index, disciplina.getDepartamento().getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
     }
    
      
    @Override
     public void atualizar(Disciplina disciplina) throws ConexaoException {
     String sql = "update UniRecife.dbo.disciplina set nome = ?,"
                + "descricao = ?, id_dept=?"
                + "where id=?";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, disciplina.getNome());
            ps.setString(++index, disciplina.getDescricao());
            ps.setInt(++index, disciplina.getDepartamento().getId());
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
        String sql = "delete from UniRecife.dbo.disciplina where id ="+id;
        
        try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * @param id
     * @return
     * @throws ConexaoException
     * Consulta da disciplima por ID
     */
    @Override
    public Disciplina buscarPorId(Integer id) throws ConexaoException {
        String sql ="d.id AS Códido,"
                    + "d.nome AS Nome,"
                    + "d.descricao AS Descrição,"
                    + "dt.id_detp AS Departamento"
                    + "from Unirecife.dbo.disciplina AS d left join departamento AS dt"
                        + "on d.id_depto=dt.id_depto"
                    + "where d.id"+id;   
        
            Disciplina disciplina = null;
            Departamento departamento = null;
            
             try (Connection con = GerenciarConexao.getInstancia().conectar()){
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                if(rs.next()){
                  //Montando ref. disciplina
                   disciplina = new Disciplina();
                   disciplina.setIdDisciplina(rs.getInt("id"));
                   disciplina.setNome(rs.getString("nome"));
                   disciplina.setDescricao(rs.getString("descricao"));
                   disciplina.setDepartamento(departamento);
                }
                return disciplina;
             }catch (SQLException ex){
                 ex.printStackTrace();
             }
             
             return disciplina;
    }
    @Override
    public List<Disciplina> listarTodos() throws ConexaoException {

        Connection c = GerenciarConexao.getInstancia().conectar();
         Departamento departamento = null;
         Disciplina disc = new Disciplina();
         
        ArrayList<Disciplina> lista = new ArrayList();
        String sql = "SELECT id,"
                + "nome, descricao, id_dept FROM disciplina";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             
                disc.setIdDisciplina(rs.getInt("id") );
                disc.setNome( rs.getString("nome") );
                disc.setDescricao( rs.getString("descrição") );
                disc.setDepartamento(departamento);
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