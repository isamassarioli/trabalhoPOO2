package cdp;

import java.util.Date;

public class Professor extends Pessoa {

    private String titulacao;

    public Professor(String nome, Date dataNascimento, long CPF, String titulacao) {
        super(nome, dataNascimento, CPF);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
