package cgt;

import java.util.ArrayList;
import java.util.Date;
import cgd.CursoDAO;
import cgd.TurmaDAO;

import cdp.Curso;
import cdp.Turma;


public class AplGerenciarCurso {
    private final CursoDAO cursoDAO = new CursoDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();

    public int criarCurso(int IdCurso, String nome, int cargaHoraria){
        if (nome.length()>3){
            Curso novo = new Curso(IdCurso, nome, cargaHoraria);
            cursoDAO.save(novo);
            return 0;
        }
        else
            return 1;
    }

    public int criarTurma(String horario, int limiteAlunos, boolean fechada, Date dataInicio, Date dataFim){
        if (horario.length()>3){
            Turma novaTurma = new Turma(horario, limiteAlunos, fechada, dataInicio, dataFim);
            return 0;
        }
        else
            return 1;
    }

}
