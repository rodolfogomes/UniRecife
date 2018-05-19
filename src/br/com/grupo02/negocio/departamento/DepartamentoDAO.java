package br.com.grupo02.negocio.departamento;


import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Wallison
 */
public class DepartamentoDAO implements IGerenciarDados<Departamento> {
    
    @Override
    public void inserir(Departamento obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Departamento obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> listarTodos() throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
    @Override
    public Departamento buscarPorId(Integer id) throws ConexaoException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Departamento dept;
        String sql = "SELECT * FROM DEPARTAMENTO WHERE departamento=" + id;
        dept = new Departamento();
        try (Connection con = gc.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                dept.setIdDept(rs.getInt("idDepartamento"));
                dept.setNomeDept(rs.getString("NomeDepartamento"));
//                dept.setTelefoneDept(rs.getString("Telefone"));
//                dept.setCentroDept(rs.getString("Centro"));
//                            
                return dept;
            }
            st.close();

        } catch (SQLException ex) {
            ex.getMessage();

        }
        return dept;

    }
}
