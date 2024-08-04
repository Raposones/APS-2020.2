import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.Locacoes;
import br.com.raposones.models.Cliente;
import br.com.raposones.models.DVD;
import br.com.raposones.repositories.Rep_pessoas;
import br.com.raposones.repositories.Rep_produtos;

public class AddingNewLocation {
    private Rep_pessoas usersRepository;
    private Rep_produtos productsRepository;
    private Locacoes locacoes;

    @Before
    public void mount() {
        usersRepository = new Rep_pessoas();
        productsRepository = new Rep_produtos();
        locacoes = new Locacoes();

        Cliente client1 = new Cliente("Antonio Severino", 1,"Av. Café Paulista", 0, "masculino");
        usersRepository.addPessoa(client1);

        DVD dvd = new DVD("123456", "A Hora do Pesadelo 3", "Terror", false, 2004, 2, false);
        productsRepository.addProduto(dvd);
    }

    @After
    public void unmount() {
        usersRepository = null;
        productsRepository = null;
        locacoes = null;
    }

    // adiciona nova locação se o cliente e o produto existirem
    @Test
    public void addingNewLocationMainFlow() {
        LocalDate dataSaida = LocalDate.now();
        LocalDate dataEntrega = dataSaida.plusDays(7);

        if(usersRepository.checkExistance_Cliente(1) && productsRepository.checkExistance_Produto("123456")) {
            locacoes.add_locacao(new Locacoes("123456", 1, dataSaida, dataEntrega));
        }

        int lengthLocationsRepositoryAfterAdding = locacoes.lenghtLocations();

        assertEquals(1, lengthLocationsRepositoryAfterAdding);
    }

    // não adiciona nova locação, pois o produto não existe
    @Test
    public void addingNewLocationAlternativeFlow1() {
        LocalDate dataSaida = LocalDate.now();
        LocalDate dataEntrega = dataSaida.plusDays(7);
        
        if(usersRepository.checkExistance_Cliente(1) && productsRepository.checkExistance_Produto("54231")) {
            locacoes.add_locacao(new Locacoes("123456", 1, dataSaida, dataEntrega));
        }

        int lengthLocationsRepositoryAfterAdding = locacoes.lenghtLocations();

        assertEquals(0, lengthLocationsRepositoryAfterAdding);
    }

    // não adiciona nova locação, pois o cliente não existe
    @Test
    public void addingNewLocationAlternativeFlow2() {
        LocalDate dataSaida = LocalDate.now();
        LocalDate dataEntrega = dataSaida.plusDays(7);
        
        if(usersRepository.checkExistance_Cliente(2) && productsRepository.checkExistance_Produto("123456")) {
            locacoes.add_locacao(new Locacoes("123456", 1, dataSaida, dataEntrega));
        }

        int lengthLocationsRepositoryAfterAdding = locacoes.lenghtLocations();

        assertEquals(0, lengthLocationsRepositoryAfterAdding);
    }
}
