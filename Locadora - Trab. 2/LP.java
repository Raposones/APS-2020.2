public class LP extends Musica{
    
    private boolean raro;

    
    public LP(String codigo, String titulo, String genero, boolean locado, String autor, int numFaixa, boolean raro) {
        super(codigo, titulo, genero, locado, autor, numFaixa);
        setCodigo(codigo);
        setTitulo(titulo);
        setGenero(genero);
        setLocado(locado);
        setAutor(autor);
        setNumFaixa(numFaixa);
        this.raro = raro;
    }

    public boolean isRaro() {
        return raro;
    }

    public void setRaro(boolean raro) {
        this.raro = raro;
    }



    @Override
    public double CalcularDiaria() {
        return 0;
    }
    
}
