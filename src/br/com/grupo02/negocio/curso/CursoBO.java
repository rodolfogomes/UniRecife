/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
//null value in column "descricao" violates not-null constraint

    public boolean validaCampos(Curso c) throws GeralException {
        if (c == null) {
            JOptionPane.showMessageDialog(null, "A descrição é obrigatória.");
            return false;
        }

        return true;
    }

    public void salvarCurso(Curso c) throws ConexaoException, GeralException {
        CursoDAO dao = new CursoDAO();
        try {
            if (c.getCodigo() == 0) {
                dao.inserir(c);
            } else {
                dao.atualizar(c);
            }

        } catch (Exception e) {
            if (e.getMessage().contains("null value in column \"descricao\" violates not-null constraint")) {
                throw new GeralException("A descricao é campo obrigatório.");
            }

        }
    }

    public void remove(int id) throws ConexaoException {
        CursoDAO dao = new CursoDAO();
        dao.deletar(id);
    }

    public void editar(Curso curso) throws ConexaoException {
        CursoDAO dao = new CursoDAO();
        dao.atualizar(curso);
    }

}
