import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.com.raposones.models.Produto;
import br.com.raposones.repositories.Rep_produtos;

public class ViewProductInfoTestFluxoPrincipal {
  @Test
  public void shouldReturnProductInfoWhenProductFound() {
    Rep_produtos rep_produtos = new StubReProdutosFluxoPrincipal();

    Produto produto = rep_produtos.getProduto("0");

    String result;
    if (produto == null) {
      result = "Produto não encontrado.";
    } else {
      result = "Produto encontrado: " + produto.getTitulo();
    }

    assertEquals("Produto encontrado: Produto Exemplo", result);
  }
}
