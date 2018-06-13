/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;

import br.com.grupo02.negocio.curso.Curso;
import br.com.grupo02.negocio.curso.CursoBO;
import br.com.grupo02.negocio.error.ConexaoException;
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
    
    public void salvarCurso(Curso c) throws ConexaoException{
        CursoBO bo = new CursoBO();
        bo.salvarCurso(c);
    }
    
}
