/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Negocio.Modelo;


import java.util.*;

/**
 *
 * @author Bruno Rodrigues /Git: @Brunojgrc
 */
public class Disciplina {
    
    private int idDisciplina;
    private String nome;
    private String descricao;
    private int idDept;  
       

    public Disciplina(){
    }
    
    
    public Disciplina (int idDisciplina, String nome, String descricao, int idDept){
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.descricao = descricao;
        this.idDept = idDept;
    
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
     * @return the idDept
     */
    public int getIdDept() {
        return idDept;
    }

    /**
     * @param idDept the idDept to set
     */
    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }
}



