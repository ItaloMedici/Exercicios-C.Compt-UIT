package listas.lista5.professor;

import java.time.LocalDate;

public class DedicacaoExclusiva extends Professor {

  public DedicacaoExclusiva(String matricula, String nome, Sexo sexo, LocalDate dataNascimento,
      LocalDate dataContrato) {
    super(matricula, nome, sexo, dataNascimento, dataContrato);
  }

  @Override
  public int getSalario() {
    // TODO Auto-generated method stub
    return 0;
  }
  
}
