package br.com.grupo02.interfaces;

/**
 *
 * @author ADM
 */
public interface GerenciadorConexao<OBJETO>{

    public abstract void salvar(OBJETO obj);
    public abstract void editar(OBJETO obj);
    public abstract void deletar (OBJETO obj);
    public abstract Object carregar(OBJETO obj);
    public abstract Object listar();




}
