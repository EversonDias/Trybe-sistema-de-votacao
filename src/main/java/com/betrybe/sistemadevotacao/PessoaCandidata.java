package com.betrybe.sistemadevotacao;

/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param numero the numero
   * @param nome   the nome
   */
  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.votos = 0;
    super.setNome(nome);
  }

  /**
   * Gets numero.
   *
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Sets numero.
   *
   * @param numero the numero
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Gets votos.
   *
   * @return the votos
   */
  public int getVotos() {
    return votos;
  }

  /**
   * Sets votos.
   *
   * @param votos the votos
   */
  public void setVotos(int votos) {
    this.votos = votos;
  }

  /**
   * Receber voto.
   */
  public void receberVoto() {
    this.votos += 1;
  }

  @Override
  public String getNome() {
    return super.getNome();
  }

  @Override
  public void setNome(String nome) {
    super.setNome(nome);
  }
}
