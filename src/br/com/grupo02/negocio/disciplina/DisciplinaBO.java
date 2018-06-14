 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.List;

/**
 *
 * @author Bruno Rodrigues
 */
public class DisciplinaBO {

        public boolean isValidaBranco(String str) {

        return str.trim().isEmpty();
    }

    public void validarCamposDisciplina(Disciplina disciplina) throws GeralException {

        if (disciplina.getNome() == null || isValidaBranco(disciplina.getNome())) {
            throw new GeralException("Nome é um campo de preenchimento obrigatorio!");
        }
        if (disciplina == null) {

            throw new GeralException("Não é possivel salvar vazio!");
        }
        if (disciplina.getDescricao() == null || isValidaBranco(disciplina.getDescricao())) {
            throw new GeralException("Descrição é campo de preenchimento obrigatorio!");

        }

    }

    /**
     * @param disc
     * @param discdao
     * @throws ConexaoException
     * @throws DAOException
     * @throws GeralException
     */
    public void verificarDuplicidade(Disciplina disc, DisciplinaDAO discdao) throws ConexaoException, DAOException, GeralException {

        if (discdao.filtrarDisciplina(disc, "nome")) {
            throw new GeralException("Já existe uma disciplina com este nome!");
        }
        if (discdao.filtrarDisciplina(disc, "descricao")) {
            throw new GeralException("Já existe uma disciplina com esta descricao!");
        }

    }

    public Disciplina bucarDisciplina(Disciplina disc) throws DAOException, ConexaoException {
        DisciplinaDAO discdao = new DisciplinaDAO();
        disc = discdao.buscarPorId(disc.getId());

        return disc;
    }

    public void salvarDisciplina(Disciplina disc) throws DAOException, GeralException, ConexaoException {
        DisciplinaDAO discdao = new DisciplinaDAO();
        validarCamposDisciplina(disc);
        verificarDuplicidade(disc, discdao);
        discdao.inserir(disc);

    }

    public void atualizarDisciplina(Disciplina disc) throws GeralException, ConexaoException, DAOException {
        DisciplinaDAO discdao = new DisciplinaDAO();
        validarCamposDisciplina(disc);
        if (disc.getId() != 0 && disc.getId() > 0) {
            discdao.atualizar(disc);

        }
    }

    public void deletarDisciplina(Disciplina disc) throws ConexaoException, DAOException, GeralException {
        DisciplinaDAO discdao = new DisciplinaDAO();
        if (disc != null) {
            discdao.deletar(disc.getId());
        } else {
            throw new GeralException("Selecione ao menos uma disciplina para ser excluida.");
        }
    }

    public List<Disciplina> listarDisciplina() throws ConexaoException, DAOException {
        DisciplinaDAO discdao = new DisciplinaDAO();
        return discdao.listarTodos();
    }

}
