/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.persistencia.IGerenciarDados;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Rodolfo Gomes
 */
public class CursoDAO  implements IGerenciarDados<Curso> {

    @Override
    public void inserir(Curso curso) throws ConexaoException {
        String sql = "insert into UniRecife.dbo.curso (curso_tipo,curso_cpf_coordenador,curso_cpf_vicecoordenador)"
                + "values(?,?,?)";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, curso.getTipo());
            ps.setString(++index, curso.getCoordenador().getCpf());
            ps.setString(++index, curso.getViceCoordenador().getCpf());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void atualizar(Curso curso) throws ConexaoException {
        String sql = "update UniRecife.dbo.curso set curso_tipo = ?,curso_cpf_coordenador=?,curso_cpf_vicecoordenador=?"
                + "where curso_codigo=?";
        int index = 0;
        try (Connection con = GerenciarConexao.getInstancia().conectar()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(++index, curso.getTipo());
            ps.setString(++index, curso.getCoordenador().getCpf());
            ps.setString(++index, curso.getViceCoordenador().getCpf());
            ps.setInt(++index, curso.getCodigo());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ConexaoException();
        }
    }

    @Override
    public void deletar(Integer id) throws ConexaoException {
        String sql = "delete from UniRecife.dbo.curso where curso_codigo ="+id;
        
        try (Connection con = GerenciarConexao.getInstancia().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Curso> listarTodos() throws ConexaoException {
        ArrayList<Curso> listaCurso = new ArrayList();
        StringBuilder sb = null;
        PreparedStatement ps=null;
        sb.append("select * from UniRecife.dbo.curso");
        
         try (Connection con = GerenciarConexao.getInstancia().conectar()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sb.toString());
             while(rs.next()){
                     // Montando uma referência coordenador do tipo professor
                Professor coordenador = new Professor();
                coordenador.setCpf(rs.getString("cpf_coor"));
                coordenador.setNome(rs.getString("nome_prof"));
                coordenador.setDnumero(rs.getInt("dep_prof"));
                coordenador.setTelefone(rs.getString("tel_prof"));
                coordenador.setSalario(rs.getFloat("sal_prof"));
                
                // Montando uma referência viceCoordenador do tipo professor
                Professor viceCoordenador = new Professor();
                viceCoordenador.setCpf(rs.getString("cpf_Vice"));
                coordenador.setNome(rs.getString("nome_prof"));
                coordenador.setDnumero(rs.getInt("dep_prof"));
                coordenador.setTelefone(rs.getString("tel_prof"));
                coordenador.setSalario(rs.getFloat("sal_prof"));
                
                // Montando uma referência curso
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("curso_codigo"));
                curso.setTipo(rs.getString("curso_tipo"));
                curso.setCoordenador(coordenador);
                curso.setViceCoordenador(viceCoordenador);
               
                listaCurso.add(curso);
                
            }
            
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return listaCurso;

    }
    /**
     * 
     * @param id
     * @return Uma referência do tipo curso carregada com seus dados. 
     * @throws ConexaoException 
     */
    @Override
    public Curso buscarPorId(Integer id) throws ConexaoException {
        String sql="select c.curso_codigo,c.curso_tipo,c.curso_cpf_coordenador AS cpf_coor,"
                + "c.curso_cpf_vicecoordenador AS cpf_Vice,p.professor_nome AS nome_prof,p.professor_dep_codigo AS dep_prof,"
                + "p.professor_telefone AS tel_prof,p.professor_salario AS sal_prof"
                + " from  UniRecife.dbo.curso c left join professor p"
                + "on c.curso_cpf_coordenador= p.professor_cpf  "
                + "or c.curso_cpf_vicecoordenador= p.professor_cpf "
                + "where c.curso_codigo ="+id;
        
        Curso curso=null;
        
          try (Connection con = GerenciarConexao.getInstancia().conectar()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           
            
            if(rs.next()){
                // Montando uma referência coordenador do tipo professor
                Professor coordenador = new Professor();
                coordenador.setCpf(rs.getString("cpf_coor"));
                coordenador.setNome(rs.getString("nome_prof"));
                coordenador.getDepartamento().setIdDept(rs.getInt("dep_codigo"));
                coordenador.setTelefone(rs.getString("tel_prof"));
                coordenador.setSalario(rs.getFloat("sal_prof"));
                
                // Montando uma referência viceCoordenador do tipo professor
                Professor viceCoordenador = new Professor();
                viceCoordenador.setCpf(rs.getString("cpf_Vice"));
                coordenador.setNome(rs.getString("nome_prof"));
                coordenador.getDepartamento().setIdDept(rs.getInt("dep_codigo"));
                coordenador.setTelefone(rs.getString("tel_prof"));
                coordenador.setSalario(rs.getFloat("sal_prof"));
                
                // Montando uma referência curso
                curso = new Curso();
                curso.setCodigo(rs.getInt("curso_codigo"));
                curso.setTipo(rs.getString("curso_tipo"));
                curso.setCoordenador(coordenador);
                curso.setViceCoordenador(viceCoordenador);
            }
            return curso;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
          
          return curso;
    }

}
