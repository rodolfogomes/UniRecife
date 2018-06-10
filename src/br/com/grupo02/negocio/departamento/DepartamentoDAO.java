package br.com.grupo02.negocio.departamento;


import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.negocio.IGerenciarDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wallison     
 */
public class DepartamentoDAO implements IGerenciarDados<Departamento> {
    
/**
 * Inserir dados no Banco de Dados
 * @throws ConexaoException
 * @throws DAOException 
 */
    @Override
    public void inserir(Departamento departamento) throws ConexaoException,DAOException {
       
        
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT into DEPARTAMENTO")
        .append("( nome, telefone, centro)")
        .append("VALUES")
        .append("(?,?,?)");
       
        int i = 1;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement pst;
            pst = con.prepareStatement(sb.toString());
            pst.setString(i++, departamento.getNome());
            pst.setString(i++, departamento.getTelefone());
            pst.setString(i++, departamento.getCentro()); 
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            sb.delete(0, sb.length());
            sb = null;     
        }
    }
    
      
    @Override
     public void atualizar(Departamento departamento) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE DEPARTAMENTO SET ");
        sb.append("(nome=?, telefone=?, centro=?)");
        sb.append("(WHERE");
        sb.append(" id=?");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setString(i++, departamento.getNome());
            pst.setString(i++, departamento.getTelefone());
            pst.setString(i++, departamento.getCentro());
            pst.setInt(i++, departamento.getId());
            pst.execute();
            pst.close();
        pst.executeUpdate();
            
        } catch (Exception e) {
            throw new DAOException();
        } finally {
            sb.delete(0, sb.length());
            sb = null;    
        }
        
    }
    
    @Override
    public void deletar(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        String sql = "DELETE FROM DEPARTAMENTO WHERE id=?";
        PreparedStatement pst;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
        } catch (Exception e) {
            throw new DAOException();
        }
    }
    

    @Override
    public Departamento buscarPorId(Integer id) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Departamento dept = null;
        String sql = "SELECT * FROM DEPARTAMENTO WHERE id=" + id;
        try (Connection con = gc.conectar()) {
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);          
                if(rs.next()){
                   dept = new Departamento(); 
                   dept.setId(rs.getInt("id"));
                   dept.setNome(rs.getString("nome"));
                   dept.setTelefone(rs.getString("telefone"));
                   dept.setCentro(rs.getString("Centro"));
                 return dept;
                }
            }

        } catch (SQLException ex) {
            throw new DAOException();
        }
        return dept;
    }   


    @Override
    public List<Departamento> listarTodos() throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        List<Departamento> lista = new ArrayList();
        Departamento departamento = null;
        String sql = "SELECT * FROM DEPARTAMENTO";
        try (Connection con = gc.conectar()) {
            try (Statement stm = con.createStatement()) {
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                departamento = new Departamento ();
                departamento.setId(rs.getInt("id") );
                departamento.setNome( rs.getString("nome") );
                departamento.setTelefone( rs.getString("telefone"));
                departamento.setCentro(rs.getString("Centro"));
                lista.add(departamento);
                }   
            return lista;
            }

        } catch (Exception e) {
            throw new DAOException();
        }
    }
}