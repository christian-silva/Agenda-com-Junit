/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;

/**
 * Classe que contém todas as informações do contato
 *
 * @author Christian
 * @date 04-06-2020
 */
public class Contato {

    protected String nome;
    protected String endereco;
    protected int idade;
    protected ArrayList<Telefones> telefones;
    protected ArrayList<Emails> emails;

    /**
     * Construtor da classe contato com atributos iniciais
     */
    public Contato() {
        this.nome = "";
        this.endereco = "";
        this.idade = 1;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    /**
     * Contrutor da classe contato com todos os atributos
     *
     * @param nome Nome do Contato
     * @param endereco Endereço do Contato
     * @param idade Idade do Contato
     * @param telefones Telefones do Contato
     * @param emails Emails do Contato
     */
    public Contato(String nome, String endereco, int idade, ArrayList<Telefones> telefones, ArrayList<Emails> emails) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefones = telefones;
        this.emails = emails;
    }

    /**
     * Obtém o nome do contato
     *
     * @return retorna o nome do contato
     */
    public String getNome() {
        return nome;
    }

    /**
     * Informa o nome do contato
     *
     * @param nome Informa o nome do contato
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereco do contato
     *
     * @return retorna o endereco do contato
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Informa o endereco do contato
     *
     * @param endereco Informa o endereco do contato
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém a idade do contato
     *
     * @return retorna a idade do contato
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Informa a idade do contato
     *
     * @param idade Informa a idade do contato
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Informa o núemro do telefone
     *
     * @param tel Núemro do telefone
     */
    public void setTelefones(Telefones tel) {
        this.telefones.add(tel);
    }

    /**
     * Trasforma a lista de telefones em uma String para exibir a informação
     *
     * @return String com os telefones
     */
    public String getTelefones() {
        String tel = "Telefones: ";
        for (Telefones telefone : telefones) {
            tel += telefone.getModelo() + " - " + telefone.getNumero() + " | ";
        }
        return tel;
    }

    /**
     * Informa o email do contato
     * @param email Email do contato
     */
    public void setEmails(Emails email) {
        this.emails.add(email);
    }

    /**
     * Retorna os emails do contato organizados em uma String.
     * @return  String com os emails
     */
    public String getEmails() {
        String email = "Emails: ";
        for (Emails eml : emails) {
            email += eml.getEmail() + " | ";
        }
        return email;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", "
                + "telefones=" + this.getTelefones() + ", "
                + "emails=" + this.getEmails() + '}';
    }

}
