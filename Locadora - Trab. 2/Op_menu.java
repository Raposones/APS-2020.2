import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Op_menu {
    static Scanner scan = new Scanner(System.in);


    public static void op_menu(Rep_pessoas pessoas, Rep_produtos produtos, Locacoes locacoes) {
        int op_opc;

        do {
            System.out.println("\n[1] - Locação..");
            System.out.println("[2] - Procurar..");
            System.out.println("[3] - Listar..\n");
            System.out.println("[0] - SAIR");
            System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

            op_opc = Integer.parseInt(scan.nextLine());

            switch (op_opc) {
                case 1:
                    loc_menu(pessoas, produtos, locacoes);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 0:
                    System.out.println("VOLTANDO...");
                    break;

                default:
                    System.out.println("ESCOLHA INVALIDA!");
                    System.out.println("VOLTANDO...");
            }

        } while (op_opc != 0);
    }

    public static void loc_menu(Rep_pessoas pessoas, Rep_produtos produtos, Locacoes locacoes){
        System.out.println("\n == MENU DE LOCAÇÕES == ");
        System.out.println("\n[1] - Fazer locação");
        System.out.println("[2] - Excluir uma locação");
        System.out.println("[3] - Dar baixa em locação\n");
        System.out.println("[0] - SAIR");
        System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

        int loc_opc = Integer.parseInt(scan.nextLine());

        switch(loc_opc){
            case 1:
                System.out.println(" -- DIGITE AS INFORMAÇÕES DA LOCAÇÃO A SER CRIADA -- ");
                System.out.println("Matricula do cliente: ");
                int matricula = Integer.parseInt(scan.nextLine());
                System.out.println("Codigo do produto: ");
                String codigo = scan.nextLine();

                if(!pessoas.checkExistance_Cliente(matricula) || !produtos.checkExistance_Produto(codigo)){
                    System.out.println("Matricula e/ou produto inexistente!");
                    System.out.println("Verifique o código do produto, a matrícula do cliente e certifique-se de digitar ambos corretamente!");
                }
                
                else{
                    Pessoa cliente = pessoas.getPessoa(matricula);
                    Produto produto = produtos.getProduto(codigo);
            
                    System.out.println("\nA seguinte locação será ADICIONADA: ");
                    System.out.println(" -- CLIENTE -- ");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Matricula: " + cliente.getMatricula());
                    System.out.println("\n -- PRODUTO -- ");
                    produtos.showProduto(codigo);
                    System.out.println("\n -- DATA E PREÇO -- ");
                    
                    LocalDate data_saida = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    System.out.println("Data de saída: " + data_saida.format(formatter));
                    System.out.println("Diária: " + produtos.calcPreco(produto));
                    System.out.println("--> Discos arranhados acrescentam 50% do valor original de locação ao total");
                    System.out.println("--> Multas aplicada em 15% de juros a cada semana após a data de saída");

                    System.out.println("\nConfirmar locação? \n[s]im / [n]ao");
                    String loc_add = scan.nextLine();

                    if(loc_add.equals("s")){
                        Locacoes locacao = new Locacoes(codigo, matricula, data_saida);
                        locacoes.add_locacao(locacao);
                    }
                }

                break;

            case 2:

                break;

            case 3:

                break;

            case 0:
                System.out.println("VOLTANDO...");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
                System.out.println("VOLTANDO...");

        }
    }
}
