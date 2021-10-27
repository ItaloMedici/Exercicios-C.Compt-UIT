package com.testepessoa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

  @Test
  public void testaPessoa() {
    Pessoa p1 = new Pessoa();
    assertEquals("Nome Desconhecido", p1.getNome());
    assertEquals(3, p1.getMaxLivros());
  }

  @Test
  public void testSetNome() {
    Pessoa p2 = new Pessoa();
    p2.setNome("Italo");
    assertEquals("Italo", p2.getNome());
  }

  @Test
  public void testSetMaxLivros() {
    Pessoa p3 = new Pessoa();
    p3.setMaxLivros(20);
    assertEquals(20, p3.getMaxLivros());
  }

  @Test
  public void testToString() {
    Pessoa p4 = new Pessoa();

    p4.setNome("Italo");
    p4.setMaxLivros(7);

    String result = "Italo (7 livros)";
    assertEquals(result, p4.toString());
  }
}
