/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.error.ConexaoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodolfogomes
 */
public class CursoBO {

    public List<Curso> listarTodosCursos() throws ConexaoException {

        List<Curso> lista = new ArrayList<>();
        CursoDAO dao = new CursoDAO();
        lista = dao.listarTodos();
        return lista;
    }

    public void salvarCurso(Curso c)throws ConexaoException {
        CursoDAO dao = new CursoDAO();
        dao.inserir(c);
    }

}
