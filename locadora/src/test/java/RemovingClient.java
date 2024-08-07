import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.Cliente;
import br.com.raposones.models.Pessoa;
import br.com.raposones.repositories.Rep_pessoas;

public class RemovingClient {
    private Rep_pessoas usersRepository;

    @Before
    public void mount() {
        usersRepository = new Rep_pessoas();

        // adicionando 3 clientes
        Cliente client1 = new Cliente("Antonio Severino", 1,"Av. Café Paulista", 0, "masculino");
        Cliente client2 = new Cliente("Lucas Andrade", 2,"Rua Senna", 0, "masculino");
        Cliente client3 = new Cliente("Jonas Silva", 3,"Rua Carvalho de Souza", 0, "masculino");
        
        usersRepository.addPessoa(client1);
        usersRepository.addPessoa(client2);
        usersRepository.addPessoa(client3);
    }

    @After
    public void unmount() {
        usersRepository = null;
    }
    
    // há cliente com a matricula e é removido
    @Test
    public void removingClientMainFlow() {
        usersRepository.remPessoa(2);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();
        
        // checa se o cliente foi removido
        assertEquals(2, lengthOperatorsRepositoryAfterAdding);
        
        // checa se o cliente com a matricula 2 foi removido
        Pessoa aux = usersRepository.getPessoa(2);
        assertEquals(null, aux);
    }
    
    // não há cliente com a matricula e nada acontece
    @Test
    public void removingClientAlternativeFlow() {
        // garante que o cliente 4 não existe
        Pessoa aux = usersRepository.getPessoa(4);
        assertEquals(null, aux);

        usersRepository.remPessoa(4);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();
        
        // checa se o repositório foi alterado
        assertEquals(3, lengthOperatorsRepositoryAfterAdding);
    }
}
