/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Negocio.Modelo.Interfaces;

import br.com.grupo02.Negocio.Modelo.Excepitons.ConexaoException;
import java.util.List;

/**
 * Contém métodos genericos para realização do crud.
 * @author Rodolfo Gomes
 */
public interface DAO<o> {
    
    void inserir(o obj)throws ConexaoException;
    void atualizar(o obj)throws ConexaoException;
    void deletar(Integer id)throws ConexaoException;
    List<o> listarTodos()throws ConexaoException;
    o buscarPorId(Integer id)throws ConexaoException;
    
}
