package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.IGerenciarDados;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class AlunoDAO extends GerenciarConexao implements IGerenciarDados<Aluno> {

    /*
    este metodo vai servir para carregar as informações de um unico Aluno para que possa ser editado, sendo localizado pelo  
    cpf, este metodo recebe o objeto (entidade) populado porem faz a pesquisa pelo aluno por CPF 
     */
//    @Override
//    public Aluno carregar(Aluno al) {
//
//    }
    @Override
    public void inserir(Aluno obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Aluno obj) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> listarTodos() throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno buscarPorId(Integer id) throws ConexaoException {
        Aluno al;
        String sql = "SELECT * FROM ALUNO WHERE aluno_matricula=" + id;
        try (Connection con = conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            al = new Aluno();
            System.out.println(rs.next());
            if (rs.next()) {
                al.setMatricula(rs.getInt("matricula"));
                al.setIdCurso(rs.getInt("idCurso"));
                al.setIdDept(rs.getInt("iddept"));
                al.setNome(rs.getString("nome"));
                al.setRua(rs.getString("rua"));
                al.setCpf(rs.getString("cpf"));
                al.setCep(rs.getString("cep"));
                al.setCidade(rs.getString("cidade"));
                al.setDatnasc(rs.getString("datnasc"));
                al.setSexo(rs.getString("sexo"));
                al.setTelefone1(rs.getString("telefone1"));
                al.setTelefone2(rs.getString("telefone2"));
            System.out.println("aluno "+ rs.getString("nome"));
            }
            st.close();
            
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
