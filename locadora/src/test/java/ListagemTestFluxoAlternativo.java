import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListagemTestFluxoAlternativo {

  @Test
  public void shouldReturnNoOperatorsAndNoClientsMessage() {
    StubRepPessoasFluxoAlternativo rep_produtos = new StubRepPessoasFluxoAlternativo();

    var operadores = rep_produtos.listarOperadores();
    String operadoresMessage = operadores.isEmpty() ? "Não há operadores cadastrados." : "Operadores listados.";

    var clientes = rep_produtos.listarClientes();
    String clientesMessage = clientes.isEmpty() ? "Não há clientes cadastrados." : "Clientes listados.";

    assertEquals("Não há operadores cadastrados.", operadoresMessage);
    assertEquals("Não há clientes cadastrados.", clientesMessage);
  }
}
