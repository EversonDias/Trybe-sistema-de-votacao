package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The constant gerenciamentoVotacao.
   */
  public static GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
  private static final Scanner sc = new Scanner(System.in);
  private static boolean novaPessoaCandidata = true;
  private static boolean novaPessoaEleitora = true;
  private static boolean progresso = true;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    menu();
  }

  /**
   * Menu.
   */
  public static void menu() {
    if (novaPessoaCandidata) {
      menuCadastroCandidatos();
    } else if (novaPessoaEleitora) {
      menuPessoaEleitora();
    } else {
      menuVotar();
    }
    if (progresso) {
      menu();
    }
  }

  /**
   * Menu votar.
   */
  public static void menuVotar() {
    System.out.println("\n Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
    int opcao = Integer.parseInt(sc.next());
    switch (opcao) {
      case 1:
        votar();
        break;
      case 2:
        verResultado();
        break;
      default:
        finalizar();
    }
  }

  private static void finalizar() {
    gerenciamentoVotacao.mostrarResultado();
    progresso = false;
  }

  private static void verResultado() {
    gerenciamentoVotacao.mostrarResultado();
  }

  private static void votar() {
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpfPessoaEleitora = sc.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int numeroDoCandidato = Integer.parseInt(sc.next());
    gerenciamentoVotacao.votar(cpfPessoaEleitora, numeroDoCandidato);
  }

  /**
   * Cadastra pessoa eleitora.
   */
  public static void cadastraPessoaEleitora() {
    System.out.println("Entre com o nome da pessoa eleitora:");
    String nome = sc.next();
    System.out.println("Entre com o cpf da pessoa eleitora:");
    String cpf = sc.next();
    gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
  }

  /**
   * Cadastra candidato.
   */
  public static void cadastraCandidato() {
    System.out.println("Entre com o nome da pessoa candidata:");
    String nome = sc.next();
    System.out.println("Entre com o número da pessoa candidata:");
    int numero = Integer.parseInt(sc.next());
    gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
  }


  /**
   * Menu cadastro candidatos.
   */
  public static void menuCadastroCandidatos() {
    System.out.println("\n Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String novoCadastro = sc.next();
    if (novoCadastro.equals("1")) {
      cadastraCandidato();
    } else {
      novaPessoaCandidata = false;
    }
  }


  /**
   * Menu pessoa eleitora.
   */
  public static void menuPessoaEleitora() {
    System.out.println("\n Cadastrar pessoa eleitora?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número correspondente à opção desejada:");
    String novaPessoa = sc.next();
    if (novaPessoa.equals("1")) {
      cadastraPessoaEleitora();
    } else {
      novaPessoaEleitora = false;
    }
  }

}

