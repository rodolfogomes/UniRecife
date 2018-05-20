/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.departamento;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import java.util.*;

/**
 *
 * @author Wallison          
 */
public class Departamento {

     
    private int id;
    private String nome;
    private String telefone;
    private String centro;
    
    public Departamento(){
    
    }
    
    public Departamento(int id, String nome, String telefone, String centro){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.centro = centro;
    
    }
    
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
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
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the centro
     */
    public String getCentro() {
        return centro;
    }

    /**
     * @param centro the centro to set
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }
    public Departamento buscarDepartamento (Departamento dept) throws ConexaoException, DAOException {
        DepartamentoDAO deptDao =  new DepartamentoDAO();
        try {
            dept = deptDao.buscarPorId(dept.getId());
           
            return dept;
        } catch (NullPointerException e) {
            System.out.println("1aa"+e.getMessage());
            e.getMessage();
            return dept;
        }
    }

    public void setIdDept(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
