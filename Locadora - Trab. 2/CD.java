public class CD extends Musica{
    
    private boolean arranhado;
    private boolean duplo;

    public CD(String codigo, String titulo, String genero, boolean locado, String autor, int numFaixa,
    boolean arranhado, boolean duplo) {
        super(codigo, titulo, genero, locado, autor, numFaixa);
        setCodigo(codigo);
        setTitulo(titulo);
        setGenero(genero);
        setLocado(locado);
        setAutor(autor);
        setNumFaixa(numFaixa);
        this.arranhado = arranhado;
        this.duplo = duplo;
    }

    public boolean isArranhado() {
        return arranhado;
    }

    public void setArranhado(boolean arranhado) {
        this.arranhado = arranhado;
    }

    public boolean isDuplo() {
        return duplo;
    }

    public void setDuplo(boolean duplo) {
        this.duplo = duplo;
    }


    @Override
    public double CalcularDiaria() {
        return 0;
    }

}
