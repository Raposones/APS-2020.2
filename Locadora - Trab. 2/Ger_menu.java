import java.util.Scanner;

public class Ger_menu {
    static Scanner scan = new Scanner(System.in);

    public static void menu(Rep_pessoas pessoas, Rep_produtos produtos) {

        int ger_opc;

        do {
            System.out.println("\n[1] - Adicionar..");
            System.out.println("[2] - Remover..");
            System.out.println("[3] - Procurar..");
            System.out.println("[4] - Listar..\n");
            System.out.println("[0] - SAIR");
            System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

            ger_opc = Integer.parseInt(scan.nextLine());

            switch (ger_opc) {

                case 1:
                    add_menu(pessoas, produtos);
                    break;

                case 2:
                    rem_menu(pessoas, produtos);
                    break;

                case 3:
                    search_menu(pessoas, produtos);
                    break;

                case 4:
                    list_menu(pessoas, produtos);
                    break;

                case 0:
                    System.out.println("\n-- SAINDO DO PERFIL DE GERENTE --");
                    System.out.println("\nVoltando ao menu de login...\n");
                    break;

                default:
                    System.out.println("Escolha entre as opções disponíveis!");
            }

        } while (ger_opc != 0);
    }

    public static void add_menu(Rep_pessoas pessoas, Rep_produtos produtos) {
        int add_opc;

        System.out.println("O que deseja adicionar ao sistema?\n");
        System.out.println("[1] - Produto");
        System.out.println("[2] - Cliente");
        System.out.println("[3] - Operador de Sistema");
        System.out.println("\n[0] - CANCELAR");
        System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

        String add_opc_str = scan.nextLine();

        try {
            add_opc = Integer.parseInt(add_opc_str);
        } catch (NumberFormatException e) {
            add_opc = -1;
        }

        switch (add_opc) {
            case 1:
                System.out.println("Qual o código do produto a ser adicionado?");
                String cod = scan.nextLine();

                if (produtos.checkExistance_Produto(cod)) {
                    System.out.println("\n-- PRODUTO JÁ CADASTRADO! --\n");
                }

                else {
                    System.out.println("Qual produto deseja adicionar?");
                    System.out.println("[1] - FILME --> DVD");
                    System.out.println("[2] - FILME --> Blu-Ray");
                    System.out.println("[3] - FILME --> VHS\n");
                    System.out.println("[4] - MUSICA --> CD");
                    System.out.println("[5] - MUSICA --> Vinil (LP)\n");
                    System.out.println("[0] - CANCELAR");
                    System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

                    int add_prod_opc;
                    String add_prod_opc_str = scan.nextLine();
                    try {
                        add_prod_opc = Integer.parseInt(add_prod_opc_str);
                    } catch (NumberFormatException e) {
                        add_prod_opc = -1;
                    }

                    switch (add_prod_opc) {
                        case 1:
                            System.out.println("-- DIGITE AS INFORMAÇÕES DO DVD --");

                            System.out.println("\nTitulo: ");
                            String dvd_titulo = scan.nextLine();

                            System.out.println("Genero:");
                            String dvd_genero = scan.nextLine();

                            int dvd_ano_lancamento = -1;
                            while (dvd_ano_lancamento == -1) {
                                System.out.println("Ano de lançamento:");
                                String dvd_ano_lancamento_str = scan.nextLine();
                                try {
                                    dvd_ano_lancamento = Integer.parseInt(dvd_ano_lancamento_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use npumeros inteiros!");
                                    dvd_ano_lancamento = -1;
                                }
                            }

                            int dvd_duracao = -1;
                            while (dvd_duracao == -1) {
                                System.out.println("Duração (minutos):");
                                String dvd_duracao_str = scan.nextLine();
                                try {
                                    dvd_duracao = Integer.parseInt(dvd_duracao_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use números inteiros!");
                                    dvd_duracao = -1;
                                }
                            }

                            DVD dvd_produto = new DVD(cod, dvd_titulo, dvd_genero, false, dvd_ano_lancamento,
                                    dvd_duracao, false);

                            System.out.println("\n== O seguinte produto será ADICIONADO == \n");
                            System.out.println("Titulo: " + dvd_titulo);
                            System.out.println("Tipo: FILME - DVD");
                            System.out.println("Gênero: " + dvd_genero);
                            System.out.println("Ano: " + dvd_ano_lancamento);
                            System.out.println("Duração: " + dvd_duracao + " minutos");
                            System.out.println("--- // ---\n");
                            System.out.println("Prosseguir com a adição?\n[s]im / [n]ão");
                            String dvd_esc = scan.nextLine();

                            if (dvd_esc.equals("s"))
                                produtos.addProduto(dvd_produto);
                            break;

                        case 2:
                            System.out.println("-- DIGITE AS INFORMAÇÕES DO BLU-RAY --");

                            System.out.println("\nTitulo: ");
                            String blu_titulo = scan.nextLine();

                            System.out.println("Genero:");
                            String blu_genero = scan.nextLine();

                            int blu_ano_lancamento = -1;
                            while (blu_ano_lancamento == -1) {
                                System.out.println("Ano de lançamento:");
                                String blu_ano_lancamento_str = scan.nextLine();
                                try {
                                    blu_ano_lancamento = Integer.parseInt(blu_ano_lancamento_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros!");
                                    blu_ano_lancamento = -1;
                                }
                            }

                            int blu_duracao = -1;
                            while (blu_duracao == -1) {
                                System.out.println("Duração (minutos):");
                                String blu_duracao_str = scan.nextLine();
                                try {
                                    blu_duracao = Integer.parseInt(blu_duracao_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros1");
                                    blu_duracao = -1;
                                }
                            }

                            String[] blu_idiomas = new String[2];
                            System.out.println(
                                    "Idiomas disponíveis \n(Digite até 2 idiomas. Se não houver, apenas digite ENTER.):");
                            for (int a = 0; a < blu_idiomas.length; a++) {
                                blu_idiomas[a] = scan.nextLine();
                            }

                            BluRay produto = new BluRay(cod, blu_titulo, blu_genero, false, blu_ano_lancamento,
                                    blu_duracao, blu_idiomas);

                            System.out.println("\n== O seguinte produto será ADICIONADO == \n");
                            System.out.println("Titulo: " + blu_titulo);
                            System.out.println("Tipo: FILME - Blu-Ray");
                            System.out.println("Gênero: " + blu_genero);
                            System.out.println("Ano: " + blu_ano_lancamento);
                            System.out.println("Duração: " + blu_duracao + " minutos");
                            System.out.println("Disponível em " + blu_idiomas[0] + "; " + blu_idiomas[1]);
                            System.out.println("--- // ---\n");
                            System.out.println("Prosseguir com a adição?\n[s]im / [n]ão");
                            String blu_esc = scan.nextLine();

                            if (blu_esc.equals("s"))
                                produtos.addProduto(produto);
                            break;

                        case 3:
                            System.out.println("-- DIGITE AS INFORMAÇÕES DO VHS --");

                            System.out.println("\nTitulo: ");
                            String vhs_titulo = scan.nextLine();

                            System.out.println("Genero:");
                            String vhs_genero = scan.nextLine();

                            int vhs_ano_lancamento = ~-1;
                            while (vhs_ano_lancamento == -1) {
                                System.out.println("Ano de lançamento:");
                                String vhs_ano_lancamento_str = scan.nextLine();
                                try {
                                    vhs_ano_lancamento = Integer.parseInt(vhs_ano_lancamento_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros1");
                                    vhs_ano_lancamento = -1;
                                }
                            }

                            
                            int vhs_duracao = -1;
                            while (vhs_duracao == -1) {
                                System.out.println("Duração (minutos):");
                                String vhs_duracao_str = scan.nextLine();
                                try {
                                    vhs_duracao = Integer.parseInt(vhs_duracao_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros1");
                                    vhs_duracao = -1;
                                }
                            }

                            boolean vhs_cor;
                            System.out.println("O VHS tem cores?\n[s]im / [n]ão");
                            String cor = scan.nextLine();

                            if (cor.equals("s"))
                                vhs_cor = true;
                            else
                                vhs_cor = false;

                            VHS vhs_produto = new VHS(cod, vhs_titulo, vhs_genero, false, vhs_ano_lancamento,
                                    vhs_duracao, vhs_cor);

                            System.out.println("\n== O seguinte produto será ADICIONADO == \n");
                            System.out.println("Titulo: " + vhs_titulo);
                            System.out.println("Tipo: FILME -VHS");
                            System.out.println("Gênero: " + vhs_genero);
                            System.out.println("Ano: " + vhs_ano_lancamento);
                            System.out.println("Duração: " + vhs_duracao + " minutos");
                            if (vhs_cor)
                                System.out.println("Cores: Sim");
                            else
                                System.out.println("Cores: Não");
                            System.out.println("--- // ---\n");
                            System.out.println("Prosseguir com a adição?\n[s]im / [n]ão");
                            String vhs_esc = scan.nextLine();

                            if (vhs_esc.equals("s"))
                                produtos.addProduto(vhs_produto);
                            break;

                        case 4:
                            System.out.println("-- DIGITE AS INFORMAÇÕES DO CD");

                            System.out.println("\nTitulo: ");
                            String cd_titulo = scan.nextLine();

                            System.out.println("Genero:");
                            String cd_genero = scan.nextLine();

                            System.out.println("Autor:");
                            String cd_autor = scan.nextLine();

                            
                            int cd_faixas = -1;
                            while (cd_faixas == -1) {
                                System.out.println("Número de faixas:");
                                String cd_faixas_str = scan.nextLine();
                                try {
                                    cd_faixas = Integer.parseInt(cd_faixas_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros1");
                                    cd_faixas = -1;
                                }
                            }

                            boolean cd_duplo;
                            System.out.println("É duplo?\n[s]im / [n]ão");
                            String duplo = scan.nextLine();

                            if (duplo.equals("s"))
                                cd_duplo = true;
                            else
                                cd_duplo = false;

                            CD cd_produto = new CD(cod, cd_titulo, cd_genero, false, cd_autor, cd_faixas, false,
                                    cd_duplo);

                            System.out.println("\n== O seguinte produto será ADICIONADO == \n");
                            System.out.println("Titulo: " + cd_titulo);
                            System.out.println("Tipo: MÚSICA - CD");
                            System.out.println("Genero: " + cd_genero);
                            System.out.println("Autor: " + cd_genero);
                            System.out.println("Num. Faixas: " + cd_faixas);
                            if (cd_duplo)
                                System.out.println("Duplo: Sim");
                            else
                                System.out.println("Duplo: Não");
                            System.out.println("--- // ---\n");
                            System.out.println("Prosseguir com a adição?\n[s]im / [n]ão");
                            String cd_esc = scan.nextLine();

                            if (cd_esc.equals("s"))
                                produtos.addProduto(cd_produto);
                            break;

                        case 5:
                            System.out.println("-- DIGITE AS INFORMAÇÕES DO VINIL(LP)");

                            System.out.println("\nTitulo: ");
                            String lp_titulo = scan.nextLine();

                            System.out.println("Genero:");
                            String lp_genero = scan.nextLine();

                            System.out.println("Autor:");
                            String lp_autor = scan.nextLine();

                            System.out.println("Número de faixas:");
                            int lp_faixas = -1;
                            while (lp_faixas == -1) {
                                System.out.println("Número de faixas:");
                                String lp_faixas_str = scan.nextLine();
                                try {
                                    lp_faixas = Integer.parseInt(lp_faixas_str);
                                } catch (NumberFormatException e) {
                                    System.out.println("Use numeros inteiros1");
                                    lp_faixas = -1;
                                }
                            }

                            boolean lp_raro;
                            System.out.println("É raro?\n[s]im / [n]ão");
                            String raro = scan.nextLine();

                            if (raro.equals("s"))
                                lp_raro = true;
                            else
                                lp_raro = false;

                            CD lp_produto = new CD(cod, lp_titulo, lp_genero, false, lp_autor, lp_faixas, false,
                                    lp_raro);

                            System.out.println("\n== O seguinte produto será ADICIONADO == \n");
                            System.out.println("Titulo: " + lp_titulo);
                            System.out.println("Tipo: MÚSICA - LP");
                            System.out.println("Genero: " + lp_genero);
                            System.out.println("Autor: " + lp_autor);
                            System.out.println("Num. Faixas: " + lp_faixas);
                            if (lp_raro)
                                System.out.println("Raro: Sim");
                            else
                                System.out.println("Raro: Não");
                            System.out.println("--- // ---\n");
                            System.out.println("Prosseguir com a adição?\n[s]im / [n]ão");
                            String lp_esc = scan.nextLine();

                            if (lp_esc.equals("s"))
                                produtos.addProduto(lp_produto);
                            break;

                        case 0:
                            System.out.println("-- SAINDO... -- ");
                            break;

                        default:
                            System.out.println("ESCOLHA INVALIDA!");

                    }
                }
                break;

            case 2:
                int cliente_matricula = -1;
                while (cliente_matricula == -1) {
                    System.out.println("Digite a matrícula do cliente a ser adicionado.");
                    System.out.println("[DIGITE 0 PARA SAIR]");
                    String cliente_matricula_str = scan.nextLine();
                    try {
                        cliente_matricula = Integer.parseInt(cliente_matricula_str);
                    } catch (NumberFormatException e) {
                        System.out.println("Use números inteiros!");
                        cliente_matricula = -1;
                    }
                }

                if (cliente_matricula == 0)
                    break;

                else if (pessoas.checkExistance_Cliente(cliente_matricula)) {
                    System.out.println("CLIENTE JÁ CADASTRADO!");
                }

                else {
                    System.out.println("-- DIGITE AS INFORMAÇÕES DO CLIENTE --\n ");

                    System.out.println("Nome:");
                    String nome = scan.nextLine();

                    System.out.println("Endereço:");
                    String end = scan.nextLine();

                    System.out.println("Idade:");
                    int idade = Integer.parseInt(scan.nextLine());

                    System.out.println("Sexo:");
                    String sexo = scan.nextLine();

                    Cliente cliente = new Cliente(nome, cliente_matricula, end, idade, sexo);

                    System.out.println("\n== O seguinte cliente será ADICIONADO ==\n");
                    System.out.println("Nome: " + nome);
                    System.out.println("Idade: " + idade);
                    System.out.println("Sexo: " + sexo);
                    System.out.println("Endereço: " + end);
                    System.out.println("--- // ---\n");
                    System.out.println("Prosseguir com a adição?\n [s]im / [n]ão");
                    String add_cl = scan.nextLine();

                    if (add_cl.equals("s"))
                        pessoas.addPessoa(cliente);
                }
                break;

            case 3:
                System.out.println("Digite a matrícula do operador a ser adicionado.");
                int op_matricula = Integer.parseInt(scan.nextLine());

                if (pessoas.checkExistance_Operador(op_matricula)) {
                    System.out.println("OPERADOR JÁ CADASTRADO!");
                }

                else {
                    System.out.println("-- DIGITE AS INFORMAÇÕES DO OPERADOR -- ");

                    System.out.println("Nome:");
                    String opnome = scan.nextLine();

                    System.out.println("Login:");
                    String login = scan.nextLine();

                    System.out.println("Senha:");
                    String senha = scan.nextLine();

                    Operador_sis operador = new Operador_sis(opnome, op_matricula, login, senha);

                    System.out.println("\n== O seguinte operador será ADICIONADO ==\n");
                    System.out.println("Nome: " + opnome);
                    System.out.println("Matricula: " + op_matricula);
                    System.out.println("Login: " + login);
                    System.out.println("Senha: " + senha);
                    System.out.println("--- // ---\n");
                    System.out.println("Prosseguir com a adição?\n [s]im / [n]ão");
                    String add_op = scan.nextLine();

                    if (add_op.equals("s"))
                        pessoas.addPessoa(operador);
                }
                break;

            case 0:
                System.out.println("\nVOLTANDO..\n");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }

    public static void rem_menu(Rep_pessoas pessoas, Rep_produtos produtos) {
        int rem_opc;

        System.out.println("O que deseja remover do sistema?\n");
        System.out.println("[1] - Produto");
        System.out.println("[2] - Cliente");
        System.out.println("[3] - Operador de Sistema");
        System.out.println("\n[0] - CANCELAR");
        System.out.println("\n-- ESCOLHA UMA OPÇÃO --");

        rem_opc = Integer.parseInt(scan.nextLine());

        switch (rem_opc) {
            case 1:
                System.out.println("Digite o código do produto a ser removido.");
                String codigo = scan.nextLine();

                if (!produtos.checkExistance_Produto(codigo)) {
                    System.out.println("PRODUTO NÃO CADASTRADO / NÃO EXISTE!");
                }

                else {
                    Produto aux = produtos.getProduto(codigo);

                    System.out.println("O seguinte produto esrá REMOVIDO:\n");
                    System.out.println("Titulo: " + aux.getTitulo());
                    System.out.println("Genero: " + aux.getGenero());
                    System.out.println("--- // ---\n");
                    System.out.println("Prosseguir com a remoção?\n[s]im / [n]ão");
                    String prod_rem = scan.nextLine();

                    if (prod_rem.equals("s"))
                        produtos.remProduto(codigo);
                }
                break;

            case 2:
                int out = 0;
                do {
                    int matricula = -1;
                    while (matricula == -1) {
                        System.out.println("Qual o numero de matrícula do cliente a ser removido?");
                        System.out.println("[DIGITE 0 PARA SAIR]");
                        String matr_str = scan.nextLine();
                        try {
                            matricula = Integer.parseInt(matr_str);
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, forneça uma matrícula com números inteiros.");
                        }
                    }
                    if (matricula == 0)
                        out = 1;
                    else if (!pessoas.checkExistance_Cliente(matricula))
                        System.out.println("Cliente não cadastrado!");
                    else {
                        Pessoa aux = pessoas.getPessoa(matricula);

                        System.out.println("O seguinte cliente será REMOVIDO: \n");
                        System.out.println("Nome: " + aux.getNome());
                        System.out.println("Matricula: " + aux.getMatricula());
                        System.out.println("--- // ---\n");

                        System.out.println("Prosseguir com a remoção?\n[s]im / [n]ão");
                        String cliente_rem = scan.nextLine();

                        if (cliente_rem.equals("s"))
                            pessoas.remPessoa(matricula);
                        out = 1;
                    }
                } while (out != 1);
                break;

            case 3:
                int out2 = 0;
                do {
                    int opmatricula = -1;
                    while (opmatricula == -1) {
                        System.out.println("Digite a matricula do operador a ser removido.");
                        System.out.println("[DIGITE 0 PARA SAIR]");
                        String opmatricula_str = scan.nextLine();
                        try {
                            opmatricula = Integer.parseInt(opmatricula_str);
                        } catch (NumberFormatException e) {
                            System.out.println("Use números inteiros!");
                        }
                    }

                    if (opmatricula == 0)
                        out2 = 1;

                    else if (!pessoas.checkExistance_Operador(opmatricula)) {
                        System.out.println("OPERADOR NÃO CADASTRADO / NÃO EXISTE!");
                    }

                    else {
                        Pessoa aux = pessoas.getPessoa(opmatricula);

                        System.out.println("O seguinte operador será REMOVIDO: \n");
                        System.out.println("Nome: " + aux.getNome());
                        System.out.println("Matricula: " + aux.getMatricula());
                        System.out.println("--- // ---\n");

                        System.out.println("Prosseguir com a remoção?\n[s]im / [n]ão");
                        String op_rem = scan.nextLine();

                        if (op_rem.equals("s"))
                            pessoas.remPessoa(opmatricula);
                        out2 = 1;
                    }
                } while (out2 != 1);
                break;

            case 0:
                System.out.println("SAINDO...");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }

    public static void search_menu(Rep_pessoas pessoas, Rep_produtos produtos) {
        System.out.println("O que deseja procurar?\n");
        System.out.println("[1] - Produto");
        System.out.println("[2] - Cliente");
        System.out.println("[3] - Operador\n");
        System.out.println("[0] - SAIR\n");
        System.out.println("-- ESCOLHA UMA OPÇÃO --");

        String list_opc_str = scan.nextLine();
        int list_opc;

        try {
            list_opc = Integer.parseInt(list_opc_str);
        } catch (NumberFormatException e) {
            list_opc = -1;
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
                int out = 0;
                do {
                    int mat_srch = -1;
                    while (mat_srch == -1) {
                        System.out.println("Qual a matricula do cliente que deseja encontrar?");
                        System.out.println("[DIGITE 0 PARA SAIR]");
                        String mat_srch_str = scan.nextLine();
                        try {
                            mat_srch = Integer.parseInt(mat_srch_str);
                        } catch (NumberFormatException e) {
                            System.out.println("Use números inteiros!");
                        }
                    }

                    if (mat_srch == 0)
                        out = 1;

                    else if (!pessoas.checkExistance_Cliente(mat_srch)) {
                        System.out.println("CLIENTE NÃO CADASTRADO / NÃO EXISTE!");
                    }

                    else {
                        Pessoa aux = pessoas.getPessoa(mat_srch);
                        System.out.println("Cliente de matricula [" + mat_srch + "]: ");
                        System.out.println("Nome: " + aux.getNome());
                        System.out.println("--- // ---\n");
                        out = 1;
                    }
                } while (out != 1);
                break;

            case 3:
                int out2 = 0;
                do {
                    int op_matr = -1;
                    while (op_matr == -1) {
                        System.out.println("Qual a matricula do operador a se buscar?");
                        System.out.println("[DIGITE 0 PARA CANCELAR]");
                        String op_matr_str = scan.nextLine();
                        try {
                            op_matr = Integer.parseInt(op_matr_str);
                        } catch (NumberFormatException e) {
                            System.out.println("Use numeros inteiros!");
                        }
                    }

                    if (op_matr == 0)
                        out = 1;

                    else if (!pessoas.checkExistance_Operador(op_matr)) {
                        System.out.println("OPERADOR NÃO CADASTRADO / NÃO EXISTE!");
                    }

                    else {
                        Pessoa aux = pessoas.getPessoa(op_matr);
                        System.out.println("Operador de matricula [" + op_matr + "]: ");
                        System.out.println("Nome: " + aux.getNome());
                        System.out.println("--- // ---\n");
                    }
                } while (out2 != 1);

                break;

            case 0:
                System.out.println("SAINDO...");

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }

    public static void list_menu(Rep_pessoas pessoas, Rep_produtos produtos) {
        System.out.println("O que deseja listar?\n");
        System.out.println("[1] - Produtos");
        System.out.println("[2] - Clientes");
        System.out.println("[3] - Operadores\n");
        System.out.println("[0] - SAIR\n");
        System.out.println("-- ESCOLHA UMA OPÇÃO --");

        String list_opc_str = scan.nextLine();
        int list_opc;

        try {
            list_opc = Integer.parseInt(list_opc_str);
        } catch (NumberFormatException e) {
            list_opc = -1;
        }

        switch (list_opc) {
            case 1:
                System.out.println("== LISTANDO TODOS OS PRODUTOS == ");
                produtos.listProdutos();
                break;

            case 2:
                System.out.println("== LISTANDO TODOS OS CLIENTES == ");
                pessoas.listClientes();
                break;

            case 3:
                System.out.println("== LISTANDO TODOS OS OPERADORES ==");
                pessoas.listOperadores();
                break;

            case 0:
                System.out.println("SAINDO...");
                break;

            default:
                System.out.println("ESCOLHA INVALIDA!");
        }
    }
}
