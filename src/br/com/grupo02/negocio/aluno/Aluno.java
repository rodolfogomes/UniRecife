package br.com.grupo02.negocio.aluno;

import br.com.grupo02.negocio.curso.Curso;
import br.com.grupo02.negocio.departamento.Departamento;
import java.sql.Date;

/**
 *
 * @author Dadniel Medeiros
 */
public class Aluno {

    private int id;
    private int matricula;
    private String nome;
    private String cpf;
    private String rua;
    private String cidade;
    private String cep;
    private String telefone1;
    private Date datnasc;
    private String sexo;

    public Aluno() {

    }

    public Aluno(String nome, String cpf, String rua, String cidade, String cep, String telefone1,  Date datnasc) {

        this.nome = nome;
        this.cpf = cpf;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone1 = telefone1;
        this.datnasc = datnasc;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }



    /**
     * @return the datnasc
     */
    public Date getDatnasc() {
        return datnasc;
    }

    /**
     * @param datnasc the datnasc to set
     */
    public void setDatnasc(Date datnasc) {
        this.datnasc = datnasc;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    



}
