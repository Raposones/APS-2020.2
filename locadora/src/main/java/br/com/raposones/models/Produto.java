package br.com.raposones.models;

public abstract class Produto{

    private String codigo;
    private String titulo;
    private String genero;
    private boolean locado;

    public Produto(String codigo, String titulo, String genero, boolean locado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.locado = locado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }


    public abstract double CalcularDiaria();

}