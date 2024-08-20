import br.com.raposones.repositories.Rep_produtos;
import br.com.raposones.models.Produto;

public class StubReProdutosFluxoAlternativo extends Rep_produtos {

  @Override
  public Produto getProduto(String codigo) {
    // Simula a ausência do produto
    return null;
  }
}
