/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.oferta;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Valeria
 */
public class OfertaDao implements IGerenciarDados<Oferta> {
    
    /**
    * Método responsável por inserir dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    
    @Override
    public void inserir (Oferta oferta) throws ConexaoException,DAOException {
         StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Oferta ")
        .append("(id_disciplina,id_professor,horario )")
        .append("VALUES")
        .append("(?,?,?)");
            
        int i = 1;        
        try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement pst; 
            pst = con.prepareStatement(sb.toString());
            pst.setDate(i++, oferta.getHorario());
            pst.setInt(i++, oferta.getIDisciplina().getId());
            pst.setInt(i++, oferta.getIdProfessor().getId());
            pst.executeUpdate();
            pst.close();
            
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }finally {
            sb.delete(0, sb.length());
            sb = null;     
        }
    }
    /**
    * Método responsável por atualizar dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(Oferta oferta) throws ConexaoException, DAOException {
         
        String sql = "update oferta set id_disciplina = ?,id_professor =?,horario=?"
                + "where id=?";
      
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, oferta.getIDisciplina().getId());
            ps.setInt(++index, oferta.getIdProfessor().getId());
            ps.setDate(++index, oferta.getHorario());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        } 
    }
/**
    * Método responsável por deletar dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void deletar(Integer id) throws ConexaoException,DAOException {
       
        String sql = "delete from UniRecife.dbo.ofertar where id = ?"+id;
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    
    }
    /**
    * Método responsável por consultar dados na tabela oferta através do id;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
     @Override
     public Oferta buscarPorId(Integer id) throws ConexaoException,DAOException {
         
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Oferta ofr = null;
        String sql = "SELECT * FROM oferta WHERE id=" + id;
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);          
                if(rs.next()){
                  //Montando objeto oferta com consulta no BD
                   ofr = new Oferta(); 
                   ofr.setId(rs.getInt("id"));
                   ofr.getIDisciplina().setId(rs.getInt("id_disciplina"));
                   ofr.getIdProfessor().setId(rs.getInt("id_professor"));
                   ofr.setHorario(rs.getDate("horario"));
                   return ofr;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return ofr;
    }   

  
      
     /**
    * Método responsável por listar todos os dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<Oferta> listarTodos() throws ConexaoException,DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        List<Oferta> lista = new ArrayList();
        Oferta oferta = null;
        String sql = "SELECT * FROM Oferta";
        try (Connection con = gc.conectar()) {
            try (Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    //montando o objeto oferta com o resultado da consulta do banco
                oferta = new Oferta();
                oferta.setId(rs.getInt("id"));
                oferta.getIDisciplina().setId(rs.getInt("id_disciplina"));
                oferta.getIdProfessor().setId(rs.getInt("id_professor"));
                oferta.setHorario(rs.getDate("horario"));
                lista.add(oferta);
                }   
            return lista;
            }

        } catch (Exception e) {
            throw new DAOException();
        }

        
    }        

   
  
}