package cgt;

import cdp.Aluno;
import cdp.Professor;
import cgd.AlunoDAO;
import cgd.ProfessorDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.Normalizer;

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

    public List<Aluno> buscarAlunos(String criterio, String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return listarAlunos();
        }

        String pesquisa = valor.trim();
        String campo = normalizar(criterio);
        switch (campo) {
            case "nome":
                return alunoDAO.findByNome(pesquisa);
            case "cpf":
                try {
                    return alunoDAO.findByCpf(Long.parseLong(pesquisa));
                } catch (NumberFormatException ex) {
                    return new ArrayList<>();
                }
            case "nascimento":
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    Date data = sdf.parse(pesquisa);
                    return alunoDAO.findByDataNascimento(data);
                } catch (ParseException ex) {
                    return new ArrayList<>();
                }
            default:
                return listarAlunos();
        }
    }

    public List<Professor> buscarProfessores(String criterio, String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return listarProfessores();
        }

        String pesquisa = valor.trim();
        String campo = normalizar(criterio);
        switch (campo) {
            case "professor":
                return professorDAO.findByNome(pesquisa);
            case "cpf":
                try {
                    return professorDAO.findByCpf(Long.parseLong(pesquisa));
                } catch (NumberFormatException ex) {
                    return new ArrayList<>();
                }
            case "titulo":
                return professorDAO.findByTitulacao(pesquisa);
            case "nascimento":
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    Date data = sdf.parse(pesquisa);
                    return professorDAO.findByDataNascimento(data);
                } catch (ParseException ex) {
                    return new ArrayList<>();
                }
            default:
                return listarProfessores();
        }
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return "";
        }

        String semAcentos = Normalizer.normalize(valor, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "");
        return semAcentos.trim().toLowerCase();
    }
}
