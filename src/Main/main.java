package Main;

import agenda.Agenda;
import agenda.Contato;
import agenda.Emails;
import agenda.Telefones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 */
/**
 * Classe main onde é realizada as atividades de manipulação da agenda
 * @author Christian
 * @date 04-06-2020
 */
public class main {

    private static Agenda agenda;

    public static void main(String[] args) throws IOException {
        agenda = new Agenda();

        // Cria algumas agendas
        inicializaAgenda();

        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        boolean continua = true;

        do {
            //Exibe o menu 
            mostrarMenu();

            int opcao;
            String validacao = sc.next();

            //Verifica se o usuário digitou um número e não um caracter qualquer
            try {
                opcao = Integer.parseInt(validacao);
            } catch (NumberFormatException e) {
                System.err.println(" >>> Digite uma opção válida.");
                opcao = 0;
            }

            switch (opcao) {
                //  System.out.println(" 1) Adicionar Contato");
                case 1:

                    System.out.printf(" >>> Adicionando Contato\n");
                    Contato contatoAdicionando = new Contato();
                    System.out.printf("      >>> Nome: ");
                    contatoAdicionando.setNome(in.readLine());
                    System.out.printf("      >>> Idade: ");
                    contatoAdicionando.setIdade(sc.nextInt());
                    System.out.printf("      >>> Endereço: ");
                    contatoAdicionando.setEndereco(in.readLine());

                    agenda.adicionarContato(contatoAdicionando);
                    novaLinha();
                    break;

                // System.out.println(" 2) Adicionar Telefones ao contato");
                case 2:

                    System.out.printf(" >>> Adicionando Telefones ao Contato\n");
                    mostraContatos();
                    System.out.print(" >>> Digite o nome do contato para adicionar o telefone: \n");
                    String nomeContatoAdicionarTelefone = in.readLine();
                    Contato contatoBuscadoAdicionarTelefone = agenda.buscarContato(nomeContatoAdicionarTelefone);

                    if (contatoBuscadoAdicionarTelefone != null) {
                        System.out.printf("      >>> Digite o telefone: ");
                        String telefoneNumero = in.readLine();
                        System.out.printf("      >>> Digite o modelo: ");
                        String telefoneModelo = in.readLine();
                        Telefones telefoneParaAdicionar = new Telefones(telefoneNumero, telefoneModelo);
                        contatoBuscadoAdicionarTelefone.setTelefones(telefoneParaAdicionar);
                        System.out.println("Telefone adicionado.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }

                    break;

                // System.out.println(" 3) Adicionar Emails ao contato");
                case 3:

                    System.out.printf(" >>> Adicionando Emails ao Contato\n");
                    mostraContatos();
                    System.out.print(" >>> Digite o nome do contato para adicionar o email: \n");
                    String nomeContatoAdicionarEmail = in.readLine();
                    Contato contatoBuscadoAdicionarEmail = agenda.buscarContato(nomeContatoAdicionarEmail);

                    if (contatoBuscadoAdicionarEmail != null) {
                        System.out.printf("      >>> Digite o email: ");
                        Emails email = new Emails(in.readLine());
                        contatoBuscadoAdicionarEmail.setEmails(email);
                        System.out.println("Email adicionado.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }

                    break;

                //  System.out.println(" 4) Remover Contato");
                case 4:
                    mostraContatos();
                    System.out.print(" >>> Digite o nome do contato para remover: \n");
                    String nomeContatoRemover = in.readLine();
                    Contato contatoBuscadoRemover = agenda.buscarContato(nomeContatoRemover);

                    if (contatoBuscadoRemover != null) {
                        if (agenda.removerContato(contatoBuscadoRemover)) {
                            System.out.println("Contato removido.");

                        } else {
                            System.out.println("Erro ao remover contato.");
                        }
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                //  System.out.println(" 5) Buscar Contato pelo nome");
                case 5:

                    System.out.print(" >>> Buscando o contato, digite o nome do contato: \n");
                    String nomeContato = in.readLine();
                    Contato contatoBuscado = agenda.buscarContato(nomeContato);

                    if (contatoBuscado != null) {
                        System.out.println("Contato: " + contatoBuscado.toString());
                    } else {
                        System.out.println("Contato não encontrado.");
                    }

                    novaLinha();
                    break;

                //   System.out.println(" 6) Buscar Emails do contato");
                case 6:

                    System.out.print(" >>> Buscando os Emails, digite o nome do contato: \n");
                    String nomeContatoEmail = in.readLine();
                    Contato contatoBuscadoEmail = agenda.buscarContato(nomeContatoEmail);

                    if (contatoBuscadoEmail != null) {
                        System.out.println(contatoBuscadoEmail.getEmails());

                    } else {
                        System.out.println("Cliente não encontrado!");
                    }

                    novaLinha();
                    break;

                // System.out.println(" 7) Buscar Telefones do contato");
                case 7:
                    System.out.print(" >>> Buscando os Telefones, digite o nome do contato: \n");
                    String nomeContatoTelefone = in.readLine();
                    Contato contatoBuscadoTelefone = agenda.buscarContato(nomeContatoTelefone);

                    if (contatoBuscadoTelefone != null) {
                        System.out.println(contatoBuscadoTelefone.getTelefones());

                    } else {
                        System.out.println("Cliente não encontrado!");
                    }

                    novaLinha();
                    break;

                // System.out.println(" 8) Buscar todos os contatos");
                case 8:

                    mostraContatos();
                    novaLinha();

                    break;

                // System.out.println(" 9) Ver a quantidade de contatos na lista");
                case 9:
                    System.out.println(" ########  Quantidade de contatos na agenda: " + agenda.quantidadeContatosAgenda() + "  ########\n");
                    novaLinha();
                    break;

                //  System.out.println("10) Esvaziar lista de contatos");
                case 10:
                    agenda.esvaziarAgenda();
                    System.out.println(" ########  Lista de contatos esvaziada da agenda  ########\n");
                    novaLinha();
                    break;

                // Sair
                case 11:
                    continua = false;
                    sc.close(); //Encerra o programa
                    System.out.println("######## Sistema finalizado ########");
                    break;

                default:
                    novaLinha();
                    break;

            }

        } while (continua);
    }

    /**
     * Inicializa a agenda com alguns dados para poder manipular posteriormente pelo menu
     */
    private static void inicializaAgenda() {
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
    }

    /**
     * Mostra um menu para o usuário selecionar
     */
    private static void mostrarMenu() {
        System.out.println("Digite um número do menu abaixo");
        System.out.println(" 1) Adicionar contato");
        System.out.println(" 2) Adicionar telefones ao contato");
        System.out.println(" 3) Adicionar emails ao contato");
        System.out.println(" 4) Remover contato");
        System.out.println(" 5) Buscar contato pelo nome");
        System.out.println(" 6) Buscar emails do contato");
        System.out.println(" 7) Buscar telefones do contato");
        System.out.println(" 8) Buscar todos os contatos");
        System.out.println(" 9) Ver a quantidade de contatos na lista");
        System.out.println("10) Esvaziar lista de contatos");
        System.out.println("11) Sair\n");
    }

    /**
     * Mostra todos os contatos armazenados na agenda
     */
    private static void mostraContatos() {
        for (Contato contato : agenda.buscarTodosContatos()) {
            System.out.println(contato.toString());
        }

    }

    /**
     * Insere uma quebra de linha
     */
    private static void novaLinha() {
        System.out.println(" ------------------------------------------------------------------------------------");
    }

}
