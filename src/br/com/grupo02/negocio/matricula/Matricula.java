/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.matricula;
import br.com.grupo02.negocio.oferta.Oferta;

/**
 *
 * @author Valeria
 */
public class Matricula {
    private Oferta idOferta;
    private Integer id;
    
    public Matricula(){
        idOferta = new Oferta();
    }
    
      /**
     * @return the id
     */
    public Integer getId(){
    
        return id;
    }
    
    /**
     * @param id the matricula to set
     */
    
    public void setId(Integer id){
    
        this.id = id;
    }
      /**
     * @return the id_oferta
     */
    public Oferta getIdOferta(){
        return idOferta;
    }
    
    /**
     * @param id the oferta to get
     */
    public void setIdOferta(Oferta idOferta){
        this.idOferta = idOferta;
    }
    
    
}
