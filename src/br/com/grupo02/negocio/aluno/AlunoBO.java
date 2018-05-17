
package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.error.ConexaoException;

/**
 *
 * @author Daniel
 */
public class AlunoBO {

     
    public AlunoBO() {
    }
    
     public Aluno bucarAluno(Aluno al) {
        AlunoDAO aldao = new AlunoDAO();
        try {
            al = aldao.buscarPorId(al.getMatricula());

            return al;
        } catch (NullPointerException | ConexaoException e) {
            throw new NullPointerException();
        }

    }

    public void salvarAluno(String acao, Aluno al) {
        AlunoDAO aldao = new AlunoDAO();
        try {
            switch (acao) {
                case "salvar":
                    aldao.inserir(al);
                    break;
                case "atualizar":
                    aldao.atualizar(al);
                    break;
                default:
                    System.out.println("informar a acao, salvar ou atualizar");
            }

        } catch (NullPointerException | ConexaoException e) {
            throw new NullPointerException();
        }

    }
    
    
    
    
    
    
    
}
