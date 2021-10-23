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
  private String codigoSala;
  private ArrayList<Aluno> alunos;

  public Sala(String codigoSala) {
    this.alunos = new ArrayList<>();
    this.codigoSala = codigoSala;
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

  public boolean encontrarAlunoPeloId(Long id) {
    for (Aluno a : alunos) {
      if (a.getIdentificador().equals(id)) {
        return true;
      }
    }
    return false;
  }

  public boolean encontrarAlunoPeloNome(String nome) {
    for (Aluno a : alunos) {
      if (a.getNome().equalsIgnoreCase(nome)) {
        return true;
      }
    }
    return false;
  }

  public void esvaziarSala() {
    this.alunos.clear();
  }

  public Aluno getMelhorAluno() {
    if (alunos.isEmpty()) return null;

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

  public String listarSala() {
    return "\nCodigo Sala: " + codigoSala + ", quantidade de alunos: " + getQuantidadeAlunos();
  }

  public int getQuantidadeAlunos() {
    return alunos.size();
  }
}
