import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.raposones.models.Produto;

public class ViewProductsFluxoAlternativo {
  @Test
  public void shouldReturnProductInfoWhenProductFound() {
    StubReProdutosFluxoPrincipal rep_produtos = new StubReProdutosFluxoPrincipal();
    List<Produto> produtos = rep_produtos.getProdutos();

    assertNull(produtos);
  }
}
