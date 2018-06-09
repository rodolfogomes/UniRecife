/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.alunoposgrad;

import br.com.grupo02.negocio.aluno.Aluno;
import br.com.grupo02.negocio.professor.Professor;

/**
 *
 * @author Valeria
 */
public class AlunoPosGrad extends Aluno{

    private int id;
    private Float valorBolsa;
    private Professor idOrientador;
    
    public AlunoPosGrad (){
        
        idOrientador = new Professor();
    
    }
    
          
      /**
     * @return the id
     */
    public int getId(){
        return id;
    }
    
     /**
     * @param id the alunoPosGrad to set
     */
    public void setId(int id){
        this.id = id;
    }
    
     /**
     * @return the valorBolsa
     */
    public Float getValorBolsa(){
        return valorBolsa;
    }
    
     /**
     * @param valorBolsa the alunoPosGrad to set
     */
    public void setValorBolsa(Float valorBolsa){
        this.valorBolsa = valorBolsa;
    }
   
     /**
     * @return the id_orientador
     */
    public Professor getIdOrientador(){
        return idOrientador;
    }
    
     /**
     * @param idOrientador the alunoPosGrad to set
     */
    public void setIdOrientador(Professor idOrientador){
        this.idOrientador = idOrientador;
    }
}
