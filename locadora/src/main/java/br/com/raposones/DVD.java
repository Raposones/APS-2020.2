package br.com.raposones;

public class DVD extends Filme{
    
    private boolean arranhado;

    public DVD(String codigo, String titulo, String genero, boolean locado, int anoLancamento, int duracao,
            boolean arranhado) {
        super(codigo, titulo, genero, locado, anoLancamento, duracao);
        setCodigo(codigo);
        setTitulo(titulo);
        setGenero(genero);
        setLocado(locado);
        setAnoLancamento(anoLancamento);
        setDuracao(duracao);
        this.arranhado = arranhado;
    }

    public boolean isArranhado() {
        return arranhado;
    }

    public void setArranhado(boolean arranhado) {
        this.arranhado = arranhado;
    }


    @Override
    public double CalcularDiaria() {
        return 4;
    }

}
