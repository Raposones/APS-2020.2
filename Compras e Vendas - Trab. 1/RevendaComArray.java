import java.util.Scanner;

public class RevendaComArray{
    Scanner scan = new Scanner(System.in);

    private Produto produtos [];
    private int index = 0;

    public RevendaComArray(int qtd) {
        produtos = new Produto[qtd];
 }

    void inserirProduto(Produto prod){
        produtos[index] = prod;
        index += 1;
    }

    void comprar(int cod, int qtd){
        boolean existe = false;
        Produto aux;

        for (int i = 0; produtos[i] != null; i++){
            aux = produtos[i];

            if(aux.getCodigo() == cod){
                produtos[i].compra(qtd);
                existe = true;
                break;
            }
        }

        if(!existe){
            System.out.println("Nao ha produto com este codigo!\n\n");
        }
    }

    void vender(int cod, int qtd){
        boolean existe = false;
        Produto aux;

        for (int i = 0; produtos[i] != null; i++){
            aux = produtos[i];

            if(aux.getCodigo() == cod){
                
                produtos[i].venda(qtd);
                existe = true;
                break;
            }
        }

        if(!existe){
            System.out.println("Nao ha produto com este codigo!\n\n");
        }
    }

    void consultaPrecoVenda(int cod){
        boolean existe = false;
        Produto aux;

        for (int i = 0; produtos[i] != null; i++){
            aux = produtos[i];

            if(aux.getCodigo() == cod){
                System.out.println("Descricao: " + produtos[i].getDescricao());
                System.out.println("Quantidade: " + produtos[i].getQtd_estoque());
                System.out.println("Valor da venda: " + produtos[i].calculaPrecoVenda());
                existe = true;
                break;
            }
        }

        if(!existe){
            System.out.println("Nao ha produto com este codigo!\n\n");
        }
    }

    void listaPrecos(){
        System.out.println("\n--------------------------\n");
        for (int i = 0; produtos[i] != null; i++){
            Produto aux = produtos[i];
            int cod = aux.getCodigo();
            String desc = aux.getDescricao();
            double valor = aux.calculaPrecoVenda();
            int qtd = aux.getQtd_estoque();


            System.out.println("Codigo de produto: " + cod 
                           + "\nDescricao: " + desc
                           + "\nQuantidade: " + qtd
                           + "\nValor de venda: " + valor 
                           + "\n");
            System.out.println("--------------------------\n");

        }
    }

    boolean codExistente(int cod){
        boolean existe = false;
        for (int i = 0; produtos[i] != null; i++){
            if (produtos[i].getCodigo() == cod){
                existe = true;
                break;
            }
  
        }
        return existe;
    }

    int size(){
        return produtos.length;
    }

    void editProd(int cod){
        boolean existe = false;
        int item = -1;
        for (int i = 0; produtos[i] != null; i++){
            if (produtos[i].getCodigo() == cod){
                existe = true;
                item = i;
                break;
            }
        }

        if(existe){
            System.out.println("O que deseja editar no produto " + produtos[item].getDescricao() + "?");
            System.out.println("[1] - Valor de compra\n"
                            +  "[2] - Custo\n"
                            +  "[3] - Margem de lucro\n"
                            +  "[0] - VOLTAR\n");
            System.out.println("Escola uma opcao: ");
            int opc = Integer.parseInt(scan.nextLine());


            switch(opc){
                case 1:
                    System.out.println("Qual sera o novo valor de compra?");
                    double new_valor = Double.parseDouble(scan.nextLine());
                    produtos[item].setValor_compra(new_valor);
                    break;

                case 2:
                    System.out.println("Qual sera o novo custo?");
                    double new_custo = Double.parseDouble(scan.nextLine());
                    produtos[item].setCusto(new_custo);
                    break;

                case 3:
                    System.out.println("Qual sera a nova margem de lucro?");
                    double new_margem = Double.parseDouble(scan.nextLine());
                    produtos[item].setMargem_lucro(new_margem);;
                    break;

                case 0:
                    break;

                default:
                    break;

            }
        }

        else{
            System.out.println("Codigo nao cadastrado.");
        }
    }
 
}
