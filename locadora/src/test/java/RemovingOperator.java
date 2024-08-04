import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.Operador_sis;
import br.com.raposones.models.Pessoa;
import br.com.raposones.repositories.Rep_pessoas;

public class RemovingOperator {
    private Rep_pessoas usersRepository;

    @Before
    public void mount() {
        usersRepository = new Rep_pessoas();

        // adicionando 3 operadores
        Operador_sis operator1 = new Operador_sis("Antonio Severino", 1, "ant0sev", "1k232d3");
        Operador_sis operator2 = new Operador_sis("Lucas Andrade", 2, "lucand", "lu32md3");
        Operador_sis operator3 = new Operador_sis("Jonas Silva", 3, "jonsil", "jon3sild3");
        
        usersRepository.addPessoa(operator1);
        usersRepository.addPessoa(operator2);
        usersRepository.addPessoa(operator3);
    }

    @After
    public void unmount() {
        usersRepository = null;
    }

    // há operador com a matricula e é removido
    @Test
    public void removingOperatorMainFlow() {
        usersRepository.remPessoa(2);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();
        
        // checa se o operador foi removido
        assertEquals(2, lengthOperatorsRepositoryAfterAdding);
        
        // checa se o operador com a matricula 2 foi removido
        Pessoa aux = usersRepository.getPessoa(2);
        assertEquals(null, aux);
    }

    // não há operador com a matricula e nada acontece
    @Test
    public void removingOperatorAlternativeFlow() {
        // garante que o operador 4 não existe
        Pessoa aux = usersRepository.getPessoa(4);
        assertEquals(null, aux);

        usersRepository.remPessoa(4);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();
        
        // checa se o repositório foi alterado
        assertEquals(3, lengthOperatorsRepositoryAfterAdding);
    }
}
