
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;

import br.com.grupo02.negocio.aluno.Aluno;
import br.com.grupo02.negocio.aluno.AlunoBO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.List;

/**
 *
 * @author danielmedeiros
 */
public class FachadaAluno {

    AlunoBO albo;

    public FachadaAluno() {

        albo = new AlunoBO();

    }

    public void salvar(Aluno al) throws DAOException, GeralException, ConexaoException {

        albo.salvarAluno(al);

    }

    public void deletar(Aluno al) throws ConexaoException, DAOException, GeralException {
        albo.deletarAluno(al);
    }

    public Aluno buscar(Aluno al) throws DAOException, ConexaoException {
        return albo.bucarAluno(al);

    }

    public List<Aluno> listar() throws ConexaoException, DAOException {

        return albo.listarAlunos();
    }

    public void atualizar(Aluno al) throws GeralException, ConexaoException, DAOException {
        albo.atualizarAluno(al);
    }
}
