package br.com.grupo02.negocio.aluno;

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
 * @author Daniel
 */
public class AlunoDAO implements IGerenciarDados<Aluno> {

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
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        Aluno al;
        String sql = "SELECT * FROM ALUNO WHERE matricula=" + id;
        al = new Aluno();
        try (Connection con = gc.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                al.setMatricula(rs.getInt("matricula"));
//                al.setIdCurso(rs.getInt("idCurso"));
//                al.setIdDept(rs.getInt("iddept"));
                al.setNome(rs.getString("nome"));
//                al.setRua(rs.getString("rua"));
//                al.setCpf(rs.getString("cpf"));
//                al.setCep(rs.getString("cep"));
//                al.setCidade(rs.getString("cidade"));
//                al.setDatnasc(rs.getString("datnasc"));
//                al.setSexo(rs.getString("sexo"));
//                al.setTelefone1(rs.getString("telefone1"));
//                al.setTelefone2(rs.getString("telefone2"));
                return al;
            }
            st.close();

        } catch (SQLException ex) {
            ex.getMessage();

        }
        return al;

    }
}
