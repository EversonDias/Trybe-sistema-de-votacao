package com.betrybe.sistemadevotacao;

/**
 * The interface Gerenciamento votacao interface.
 */
public interface GerenciamentoVotacaoInterface {

  /**
   * Cadastrar pessoa candidata.
   *
   * @param nome   the nome
   * @param numero the numero
   */
  void cadastrarPessoaCandidata(String nome, int numero);

  /**
   * Cadastrar pessoa eleitora.
   *
   * @param nome the nome
   * @param cpf  the cpf
   */
  void cadastrarPessoaEleitora(String nome, String cpf);

  /**
   * Votar.
   *
   * @param cpfPessoaEleitora     the cpf pessoa eleitora
   * @param numeroPessoaCandidata the numero pessoa candidata
   */
  void votar(String cpfPessoaEleitora, int numeroPessoaCandidata);

  /**
   * Mostrar resultado.
   */
  void mostrarResultado();
}
