/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;


import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.departamento.DepartamentoDAO;
import br.com.grupo02.negocio.disciplina.Disciplina;
import br.com.grupo02.negocio.disciplina.DisciplinaDAO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Rodolfo Gomes
 */
@SuppressWarnings("InitializerMayBeStatic")
public class UniRecife {
    // Para realizar os testes criem seus métodos e chamem no main como no exempo abaixo.

    public static void main(String[] args) {
    testaConexao();
    inserirDisciplina();
    
    
    }
    public static void testaConexao(){
            
        try {
            
            Connection con =GerenciarConexao.getInstancia().conectar();
            System.out.println("Conexão Funciona!");
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão: " + ex.getMessage());
           ex.printStackTrace();
        }
    }   
        
    public static void inserirDisciplina() {
        
        Disciplina disciplina = new Disciplina();
        DisciplinaDAO dao = new DisciplinaDAO();
         Departamento departamento;
        departamento = new Departamento();
        
        disciplina.setId(1);
        disciplina.setNome ("POO");
        disciplina.setDescricao ("Labor");
        
        
        try{
            dao.inserir(disciplina);
        }   catch (ConexaoException ex) {
            Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro01");
        } catch (DAOException ex) {
            Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro02");
        } 
    }
    
    public static void inserirdepto() {
        
        Departamento departamento;
        departamento = new Departamento();
        DepartamentoDAO dao = new DepartamentoDAO();
              
        departamento.setId(02);
        departamento.setNome ("TI");
        departamento.setTelefone ("0112");
        departamento.setCentro("EXATAS");
                
        
        try{
            dao.inserir(departamento);
        }   catch (ConexaoException ex) {
            Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro01");
        } 
    }   
        
        
}
    

