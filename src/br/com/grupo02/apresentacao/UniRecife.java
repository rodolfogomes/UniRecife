/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupo02.apresentacao;

import br.com.grupo02.negocio.curso.Curso;
import br.com.grupo02.negocio.curso.CursoDAO;
import br.com.grupo02.negocio.departamento.Departamento;
import br.com.grupo02.negocio.disciplina.Disciplina;
import br.com.grupo02.negocio.disciplina.DisciplinaDAO;
import br.com.grupo02.negocio.matricula.Matricula;
import br.com.grupo02.negocio.matricula.MatriculaDAO;
import br.com.grupo02.negocio.alunoposgrad.AlunoPosGrad;
import br.com.grupo02.negocio.alunoposgrad.AlunoPosGradDAO;
import br.com.grupo02.negocio.oferta.Oferta;
import br.com.grupo02.negocio.oferta.OfertaDao;
import br.com.grupo02.negocio.error.ConexaoException;
import br.com.grupo02.negocio.error.DAOException;
import br.com.grupo02.negocio.professor.Professor;
import br.com.grupo02.negocio.professor.ProfessorDAO;
import br.com.grupo02.negocio.professor.ProfessorBO;
import br.com.grupo02.persistencia.GerenciarConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Date.parse;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.parse;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.Global.getDate;

/**
 *
 * @author Rodolfo Gomes
 */
public class UniRecife {
    // Para realizar os testes criem seus métodos e chamem no main como no exempo abaixo.

    public static void main(String[] args) throws ConexaoException, DAOException, ParseException {

        //inserirCurso();
        //atualizarCurso();
        //excluirCurso();
//       buscarCursoId(); 
       //inserirProfessor();
       atualizarProfessor();
       buscarPorIdOferta();
       listarTodosOferta();
       atualizarOferta();
       // deletarProfessor();
       // buscarPorIdProfessor();
       // listarTodosProfessor();
         // testaConexao();
         // inserirMatricula();
         //atualizarMatricula();
         // deletarMatricula();
         // buscarPorIdMatricula();
         // listarTodosMatricula();
        //  inserirAlunoPosGrad ();
          //deletarAlunoPosGrad();
        //  atualizarAlunoPosGrad();
       //   buscarPorIdAlunoPosGrad();
        //  listarTodosPorAlunoPosGrad();
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

    public static void buscarPorIdTeste() throws ConexaoException, DAOException {

        int id = 4;
        DisciplinaDAO dao = new DisciplinaDAO();
        Disciplina disciplina = dao.buscarPorId(id);

        System.out.println("Dados do id: " + disciplina.getId());
        System.out.println("Dados do Nome: " + disciplina.getNome());
        System.out.println("Dados do Descricao: " + disciplina.getDescricao());

    }

    public static void listarTodosDiscTeste() throws ConexaoException, DAOException {

        DisciplinaDAO dao = new DisciplinaDAO();
        List<Disciplina> listaDis;
        listaDis = dao.listarTodos();

        for (Disciplina d : listaDis) {
            System.out.println("Nome: " + d.getNome());
        }

    }

   public static void inserirCurso() {

        try {

           ProfessorDAO daoP = new ProfessorDAO();
           Curso curso = new Curso();
           curso.setTipo("curso02");
           curso.getCoordenador().setId(3);
           curso.getViceCoordenador().setId(1);

           CursoDAO dao = new CursoDAO();
           dao.inserir(curso);
           System.out.println("Dados inseridos!");
            } catch (ConexaoException ex) {
            ex.getMessage();
           ex.printStackTrace();
        }
    }
    
    public static  void atualizarCurso(){
        
          Curso curso = new Curso();
            curso.setCodigo(1);
            curso.setTipo("teste update");
            curso.getCoordenador().setId(1);
            curso.getViceCoordenador().setId(3);

            CursoDAO dao = new CursoDAO();
       try {
            dao.atualizar(curso);
            System.out.println("Dados atualizados!");
        } catch (ConexaoException ex) {
            Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
    public static void excluirCurso(){
       
        CursoDAO dao = new CursoDAO();
        try {
            dao.deletar(1);
            System.out.println("Excluido com sucesso!");
        } catch (ConexaoException ex) {
            Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void buscarCursoId(){
        CursoDAO dao = new CursoDAO();
        try {
         Curso curso = dao.buscarPorId(2);
          System.out.println("Coordenador: ".concat(curso.getCoordenador().getNome()));
        } catch (ConexaoException ex) {
           Logger.getLogger(UniRecife.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
   public static void inserirProfessor() {
    
   
     Professor prf = new Professor();
     prf.setCpf("777.777.77-56");
     prf.setNome("Teste 55");
     prf.getDepartamento().setId(1);
     prf.setTelefone("2111-1111");
     prf.setSalario(500f);
     ProfessorBO bo = new ProfessorBO();
        try {
            bo.salvarProfessor("salvar", prf);
            System.out.println("REGISTRO SALVO COM SUCESSO");
        } catch (DAOException e) {
             System.out.println("ERRO: " + e.getMessage());
        }
       
        }
     //ProfessorDAO dao = new ProfessorDAO();
    //dao.inserir(prf);
    // System.out.println("Dados inseridos!");
   // } catch (ConexaoException | DAOException ex) {
        //   ex.getMessage();
           //ex.printStackTrace();
    
      //  }

    public static void atualizarProfessor() {       
       
            Professor prf = new Professor();
            prf.setId(9);   
            prf.setCpf("111.111.111-12");
            prf.setNome("Teste 30");
            prf.setTelefone("2121-5020");
            prf.setSalario(10000f);
            prf.getDepartamento().setId(1);
            ProfessorBO bo = new ProfessorBO();
            
             try{
            bo.salvarProfessor("atualizar", prf);
            System.out.println("Registro alterado com sucesso");
                 }catch ( DAOException e){
             System.out.println("ERRO: " + e.getMessage());
              }
            //try{        
           // dao.atualizar(prf);
          //  System.out.println("Dados atualizados!");   
          //  } catch (ConexaoException | DAOException ex) {
            //ex.getMessage();

      //  }
           
}
    public static void deletarProfessor() {
        Professor prf = new Professor();
        ProfessorDAO dao = new ProfessorDAO();
        prf.setId(7);
        try{
        dao.deletar(prf.getId());
        System.out.println("Dados Excluídos!");  
        } catch (ConexaoException | DAOException ex) {
            ex.getMessage();}
        }
    
    public static void buscarPorIdProfessor() throws ConexaoException, DAOException{
        int id = 2;
        ProfessorDAO dao = new ProfessorDAO();
        Professor prf = dao.buscarPorId(id);
        System.out.println("Consulta Realizada com sucesso!");  
        
        System.out.println("Dados do id: " + prf.getId());
        System.out.println("Dados do Cpf: " + prf.getCpf());
        System.out.println("Dados do Nome: " + prf.getNome());
        
    
      }
    
    public static void listarTodosProfessor() throws ConexaoException, DAOException {

        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> listaProf;
        listaProf = dao.listarTodos();
        System.out.println("Lista Realizada com sucesso!"); 
        for (Professor p : listaProf) {
            System.out.println("id: " + p.getId());
            System.out.println("cpf: " + p.getCpf());
            System.out.println("telefone: " + p.getTelefone());
            System.out.println("salario: " + p.getSalario());
            System.out.println("dep_codigo: " + p.getDepartamento().getId());
        }

    }
    
    
    public static void inserirMatricula(){
        try{
            Matricula mat = new Matricula();
            mat.getIdOferta().setId(2);
            
            MatriculaDAO dao = new MatriculaDAO();
            dao.inserir(mat);
            System.out.println("Dados inseridos!"); 
        } catch (ConexaoException | DAOException ex) {
           ex.getMessage();
           ex.printStackTrace();
    
            
        }
    }
    public static void atualizarMatricula(){
        Matricula mat = new Matricula();
        mat.setId(3);
        mat.getIdOferta().setId(1);
        MatriculaDAO dao = new MatriculaDAO();
        
        try{
            dao.atualizar(mat);
            System.out.println("Dados atualizados!");   
            } catch (ConexaoException | DAOException ex) {
            ex.getMessage();

        }
    }
    
    public static void deletarMatricula (){
        Matricula mat = new Matricula();
        MatriculaDAO dao = new MatriculaDAO();
        mat.setId(5);
        try{
        dao.deletar(mat.getId());
        System.out.println("Dados Excluídos!");  
        } catch (ConexaoException | DAOException ex) {
            ex.getMessage();}
        }
    
    public static void buscarPorIdMatricula()throws ConexaoException, DAOException{
        int id = 2;
        MatriculaDAO dao = new MatriculaDAO();
        Matricula mat = dao.buscarPorId(id);
        System.out.println("Consulta Realizada com sucesso!");  
        
        System.out.println("Dados do id: " + mat.getId());
        System.out.println("Dados do id_oferta: " + mat.getIdOferta().getId());

      }
     public static void listarTodosMatricula() throws ConexaoException, DAOException {

        MatriculaDAO dao = new MatriculaDAO();
        List<Matricula> listaMatricula;
        listaMatricula = dao.listarTodos();
        System.out.println("Lista Realizada com sucesso!"); 
        for (Matricula m : listaMatricula) {
            System.out.println("id: " + m.getId());
            System.out.println("Dados do id_oferta: " + m.getIdOferta().getId());
         
        }

    }   
        
    public static void inserirAlunoPosGrad(){
        
        try{
            AlunoPosGrad apg = new AlunoPosGrad();
            apg.getIdOrientador().setId(1);
            apg.setValorBolsa(900f);
         
            
            AlunoPosGradDAO dao = new AlunoPosGradDAO();
            dao.inserir(apg);
            System.out.println("Dados inseridos!"); 
        } catch (ConexaoException | DAOException ex) {
           ex.getMessage();
           ex.printStackTrace();
    
            
        }
    }
    
     public static void atualizarAlunoPosGrad(){
            AlunoPosGrad apg = new AlunoPosGrad();
            apg.setId(1);   
            apg.getIdOrientador().setId(1);
            apg.setValorBolsa(500f);
            AlunoPosGradDAO dao = new AlunoPosGradDAO();
            try{        
            dao.atualizar(apg);
            System.out.println("Dados atualizados!");   
            } catch (ConexaoException | DAOException ex) {
            ex.getMessage();

        }
           
} 
        
    public static void deletarAlunoPosGrad(){
        AlunoPosGrad apg = new AlunoPosGrad();
        AlunoPosGradDAO dao = new AlunoPosGradDAO();
        apg.setId(2);
        try{
        dao.deletar(apg.getId());
        System.out.println("Dados Excluídos!");  
        } catch (ConexaoException | DAOException ex) {
            ex.getMessage();}
        }
    
    public static void buscarPorIdAlunoPosGrad()throws ConexaoException, DAOException {
        int id = 1;
        AlunoPosGradDAO dao = new AlunoPosGradDAO();
        AlunoPosGrad apg = dao.buscarPorId(id);
        System.out.println("Consulta Realizada com sucesso!");  
        
        System.out.println("Dados do id: " + apg.getId());
        System.out.println("Dados do Id_orientador: " + apg.getIdOrientador().getId());
        System.out.println("Dados da Bolsa: " + apg.getValorBolsa());
    } 
    
    public static void listarTodosPorAlunoPosGrad() throws ConexaoException, DAOException{
        AlunoPosGradDAO dao = new AlunoPosGradDAO();
        List<AlunoPosGrad> listaAlunoPosGrad;
        listaAlunoPosGrad = dao.listarTodos();
        System.out.println("Lista Realizada com sucesso!"); 
        for (AlunoPosGrad apg : listaAlunoPosGrad) {
             System.out.println("Dados do id: " + apg.getId());
             System.out.println("Dados do Id_orientador: " + apg.getIdOrientador().getId());
             System.out.println("Dados da Bolsa: " + apg.getValorBolsa());
        }
}
    
    
    public static void buscarPorIdOferta() throws ConexaoException, DAOException, ParseException{
        int id = 2;
        OfertaDao dao = new OfertaDao();
        Oferta ofr = dao.buscarPorId(id);
        System.out.println("Consulta Realizada com sucesso!");  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date =  sdf.parse("30/09/2018");
        
        
        System.out.println("Dados do id: " + ofr.getId());
        System.out.println("Dados do Id_disciplina: " + ofr.getIDisciplina().getId());
        System.out.println("Dados do Id_professor: " + ofr.getIdProfessor().getId());
        System.out.println("Dados do horario: " + ofr.getHorario());
    }
    
    
    public static void  listarTodosOferta()throws ConexaoException, DAOException{
        OfertaDao dao = new OfertaDao();
        List<Oferta> listaOferta;
        listaOferta = dao.listarTodos();
        System.out.println("Lista Realizada com sucesso!"); 
        for (Oferta ofr : listaOferta) {
             System.out.println("Dados do id: " + ofr.getId());
             System.out.println("Dados do Id_disciplina: " + ofr.getIDisciplina().getId());
             System.out.println("Dados do Id_professor: " + ofr.getIdProfessor().getId());
             System.out.println("Dados do horario: " + ofr.getHorario());
        }
        
    }
    public static void atualizarOferta() throws ParseException{
        Oferta ofr = new Oferta();
      //  java.util.Date utilDate = new java.util.Date();
      //  java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());  

      //  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
     //   System.out.println(sdf.format(sq));
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          java.util.Date date =  sdf.parse("30/09/2018");
        
        ofr.setId(1);
        ofr.getIDisciplina().setId(2);
        ofr.getIdProfessor().setId(12);
        ofr.getHorario();
        //ofr.getHorario().getDate(2018-06-10);
       // ofr.setHorario(new java.sql.Date(date.getTime()));  
       // System.out.println("Data: "+ ofr.getHorario()); 
        OfertaDao dao = new OfertaDao();
         try{ 
       
            dao.atualizar(ofr);
            System.out.println("Dados atualizados!");   
            } catch (ConexaoException | DAOException ex) {
            ex.getMessage();

        }
    }
    }
    
    
    

    

    
    

