/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.negocio.IGerenciarDados;
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
public class ProfessorDAO implements IGerenciarDados<Professor>{
    
   /**
    * Método responsável por inserir dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void inserir(Professor prf) throws ConexaoException {
      
    String sql = "insert into professor ( professor_cpf,professor_nome,professor_dep_codigo,professor_salario,professor_telefone)values(?,?,?,?,?)";
    
    int index = 0;
     try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, prf.getCpf());
            ps.setString(++index, prf.getNome());
            ps.setInt(++index, prf.getDepartamento().getId());
            ps.setFloat(++index, prf.getSalario());
            ps.setString(++index, prf.getTelefone());
            ps.execute();
            ps.close();
            
                
            
            
    } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
/**
    * Método responsável por atualizar dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
    @Override
    public void atualizar(Professor prf) throws ConexaoException {
    String sql = "update professor set cpf = ?,nome = ?,dep_codigo = ?,telefone = ?,salario= ?"
                  + "where id = ?";
    
    int index = 0;
    try (Connection con = GerenciarConexao.getInstancia().conectar()){
        PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(++index, prf.getCpf());
            ps.setString(++index, prf.getNome());
            ps.setInt(++index, prf.getDepartamento().getId());
            ps.setString(++index, prf.getTelefone());
            ps.setFloat(++index, prf.getSalario());
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
    public void deletar(Integer id) throws ConexaoException {
       
        String sql = "delete from professor where professor_cpf = ?"+id;
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    
    }
    /**
    * Método responsável por consultar dados na tabela professor através do cpf;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
     @Override
     public Professor buscarPorId(Integer id) throws ConexaoException {
         
        String sql = "SELECT * FROM PROFESSOR WHERE id=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
            if (rs.next()) {
                Professor pl = new Professor();
                pl.setCpf(rs.getString("cpf"));
                pl.setNome(rs.getString("nome"));
                pl.getDepartamento().setId(rs.getInt("dep_codigo"));
                pl.setSalario(rs.getFloat("salario"));
                pl.setTelefone(rs.getString("telefone"));
                return pl;

            

            }
            st.close();


        } catch (SQLException ex) {
            ex.getMessage();

        }
        return null;
        }
        
      
     /**
    * Método responsável por listar todos os dados na tabela professor;
    * @param professor objeto que será inserido quando esse método for chamado;
   */
        @Override
        public List<Professor> listarTodos() throws ConexaoException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<Professor> lista = new ArrayList();
        String sql = "SELECT id,cpf,nome,dnumero,telefone,salario FROM professor";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             Professor   ps = new Professor();
                ps.setId(rs.getInt("id"));
                ps.setCpf(  rs.getString("cpf") );
                ps.setNome( rs.getString("nome") );
                ps.getDepartamento().setId(rs.getInt("dep_codigo"));
                ps.setTelefone(rs.getString("telefone"));
                ps.setSalario( rs.getFloat("salario") );
                lista.add(ps);
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



