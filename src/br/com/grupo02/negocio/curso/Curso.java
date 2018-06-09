/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.curso;
import br.com.grupo02.negocio.professor.Professor;

/**
 *
 * @author ADM
 */
public class Curso {
    
    private int codigo;
    private String descricao;
    Professor coordenador;
    Professor viceCoordenador;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public Professor getViceCoordenador() {
        return viceCoordenador;
    }

    public void setViceCoordenador(Professor viceCoordenador) {
        this.viceCoordenador = viceCoordenador;
    }

 
    
    
}
