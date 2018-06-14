/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;

import br.com.grupo02.negocio.disciplina.Disciplina;
import br.com.grupo02.negocio.disciplina.DisciplinaBO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.List;

/**
 *
 * @author Bruno Rodrigues
 */
public class FachadaDisciplina {

    DisciplinaBO discbo;

    public FachadaDisciplina() {

        discbo = new DisciplinaBO();

    }

    public void salvar(Disciplina disc) throws DAOException, GeralException, ConexaoException {

        discbo.salvarDisciplina(disc);

    }

    public void deletar(Disciplina disc) throws ConexaoException, DAOException, GeralException {
        discbo.deletarDisciplina(disc);
    }

    public Disciplina buscar(Disciplina disc) throws DAOException, ConexaoException {
        return discbo.bucarDisciplina(disc);

    }

    public List<Disciplina> listar() throws ConexaoException, DAOException {

        return discbo.listarDisciplina();
    }

    public void atualizar(Disciplina disc) throws GeralException, ConexaoException, DAOException {
        discbo.atualizarDisciplina(disc);
    }
}
