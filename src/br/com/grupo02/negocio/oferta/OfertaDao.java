/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.oferta;
import br.com.grupo02.persistencia.IGerenciarDados;
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
public class OfertaDao implements IGerenciarDados<Oferta> {
    
    /**
    * Método responsável por inserir dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    
    @Override
    public void inserir (Oferta ofr) throws ConexaoException,DAOException {
        String sql = "insert into oferta (horario, id_professor, id_disciplina)values (?,?,?)";
        int index = 0;
        
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, ofr.getHorario());
            ps.setInt(++index, ofr.getIdProfessor().getId());   
            ps.setInt(++index, ofr.getIDisciplina().getId());
            ps.execute();
            ps.close(); 
    }catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
            throw new ConexaoException();
        }
    
    
}
    /**
    * Método responsável por atualizar dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(Oferta ofr) throws ConexaoException,DAOException {
    String sql = "update oferta set horario = ?,Id_professor = ?,id_disciplina = ?"
                  + "where id = ?";
    
    int index = 0;
    
    try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, ofr.getHorario());
            ps.setInt(++index, ofr.getIdProfessor().getId());   
            ps.setInt(++index, ofr.getIDisciplina().getId());
            ps.execute();
            ps.close(); 
    }catch (SQLException ex) {
            ex.printStackTrace();
            ex.getMessage();
            throw new ConexaoException();
        }
}
    
/**
    * Método responsável por deletar dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void deletar(Integer id) throws ConexaoException,DAOException {
       
        String sql = "delete from ofertar where id = ?"+id;
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
         
        String sql = "SELECT * FROM oferta WHERE id=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
            if (rs.next()) {
                Oferta of = new Oferta();
                of.setHorario(rs.getString("horario"));
                of.getIdProfessor().setId(rs.getInt("id_professor"));
                of.getIDisciplina().setId(rs.getInt("id_disciplina"));
                return of;

            

            }
            st.close();


        } catch (SQLException ex) {
            ex.getMessage();

        }
        return null;
        }
        
      
     /**
    * Método responsável por listar todos os dados na tabela oferta;
    * @param oferta objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<Oferta> listarTodos() throws ConexaoException,DAOException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<Oferta> lista = new ArrayList();
        String sql = "SELECT id,horario,id_professor,id_disciplina FROM oferta";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             Oferta   oft = new Oferta();
                oft.setId(rs.getInt("id"));
                oft.getIdProfessor().setId(rs.getInt("id_professor"));
                oft.getIDisciplina().setId(rs.getInt("id_disciplina"));
                oft.setHorario(rs.getString("horario")); 
                lista.add(oft);
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