/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;

import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.disciplina.Disciplina;
import br.com.grupo02.negocio.disciplina.DisciplinaDAO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.util.List;
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
            
                try {
                    /*
                    try {
                    testaConexao();
                    inserirDisciplina();
                    atualizarDisciplina();
                    } catch (ConexaoException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DAOException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    deletarDisciplina();
                    } catch (ConexaoException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DAOException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    buscarPorIdTeste();
                    } catch (ConexaoException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DAOException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    */
                    listarTodosDiscTeste ();
                    } catch (ConexaoException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DAOException ex) {
                    Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
    }

    public static void testaConexao() {

        try {

            Connection con = GerenciarConexao.getInstancia().conectar();
            System.out.println("Conexão Funciona!");
        } catch (ConexaoException ex) {
            System.out.println("Erro na conexão: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void inserirDisciplina() {

        try {
            Departamento departamento = new Departamento();

            departamento.setId(1);

            Disciplina disciplina = new Disciplina();
            disciplina.setId(5);
            disciplina.setNome("RAO");
            disciplina.setDescricao("Jadiel");
            disciplina.setDepartamento(departamento);

            DisciplinaDAO dao = new DisciplinaDAO();
            dao.inserir(disciplina);
        } catch (ConexaoException | DAOException ex) {
            ex.getMessage();
        }

    }

    public static void atualizarDisciplina() throws ConexaoException, DAOException {
         
        DisciplinaDAO dao = new DisciplinaDAO();

        try {
            Departamento departamento = new Departamento();

            departamento.setId(1);

            Disciplina disciplina = new Disciplina();
            disciplina.setId(3);
            disciplina.setNome("POO");
            disciplina.setDescricao("Kenzo");
            disciplina.setDepartamento(departamento);

            
            System.out.println("111111111111111111111");
            dao.atualizar(disciplina);
            System.out.println("2222222222222222222");
        } catch (ConexaoException | DAOException ex) {
            ex.getMessage();

        }
    }
    public static void deletarDisciplina() throws ConexaoException, DAOException { 
        
        DisciplinaDAO dao = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        disciplina.setId(3);
        dao.deletar(disciplina.getId());
        System.out.println("Excluido com Sucesso!");
    }    
        
    public static void buscarPorIdTeste() throws ConexaoException, DAOException{
        
        int id=4;
        DisciplinaDAO dao = new DisciplinaDAO();
        Disciplina  disciplina = dao.buscarPorId(id);
                
        System.out.println("Dados do id: "+ disciplina.getId());
        System.out.println("Dados do Nome: "+ disciplina.getNome());
        System.out.println("Dados do Descricao: "+ disciplina.getDescricao());
        
      
    }
    public static void listarTodosDiscTeste () throws ConexaoException, DAOException{
    
        DisciplinaDAO dao = new DisciplinaDAO ();
        List<Disciplina> listaDis;
        listaDis = dao.listarTodos();
        
        for(Disciplina d :listaDis ){
            System.out.println("Nome: " + d.getNome());
        }
        
        
        
        
    }
    
    
    
}
