/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;


import br.com.grupo02.negocio.aluno.Aluno;
import br.com.grupo02.negocio.aluno.AlunoBO;


/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {

    public static void main(String[] args) {

        Aluno al = new Aluno();
        AlunoBO albo = new AlunoBO();
        al.setMatricula(3);
        al.setNome("AAAAAAAAAAAAAAAAA");
        al.setTelefone2("3333433-22222");
        albo.salvarAluno("atualizar",al);
        System.out.println("Aluno Nome "+ al.getNome());
        
        

    }
}
