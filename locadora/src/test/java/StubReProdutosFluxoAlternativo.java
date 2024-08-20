import br.com.raposones.repositories.Rep_produtos;

import java.util.List;

import br.com.raposones.models.Produto;

public class StubReProdutosFluxoAlternativo extends Rep_produtos {

  @Override
  public Produto getProduto(String codigo) {
    return null;
  }

  public List<Produto> getProdutos() {
    return List.of();
  }
}
