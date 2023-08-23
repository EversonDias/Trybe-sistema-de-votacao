package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Instantiates a new Gerenciamento votacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<PessoaCandidata>();
    this.pessoasEleitoras = new ArrayList<PessoaEleitora>();
    this.cpfsComputados = new ArrayList<String>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean temNumero = pessoasCandidatas.stream().map(e -> e.getNumero() == numero)
        .anyMatch(e -> e.equals(true));
    if (temNumero) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean temCpf = pessoasEleitoras.stream().map(e -> e.getCpf().equals(cpf))
        .anyMatch(e -> e.equals(true));
    if (temCpf) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean temCpf = cpfsComputados.stream().map(e -> e.equals(cpfPessoaEleitora))
        .anyMatch(e -> e.equals(true));
    if (temCpf) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      pessoasCandidatas.forEach(e -> {
            if (e.getNumero() == numeroPessoaCandidata) {
              e.receberVoto();
              cpfsComputados.add(cpfPessoaEleitora);
            }
          }
      );
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    pessoasCandidatas.forEach(e -> {
      float porcentagemDeVotos = (float) (e.getVotos() * 100) / cpfsComputados.size();
      System.out.printf("Nome: %s - %d votos ( %d%%)%n", e.getNome(), e.getVotos(),
          Math.round(porcentagemDeVotos));
    });
    System.out.printf("Total de votos: %d", cpfsComputados.size());
  }
}
