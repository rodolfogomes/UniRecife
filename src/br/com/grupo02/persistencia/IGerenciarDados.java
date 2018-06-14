/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.persistencia;

import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import java.util.List;

/**
 * Contém métodos genericos para realização do crud.
 * @author Rodolfo Gomes
 * @param <objeto>
 */
public interface IGerenciarDados<objeto> {
    
    void inserir(objeto obj)throws ConexaoException,DAOException;
    void atualizar(objeto obj)throws ConexaoException,DAOException;
    void deletar(Integer id)throws ConexaoException,DAOException;
    List<objeto> listarTodos()throws ConexaoException,DAOException;
    objeto buscarPorId(Integer id)throws ConexaoException,DAOException;
    
}
