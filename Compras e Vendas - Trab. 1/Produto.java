public class Produto{

    //ATRIBUTOS - GETTER E SETTERS
    private int codigo;
    private String descricao;
    private double valor_compra;
    private double custo;
    private double margem_lucro;
    private int qtd_estoque;

    public double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getMargem_lucro() {
        return margem_lucro;
    }

    public void setMargem_lucro(double margem_lucro) {
        this.margem_lucro = margem_lucro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    

    //CONSTRUTORES
    public Produto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Produto(int codigo, String descricao, double valor_compra, double custo, double margem_lucro) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_compra = valor_compra;
        this.custo = custo;
        this.margem_lucro = margem_lucro;
    }

    public Produto(int codigo, String descricao, double valor_compra, double custo, double margem_lucro,
            int qtd_estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_compra = valor_compra;
        this.custo = custo;
        this.margem_lucro = margem_lucro;
        this.qtd_estoque = qtd_estoque;
    }

    //METODOS
    void compra(int qnt){  
        qtd_estoque = qtd_estoque + qnt;
    }

    void venda(int qnt){
        if(qtd_estoque - qnt < 0) {System.out.println("Nao ha mais deste produto.");}
        
        else {qtd_estoque = qtd_estoque - qnt;}
    }

    double calculaPrecoVenda(){
        return valor_compra + custo + margem_lucro*(valor_compra + custo);
    }


}