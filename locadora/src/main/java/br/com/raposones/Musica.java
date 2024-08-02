package br.com.raposones;

public abstract class Musica extends Produto{
    
    private String autor;
    private int numFaixa;

    public Musica(String codigo, String titulo, String genero, boolean locado, String autor, int numFaixa) {
        super(codigo, titulo, genero, locado);
        setCodigo(codigo);
        setTitulo(titulo);
        setGenero(genero);
        setLocado(locado);
        this.autor = autor;
        this.numFaixa = numFaixa;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumFaixa() {
        return numFaixa;
    }

    public void setNumFaixa(int numFaixa) {
        this.numFaixa = numFaixa;
    }

    
}
