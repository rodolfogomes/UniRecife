
package br.com.grupo02.aplicacao.aluno;

import br.com.grupo02.erro.ConexaoException;
import br.com.grupo02.interfaces.GerenciadorConexao;
import java.sql.Connection;

/**
 *
 * @author Daniel
 */
public class  AlunoDAO implements GerenciadorConexao  {

    @Override
    public Connection conectar() throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public void salvar (){
        
    }
    public void deletar (Aluno a){
        
    }
    public void editar (Aluno a){
        
    }
    
    public Aluno localizar(Aluno a){
        
        return null;
    }
    
    
    
    
}
