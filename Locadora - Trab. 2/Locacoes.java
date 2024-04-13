import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Locacoes {
    static Scanner scan = new Scanner(System.in);
    ArrayList<Locacoes> locacoes = new ArrayList<Locacoes>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String codigo;
    private int matricula;
    private LocalDate data_saída;
    private LocalDate data_entrega;

    public Locacoes() {
    }

    public Locacoes(String codigo, int matricula, LocalDate data_saída, LocalDate data_entrega) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.data_saída = data_saída;
        this.data_entrega = data_entrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDate getData_saída() {
        return data_saída;
    }

    public void setData_saída(LocalDate data_saída) {
        this.data_saída = data_saída;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public void add_locacao(Locacoes locacao) {
        locacoes.add(locacao);
    }

    public Locacoes getLocacao(int num) {
        return locacoes.get(num);
    }

    public void removeLocacao(int num) {
        locacoes.remove(num);
    }

    public int calcularDias(LocalDate data_saida, LocalDate data_entrega) {
        return (int) ChronoUnit.DAYS.between(data_saida, data_entrega);
    }

    public void showLocacoes(Rep_pessoas pessoas, Rep_produtos produtos) {
        for (int i = 0; i < locacoes.size(); i++) {
            Locacoes loc = locacoes.get(i);
            Pessoa cliente = pessoas.getPessoa(loc.matricula);
            Produto produto = produtos.getProduto(loc.codigo);
            LocalDate datasaida = loc.getData_saída();
            String datasaidaf = datasaida.format(formatter);

            System.out.println("\n================");
            System.out.println("LOCAÇÃO Nº [" + i + "]");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Matricula: " + cliente.getMatricula());
            System.out.println("   //   ");
            System.out.println("Titulo: " + produto.getTitulo());
            System.out.println("Codigo: " + produto.getCodigo());
            System.out.println("   //   ");
            System.out.println("Data de saída: " + datasaidaf);
            System.out.println("================\n");
        }
    }

    public void baixaLocacao(int num, Rep_pessoas pessoas, Rep_produtos produtos) {
        Locacoes locacao;
        try{
            locacao = locacoes.get(num);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Numero de locação invalida.");
            return;
        }
        
        Produto produto = produtos.getProduto(locacao.getCodigo());
        Pessoa cliente = pessoas.getPessoa(locacao.getMatricula());

        double total = 0;
/*         int dia = -1;
        int mes = -1;
        int ano = -1;
        String diaStr, mesStr, anoStr;


        while (dia == -1) {
            System.out.println("Qual o DIA da entrega?");
            diaStr = scan.nextLine();
            try {
                dia = Integer.parseInt(diaStr);
            } catch (NumberFormatException e) {
                System.out.println("Use numeros inteiros!");
                dia = -1;
            }
        }

        while (mes == -1) {
            System.out.println("Qual o MES da entrega?");
            mesStr = scan.nextLine();
            try {
                mes = Integer.parseInt(mesStr);
            } catch (NumberFormatException e) {
                System.out.println("Use numeros inteiros!");
                mes = -1;
            }
        }

        while (ano == -1) {
            System.out.println("Qual o ANO da entrega?");
            anoStr = scan.nextLine();
            try {
                ano = Integer.parseInt(anoStr);
            } catch (NumberFormatException e) {
                System.out.println("Use numeros inteiros!");
                ano = -1;
            }
        } */

        int retornoEmDias = -1;
        String retornoEmDiasStr;
        while (retornoEmDias == -1) {
            System.out.println("Retorno feita em quantos dias?");
            retornoEmDiasStr = scan.nextLine();
            try{
                retornoEmDias = Integer.parseInt(retornoEmDiasStr);
            }
            catch(NumberFormatException e){
                System.out.println("Use numeros inteiros!");
                retornoEmDias = -1;
            }
        }

        LocalDate dataRetorno = locacao.getData_saída().plusDays(retornoEmDias);

        int dias = calcularDias(locacao.getData_saída(), dataRetorno);
        int multa_dias = calcularDias(locacao.getData_entrega(), dataRetorno);

        double valor_dia = produtos.calcPreco(produto);
        double multa = multa_dias * 0.10; // juros de 10% por dia
        String multa_txt = "+ MULTA: +" + multa_dias * 10 + "%";

        System.out.println("\n-- INFORMAÇÕES DA LOCAÇÃO -- \n");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Matricula: " + cliente.getMatricula());

        System.out.println("   //   ");

        System.out.println("Titulo: " + produto.getTitulo());
        System.out.println("Codigo: " + produto.getCodigo());
        produtos.checkIfModificado(produto);

        System.out.println("   //   ");

        System.out.println("Data de saída: " + locacao.getData_saída());
        System.out.println("Data de entrega: " + locacao.getData_entrega());

        System.out.println("\n--> Preço/dia: R$" + valor_dia);
        System.out.println("--> Dias: " + dias);
        total = (valor_dia * dias);
        System.out.println("--> Preço total base: R$" + total);

        if (multa_dias > 0)
            System.out.println("\n! Dias de atraso: " + multa_dias);
        if (multa > 0)
            System.out.println(multa_txt);
        double modificador = produtos.checkModificador(produto);

        double totalmulta = 0;
        double totalmod = total * modificador;

        if (multa > 0) {
            totalmulta = total * multa;
        }

        total = total + totalmulta + totalmod;

        System.out.println("\n--> PREÇO TOTAL: R$" + total);

        System.out.println("\nReceba R$" + total + " do(a) " + cliente.getNome());
        System.out.println("Pagamento em: \n=>[1] - Cartão \n=>[2] - Dinheiro");
        int pay = Integer.parseInt(scan.nextLine());

        if (pay == 1) {
            System.out.println("Prossiga o pagamento com a máquina de cartão.");
        }

        else {
            System.out.println("\nValor recebido: ");
            double payment = Double.parseDouble(scan.nextLine());
            System.out.println("Troco: R$" + (payment - total));
            System.out.println("\nPAGAMENTO FINALIZADO..");
        }

        locacoes.remove(num);
        produto.setLocado(false);
    }

}
