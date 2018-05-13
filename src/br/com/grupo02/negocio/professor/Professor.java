/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;

import br.com.grupo02.negocio.error.ConexaoException;

/**
 *
 * @author ADM
 */
public class Professor {
    private String cpf;
    private String nome;
    private int dnumero;
    private String telefone;
    private float salario;
    
    public Professor(){
        
    }
    
    public Professor(String cpf,String nome,int dnumero,String telefone,float salario){
        this.cpf = cpf;
        this.nome = nome;
        this.dnumero = dnumero;
        this.telefone = telefone;
        this.salario = salario;
        
    }
      /**
     * @return the cpf
     */
    public String getCpf(){
        return cpf;
    }
    
     /**
     * @param cpf the sexo to set
     */
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
      /**
     * @return the nome
     */
    public String getNome(){
        return nome;
    }
   
     /**
     * @param nome the sexo to set
     */
    public void setNome (String nome){
        this.nome = nome;
    }
    
     /**
     * @return the dnumero
     */
    public int getDnumero(){
        return dnumero;
    }
    
       /**
     * @param dnumero the sexo to set
     */
    
    public void setDnumero (int dnumero){
        this.dnumero = dnumero;
    }
      /**
     * @return the telefone
     */
    public String getTelefone(){
        return telefone;
    }
      /**
     * @param telefone the sexo to set
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
      /**
     * @return the salario
     */
    public float getSalario(){
        return salario;
    }
    
       /**
     * @param salario the sexo to set
     */
    public void setSalario (float salario){
        this.salario = salario;
    }
    
    public Professor bucarProfessor(Professor pl) {
        ProfessorDAO pldao = new ProfessorDAO();
        try {
            pl = pldao.buscarPorId(Integer.parseInt(pl.getCpf()));
           
            return pl;
        } catch (NullPointerException | ConexaoException e) {
            System.out.println("1aa"+e.getMessage());
            e.getMessage();
            return pl;}
    }
    
   }
