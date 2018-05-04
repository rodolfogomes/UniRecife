/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.Negocio.Modelo.Interfaces;

import java.util.List;

/**
 * Contém métodos genericos para realização do crud.
 * @author Rodolfo Gomes
 */
public interface DAO<o> {
    
    void inserir(o obj);
    void atualizar(o obj);
    void deletar(Integer id);
    List<o> listarTodos();
    o buscarPorId(Integer id);
    
}
