
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.negocio.professor.ProfessorBO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Joanna
 */
public class FachadaProfessor {
   
    
    public void salvar(Professor prf) throws DAOException, GeralException, ConexaoException, SQLException {
        ProfessorBO bo = new ProfessorBO();
        bo.salvarProfessor(prf);

    }

    public void deletar(Professor prf) throws ConexaoException, DAOException, GeralException {
        ProfessorBO bo = new ProfessorBO();
        bo.deletarProfessor(prf);
    }

    public Professor buscar(Professor prf) throws DAOException, ConexaoException {
        ProfessorBO bo = new ProfessorBO();
        return bo.bucarProfessor(prf);

    }

    public List<Professor> listarProfessores() throws ConexaoException, DAOException {
        List<Professor> listaProfessor = new ArrayList();
        ProfessorBO bo = new ProfessorBO();
        listaProfessor = bo.listarProfessor();
    
        return listaProfessor;
    }

    public void atualizar(Professor prf) throws GeralException, ConexaoException, DAOException {
        ProfessorBO bo = new ProfessorBO();
        bo.atualizarProfessor(prf);
    }
}