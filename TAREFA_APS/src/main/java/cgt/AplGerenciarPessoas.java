package cgt;

import cdp.Aluno;
import cdp.Professor;

import java.util.ArrayList;
import java.util.Date;

public class AplGerenciarPessoas {
    private final ArrayList<Aluno> lstAlunos = new ArrayList();

    public int criarAluno(String nome, Date dataNascimento, long CPF){
        if (nome.length()>3){
            Aluno novoAluno = new Aluno(nome, dataNascimento, CPF);
            lstAlunos.add(novoAluno);
            return 0;
        }
        else
            return 1;
    }

    private final ArrayList<Professor> lstProfessores = new ArrayList();

    public int criarProfessor(String nome, Date dataNascimento, long CPF, String titulacao){
        if (nome.length()>3){
            Professor novoProf = new Professor(nome, dataNascimento, CPF, titulacao);
            lstProfessores.add(novoProf);
            return 0;
        }
        else
            return 1;
    }
}
