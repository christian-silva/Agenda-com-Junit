/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Christian
 */
public class ContatoTest {
    
    private static ArrayList<Contato> contatos;
    
    public ContatoTest() {
        contatos = new ArrayList<>();
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
        contatos.add(contato1);
        contatos.add(contato2);
    }
    
    @After
    public void tearDown() {
        /**
         * Executado no final de cada teste. Server para limpar possíveis lixo
         * para o próximo teste.
         */
        contatos.clear();
        
    }

    /**
     * Test of getNome method, of class Contato.
     */
    @Test
    public void testGetNome() {
        System.out.println("get Nome");
        
        String expResult = "Christian Silva";
        
        String result = contatos.get(0).getNome();
        
        // verificações do teste
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEndereco method, of class Contato.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("get Endereco");
        
        /**
         * Montando o cenário para realizar os testes de obter o enfereõ do contato
         */
        String endereco = "logradouro - Rio Grande - RS";
        
        // Execução do teste
        String result = contatos.get(0).getEndereco();
        
        // verificações do teste
        assertEquals(endereco, result);
        assertNotNull(result);
        
    }

    /**
     * Test of setEndereco method, of class Contato.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("set Endereco");
        
        /**
         * Montando o cenário para realizar os testes
         */
        String endereco = "Rua francisco marques, 333, Centro - RS";
        Contato contato = contatos.get(1);
        
        // Executa  o teste
        contato.setEndereco(endereco);
        
        // verificações do teste
        assertEquals(endereco, contato.getEndereco());
        
    }

    /**
     * Test of getIdade method, of class Contato.
     */
    @Test
    public void testGetIdade() {
        System.out.println("get Idade");
        
        /**
         * Montando o cenário para realizar os testes de obter a idade
         */
        Contato instance = contatos.get(0);
        int expResult = 31;
        
        // executa o teste de obter a idade
        int result = instance.getIdade();
        
        // verificações do teste
        assertEquals(expResult, result);
        assertThat(result, is(31));
    }

    /**
     * Test of setTelefones method, of class Contato.
     */
    @Test
    public void testSetTelefones() {
        System.out.println("set Telefones");
        
        /**
         * Montando o cenário 
         */
        Telefones tel = new Telefones("5390908888", "LG");
        Contato instance = contatos.get(1);
        
        //Executa o teste
        instance.setTelefones(tel);
        
        // verificações do teste
        assertEquals(tel, instance.telefones.get(2));
        assertThat(instance.telefones.size(), is(3));
    }

    /**
     * Test of setEmails method, of class Contato.
     */
    @Test
    public void testSetEmails() {
        System.out.println("set Emails");
        
        /**
         * Montando o cenário para setar um novo email
         */
        Emails email = new Emails("lucas.moraes@gmailcom");
        Contato instance = contatos.get(1);
        
        // Executa o teste
        instance.setEmails(email);
        
        // verificações do teste
        assertEquals(email, instance.emails.get(2));
        assertThat(instance.emails.size(), is(3));
    }

    /**
     * Test of getEmails method, of class Contato.
     */
    @Test
    public void testGetEmails() {
        System.out.println("get Emails");
        
        /**
         * Montando o cenário para realizar os testes
         */
        Contato instance = contatos.get(0);
        String expResult1 = "christianecomp@gmail.com";
        String expResult2 = "christian.ecomp@gmail.com";
        
        // Execução do teste obtendo os dois emails pré cadastrados
        Emails emailResult1 = instance.emails.get(0);
        Emails emailResult2 = instance.emails.get(1);
        
        // verificações do teste
        assertEquals(expResult1, emailResult1.getEmail());
        assertEquals(expResult2, emailResult2.getEmail());
        
    }

    /**
     * Test of adicionarContato method, of class Contato.
     */
    @Test
    public void adicionarContatoLista() {
        System.out.println("set Nome");
        
        /**
         * Montando o cenário para adicionar um novo usuario na lista de contatos
         */
        String nome = "Mari Lucy";
        String endereco = "Alagoas 379, Centro - RS";
        Contato instance = new Contato(nome, endereco, 35, null, null);
        
        // Executa a adição do novo contato
        contatos.add(instance);
        
        // verificações do teste
        assertEquals(instance,contatos.get(2));
        assertThat(contatos.size(), is(3));
    }
    
}
