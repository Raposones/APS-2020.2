import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;

import br.com.raposones.models.Produto;

public class ViewProductsFluxoPrincipal {
  @Test
  public void shouldReturnProductInfoWhenProductFound() {
    StubReProdutosFluxoPrincipal rep_produtos = new StubReProdutosFluxoPrincipal();

    List<Produto> produtos = rep_produtos.getProdutos();

    assertNotNull(produtos);
  }
}
