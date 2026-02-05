package cdp;

import java.util.Date;

public class Professor extends Pessoa {

    public Professor(String nome, Date dataNascimento, long CPF, String titulacao) {
        super(nome, dataNascimento, CPF);
        this.titulacao = titulacao;
    }

    private String titulacao;
}
