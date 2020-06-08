/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Christian
 */
public class AgendaTest {

    private static Agenda agenda;

    public AgendaTest() {
        agenda = new Agenda();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        /**
         * Montando o cenário para realizar os testes. Sempre chamado antes de
         * executar um teste.
         */
        Telefones telefone1 = new Telefones("53984999999", "Motorola");
        Telefones telefone2 = new Telefones("53984000000", "iPhone");
        ArrayList<Telefones> telefones1 = new ArrayList<>();
        telefones1.add(telefone1);
        telefones1.add(telefone2);

        Emails email1 = new Emails("christianecomp@gmail.com");
        Emails email2 = new Emails("christian.ecomp@gmail.com");
        ArrayList<Emails> emails1 = new ArrayList<>();
        emails1.add(email1);
        emails1.add(email2);

        Contato contato1 = new Contato("Christian Silva", "logradouro - Rio Grande - RS", 31, telefones1, emails1);

        Telefones telefone3 = new Telefones("53981109999", "Nokia");
        Telefones telefone4 = new Telefones("53981100099", "Xiaomi");
        ArrayList<Telefones> telefones2 = new ArrayList<>();
        telefones2.add(telefone3);
        telefones2.add(telefone4);

        Emails email3 = new Emails("luuhcas@gmail.com");
        Emails email4 = new Emails("lucasmoraes@gmail.com");
        ArrayList<Emails> emails2 = new ArrayList<>();
        emails2.add(email3);
        emails2.add(email4);

        Contato contato2 = new Contato("Lucas Moraes", "logradouro - São Paulo - SP", 23, telefones2, emails2);

        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        System.out.println(" >>> Agenda iniciada.");
    }

    @After
    public void tearDown() {

        /**
         * Executado no final de cada teste. Server para limpar possíveis lixo
         * para o próximo teste.
         */
        agenda.esvaziarAgenda();
        System.out.println(" >>> Agenda esvaziada.");
    }

    /**
     * Test of adicionarContato method, of class Agenda.
     */
    @Test
    public void testAdicionarContato() {
        System.out.println("Adicionar contato.");
        
        /**
         * Montando o cenário para realizar os testes de Adicionar Contato
         */
        Telefones telefone = new Telefones("53981109999", "Nokia");
        ArrayList<Telefones> telefones = new ArrayList<>();
        telefones.add(telefone);

        Emails email = new Emails("chris@gmail.com");
        ArrayList<Emails> emails = new ArrayList<>();
        emails.add(email);

        Contato contato = new Contato("Lucas Moraes", "logradouro - São Paulo - SP", 23, telefones, emails);
        
        // Execução do método 
        agenda.adicionarContato(contato);

        // verificações do teste
        assertThat(agenda.quantidadeContatosAgenda(), is(3));
        assertEquals(contato.getNome(), agenda.buscarContato("Lucas Moraes").getNome());

    }

    /**
     * Test of removerContato method, of class Agenda.
     */
    @Test
    public void testRemoverContato() {
        System.out.println("remover Contato");
        /**
         * Montando o cenário para realizar a remoção do contato
         */
        Contato contato = agenda.buscarContato("Lucas Moraes");

        // Executando a remoção do contato
        boolean removerContato = agenda.removerContato(contato);

        // verificações do teste
        assertTrue(removerContato);
        assertNull(agenda.buscarContato("Lucas Moraes"));
        assertThat(agenda.quantidadeContatosAgenda(), is(1));

    }

    /**
     * Test of buscarContato method, of class Agenda.
     */
    @Test
    public void testBuscarContato() {
        System.out.println("buscar Contato");
        
        // Monta o cenário com um contato pré cadastrado
        String nome = "Christian Silva";
        
        // Executa a busca do contato
        Contato result = agenda.buscarContato(nome);

        // verificações do teste
        assertEquals(nome, result.getNome());
        assertThat(result.getEndereco(), is("logradouro - Rio Grande - RS"));
    }

    /**
     * Test of buscarEmailsContato method, of class Agenda.
     */
    @Test
    public void testBuscarEmailsContato() {
        System.out.println("buscar Emails do Contato");
        
        // Monta o cenário com um contato pré cadastrado
        String nome = "Christian Silva";
        Contato contato = agenda.buscarContato(nome);
        
        // Executa a busca dos emails do contato informado
        String result = agenda.buscarEmailsContato(contato);

        // verificação do teste
        assertEquals(contato.getEmails(), result);

    }

    /**
     * Test of buscarTelefonesContato method, of class Agenda.
     */
    @Test
    public void testBuscarTelefonesContato() {
        System.out.println("buscar Telefones do Contato");
        
        // Monta o cenário com um contato pré cadastrado
        Contato contato = agenda.buscarContato("Lucas Moraes");

        // Executa a busca dos telefones do contato informado
        String result = agenda.buscarTelefonesContato(contato);

        // verificação do teste
        assertEquals(contato.getTelefones(), result);

    }

    /**
     * Test of buscarTodosContatos method, of class Agenda.
     */
    @Test
    public void testBuscarTodosContatos() {
        System.out.println("buscar Todos os Contatos");
        
        // Executa a busca de todos os contatos pré adicionados na agenda
        ArrayList<Contato> result = agenda.buscarTodosContatos();

        // verificações do teste
        assertNotNull(result);
        assertThat(agenda.quantidadeContatosAgenda(), is(2));
        assertEquals("Christian Silva", result.get(0).getNome());

    }

    /**
     * Test of quantidadeContatosAgenda method, of class Agenda.
     */
    @Test
    public void testQuantidadeContatosAgenda() {
        System.out.println("quantidade de Contatos na Agenda");
        
        // Seta o resultado esperado do cenário
        int expResult = 2;
        
        // Executa a busca da quantidade de contatos inseridos na agenda
        int result = agenda.quantidadeContatosAgenda();

        // verificação do teste
        assertEquals(expResult, result);
        assertThat(result, is(2));

    }

    /**
     * Test of esvaziarAgenda method, of class Agenda.
     */
    @Test
    public void testEsvaziarAgenda() {
        System.out.println("esvaziar Agenda");

        // Execução do teste
        agenda.esvaziarAgenda();

        // verificação do teste
        assertThat(agenda.quantidadeContatosAgenda(), is(0));
        assertNull(agenda.buscarContato("teste"));
    }

}
