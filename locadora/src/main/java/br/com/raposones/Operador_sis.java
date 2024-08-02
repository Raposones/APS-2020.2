package br.com.raposones;

public class Operador_sis extends Funcionario{

    public Operador_sis(String nome, int matricula, String login, String senha) {
        super(nome, matricula, login, senha);
        setNome(nome);
        setMatricula(matricula);
        setLogin(login);
        setSenha(senha);
    }
    
    
}
