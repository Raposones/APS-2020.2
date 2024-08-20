import static org.junit.Assert.assertEquals;

import org.junit.Test;
import br.com.raposones.repositories.Rep_produtos;
import br.com.raposones.models.Produto;

public class ViewProductInfoTestFluxoAlternativo {

  @Test
  public void shouldReturnErrorMessageWhenProductNotFound() {
    Rep_produtos rep_produtos = new StubReProdutosFluxoAlternativo();

    Produto produto = rep_produtos.getProduto("0");

    String result;
    if (produto == null) {
      result = "Produto não encontrado.";
    } else {
      result = "Produto encontrado: " + produto.getCodigo();
    }

    assertEquals("Produto não encontrado.", result);
  }
}
