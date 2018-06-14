/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.fachada;

import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.departamento.DepartamentoBO;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.error.GeralException;
import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author Wallison
 */
public class FachadaDepartamento {
    
    public List<Departamento> listaDepartamento() throws ConexaoException, DAOException{
        List<Departamento> listaDepartamento = new ArrayList();
        DepartamentoBO bo = new DepartamentoBO();
        listaDepartamento = bo.listarDepartamento();
    
        return listaDepartamento;
    }
    
    public void salvarDepartamento(Departamento d) throws ConexaoException, DAOException, GeralException{
        DepartamentoBO bo = new DepartamentoBO();
        bo.salvarDepartamento(d);
    }
    
}
