package cgt;

import java.util.ArrayList;
import java.util.Date;
import cgd.CursoDAO;
import cgd.TurmaDAO;
import cgd.ProfessorDAO;

import cdp.Curso;
import cdp.Professor;
import cdp.Turma;
import java.util.List;


public class AplGerenciarCurso {
    private final CursoDAO cursoDAO = new CursoDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();

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
            turmaDAO.save(novaTurma);
            return 0;
        }
        else
            return 1;
    }

    public int criarTurma(String horario, int limiteAlunos, boolean fechada, Date dataInicio, Date dataFim, int cursoId, long professorCpf){
        if (horario == null || horario.trim().length() < 4) {
            return 1;
        }

        Curso curso = cursoDAO.get(cursoId);
        Professor professor = professorDAO.get(professorCpf);
        if (curso == null || professor == null) {
            return 2;
        }

        Turma novaTurma = new Turma(horario, limiteAlunos, fechada, dataInicio, dataFim, curso, professor);
        turmaDAO.save(novaTurma);
        return 0;
    }

    public List<Curso> listarCursos() {
        return cursoDAO.getAll();
    }

    public List<Professor> listarProfessores() {
        return professorDAO.getAll();
    }

    public List<Turma> listarTurmas() {
        return turmaDAO.getAll();
    }

    public int matricularAlunoEmTurma(int turmaId, long alunoCpf) {
        return turmaDAO.adicionarAlunoTurma(turmaId, alunoCpf);
    }

}
