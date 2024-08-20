import br.com.raposones.repositories.Rep_produtos;

import java.util.HashMap;
import java.util.List;

import br.com.raposones.models.Produto;
import br.com.raposones.models.VHS;

public class StubReProdutosFluxoAlternativo extends Rep_produtos {

  @Override
  public Produto getProduto(String codigo) {
    return null;
  }

}
