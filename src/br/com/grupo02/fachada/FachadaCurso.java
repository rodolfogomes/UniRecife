/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;

import br.com.grupo02.negocio.curso.Curso;
import br.com.grupo02.negocio.curso.CursoBO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADM
 */
public class FachadaCurso {
    
    public List<Curso> listaCursos() throws ConexaoException{
        List<Curso> listaCurso = new ArrayList();
        CursoBO bo = new CursoBO();
        listaCurso = bo.listarTodosCursos();
    
        return listaCurso;
    }
    
    public void salvarCurso(Curso c) throws GeralException, ConexaoException{
        try {
        CursoBO bo = new CursoBO();
        bo.validaCampos(c);
        bo.salvarCurso(c);
        } catch (Exception e) {
            throw  new GeralException();
            
        }
        
    }

    public void remover(int id) throws ConexaoException {
        CursoBO bo = new CursoBO();
        bo.remove(id);
    }

    public void edtidar(Curso curso) throws ConexaoException {
        CursoBO bo = new CursoBO();
        bo.editar(curso);
    }
    
}
