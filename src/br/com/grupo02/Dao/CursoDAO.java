/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Dao;

import br.com.grupo02.Negocio.Modelo.Curso;
import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import br.com.grupo02.Negocio.Modelo.Interfaces.DAO;
import br.com.grupo02.Persistencia.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Rodolfo Gomes
 */
public class CursoDAO implements DAO<Curso>{

    @Override
    public void inserir(Curso obj) {
        Connection con =null;
        PreparedStatement st=null;
        String sql = "insert into UniRecife.dbo.curso (curso_tipo,curso_cpf_coordenador,curso_cpf_vicecoordenador)values(?,?,?)";
        int index=0;
        try {
             con = GerenciadorConexao.getInstance().getConnection();
             st = con.prepareStatement(sql);
             st.setString(++index, "GRADUAÇÂO");
             st.execute();
        } catch (ConexaoException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        
        
    }

    @Override
    public void atualizar(Curso obj) {
        
    }

    @Override
    public void deletar(Integer id) {
        
    }

    @Override
    public List listarTodos() {
        return null;
        
    }

    @Override
    public Curso buscarPorId(Integer id) {
        return null;
        
        
    }
    
}
