package br.com.raposones;

public class BluRay extends Filme{

	private String[] idiomas = new String[2];
	
	public BluRay(String codigo, String titulo, String genero, boolean locado, int anoLancamento, int duracao,
	String[] idiomas) {
		super(codigo, titulo, genero, locado, anoLancamento, duracao);
		setCodigo(codigo);
		setTitulo(titulo);
		setGenero(genero);
		setLocado(locado);
		setAnoLancamento(anoLancamento);
		setDuracao(duracao);
		this.idiomas = idiomas;
	}

	public String[] getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String[] idiomas) {
		this.idiomas = idiomas;
	}

	@Override
	public double CalcularDiaria() {
		return 0;
	}

}
