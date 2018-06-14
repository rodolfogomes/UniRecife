package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class AlunoBO {

    public AlunoBO() {
    }

    public boolean isValidaBranco(String str) {

        if (str.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public void validarCamposAluno(Aluno al) throws GeralException {

        if (al.getNome() == null || isValidaBranco(al.getNome())) {
            throw new GeralException("Nome é um campo de preenchimento obrigatorio!");
        }
        if (al == null) {

            throw new GeralException("Não é possivel salvar vazio!");
        }
        if (al.getCpf() == null || isValidaBranco(al.getCpf())) {
            throw new GeralException("CPF é um campo de preenchimento obrigatorio!");

        }
        if (al.getCidade() == null || isValidaBranco(al.getCidade())) {
            throw new GeralException("O Campo de cidade é de preenchimento obrigatorio!");
        }

    }

    public void verificarDuplicidade(Aluno al, AlunoDAO aldao) throws ConexaoException, DAOException, GeralException {
        if (aldao.filtrarAluno(al, "nome")) {
            throw new GeralException("Já existe um aluno com este nome!");
        }
        if (aldao.filtrarAluno(al, "cpf")) {
            throw new GeralException("Já existe um aluno com este CPF!");
        }
        if (aldao.filtrarAluno(al, "matricula")) {
            throw new GeralException("Já existe um aluno com a mesma matricula");
        }

    }

    public Aluno bucarAluno(Aluno al) throws DAOException, ConexaoException {
        AlunoDAO aldao = new AlunoDAO();
        al = aldao.buscarPorId(al.getId());

        return al;
    }

    public void salvarAluno(Aluno al) throws DAOException, GeralException, ConexaoException {
        AlunoDAO aldao = new AlunoDAO();
        validarCamposAluno(al);
        verificarDuplicidade(al, aldao);
        aldao.inserir(al);

    }
    public void atualizarAluno(Aluno al) throws GeralException, ConexaoException, DAOException{
        AlunoDAO aldao = new AlunoDAO();
        validarCamposAluno(al);
        if(al.getId()!=0 &&al.getId()>0){
        aldao.atualizar(al);
           
        }
    }
    public void deletarAluno(Aluno al) throws ConexaoException, DAOException, GeralException{
        AlunoDAO aldao = new AlunoDAO();
        if(al!=null){
           if(aldao.filtrarAluno(al, "id")){
            aldao.deletar(al.getId());
           
           }else{
               throw new GeralException("Usuario invalido!");
           }
            
        }else{
            throw new GeralException("Selecione ao menos um Aluno para ser excluido.");
        }
    }
    public List<Aluno> listarAlunos() throws ConexaoException, DAOException{
        AlunoDAO aldao = new AlunoDAO();
        return aldao.listarTodos();
    }
    

}
