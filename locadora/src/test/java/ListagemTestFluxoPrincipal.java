import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.Cliente;
import br.com.raposones.models.Operador_sis;
import br.com.raposones.repositories.Rep_pessoas;

public class ListagemTestFluxoPrincipal {
        private Rep_pessoas usersRepo;

        @Before
        public void mount() {
            usersRepo = new Rep_pessoas();
        }
    
        @After
        public void unmount() {
            usersRepo = null;
        }

        //ha clientes na lista e eles sao mostrados
        @Test
        public void GerTestClientListMainFlow(){
            Cliente cliente1 = new Cliente("Marcelo", 1, "Av. Ponto", 20, "masculino");
            Cliente cliente2 = new Cliente("Julia", 2, "Av. Ponto2", 25, "feminino");

            usersRepo.addPessoa(cliente1);
            usersRepo.addPessoa(cliente2);

            int clientListSize = usersRepo.lenghtRepository();

            assertEquals(2, clientListSize);
        }

        //ha operadores na lista e eles são mostrados
        @Test
        public void GerTestOpListMainFlow(){
            Operador_sis op1 = new Operador_sis("Olivia", 1, "olivegarden", "miku44!");
            Operador_sis op2 = new Operador_sis("Jose", 2, "jojoadv", "zawarudo#1");

            usersRepo.addPessoa(op1);
            usersRepo.addPessoa(op2);

            int opListSize = usersRepo.lenghtRepository();

            assertEquals(2, opListSize);
        }
}
