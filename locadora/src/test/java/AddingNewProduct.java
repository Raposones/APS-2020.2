import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.DVD;
import br.com.raposones.repositories.Rep_produtos;

public class AddingNewProduct {
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
    
    // não há produtos cadastrados com o mesmo código
    @Test
    public void addingNewProductMainFlow() {
        DVD dvd = new DVD("543453", "Rambo 4", "Ação", false, 2022, 2, false);
        productsRepository.addProduto(dvd);

        int lengthProductsRepositoryAfterAdding = productsRepository.lenghtProducts();

        assertEquals(2, lengthProductsRepositoryAfterAdding);
    }
    
    // há produtos cadastrados com o mesmo código
    @Test
    public void addingNewProductAlternativeFlow() {
        DVD dvd = new DVD("123456", "A Freira", "Terror", false, 2004, 2, true);
        productsRepository.addProduto(dvd);

        int lengthProductsRepositoryAfterAdding = productsRepository.lenghtProducts();

        assertEquals(1, lengthProductsRepositoryAfterAdding);
    }
}
