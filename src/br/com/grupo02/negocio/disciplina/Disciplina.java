/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.disciplina;


import br.com.grupo02.negocio.departamento.Departamento;

/**
 * Classe básica Disciplina com atributos encapsulados
 * @author Bruno Rodrigues /Git: @Brunojgrc
 */
public class Disciplina {
    
    private int id;
    private String nome;
    private String descricao;
    Departamento departamento;
    
       

    public Disciplina(){
    }
    
    /**
 * Classe básica Disciplina com atributos e métodos
 * @author Bruno Rodrigues /Git: @Brunojgrc
     * @param id
     * @param nome
     * @param descricao
     * @param departamento
     */
    public Disciplina (int id, String nome, String descricao, Departamento departamento){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.departamento = departamento; 
    
    }
    
        /**
     * @return the idDisciplina
     */
    public int getId() {
        return id;
    }

    /**
     * @param idDisciplina the idDisciplina to set
     */
    public void setId(int id) {
        this.id = id;
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
    
     
}



