/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.matricula;
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
public class MatriculaDAO implements IGerenciarDados<Matricula>{

/**
    * Método responsável por inserir dados na tabela matricula;
    * @param Matricula objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void inserir(Matricula mat) throws ConexaoException, DAOException {
      
    StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Matricula ")
        .append("(id_oferta)")
        .append("VALUES")
        .append("(?)");
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sb.toString()); 
            ps.setInt(++index, mat.getIdOferta().getId());
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
    * Método responsável por atualizar dados na tabela matricula;
    * @param matricula objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(Matricula mat) throws ConexaoException, DAOException {
        
    String sql = "update matricula set id_oferta = ?" + "where id = ?";
    
    int index = 0;
    try (Connection con = GerenciarConexao.getInstancia().conectar()){
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, mat.getIdOferta().getId());
            ps.setInt(++index,mat.getId());
            ps.execute();
            ps.close();
     } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
            
/**
    * Método responsável por deletar dados na tabela matricula;
    * @param matricula objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void deletar(Integer id) throws ConexaoException, DAOException {
       
        String sql =  "DELETE FROM matricula WHERE id =? ";
            
           GerenciadorConexao gc;
           gc = GerenciarConexao.getInstancia();
           PreparedStatement pst = null;
            try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            pst.close();
            }catch (Exception e) {throw new DAOException();}
    
    }
    
    /**
    * Método responsável por consultar dados na tabela matricula através do id;
    * @param matricula objeto que será inserido quando esse método for chamado;
   */
     @Override
     public Matricula buscarPorId(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Matricula mat = null;
        String sql = "SELECT * FROM matricula WHERE id=" + id;
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                 ResultSet rs = st.executeQuery(sql);          
                    if(rs.next()){
                  //Montando objeto matricula com consulta no BD
                   mat = new Matricula(); 
                   
                   mat.setId(rs.getInt("id"));
                   mat.getIdOferta().setId(rs.getInt("id_oferta"));
                   return mat;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return mat;
    }   
    /**
    * Método responsável por listar todos os dados na tabela matricula;
    * @param matricula objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<Matricula> listarTodos() throws ConexaoException, DAOException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<Matricula> lista = new ArrayList();
        String sql = "SELECT id, id_oferta FROM matricula";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             Matricula   ms = new Matricula();
                ms.setId(rs.getInt("id"));
                ms.getIdOferta().setId(rs.getInt("id_oferta"));
                lista.add(ms);
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
    
     

