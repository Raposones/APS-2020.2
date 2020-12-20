import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Locacoes {
    ArrayList<Locacoes> locacoes = new ArrayList<Locacoes>();
    
    private String codigo;
    private int matricula;
    private LocalDate data_saída;
    private LocalDate data_entrega;

    public Locacoes() {
    }
    
    public Locacoes(String codigo, int matricula, LocalDate data_saída) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.data_saída = data_saída;
    }


    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public void add_locacao(Locacoes locacao){
        locacoes.add(locacao);
    }

    public int calcularDias(LocalDate data_saida, LocalDate data_entrega){
        return (int) ChronoUnit.DAYS.between(data_saida, data_entrega);
    }
    
    public double calcularMulta(LocalDate data_saida, LocalDate data_entrega){ //15% de juros por semana
        int dias = calcularDias(data_saida, data_entrega);
        return (dias/7) * 0.15;
    }


}
