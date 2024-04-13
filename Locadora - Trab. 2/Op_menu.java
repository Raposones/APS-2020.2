import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Op_menu {
    static Scanner scan = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void op_menu(Rep_pessoas pessoas, Rep_produtos produtos, Locacoes locacoes) {
        int op_opc;

        do {
            System.out.println("\n[1] - Locação..");
            System.out.println("[2] - Procurar..");
            System.out.println("[3] - Listar..\n");
            System.out.println("[0] - SAIR");
            System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

            String op_opc_str = scan.nextLine();
            try {
                op_opc = Integer.parseInt(op_opc_str);
            } catch (NumberFormatException e) {
                op_opc = -1;
            }

            switch (op_opc) {
                case 1:
                    loc_menu(pessoas, produtos, locacoes);
                    break;

                case 2:
                    search_menu(pessoas, produtos);
                    break;

                case 3:
                    list_menu(pessoas, produtos);
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

    public static void loc_menu(Rep_pessoas pessoas, Rep_produtos produtos, Locacoes locacoes) {
        System.out.println("\n == MENU DE LOCAÇÕES == ");
        System.out.println("\n[1] - Fazer locação");
        System.out.println("[2] - Excluir uma locação");
        System.out.println("[3] - Dar baixa em locação\n");
        System.out.println("[0] - SAIR");
        System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

        int loc_opc;
        String loc_opc_str = scan.nextLine();
        try {
            loc_opc = Integer.parseInt(loc_opc_str);
        } catch (NumberFormatException e) {
            loc_opc = -1;
        }

        switch (loc_opc) {
            case 1:
                System.out.println(" -- DIGITE AS INFORMAÇÕES DA LOCAÇÃO A SER CRIADA -- ");

                int matricula = -1;
                while (matricula == -1) {
                    System.out.println("Matricula do cliente: ");
                    String matricula_str = scan.nextLine();
                    try {
                        matricula = Integer.parseInt(matricula_str);
                    } catch (NumberFormatException e) {
                        System.out.println("Use numeros inteiros!");
                        matricula = -1;
                    }
                }
                System.out.println("Codigo do produto: ");
                String codigo = scan.nextLine();

                if (!pessoas.checkExistance_Cliente(matricula) || !produtos.checkExistance_Produto(codigo)) {
                    System.out.println("Matricula e/ou produto inexistente!");
                    System.out.println(
                            "Verifique o código do produto, a matrícula do cliente e certifique-se de digitar ambos corretamente!");
                }

                else {
                    Pessoa cliente = pessoas.getPessoa(matricula);
                    Produto produto = produtos.getProduto(codigo);

                    if (produto.isLocado()) {
                        System.out.println("Este produto já foi locado!\n");
                    }

                    else {
                        System.out.println("\nA seguinte locação será ADICIONADA: ");
                        System.out.println(" -- CLIENTE -- ");
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("Matricula: " + cliente.getMatricula());
                        System.out.println("\n -- PRODUTO -- ");
                        produtos.showProduto(codigo);
                        System.out.println("\n -- DATA E PREÇO -- ");

                        LocalDate data_saida = LocalDate.now();
                        LocalDate data_entrega = data_saida.plusDays(2);

                        System.out.println("Data de saída: " + data_saida.format(formatter));
                        System.out.println("ENTREGAR NO DIA " + data_entrega.format(formatter));
                        System.out.println("Diária: " + produtos.calcPreco(produto));
                        System.out.println("--> Discos arranhados acrescentam 50% ao total");
                        System.out.println("--> Multa aplicada em +10% juros/dia após a data prevista de entrega");

                        System.out.println("\nConfirmar locação? \n[s]im / [n]ao");
                        String loc_add = scan.nextLine();

                        if (loc_add.equals("s")) {
                            Locacoes locacao = new Locacoes(codigo, matricula, data_saida, data_entrega);
                            locacoes.add_locacao(locacao);
                            produto.setLocado(true);
                        }
                    }
                }
                break;

            case 2:
                locacoes.showLocacoes(pessoas, produtos);
                System.out.println("\nQual locação deseja excluir?");
                System.out.println("(Escolha por número da locação)");

                int loc_rem = -1;
                while (loc_rem == -1) {
                    String loc_rem_str = scan.nextLine();
                    try {
                        loc_rem = Integer.parseInt(loc_rem_str);
                    } catch (NumberFormatException e) {
                        System.out.println("Use numeros inteiros!");
                        loc_rem = -1;
                    }
                }

                Locacoes loc;
                try {
                    loc = locacoes.getLocacao(loc_rem);
                } catch (Exception e) {
                    System.out.println("Locação não encontrada!");
                    return;
                }

                Pessoa cliente = pessoas.getPessoa(loc.getMatricula());
                Produto produto = produtos.getProduto(loc.getCodigo());
                LocalDate datasaida = loc.getData_saída();
                String datasaidaf = datasaida.format(formatter);

                System.out.println("-- Será REMOVIDA a seguinte locação: --");
                System.out.println("\nLOCAÇÃO Nº " + loc_rem);
                System.out.println("Cliente: " + cliente.getNome());
                System.out.println("Matricula: " + cliente.getMatricula());
                System.out.println("   //   ");
                System.out.println("Titulo: " + produto.getTitulo());
                System.out.println("Codigo: " + produto.getCodigo());
                System.out.println("   //   ");
                System.out.println("Data de saída: " + datasaidaf);
                System.out.println("========\n");

                System.out.println("Prosseguir com remoção?\n[s]im / [n]ao");
                String rem_opc = scan.nextLine();

                if (rem_opc.equals("s"))
                    locacoes.removeLocacao(loc_rem);
                break;

            case 3:
                locacoes.showLocacoes(pessoas, produtos);
                System.out.println("\nQual locação deseja dar baixa?");
                System.out.println("(Escolha por número da locação)");

                int loca = -1;
                while (loca == -1) {
                    String loca_str = scan.nextLine();
                    try {
                        loca = Integer.parseInt(loca_str);
                    } catch (NumberFormatException e) {
                        System.out.println("Use numeros inteiros!");
                        loca = -1;
                    }
                }

                locacoes.baixaLocacao(loca, pessoas, produtos);
                break;

            case 0:
                System.out.println("VOLTANDO...");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
                System.out.println("VOLTANDO...");

        }
    }

    public static void search_menu(Rep_pessoas pessoas, Rep_produtos produtos) {
        System.out.println("O que deseja procurar?\n");
        System.out.println("[1] - Produto");
        System.out.println("[2] - Cliente\n");
        System.out.println("[0] - SAIR\n");
        System.out.println("-- ESCOLHA UMA OPÇÃO --");

        int list_opc = -1;
        while (list_opc == -1) {
            String list_opc_str = scan.nextLine();
            try {
                list_opc = Integer.parseInt(list_opc_str);
            } catch (NumberFormatException e) {
                System.out.println("Use numeros inteiros!");
                list_opc = -1;
            }
        }

        switch (list_opc) {
            case 1:
                System.out.println("Qual o código do produto que deseja encontrar?");
                String cod_srch = scan.nextLine();

                if (!produtos.checkExistance_Produto(cod_srch)) {
                    System.out.println("PRODUTO NÃO CADASTRADO / NÃO EXISTE!");
                }

                else {
                    Produto aux = produtos.getProduto(cod_srch);
                    System.out.println("Produto de código [" + cod_srch + "]: ");
                    System.out.println("Titulo: " + aux.getTitulo());
                    System.out.println("Genero: " + aux.getGenero());
                    System.out.println("--- // ---\n");
                }
                break;

            case 2:
                System.out.println("Qual a matricula do cliente que deseja encontrar?");

                int mat_srch = -1;
                while (mat_srch == -1) {
                    String mat_srch_str = scan.nextLine();
                    try {
                        mat_srch = Integer.parseInt(mat_srch_str);
                    } catch (NumberFormatException e) {
                        System.out.println("Use numeros inteiros!");
                        mat_srch = -1;
                    }
                }

                if (!pessoas.checkExistance_Cliente(mat_srch)) {
                    System.out.println("CLIENTE NÃO CADASTRADO / NÃO EXISTE!");
                }

                else {
                    Pessoa aux = pessoas.getPessoa(mat_srch);
                    System.out.println("Cliente de matricula [" + mat_srch + "]: ");
                    System.out.println("Nome: " + aux.getNome());
                    System.out.println("--- // ---\n");
                }
                break;

            case 0:
                System.out.println("SAINDO...");

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }

    public static void list_menu(Rep_pessoas pessoas, Rep_produtos produtos){
        System.out.println("O que deseja listar?\n");
        System.out.println("[1] - Produtos");
        System.out.println("[2] - Clientes");
        System.out.println("[0] - SAIR\n");
        System.out.println("-- ESCOLHA UMA OPÇÃO --");

        int list_opc;
        String list_opc_str = scan.nextLine();
        try{
            list_opc = Integer.parseInt(list_opc_str);
        }
        catch(NumberFormatException e){
            list_opc = -1;
        }

        switch(list_opc){
            case 1:
                System.out.println("== LISTANDO TODOS OS PRODUTOS == ");
                produtos.listProdutos();
                break;

            case 2:
                System.out.println("== LISTANDO TODOS OS CLIENTES == ");
                pessoas.listClientes();
                break;

            case 0:
                System.out.println("SAINDO...");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }
}
