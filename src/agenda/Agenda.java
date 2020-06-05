/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;

/**
 * Classe principal da agenda pois contém os métodos para manipular os dados
 *
 * @author Christian
 */
public class Agenda {

    //Array onde ficarão salvos temporariamente os dados dos contatos
    private ArrayList<Contato> agendaContatos;

    /**
     * Inicializa a agenda
     */
    public Agenda() {
        this.agendaContatos = new ArrayList<>();
    }

    /**
     * Adiciona um novo contato à agenda
     *
     * @param contato Contato a ser inserido na agenda
     */
    public void adicionarContato(Contato contato) {
        this.agendaContatos.add(contato);
    }

    /**
     * Remover um contato à agenda
     * @param contato Passa o contato a ser removido
     * @return Retorna verdadeiro se conseguiu remover o contato e falso caso contrário
     */
    public boolean removerContato(Contato contato) {
        for (Contato agenda : agendaContatos) {
            if (agenda.equals(contato)) {
                this.agendaContatos.remove(agenda);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca um contato na agenda
     * @param nome Passa o nome do contato a ser buscado
     * @return  Retorna todas as informações do contato
     */
    public Contato buscarContato(String nome) {
        for (Contato agenda : agendaContatos) {
            if (agenda.getNome().trim().toLowerCase().equals(nome.trim().toLowerCase())) {
                return agenda;
            }
        }
        return null;
    }

    /**
     * Busca os emails dos contatos informado
     * @param contato Passa o contato para buscar os emails
     * @return Retorna uma String com os emails
     */
    public String buscarEmailsContato(Contato contato) {
        return contato.getEmails();
    }
    
    /**
     * Busca os telefones dos contatos informado
     * @param contato Passa o contato para buscar os telefones
     * @return Retorna uma String formatada com os telefones
     */
    public String buscarTelefonesContato(Contato contato) {
        return contato.getTelefones();
    }

    /**
     * Busca todos os contatos da agenda
     * @return Retorna uma lista de contatos
     */
    public ArrayList<Contato> buscarTodosContatos() {
        return agendaContatos;
    }
    
    /**
     * Verifica a quantidade de contatos existentes na agenda
     * @return Retorna o número de contatos na agenda
     */
    public int quantidadeContatosAgenda() {
        return agendaContatos.size();
    }

    /**
     * Limpa a agenda
     */
    public void esvaziarAgenda() {
        agendaContatos.clear();
    }

}
