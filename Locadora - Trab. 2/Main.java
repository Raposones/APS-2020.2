import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Gerente gerente = new Gerente("ADMIN", 1, "admin", "admin");
        DVD produto = new DVD("DVD-1", "teste", "teste", false, 2000, 120, false);
        Operador_sis operador = new Operador_sis("magno", 2, "magno123", "magno123");
        Cliente cliente = new Cliente("alan", 3, "rua da silva 123", 20, "homem");

        Rep_pessoas rep_pess = new Rep_pessoas();
        Rep_produtos rep_prod = new Rep_produtos();
        Locacoes locacoes = new Locacoes();

        rep_pess.addPessoa(gerente);
        rep_pess.addPessoa(operador);
        rep_pess.addPessoa(cliente);
        rep_prod.addProduto(produto);
        
        int opc_perfil;

        do{
            String login = "";
            String senha = "";

            System.out.println("\n\nBEM VINDO!");
            System.out.println("[1] - Gerente");
            System.out.println("[2] - Operador do Sistema");
            System.out.println("\n[0] - SAIR");
            System.out.println("\nQual perfil deseja acessar?");

            String opc_str = scan.nextLine();
            try{
                opc_perfil = Integer.parseInt(opc_str);
            }
            catch(NumberFormatException e){
                opc_perfil = -1;
            }

            switch(opc_perfil){

                case 1:
                    System.out.println("\nLOGIN: ");
                    login = scan.nextLine();
                    System.out.println("SENHA:");
                    senha = scan.nextLine();
                    if (rep_pess.checkLogin_Gerente(login, senha)){
                        Ger_menu.menu(rep_pess, rep_prod);
                    }
                    break;

                case 2:
                    System.out.println("\nLOGIN: ");
                    login = scan.nextLine();
                    System.out.println("SENHA:");
                    senha = scan.nextLine();
                    if (rep_pess.checkLogin_Operador(login, senha)){
                        Op_menu.op_menu(rep_pess, rep_prod, locacoes);
                    }
                    break;


                case 0:
                    System.out.println("SAINDO...");
                    System.out.println("Até mais!");
                    break;

                default:
                    System.out.println("\nEscolha entre as opções disponíveis!");
            }
                
        } while (opc_perfil != 0);
    }

}

