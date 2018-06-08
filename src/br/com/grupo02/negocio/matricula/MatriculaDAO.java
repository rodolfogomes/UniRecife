/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.matricula;
import br.com.grupo02.negocio.IGerenciarDados;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

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
      
    String sql = "insert into UniRecife.dbo.matricula ( id, id_oferta)values(?,?)";
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, mat.getIdOferta().getId());
            ps.execute();
            ps.close();  
     } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
            throw new ConexaoException();
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
       
        String sql = "delete from matricula where id = ?"+id;
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    
    }
    
    /**
    * Método responsável por consultar dados na tabela matricula através do id;
    * @param matricula objeto que será inserido quando esse método for chamado;
   */
     @Override
     public Matricula buscarPorId(Integer id) throws ConexaoException, DAOException {
         
        String sql = "SELECT * FROM matricula WHERE id=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
            if (rs.next()) {
                Matricula ml = new Matricula();
                ml.setId(rs.getInt("id"));
                ml.getIdOferta().setId(rs.getInt("id_oferta"));
                return ml;

            

            }
            st.close();


        } catch (SQLException ex) {
            ex.getMessage();

        }
        return null;
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