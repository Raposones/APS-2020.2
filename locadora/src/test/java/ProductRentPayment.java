import br.com.raposones.models.Cliente;
import br.com.raposones.models.CD;
import br.com.raposones.repositories.Rep_produtos;
import br.com.raposones.Locacoes;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductRentPayment {
    private Rep_produtos productList;
    private Locacoes rentalsList;

    @Before
    public void mount(){
        productList = new Rep_produtos();
        rentalsList = new Locacoes();
    }

    @After
    public void unmount(){
        productList = null;
        rentalsList = null;
    }

    @Test
    //Locação existe e será confirmada (dar baixa)
    public void productRentPaymentMain(){
        Cliente cliente1 = new Cliente("Cezar", 1, "Av. Omaiga 425", 18, "Masculino");
        CD cd1 = new CD("CD-001", "Summer Eletrohits 2", "Eletronica", true, "Som Livre", 16, false, false);

        //simulação de datas de entrada e vencimento da locação
        LocalDate rentalEntryDate = LocalDate.of(2024, 9, 1);
        LocalDate rentalDueDate = LocalDate.of(2024, 9, 2);


        Locacoes loc1 = new Locacoes(cd1.getCodigo(), cliente1.getMatricula(), rentalEntryDate, rentalDueDate);
        rentalsList.add_locacao(loc1);
        int rentalsListSize = rentalsList.lenghtLocations();
        //verifica se a lista de locações tem uma locação adicionada
        assertEquals(1, rentalsListSize);

        //o valor esperado é de uma diária do produto (no caso, CD = 15), mais um dia de multa -> 30 (diária x 2) + 10% sobre diárias
        double expectedTotal = 30 + (30 * 0.1);
        double prodValue = productList.calcPreco(cd1) * 2;
        double total = prodValue + (prodValue * 0.1);
        //verifica o valor da locação
        assertEquals(expectedTotal, total, 0);

        rentalsList.removeLocacao(0);
        rentalsListSize = rentalsList.lenghtLocations();
        //verifica se a lista de ocação está vazia após a remoção
        assertEquals(0, rentalsListSize);
    }

    @Test
    //Locação existe mas foi calculada errada
    public void productRentPaymentAlter(){
        Cliente cliente1 = new Cliente("Cezar", 1, "Av. Omaiga 425", 18, "Masculino");
        CD cd1 = new CD("CD-001", "Summer Eletrohits 2", "Eletronica", true, "Som Livre", 16, false, false);

        //simulação de datas de entrada e vencimento da locação
        LocalDate rentalEntryDate = LocalDate.of(2024, 9, 1);
        LocalDate rentalDueDate = LocalDate.of(2024, 9, 2);

        Locacoes loc1 = new Locacoes(cd1.getCodigo(), cliente1.getMatricula(), rentalEntryDate, rentalDueDate);
        rentalsList.add_locacao(loc1);
        int rentalsListSize = rentalsList.lenghtLocations();
        //verifica se a lista de locações tem uma locação adicionada
        assertEquals(1, rentalsListSize);

        //o valor esperado é de uma diária do produto (no caso, CD = 15), mais um dia de multa -> 30 (diária x 2) + 10% sobre diárias
        double expectedTotal = 30 + (30 * 0.1);
        double prodValue = productList.calcPreco(cd1) * 2;
        //simulando caso onde a multa não foi calculada
        double total = prodValue;
        //verifica o valor da locação
        assertNotEquals(expectedTotal, total, 0);
    }
}
