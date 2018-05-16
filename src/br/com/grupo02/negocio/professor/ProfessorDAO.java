/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import java.sql.Connection;
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
    
     @Override
    public void inserir(Professor prf) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Professor prf) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
     public Professor buscarPorId(Integer id) throws ConexaoException {
         // Joanna esse cara aqui é static não precisa criar uma referencia para elea e nesse caso
         //vc tem que retornar uma conexão tipo assim:
         /*
         Connection con = GerenciarConexao.getInstancia.getConectar();
         
         */
        String sql = "SELECT * FROM PROFESSOR WHERE cpf=" + id;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                Professor pl = new Professor();
                pl.setCpf(rs.getString("cpf"));
                pl.setNome(rs.getString("nome"));
                pl.setDnumero(rs.getInt("numero"));
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
        
      
     
        @Override
        public List<Professor> listarTodos() throws ConexaoException {

        Connection c = GerenciarConexao.getInstancia().conectar();
        
        ArrayList<Professor> lista = new ArrayList();
        String sql = "SELECT cpf,nome,dnumero,telefone,salario FROM professor";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
             Professor   ps = new Professor();
                ps.setCpf(  rs.getString("cpf") );
                ps.setNome( rs.getString("nome") );
                ps.setDnumero( rs.getInt("numero") );
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



