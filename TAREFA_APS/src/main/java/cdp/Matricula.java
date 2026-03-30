package cdp;

import java.util.Date;

public class Matricula {
    private int nota;
    private Date dataMatricula;

    public Matricula(int nota, Date dataMatricula){
        this.nota = nota;
        this.dataMatricula = dataMatricula;
    }

    public int getNota() {
        return nota;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
