
package br.com.grupo02.Negocio.Modelo;

import java.util.*;

/**
 *
 * @author Dadniel Medeiros
 */
public class Aluno {

    private int matricula;
    private int idCurso;
    private int idDept;
    private String nome;
    private String cpf;
    private String rua;
    private String cidade;
    private String cep;
    private String telefone1;
    private String telefone2;
    private String datnasc;
    private String sexo;

    public Aluno() {

    }

    public Aluno(String nome, String cpf, String rua, String cidade, String cep, String telefone1, String telefone2, String datnasc) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
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
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * @param telefone2 the telefone2 to set
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    /**
     * @return the datnasc
     */
    public String getDatnasc() {
        return datnasc;
    }

    /**
     * @param datnasc the datnasc to set
     */
    public void setDatnasc(String datnasc) {
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

}
