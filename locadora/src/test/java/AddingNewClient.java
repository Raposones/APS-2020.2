import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.Cliente;
import br.com.raposones.repositories.Rep_pessoas;

public class AddingNewClient {
    private Rep_pessoas usersRepository;

    @Before
    public void mount() {
        usersRepository = new Rep_pessoas();
    }

    @After
    public void unmount() {
        usersRepository = null;
    }
    
    // não há cliente com a matrícula já cadastrada
    @Test
    public void addingNewClientMainFlow() {
        Cliente client1 = new Cliente("Antonio Severino", 1,"Av. Café Paulista", 0, "masculino");
        Cliente client2 = new Cliente("Lucas Andrade", 2,"Rua Senna", 0, "masculino");
        Cliente client3 = new Cliente("Jonas Silva", 3,"Rua Carvalho de Souza", 0, "masculino");
        
        usersRepository.addPessoa(client1);
        usersRepository.addPessoa(client2);
        usersRepository.addPessoa(client3);

        int lengthClientsRepositoryAfterAdding = usersRepository.lenghtRepository();

        assertEquals(3, lengthClientsRepositoryAfterAdding);
    }

    // há cliente com a matrícula já cadastrada
    @Test
    public void addingNewClientAlternativeFlow() {
        Cliente client1 = new Cliente("Antonio Severino", 1,"Av. Café Paulista", 0, "masculino");
        Cliente client2 = new Cliente("Lucas Andrade", 1,"Rua Senna", 0, "masculino");
        Cliente client3 = new Cliente("Jonas Silva", 1,"Rua Carvalho de Souza", 0, "masculino");
        
        usersRepository.addPessoa(client1);
        usersRepository.addPessoa(client2);
        usersRepository.addPessoa(client3);

        int lengthClientsRepositoryAfterAdding = usersRepository.lenghtRepository();

        assertEquals(1, lengthClientsRepositoryAfterAdding);
    }
}
