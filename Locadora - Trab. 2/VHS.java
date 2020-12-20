public class VHS extends Filme{
    
    private boolean cores;

    public VHS(String codigo, String titulo, String genero, boolean locado, int anoLancamento, int duracao,
            boolean cores) {
        super(codigo, titulo, genero, locado, anoLancamento, duracao);
        setCodigo(codigo);
		setTitulo(titulo);
		setGenero(genero);
		setLocado(locado);
		setAnoLancamento(anoLancamento);
		setDuracao(duracao);
        this.cores = cores;
    }

    public boolean isCores() {
        return cores;
    }

    public void setCores(boolean cores) {
        this.cores = cores;
    }


    @Override
    public double CalcularDiaria() {
        return 0;
    }
    
}
