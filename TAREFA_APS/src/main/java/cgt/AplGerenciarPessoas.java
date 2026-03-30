package cgt;

import cdp.Aluno;
import cdp.Professor;
import cgd.AlunoDAO;
import cgd.ProfessorDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AplGerenciarPessoas {
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    public int criarAluno(String nome, Date dataNascimento, long CPF){
        if (nome.length()>3){
            Aluno novoAluno = new Aluno(nome, dataNascimento, CPF);
            alunoDAO.save(novoAluno);
            return 0;
        }
        else
            return 1;
    }

    public int criarProfessor(String nome, Date dataNascimento, long CPF, String titulacao){
        if (nome.length()>3){
            Professor novoProf = new Professor(nome, dataNascimento, CPF, titulacao);
            professorDAO.save(novoProf);
            return 0;
        }
        else
            return 1;
    }
    
    public List<Aluno> listarAlunos(){
        return alunoDAO.getAll();
    }
    
    public List<Professor> listarProfessores(){
        return professorDAO.getAll();
    }
}
