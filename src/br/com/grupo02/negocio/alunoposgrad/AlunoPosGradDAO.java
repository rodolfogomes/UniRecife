/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.alunoposgrad;
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
public class AlunoPosGradDAO implements IGerenciarDados<AlunoPosGrad> {
    
     /**
    * Método responsável por inserir dados na tabela AlunoPosGradr;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void inserir(AlunoPosGrad apg) throws ConexaoException,DAOException {
      
    String sql = "insert into UniRecife.dbo.alunoposgrad ( valor_bolsa, id_orientador)values(?,?)";
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(++index, apg.getValorBolsa());
            ps.setInt(++index, apg.getIdOrientador().getId());
            ps.execute();
            ps.close();           
            
            
    } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
            throw new ConexaoException();
        }
    }
    
    /**
    * Método responsável por atualizar dados na tabela AlunoPosGrad;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(AlunoPosGrad apg) throws ConexaoException,DAOException {
    String sql = "update AlunoPosGrad set valor_bolsa = ?,id_orientador = ?"
                  + "where id = ?";
    
    int index = 0;
    try (Connection con = GerenciarConexao.getInstancia().conectar()){
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(++index, apg.getValorBolsa());
            ps.setInt(++index,apg.getIdOrientador().getId());
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
       
        String sql = "delete from alunoposgrad where id = ?"+id;
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   
       /**
    * Método responsável por consultar dados na tabela AlunoPosGrad através do id;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
     @Override
     public AlunoPosGrad buscarPorId(Integer id) throws ConexaoException,DAOException {
         
        String sql = "SELECT * FROM AlunoPosGrad WHERE id=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
            if (rs.next()) {
                AlunoPosGrad al = new AlunoPosGrad();
                al.setValorBolsa(rs.getFloat("valor_bolsa"));
                al.getIdOrientador().setId(rs.getInt("id_orientador"));
                return al;

            

            }
            st.close();


        } catch (SQLException ex) {
            ex.getMessage();

        }
        return null;
        }   

    
     /**
    * Método responsável por listar todos os dados na tabela AlunoPosGrad;
    * @param AlunoPosGrad objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<AlunoPosGrad> listarTodos() throws ConexaoException,DAOException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<AlunoPosGrad> lista = new ArrayList();
        String sql = "SELECT id,valor_bolsa,id_orientador FROM alunoposgrad";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             AlunoPosGrad   al = new AlunoPosGrad();
                al.setId(rs.getInt("id"));
                al.setValorBolsa(rs.getFloat("valor_bolsa"));
                al.getIdOrientador().setId(rs.getInt("id_orientador"));
                lista.add(al);
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
