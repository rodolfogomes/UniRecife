/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.departamento;

import br.com.grupo02.negocio.error.ConexaoException;
import java.util.*;

/**
 *
 * @author Wallison
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
    public Departamento buscarDisciplina (Departamento dept) {
        DepartamentoDAO deptDao =  new DepartamentoDAO();
        try {
            dept = deptDao.buscarPorId(dept.getIdDept());
           
            return dept;
        } catch (NullPointerException | ConexaoException e) {
            System.out.println("1aa"+e.getMessage());
            e.getMessage();
            return dept;
        }
    }

    void setCentroDept(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
