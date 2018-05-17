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
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
            pst.setInt(i++, 1); // id dpt
            pst.setInt(i++, 1); // id curso
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("AAAAAAAAAAAA" + e.getMessage());
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }

    }

    @Override
    public void atualizar(Aluno aluno) throws ConexaoException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ALUNO SET ");
        sb.append("aluno_nome=?,aluno_CPF=?,aluno_rua=?,aluno_cidade=?,");
        sb.append("aluno_CEP=?,aluno_telefone1=?,aluno_telefone2=?,aluno_datanasc=?,aluno_sexo=?,");
        sb.append("aluno_dep_codigo=?,aluno_curso_codigo=?");
        sb.append(" WHERE");
        sb.append(" aluno_matricula=?");
        String sql = sb.toString().trim();
        PreparedStatement pst;
        int i = 1;
        try (Connection con = gc.conectar()) {
            pst = con.prepareStatement(sql);
            pst.setString(i++, aluno.getNome());
            pst.setString(i++, aluno.getCpf());
            pst.setString(i++, aluno.getRua());
            pst.setString(i++, aluno.getCidade());
            pst.setString(i++, aluno.getCep());
            pst.setString(i++, aluno.getTelefone1());
            pst.setString(i++, aluno.getTelefone2());
            pst.setDate(i++, aluno.getDatnasc());
            pst.setString(i++, aluno.getSexo());
            pst.setInt(i++, 1); // id dpt
            pst.setInt(i++, 1); // id curso
            pst.setInt(i++, aluno.getMatricula());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("AAAAAAAAAAAA" + e.getMessage());
        } finally {
            sb.delete(0, sb.length());
            sb = null;
        }
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        GerenciadorConexao gc;
        gc = GerenciarConexao.getInstancia();
        String sql = "DELETE FROM ALUNO WHERE aluno_matricula=?";
        PreparedStatement pstm;
        try (Connection con = gc.conectar()) {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
        } catch (Exception e) {
        }
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
            try (Statement st = con.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    al.setMatricula(rs.getInt("aluno_matricula"));
                    al.setIdCurso(rs.getInt("aluno_curso_codigo"));
                    al.setIdDept(rs.getInt("aluno_dep_codigo"));
                    al.setNome(rs.getString("aluno_nome"));
                    al.setRua(rs.getString("aluno_rua"));
                    al.setCpf(rs.getString("aluno_CPF"));
                    al.setCep(rs.getString("aluno_CEP"));
                    al.setCidade(rs.getString("aluno_cidade"));
                    al.setDatnasc(rs.getDate("aluno_datanasc"));
                    al.setSexo(rs.getString("aluno_sexo"));
                    al.setTelefone1(rs.getString("aluno_telefone1"));
                    al.setTelefone2(rs.getString("aluno_telefone2"));
                    return al;
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();

        }
        return al;

    }
}
