import static org.junit.Assert.assertEquals;

import org.junit.Test;
import br.com.raposones.repositories.Rep_produtos;
import br.com.raposones.models.Produto;

public class ViewProductInfoTest {

  @Test
  public void shouldReturnErrorMessageWhenProductNotFound() {
    // Usando o stub para simular o comportamento do repositório
    Rep_produtos rep_produtos = new StubRep_produtos();

    // Simulando a operação de visualização de produto
    Produto produto = rep_produtos.getProduto("0");

    String result;
    if (produto == null) {
      result = "Produto não encontrado.";
    } else {
      result = "Produto encontrado: " + produto.getCodigo();
    }

    // Verificando se a mensagem de erro é a esperada
    assertEquals("Produto não encontrado.", result);
  }
}
