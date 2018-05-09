/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;

import br.com.grupo02.negocio.aluno.Aluno;


/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) {
        
        Aluno alun = new Aluno();
        
        alun.setMatricula(3);
        alun.bucarAluno(alun);
        System.out.println(alun.getNome());

    }
}
