import java.util.Scanner;


public class Main {

    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);

        Gerente gerente = new Gerente("Raphael Garcia", 1, "raposones2", "147852");
        Rep_pessoas rep_pess = new Rep_pessoas();
        Rep_produtos rep_prod = new Rep_produtos();
        Locacoes locacoes = new Locacoes();

        rep_pess.addPessoa(gerente);

        int opc_perfil;

        do{
            String login = "";
            String senha = "";

            System.out.println("\n\nBEM VINDO!");
            System.out.println("[1] - Gerente");
            System.out.println("[2] - Operador do Sistema");
            System.out.println("\n[0] - SAIR");
            System.out.println("\nQual perfil deseja acessar?");

            opc_perfil = Integer.parseInt(scan.nextLine());

            if (opc_perfil != 0){
                System.out.println("\nLOGIN: ");
                login = scan.nextLine();
                System.out.println("SENHA:");
                senha = scan.nextLine();
            }

            switch(opc_perfil){

                case 1:
                    if (rep_pess.checkLogin_Gerente(login, senha)){
                        Ger_menu.menu(rep_pess, rep_prod);
                    }
                    break;

                case 2:
                    if (rep_pess.checkLogin_Operador(login, senha)){
                        Op_menu.op_menu(rep_pess, rep_prod, locacoes);
                    }
                    break;


                case 0:
                    System.out.println("SAINDO...");
                    System.out.println("Até mais!");
                    break;

                default:
                    System.out.println("Escolha entre as opções disponíveis!");
            }
                
        } while (opc_perfil != 0);
    }

}

