import java.util.List;

import br.com.raposones.models.Cliente;
import br.com.raposones.repositories.Rep_pessoas;

public class StubClientRepo extends Rep_pessoas{
    Cliente cliente1 = new Cliente("Sandra", 10, "Av. das Flores 234", 41, "Feminino");
    Cliente cliente2 = new Cliente("Robert", 20, "Av. das Massas 234", 22, "Masculino");

    //Lista não vazia
    public List<Cliente> getClientes(){
        return List.of(cliente1, cliente2);
    }

    //Lista vazia
    public List<Cliente> getClientes(boolean isEmpty){
        return List.of();
    }

    
}
