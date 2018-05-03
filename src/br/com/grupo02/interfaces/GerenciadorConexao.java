package br.com.grupo02.interfaces;

import br.com.grupo02.erro.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author ADM
 */
public interface GerenciadorConexao {

    public abstract void salvar(GerenciadorConexao gc);
    public abstract void editar(GerenciadorConexao gc);
    public abstract void deletar (GerenciadorConexao gc);
    public abstract Object carregar(GerenciadorConexao gc);
    public abstract Object listar();




}
