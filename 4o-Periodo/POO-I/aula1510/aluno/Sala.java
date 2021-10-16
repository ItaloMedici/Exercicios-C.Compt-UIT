package aula1510.aluno;

import java.util.ArrayList;

/**
 * Deverá ter também uma classe sala que possui atributos e métodos a sua
 * escolha mas um deles deve ser uma coleção de alunos.
 * 
 * Veja que o método de incluir aluno, mostrar, etc, deve estar em sala e não em
 * testa.
 * 
 * @author Italo
 */

public class Sala {
  private Long identificador;
  private String codigoSala;
  private ArrayList<Aluno> alunos;

  private static long count = 1;

  public Sala(String codigoSala) {
    setIdentificador(count);
    this.alunos = new ArrayList<>();
    this.codigoSala = codigoSala;
    count++;
  }

  public Long getIdentificador() {
    return identificador;
  }

  private void setIdentificador(Long identificador) {
    this.identificador = identificador;
  }

  public String getCodigoSala() {
    return codigoSala;
  }

  public void setCodigoSala(String codigoSala) {
    this.codigoSala = codigoSala;
  }

  public ArrayList<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(ArrayList<Aluno> alunos) {
    this.alunos = alunos;
  }

  public void adicionarAluno(Aluno aluno) {
    this.alunos.add(aluno);
  }

  public void removerAluno(Aluno aluno) {
    this.alunos.remove(aluno);
  }

  public boolean alunoEstaNaSala(Aluno aluno) {
    for (Aluno a : alunos) {
      if (a.equals(aluno)) {
        return true;
      }
    }
    return false;
  }

  public void esvaziarSala() {
    this.alunos.clear();
  }

  public Aluno getMelhorAluno() {
    if (alunos.isEmpty()) return new Aluno();

    Aluno melhorAluno = alunos.get(0);
    Double maiorNota = melhorAluno.getNotaSemestre();

    for (Aluno aluno : alunos) {
      Double notaAluno = aluno.getNotaSemestre();
      if (notaAluno > maiorNota) {
        melhorAluno = aluno;
      }
    }

    return melhorAluno;
  }

  public String exibirAlunos() {
    String alunosMsg = "\tAlunos";

    if (!alunos.isEmpty()) {
      for (Aluno a : alunos) {
        alunosMsg += "\n" + a.toString();
      }
    } else {
      alunosMsg = "Sala vázia!";
    }

    return alunosMsg;
  }
}
