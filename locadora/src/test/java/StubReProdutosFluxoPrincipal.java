import java.util.List;

import br.com.raposones.models.Produto;
import br.com.raposones.models.VHS;
import br.com.raposones.repositories.Rep_produtos;

public class StubReProdutosFluxoPrincipal extends Rep_produtos {
  @Override
  public Produto getProduto(String codigo) {
    if ("0".equals(codigo)) {
      Produto produto = new VHS("0", "Produto Exemplo", codigo, false, 2001, 103, false);
      return produto;
    }

    return null;
  }

  public List<Produto> getProdutos() {
    return List.of(new VHS("0", "Produto 1", "Terror", false, 0, 0, false),
        new VHS("1", "Produto 2", "Ação", false, 0, 0, false));
  }
}
