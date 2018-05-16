package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.persistencia.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciarConexao;
import br.com.grupo02.persistencia.IGerenciarDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void inserir(Aluno aluno) throws ConexaoException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ALUNO");
        sb.append("(aluno_matricula,aluno_nome,aluno_CPF,aluno_rua,aluno_cidade,");
        sb.append("aluno_CEP,aluno_telefone1,aluno_telefone2,aluno_datanasc,aluno_sexo,");
        sb.append("aluno_dep_codigo,aluno_curso_codigo)");
        sb.append("VALUES");
        sb.append("(?,?,?,?,?,?,?,?,?,?,?,?)");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(i++, aluno.getMatricula());
            pst.setString(i++, aluno.getNome());
            pst.setString(i++, aluno.getCpf());
            pst.setString(i++, aluno.getRua());
            pst.setString(i++, aluno.getCidade());
            pst.setString(i++, aluno.getCep());
            pst.setString(i++, aluno.getTelefone1());
            pst.setString(i++, aluno.getTelefone2());
            pst.setDate(i++, null);
            pst.setString(i++, aluno.getSexo());
            System.out.println(i);
            pst.setInt(i++, 1); // id dpt
            pst.setInt(i++, 1); // id curso
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("AAAAAAAAAAAA" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Aluno aluno) throws ConexaoException {
              GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ALUNO SET");
        sb.append("aluno_nome=?,aluno_CPF=?,aluno_rua=?,aluno_cidade=?,");
        sb.append("aluno_CEP=?,aluno_telefone1=?,aluno_telefone2=?,aluno_datanasc=?,aluno_sexo=?,");
        sb.append("aluno_dep_codigo=?,aluno_curso_codigo=?");
        sb.append("WHERE");
        sb.append("aluno_matricula=?");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setInt(i++, aluno.getMatricula());
            pst.setString(i++, aluno.getNome());
            pst.setString(i++, aluno.getCpf());
            pst.setString(i++, aluno.getRua());
            pst.setString(i++, aluno.getCidade());
            pst.setString(i++, aluno.getCep());
            pst.setString(i++, aluno.getTelefone1());
            pst.setString(i++, aluno.getTelefone2());
            pst.setDate(i++, null);
            pst.setString(i++, aluno.getSexo());
            System.out.println(i);
            pst.setInt(i++, 1); // id dpt
            pst.setInt(i++, 1); // id curso
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("AAAAAAAAAAAA" + e.getMessage());
        }
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
