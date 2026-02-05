package cdp;

import java.util.Date;
import ciu.JanCadTurma;

public class Turma {
    private String horario;
    private int limiteAlunos;
    private boolean fechada;
    private Date dataInicio;
    private Date dataFim;
    private JanCadTurma janCadTurma;

    public Turma(String horario, int limiteAlunos, boolean fechada, Date dataInicio, Date dataFim) {
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.fechada = fechada;
        this.horario = horario;
        this.limiteAlunos = 40;
    }
    }
