import java.util.HashMap;

public class Rep_pessoas {
    // <chave - matricula  || valor - objeto>  
    HashMap<Integer, Pessoa> repos_pessoas = new HashMap<Integer, Pessoa>();

    public void addPessoa(Pessoa pessoa){
        if(!check_Duplicates(pessoa.getMatricula())) repos_pessoas.put(pessoa.getMatricula(), pessoa);
    }

    public void remPessoa(int matricula){
        repos_pessoas.remove(matricula);
    }

    public Pessoa getPessoa(int matricula){
        return repos_pessoas.get(matricula); 
    }

    public boolean checkLogin_Gerente(String login, String senha){
        boolean existe = false;

        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);
            
            if(aux instanceof Gerente){
                Funcionario aux2 = (Funcionario) aux;
                if(login.equals(aux2.getLogin()) && senha.equals(aux2.getSenha())){
                    System.out.println("\nBem vindo, " + aux.getNome() + ".");
                    existe = true;
                    break;
                }
            }
        }

        if(!existe){
            System.out.println("Login e/ou senha incorretos.");
            System.out.println("(Certifique-se de selecionar o perfil correto!)");
        }
        return existe;
    }

    public boolean checkLogin_Operador(String login, String senha){
        boolean existe = false;

        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);
            
            if(aux instanceof Operador_sis){
                Funcionario aux2 = (Funcionario) aux;
                if(login.equals(aux2.getLogin()) && senha.equals(aux2.getSenha())){
                    System.out.println("\nBem vindo, " + aux.getNome() + ".");
                    existe = true;
                    break;
                }
            }
        }

        if(!existe){
            System.out.println("Login e/ou senha incorretos.");
            System.out.println("(Certifique-se de estar acessando o perfil correto!");
        }

        return existe;
    }

    public boolean checkExistance_Gerente(int matricula){
        boolean existe = false;

        for(int i : repos_pessoas.keySet()){
           Pessoa aux = repos_pessoas.get(i);

            if(matricula == aux.getMatricula() && aux instanceof Gerente){
                existe = true;
                break;
            }
        }

        return existe;
    }

    public boolean checkExistance_Operador(int matricula){
        boolean existe = false;

        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);

            if(matricula == aux.getMatricula() && aux instanceof Operador_sis){
                existe = true;
                break;
            }
        }

        return existe;
    }

    public boolean checkExistance_Cliente(int matricula){
        boolean existe = false;

        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);

            if(matricula == aux.getMatricula() && aux instanceof Cliente){
                existe = true;
                break;
            }
        }

        return existe;
    }

    public void listClientes(){
        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);

            if(aux instanceof Cliente){
                System.out.println("\n================");
                System.out.println("Nome: " + aux.getNome());
                System.out.println("Matricula: " + aux.getMatricula());
                System.out.println("================\n");
            }
        }
    }

    public void listOperadores(){
        for(int i : repos_pessoas.keySet()){
            Pessoa aux = repos_pessoas.get(i);

            if(aux instanceof Operador_sis){
                System.out.println("\n================");
                System.out.println("Nome: " + aux.getNome());
                System.out.println("Matricula: " + aux.getMatricula());
                System.out.println("================\n");
            }
        }
    }

    public boolean check_Duplicates(int matricula){
        boolean existe = false;

        for (int i : repos_pessoas.keySet()){
            if(i == matricula){
                existe = true;
                break;
            }
        }

        if(existe) System.out.println("CODIGO JA CADASTRADO!");

        return existe;
    }
}
