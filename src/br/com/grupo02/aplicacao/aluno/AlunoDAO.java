
package br.com.grupo02.aplicacao.aluno;

import br.com.grupo02.erro.ConexaoException;
import br.com.grupo02.interfaces.GerenciadorConexao;
import br.com.grupo02.persistencia.GerenciadorConexaoMSS;
import java.sql.Connection;

/**
 *
 * @author Daniel
 */
public class  AlunoDAO  extends GerenciadorConexaoMSS implements GerenciadorConexao{

    @Override
    public Connection conectar() throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    

    @Override
    public void salvar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GerenciadorConexao carregar(GerenciadorConexao gc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GerenciadorConexao listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
