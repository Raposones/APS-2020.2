import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.repositories.Rep_pessoas;
import br.com.raposones.models.Cliente;
import br.com.raposones.models.Gerente;
import br.com.raposones.models.Operador_sis;



public class ListagemTestFluxoPrincipal {
    Rep_pessoas usersRepo;

    @Before
    public void mount(){
        usersRepo = new Rep_pessoas();
    }

    @After
    public void unmount(){
        usersRepo = null;
    }


    //ha clientes na lista e eles sao mostrados
    @Test
    public void GerClientListMainFlow(){
            Cliente cliente1 = new Cliente("Nicole", 1, "Av. Ponto, 158", 20, "Feminino");
            Cliente cliente2 = new Cliente("Francisco", 2, "Av. Ponto, 17", 20, "Masculino");

            usersRepo.addPessoa(cliente1);
            usersRepo.addPessoa(cliente2);

            int clientListSize = usersRepo.lenghtRepository();

            assertEquals(2, clientListSize);
    }

        //ha operadores na lista e eles sao mostrados
        @Test
        public void GerOperatorListMainFlow(){
            Gerente gerente1 = new Gerente("Marcos", 1, "marchman", "marc845man!");
            Gerente gerente2 = new Gerente("Olivia ", 2, "olivegarden", "!awol345!");

            usersRepo.addPessoa(gerente1);
            usersRepo.addPessoa(gerente2);

            int OpListSize = usersRepo.lenghtRepository();

            assertEquals(2, OpListSize);
    }
}
