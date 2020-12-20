import java.util.Scanner;

public class Teste {

    
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            RevendaComArray lista = new RevendaComArray(10);
            int listqtd = 0;

            int opc;

            do{
                System.out.println("\nOlá!\nProdutos adicionados : " + listqtd + "\n(MAX: 10)\n");

                System.out.println("[1] - Criar produto \n"
                              +    "[2] - Comprar \n"
                              +    "[3] - Vender \n"
                              +    "[4] - Consultar preco de um produto\n" 
                              +    "[5] - Listar todos os precos\n"
                              +    "[6] - Editar produto\n"
                              +    "[0] - Sair");

                System.out.println("Escolha uma opcao: ");
                opc = Integer.parseInt(scan.nextLine());

                switch(opc){
                    case 1: //ADICIONAR PRODUTO
                        if(listqtd == 10){
                            System.out.println("LISTA CHEIA!!! NAO EH POSSIVEL ADICIONAR MAIS PRODUTOS.\n");
                        }

                        else{
                            System.out.println("Digite as informações do produto que deseja adicionar.\n");
                            
                            System.out.println("Codigo de produto: ");
                            int cod = Integer.parseInt(scan.nextLine());

                            if(lista.codExistente(cod)){
                                System.out.println("Produto/Codigo ja existe.");
                                break;
                            }

                            System.out.println("Descricao do produto: ");
                            String desc = scan.nextLine();
                            System.out.println("Valor de compra: ");
                            double valor = Double.parseDouble(scan.nextLine());
                            System.out.println("Custo: ");
                            double custo = Double.parseDouble(scan.nextLine());
                            System.out.println("Margem de lucro: ");
                            double margem = Double.parseDouble(scan.nextLine());
                            System.out.println("Quantia em estoque: ");
                            int qtd = Integer.parseInt(scan.nextLine());

                            Produto produto = new Produto(cod, desc, valor, custo, margem, qtd);
                            lista.inserirProduto(produto);
                            listqtd += 1;
                            }

                        break;

                    case 2: //COMPRAR
                        System.out.println("Qual o codigo do produto a ser comprado?");
                        int cod_buy = Integer.parseInt(scan.nextLine());
                        System.out.println("Qual a quantidade?");
                        int qtd_buy = Integer.parseInt(scan.nextLine());

                        lista.comprar(cod_buy, qtd_buy);                                             
                        break;  

                    case 3: //VENDA
                        System.out.println("Qual o codigo do produto a ser vendido?");
                        int cod_sell = Integer.parseInt(scan.nextLine());
                        System.out.println("Qual a quantidade?");
                        int qtd_sell = Integer.parseInt(scan.nextLine());  
                        
                        lista.vender(cod_sell, qtd_sell);

                        break;

                    case 4: //CONSULTAR
                        System.out.println("Qual o codigo do produto que deseja consultar?");
                        int consulta = Integer.parseInt(scan.nextLine());
                        
                        lista.consultaPrecoVenda(consulta);

                        break;

                    case 5: //LISTAR
                        lista.listaPrecos();        

                        break;

                    case 6: //EDITAR
                            System.out.println("Digite o codigo do produto a ser alterado: ");
                            int cod_edit = Integer.parseInt(scan.nextLine());
                            lista.editProd(cod_edit);

                            break;
                    
                    case 0:
                        System.out.println("Até mais!");
                        
                        break;

                    default:
                        System.out.println("Escolha invalida!\n\n\n");
                }

            }

            while(opc != 0);
        }
        
    }
