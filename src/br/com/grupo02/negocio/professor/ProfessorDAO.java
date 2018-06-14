/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.disciplina.Disciplina;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Valeria
 */
public class ProfessorDAO implements IGerenciarDados<Professor>{
    
   /**
    * Método responsável por inserir dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void inserir(Professor professor) throws ConexaoException,DAOException {
     StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Professor ")
        .append("(cpf, nome,telefone,salario)")
        .append("VALUES")
        .append("(?,?,?,?)");
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sb.toString());
            ps.setString(++index, professor.getCpf());
            ps.setString(++index, professor.getNome());
            ps.setString(++index, professor.getTelefone());
            ps.setFloat(++index, professor.getSalario());     
            ps.executeUpdate();         
                
            
            
    } catch (Exception e) {
        e.getMessage();
        e.printStackTrace();
            } finally {
            sb.delete(0, sb.length());
            sb = null;  
        }
    }
    
/**
    * Método responsável por atualizar dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
     * @throws br.com.grupo02.negocio.error.ConexaoException
     * @throws br.com.grupo02.negocio.error.DAOException
   */
    @Override
    public void atualizar(Professor professor) throws ConexaoException, DAOException {
         
       String sql = "update professor set cpf = ?,nome=?,telefone=?,salario = ?"
                + "where id=?";
       
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, professor.getCpf());
            ps.setString(++index, professor.getNome());
            ps.setString(++index, professor.getTelefone());
            ps.setFloat(++index,professor.getSalario());
            ps.setInt(++index, professor.getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
    
/**
    * Método responsável por deletar dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void deletar(Integer id) throws ConexaoException, DAOException{
       
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        String sql = "DELETE FROM professor WHERE id =? ";
        PreparedStatement pst = null;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            pst.close();
        }catch (Exception e) {
            throw new DAOException();
        }
    }
    /**
    * Método responsável por consultar dados na tabela professor através do cpf;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
     @Override
     public Professor buscarPorId(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Professor prf = null;
        String sql = "SELECT * FROM professor WHERE id=" + id;
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);          
                if(rs.next()){
                  //Montando objeto professor com consulta no BD
                   prf = new Professor(); 
                   prf.setId(rs.getInt("id"));
                   prf.setCpf(rs.getString("cpf"));
                   prf.setNome(rs.getString("nome"));
                   prf.setTelefone(rs.getString("telefone"));
                   prf.setSalario(rs.getFloat("salario"));
                   return prf;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return prf;
    }   

  
      
     /**
    * Método responsável por listar todos os dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
       @Override
       public List<Professor> listarTodos() throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        List<Professor> lista = new ArrayList();
        Professor professor = null;
        String sql = "SELECT * FROM PROFESSOR";
        try (Connection con = gc.conectar()) {
            try (Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    //montando o objeto professor com o resultado da consulta do banco
                professor = new Professor ();
                professor.setId(rs.getInt("id") );
                professor.setCpf(rs.getString("cpf"));
                professor.setNome( rs.getString("nome") );
                professor.setTelefone(rs.getString("telefone"));
                professor.setSalario( rs.getFloat("salario"));
                lista.add(professor);
                }   
            return lista;
            }

        } catch (Exception e) {
            throw new DAOException();
        }

    }
       
    public boolean filtrarProfessor(Professor prf, String atributo) throws ConexaoException, DAOException, SQLException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();

        String sql = "SELECT * FROM professor WHERE ? = ?";
        try (Connection con = gc.conectar()) {
            PreparedStatement pstm;
            pstm = con.prepareStatement(sql);
            switch (atributo) {
                case "nome":
                    pstm.setString(1, atributo);
                    pstm.setString(2, prf.getNome());
                    break;
                case "cpf":
                    pstm.setString(1, atributo);
                    pstm.setString(2, prf.getCpf());
                    break;
              
                default:
                    pstm.setString(1, "id");
                    pstm.setInt(2, prf.getId());
            }
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    return true;
                }
            } }
        return false;

        } 

    
}
