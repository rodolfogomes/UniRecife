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

/**
 *
 * @author Valeria
 */
public class ProfessorBO {
    
    public ProfessorBO(){
    
    }
    


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