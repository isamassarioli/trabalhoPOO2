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

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public long getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
}
