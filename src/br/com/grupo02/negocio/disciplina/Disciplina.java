/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;


import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.error.ConexaoException;

import java.util.*;

/**
 * Classe básica Disciplina com atributos encapsulados
 * @author Bruno Rodrigues /Git: @Brunojgrc
 */
public class Disciplina {
    
    private int idDisciplina;
    private String nome;
    private String descricao;
    Departamento departamento;
    
       

    public Disciplina(){
    }
    
    /**
 * Classe básica Disciplina com atributos e métodos
 * @author Bruno Rodrigues /Git: @Brunojgrc
     * @param idDisciplina
     * @param nome
     * @param descricao
     * @param departamento
     */
    public Disciplina (int idDisciplina, String nome, String descricao, Departamento departamento){
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.descricao = descricao;
        this.departamento = departamento; 
    
    }
    
        /**
     * @return the idDisciplina
     */
    public int getIdDisciplina() {
        return idDisciplina;
    }

    /**
     * @param idDisciplina the idDisciplina to set
     */
    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
     /**
     * 
     * @Método buscarDisciplina para retorno de disciplina por ID
     */
    public Disciplina buscarDisciplina (Disciplina disc){
        
        DisciplinaDAO discDao = new DisciplinaDAO ();
        try {
             disc = discDao.buscarPorId(disc.getIdDisciplina());
                
             return disc;     
             
        } catch (NullPointerException | ConexaoException e) {
            System.out.println("1aa"+e.getMessage());
            e.getMessage();
            
            return disc;
        } 
    }  
}



