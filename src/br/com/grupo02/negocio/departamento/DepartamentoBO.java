/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.negocio.departamento;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;

import java.util.ArrayList;
import java.util.List;

/**
 *           
 * @author Wallison
 */
public class DepartamentoBO {
    
    public DepartamentoBO() {
    }

    public boolean isValidaBranco(String str) {


        return str.trim().isEmpty();
    }

    public void validarCamposDepartamento(Departamento dept) throws GeralException {

        if (dept.getNome().isEmpty() || isValidaBranco(dept.getNome())) {
            throw new GeralException("Nome é um campo de preenchimento obrigatorio!");
        }
        if (dept == null) {

            throw new GeralException("Não é possivel salvar vazio!");
        }
        if (dept.getTelefone().isEmpty() || isValidaBranco(dept.getTelefone())) {
            throw new GeralException("Telefone é um campo de preenchimento obrigatorio!");

        }
        if (dept.getCentro().isEmpty() || isValidaBranco(dept.getCentro())) {
            throw new GeralException("O Campo de centro é de preenchimento obrigatorio!");
        }

    }

    public void verificarDuplicidade(Departamento dept, DepartamentoDAO deptdao) throws ConexaoException, DAOException, GeralException {
        if (deptdao.filtrarDepartamento(dept, "nome")) {
            throw new GeralException("Já existe um departamento com este nome!");
        }
        if (deptdao.filtrarDepartamento(dept, "telefone")) {
            throw new GeralException("Já existe um departamento com este telefone!");
        }
        if (deptdao.filtrarDepartamento(dept, "centro")) {
            throw new GeralException("Já existe um departamento com o mesmo centro");
        }

    }

    public Departamento bucarDepartamento(Departamento dept) throws DAOException, ConexaoException {
        DepartamentoDAO deptdao = new DepartamentoDAO();
        dept = deptdao.buscarPorId(dept.getId());

        return dept;
    }

    public void salvarDepartamento(Departamento dept) throws DAOException, GeralException, ConexaoException {
        DepartamentoDAO deptdao = new DepartamentoDAO();
        //validarCamposDepartamento(dept);
        //verificarDuplicidade(dept, deptdao);
        deptdao.inserir(dept);

    }
    public void atualizarDepartamento(Departamento dept) throws GeralException, ConexaoException, DAOException{
        DepartamentoDAO deptdao = new DepartamentoDAO();
        validarCamposDepartamento(dept);
        if(dept.getId()!=0 &&dept.getId()>0){
        deptdao.atualizar(dept);
           
        }
    }
    public void deletarDepartamento(Departamento dept) throws ConexaoException, DAOException, GeralException{
        DepartamentoDAO deptdao = new DepartamentoDAO();
        if(dept!=null){
            deptdao.deletar(dept.getId());
        }else{
            throw new GeralException("Selecione ao menos um Departamento para ser excluido.");
        }
    }
    public List<Departamento> listarDepartamento() throws ConexaoException, DAOException{
        DepartamentoDAO deptdao = new DepartamentoDAO();
        return deptdao.listarTodos();
    }
    

}
