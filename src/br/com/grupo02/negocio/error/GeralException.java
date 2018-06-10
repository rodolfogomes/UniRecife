/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.error;

/**
 *
 * @author danielmedeiros
 */
public class GeralException extends Exception {

    public GeralException() {

    }

    public GeralException(String mensg) {
        super(mensg);
    }

}
