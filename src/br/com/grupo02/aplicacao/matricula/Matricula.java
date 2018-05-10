package br.com.grupo02.aplicacao.matricula;

import java.util.*;

/**
 *
 * @author Wallison
 */
public class Matricula {
    
    private int idMatricula;
    private int idOferta;
    
    public Matricula () {
        
    }
    
    public Matricula (int matricula, int oferta) {
        
        this.idMatricula = matricula;
        this.idOferta = oferta;
        
    }

    /**
     * @return the idMatricula
     */
    public int getIdMatricula() {
        return idMatricula;
    }

    /**
     * @param idMatricula the idMatricula to set
     */
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    /**
     * @return the idOferta
     */
    public int getIdOferta() {
        return idOferta;
    }

    /**
     * @param idOferta the idOferta to set
     */
    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }
}
