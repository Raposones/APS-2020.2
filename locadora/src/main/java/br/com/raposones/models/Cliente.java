package br.com.raposones.models;

public class Cliente extends Pessoa{
    
    private String endereco;
    private int idade;
    private String sexo;

    public Cliente(String nome, int matricula, String endereco, int idade, String sexo) {
        super(nome, matricula);
        setNome(nome);
        setMatricula(matricula);
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    
}
