/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.professor;

/**
 *
 * @author ADM
 */
public class Professor {
    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private float salario;

    
    
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     * @return the telefone
     */
    public String getTelefone(){
        return telefone;
    }
      /**
     * @param telefone the telefone to set
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
     * @param salario the salario to set
     */
    public void setSalario (float salario){
        this.salario = salario;
    }

    
       
   }
