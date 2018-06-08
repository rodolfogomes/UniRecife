/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.oferta;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.negocio.disciplina.Disciplina;

/**
 *
 * @author Valeria
 */
public class Oferta {
    
    private Integer id;
    private String horario;
    private Professor idProfessor;
    private Disciplina iDisciplina;
    
    public Oferta(){

    idProfessor = new Professor();
    iDisciplina = new Disciplina();
    }
    
   
    /**  /**
     * @return the id
     */
    public Integer getId(){
    
        return id;
    }
    
    /**
     * @param id the oferta to set
     */
    
    public void setId(Integer id){
    
        this.id = id;
    }
    /**
     * @return the horario
     */
    public String getHorario(){
        return horario;
    }
   /**
     * @param horario the oferta to set
     */ 
    public void setHorario(String horario){
        this.horario = horario;
    }
    
    /**
     * @return the idProfessor
     */
    
    public Professor getIdProfessor(){
        return idProfessor;
    }
    
     /**
     * @param idProfessor the oferta to set
     */
    public void setIdProfessor(Professor idProfessor){
        this.idProfessor = idProfessor;
    }
    /**
     * @return the idDisciplina
     */
    public Disciplina getIDisciplina(){
        return iDisciplina;
    }
    /**
     * @param iDisciplina the oferta to set
     */
    public void setIDisciplina(Disciplina iDisciplina){
        this.iDisciplina = iDisciplina;
    }
    
  }
        


