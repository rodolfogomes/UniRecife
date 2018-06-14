/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.professor.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;
import br.com.grupo02.negocio.error.GeralException;
import java.util.ArrayList;


/**
 *
 * @author Joanna
 */
public class ProfessorBO {

    public ProfessorBO() {
    }

    /**
    * Método responsável por validar no preenchimento campos em branco;
    * @param antes de professor objeto que ser inserido quando o método inserir()for chamado;
    * @throws br.com.grupo02.negocio.error.GeralException
   */
    
    public boolean isValidaBranco(String str) {

        if (str.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public void validarCamposProfessor(Professor prf) throws GeralException {

        if (prf.getNome() == null || isValidaBranco(prf.getNome())) {
            throw new GeralException("Nome é um campo de preenchimento obrigatorio!");
        }
        if (prf == null) {

            throw new GeralException("Não é possivel salvar vazio!");
        }
        if (prf.getCpf() == null || isValidaBranco(prf.getCpf())) {
            throw new GeralException("CPF é um campo de preenchimento obrigatorio!");

        }
        if (prf.getTelefone() == null || isValidaBranco(prf.getTelefone())) {
            throw new GeralException("O Campo telefone é de preenchimento obrigatorio!");
        }
        
             

    }
    /**
    * Método responsável por verificar a duplicidade de alguns campos;
    * @param antes de professor objeto que ser inserido quando o método inserir()for chamado;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
   */
    public void verificarDuplicidade(Professor prf, ProfessorDAO prfdao) throws ConexaoException, DAOException, GeralException, SQLException {
        if (prfdao.filtrarProfessor(prf, "nome")) {
            throw new GeralException("Já existe um professor com este nome!");
        }
        if (prfdao.filtrarProfessor(prf, "cpf")) {
            throw new GeralException("Já existe um professor com este CPF!");
        }
        
    }
    
    /**
    * Método responsável por Buscar professor pelo id;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
   */
    public Professor bucarProfessor(Professor prf) throws DAOException, ConexaoException {
        ProfessorDAO prfdao = new ProfessorDAO();
        prf = prfdao.buscarPorId(prf.getId());
   
        return prf;
    }
    
   /**
    * Método responsável por Salvar professor e inserir as informações;
    * @param antes checar a validação dos campos e duplicidade dos campos;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
    * @throws br.com.grupo02.negocio.error.SQLException
   */ 

    public void salvarProfessor(Professor prf) throws DAOException, GeralException, ConexaoException, SQLException {
        ProfessorDAO prfdao = new ProfessorDAO();
        //validarCamposProfessor(prf);
        //verificarDuplicidade(prf, prfdao);
        if(prf.getId() ==0)
            prfdao.inserir(prf);
        else
            prfdao.atualizar(prf);
     

    }
    
    
    /**
    * Método responsável por atualizar professor e inserir as informações;
    * @param antes checar a validação dos campos;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
   */
    
    public void atualizarProfessor(Professor prf) throws GeralException, ConexaoException, DAOException{
        ProfessorDAO prfdao = new ProfessorDAO();
        validarCamposProfessor(prf);
        if(prf.getId()!=0 &&prf.getId()>0){
        prfdao.atualizar(prf);
           
        }
     
   /**
    * Método responsável por deletar professor;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
   */     
        
    }
    public void deletarProfessor(Professor prf) throws ConexaoException, DAOException, GeralException{
        ProfessorDAO prfdao = new ProfessorDAO();
        if(prf!=null){
            prfdao.deletar(prf.getId());
        }else{
            throw new GeralException("Selecione ao menos um Professor para ser excluido.");
        }
    }
    /**
    * Método responsável por listar todos os professores;
    * @throws br.com.grupo02.negocio.error.GeralException;
    * @throws br.com.grupo02.negocio.error.ConexaoException;
    * @throws br.com.grupo02.negocio.error.DAOException
   */   
    
    public List<Professor> listarProfessor() throws ConexaoException, DAOException{
        ProfessorDAO prfdao = new ProfessorDAO();
        return prfdao.listarTodos();
    }
    




/**
 *
 * @author Joanna
 */

    


/**
   * Metodo usado para salvar ou atualizar os atributos da classe
   * @param professor Objeto a ser adicionado.
   * @throws ConexaoException
   * @throws Exception 
   */
  
    public void salvarProfessor(String acao, Professor prf) throws DAOException {
        ProfessorDAO prfdao = new ProfessorDAO();
        try {
            switch (acao) {
                case "salvar":
                    prfdao.inserir(prf);
                    break;
                case "atualizar":
                    prfdao.atualizar(prf);
                    break;
                                
                    
                default:
                    System.out.println("informar a acao, salvar, atualizar");
            }

        } catch (NullPointerException | ConexaoException e) {
            throw new NullPointerException();
        }

    }
    
    
 
    
}
