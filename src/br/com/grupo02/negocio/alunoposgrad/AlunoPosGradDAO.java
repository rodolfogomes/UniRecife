/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.alunoposgrad;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.negocio.IGerenciarDados;
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
public class AlunoPosGradDAO implements IGerenciarDados<AlunoPosGrad> {
    
     /**
    * Método responsável por inserir dados na tabela AlunoPosGradr;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void inserir(AlunoPosGrad apg) throws ConexaoException, DAOException {
      StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Alunoposgrad ") 
        .append("(id_orientador, bolsa)")
        .append("VALUES")
        .append("(?,?)");
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sb.toString());
            ps.setInt(++index,apg.getIdOrientador().getId());
            ps.setFloat(++index,apg.getValorBolsa());
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
    * Método responsável por atualizar dados na tabela AlunoPosGrad;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(AlunoPosGrad apg) throws ConexaoException,DAOException {
    String sql = "update AlunoPosGrad set id_orientador = ?,bolsa = ?"
                  + "where id = ?";
    
    int index = 0;
    try (Connection con = GerenciarConexao.getInstancia().conectar()){
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index,apg.getIdOrientador().getId());
            ps.setFloat(++index, apg.getValorBolsa());
            ps.setInt(++index, apg.getId());
            ps.execute();
            ps.close();
     } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
    
    /**
    * Método responsável por deletar dados na tabela AlunoPosGrad;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void deletar(Integer id) throws ConexaoException,DAOException {
       
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        String sql = "DELETE FROM Alunoposgrad WHERE id =? ";
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
    * Método responsável por consultar dados na tabela AlunoPosGrad através do id;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
     @Override
     public AlunoPosGrad buscarPorId(Integer id) throws ConexaoException,DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        AlunoPosGrad apg = null;
        String sql = "SELECT * FROM Alunoposgrad WHERE id=" + id;
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);          
                if(rs.next()){
                  //Montando objeto alunoposgrad com consulta no BD
                   apg = new AlunoPosGrad(); 
                   apg.setId(rs.getInt("id"));
                   apg.getIdOrientador().setId(rs.getInt("id_orientador"));
                   apg.setValorBolsa(rs.getFloat("bolsa"));
                   
                   return apg;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return apg;
    }   

  
      
     /**
    * Método responsável por listar todos os dados na tabela AlunoPosGrad;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<AlunoPosGrad> listarTodos() throws ConexaoException,DAOException {
 GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        List<AlunoPosGrad> lista = new ArrayList();
       AlunoPosGrad apg = null;
        String sql = "SELECT * FROM Alunoposgrad";
        try (Connection con = gc.conectar()) {
            try (Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    //montando o objeto AlunoPosGrad com o resultado da consulta do banco
                apg = new AlunoPosGrad ();
                apg.setId(rs.getInt("id"));
                apg.getIdOrientador().setId(rs.getInt("id_orientador"));
                apg.setValorBolsa(rs.getFloat("bolsa"));
                lista.add(apg);
                }   
            return lista;
            }

        } catch (Exception e) {
            throw new DAOException();
        }

    }

    
}
