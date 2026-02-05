package cdp;

import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private long CPF;

    public Pessoa(String nome, Date dataNascimento, long CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
    }


}
