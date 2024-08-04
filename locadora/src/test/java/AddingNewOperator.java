import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.raposones.models.Operador_sis;
import br.com.raposones.repositories.Rep_pessoas;

public class AddingNewOperator {
    private Rep_pessoas usersRepository;

    @Before
    public void mount() {
        usersRepository = new Rep_pessoas();
    }

    @After
    public void unmount() {
        usersRepository = null;
    }
    
    // não há operador com a matrícula já cadastrada
    @Test
    public void addingNewoperatorMainFlow() {
        Operador_sis operator1 = new Operador_sis("Antonio Severino", 1, "ant0sev", "1k232d3");
        Operador_sis operator2 = new Operador_sis("Lucas Andrade", 2, "lucand", "lu32md3");
        Operador_sis operator3 = new Operador_sis("Jonas Silva", 3, "jonsil", "jon3sild3");
        
        usersRepository.addPessoa(operator1);
        usersRepository.addPessoa(operator2);
        usersRepository.addPessoa(operator3);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();

        assertEquals(lengthOperatorsRepositoryAfterAdding, 3);
    }

    // há operador com a matrícula já cadastrada
    @Test
    public void addingNewoperatorAlternativeFlow() {
        Operador_sis operator1 = new Operador_sis("Antonio Severino", 1, "ant0sev", "1k232d3");
        Operador_sis operator2 = new Operador_sis("Lucas Andrade", 1, "lucand", "lu32md3");
        Operador_sis operator3 = new Operador_sis("Jonas Silva", 1, "jonsil", "jon3sild3");
        
        usersRepository.addPessoa(operator1);
        usersRepository.addPessoa(operator2);
        usersRepository.addPessoa(operator3);

        int lengthOperatorsRepositoryAfterAdding = usersRepository.lenghtRepository();

        assertEquals(lengthOperatorsRepositoryAfterAdding, 1);
    }
}
