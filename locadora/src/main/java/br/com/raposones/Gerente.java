package br.com.raposones;

public class Gerente extends Funcionario{

    public Gerente(String nome, int matricula, String login, String senha) {
        super(nome, matricula, login, senha);
        setNome(nome);
        setMatricula(matricula);
        setLogin(login);
        setSenha(senha);  
    }
    
    
}
