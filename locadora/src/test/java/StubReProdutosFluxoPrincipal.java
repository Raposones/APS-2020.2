import br.com.raposones.models.Produto;
import br.com.raposones.models.VHS;
import br.com.raposones.repositories.Rep_produtos;

public class StubReProdutosFluxoPrincipal extends Rep_produtos {
  @Override
  public Produto getProduto(String codigo) {
    // Simula um produto cadastrado com o código informado
    if ("0".equals(codigo)) {
      // Cria um produto com informações fictícias
      Produto produto = new VHS("0", "Produto Exemplo", codigo, false, 2001, 103, false);
      // Adicione outros atributos conforme necessário
      return produto;
    }
    // Retorna null para códigos diferentes
    return null;
  }
}
