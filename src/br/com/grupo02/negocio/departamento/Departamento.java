/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.departamento;

import java.util.*;

/**
 *
 * @author Bruno Rodrigues / Github: @brunojgrc
 */
public class Departamento {

     
    private int idDept;
    private String nomeDept;
    private String telefoneDept;
    private String centro;
    
    public Departamento(){
    
    }
    
    public Departamento(int idDept, String nomeDept, String telefoneDept, String centro){
    
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

    /**
     * @return the nomeDept
     */
    public String getNomeDept() {
        return nomeDept;
    }

    /**
     * @param nomeDept the nomeDept to set
     */
    public void setNomeDept(String nomeDept) {
        this.nomeDept = nomeDept;
    }

    /**
     * @return the telefoneDept
     */
    public String getTelefoneDept() {
        return telefoneDept;
    }

    /**
     * @param telefoneDept the telefoneDept to set
     */
    public void setTelefoneDept(String telefoneDept) {
        this.telefoneDept = telefoneDept;
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
    
}
