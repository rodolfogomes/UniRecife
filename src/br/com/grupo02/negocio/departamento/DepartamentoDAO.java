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
    private Departamento dept;
    
    @Override
    public void inserir(Departamento departamento) throws ConexaoException {
        String sql = " insert into UniRecife.dbo.departamento (id,nome,telefone,centro)"
                +"values (?,?,?,?)";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(++index, departamento.getId());
            ps.setString(++index, departamento.getNome());
            ps.setString(++index, departamento.getTelefone());
            ps.setString(++index, departamento.getCentro());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
     
    @Override
    public void atualizar (Departamento departamento) throws ConexaoException {
        String sql = "update into UniRecife.dbo.departamento set nome = ?,telefone=?,"
                + "centro=?"+"Where id=?";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, departamento.getNome());
            ps.setString(++index, departamento.getTelefone());
            ps.setString(++index, departamento.getCentro());
            ps.setInt(++index, departamento.getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }
    
    @Override
    public void deletar(Integer id) throws ConexaoException {
        String sql = "delete from UniRecife.dbo.departamento where id ="+id;
        
        try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Departamento> listar()throws ConexaoException,DAOException{
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Connection con = gc.conectar();
        
        ArrayList<Departamento> lista = new ArrayList();
        Departamento dept = null;
        
        String sql = "SELECT id,nome,telefone,centro FROM departamento";
        
        Statement stm;
        try{
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                dept = new Departamento();
                dept.setId(  rs.getInt("idDepartamento") );
                dept.setNome( rs.getString("NomeDepartamento") );
                dept.setTelefone( rs.getString("Telefone") );
                dept.setCentro( rs.getString("Centro") );
                lista.add(dept);
            }
            
            return lista;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(con);
        }          
    }

    @Override
    public List<Departamento> listarTodos() throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento buscarPorId(Integer id) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
