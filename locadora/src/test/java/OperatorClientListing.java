import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OperatorClientListing {
    private StubClientRepo usersRepo;

    @Before
    public void mount() {
        usersRepo = new StubClientRepo();
    }

    @After
    public void unmount() {
        usersRepo = null;
    }

    //Listagem não vazia de clientes
    @Test
    public void operatorClientListingMain(){
        var clientList = usersRepo.getClientes();
        String response = clientList.isEmpty() ? "Lista vazia" : "Clientes mostrados";

        assertEquals("Clientes mostrados", response);
    }

    //Listagem vazia de clientes
    @Test
    public void operatorClientListingAlter(){
        var clientList = usersRepo.getClientes(true);
        String response = clientList.isEmpty() ? "Lista vazia" : "Clientes mostrados";

        assertEquals("Lista vazia", response);
    }



}
