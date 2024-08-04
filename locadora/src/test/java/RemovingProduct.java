import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.DVD;
import br.com.raposones.repositories.Rep_produtos;

public class RemovingProduct {
    private Rep_produtos productsRepository;

    @Before
    public void mount() {
        productsRepository = new Rep_produtos();
        DVD dvd = new DVD("123456", "A Hora do Pesadelo 3", "Terror", false, 2004, 2, false);

        productsRepository.addProduto(dvd);
    }

    @After
    public void unmount() {
        productsRepository = null;
    }
    
    // há um produto com o código informado
    @Test
    public void removingProductMainFlow() {
        productsRepository.remProduto("123456");

        int lengthProductsRepositoryAfterRemoving = productsRepository.lenghtProducts();

        assertEquals(0, lengthProductsRepositoryAfterRemoving);
    }

    // não há um produto com o código informado
    @Test
    public void removingProductAlternativeFlow() {
        productsRepository.remProduto("535353");

        int lengthProductsRepositoryAfterRemoving = productsRepository.lenghtProducts();

        assertEquals(1, lengthProductsRepositoryAfterRemoving);
    }
}
