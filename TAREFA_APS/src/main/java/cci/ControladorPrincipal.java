
package cci;

import javax.swing.JOptionPane;

import cgt.AplGerenciarCurso;
import cgt.AplGerenciarPessoas;
import cdp.Aluno;
import cdp.Curso;
import cdp.Professor;
import cdp.Turma;
import ciu.JanCadAluno;
import ciu.JanCadAlunoTurma;
import ciu.JanCadCurso;
import ciu.JanCadProfessor;
import ciu.JanCadTurma;
import ciu.JanPrincipal;
import ciu.JanListAluno;
import ciu.JanListProf;
import ciu.JanListCurso;
import ciu.JanListTurma;

import java.util.Date;


public class ControladorPrincipal {

    /**
     * @param args the command line arguments
     */
    private static JanPrincipal janPrincipal;
    private static JanCadCurso janCadCurso;
    private static JanCadTurma janCadTurma;
    private static JanCadAluno janCadAluno;
    private static JanCadProfessor janCadProfessor;
    private static JanListAluno janListAluno;
    private static JanListProf janListProf;
    private static JanListCurso janListCurso;
    private static JanListTurma janListTurma;
    private static JanCadAlunoTurma janCadAlunoTurma;
    private static AplGerenciarCurso aplGerenciarCurso;
    private static AplGerenciarPessoas aplGerenciarPessoas;
    private static final ControladorPrincipal controlador = new ControladorPrincipal();


    public static void main(String[] args) {
        // TODO code application logic here
        exibirJanPrincipal();
    }


    public static void exibirJanPrincipal() {
        if (janPrincipal == null)
            janPrincipal = new JanPrincipal(controlador);
        janPrincipal.setVisible(true);

    }

    public static void exibirJanCadCurso() {
        if (janCadCurso == null)
            janCadCurso = new JanCadCurso(controlador);
        janPrincipal.setVisible(false);
        janCadCurso.setVisible(true);

    }

    public static void exibirJanCadAluno() {
        if (janCadAluno == null)
            janCadAluno = new JanCadAluno(controlador);
        janPrincipal.setVisible(false);
        janCadAluno.setVisible(true);

    }

    public static void exibirJanCadProfessor() {
        if (janCadProfessor == null)
            janCadProfessor = new JanCadProfessor(controlador);
        janPrincipal.setVisible(false);
        janCadProfessor.setVisible(true);

    }

    public static void exibirJanCadTurma() {
        if (janCadTurma == null)
            janCadTurma = new JanCadTurma(controlador);
        else
            janCadTurma.recarregarDados();
        janPrincipal.setVisible(false);
        janCadTurma.setVisible(true);
    }

    public static void exibirJanListAluno() {
        if (aplGerenciarPessoas == null)
            aplGerenciarPessoas = new AplGerenciarPessoas();
        
        if (janListAluno == null)
            janListAluno = new JanListAluno(aplGerenciarPessoas);
        else
            janListAluno.recarregarDados();
        janPrincipal.setVisible(false);
        janListAluno.setVisible(true);
    }

    public static void exibirJanListProf() {
        if (aplGerenciarPessoas == null)
            aplGerenciarPessoas = new AplGerenciarPessoas();
        
        if (janListProf == null)
            janListProf = new JanListProf(aplGerenciarPessoas);
        else
            janListProf.recarregarDados();
        janPrincipal.setVisible(false);
        janListProf.setVisible(true);
    }

    public static void exibirJanListCurso() {
        if (aplGerenciarPessoas == null)
            aplGerenciarPessoas = new AplGerenciarPessoas();
        
        if (janListCurso == null)
            janListCurso = new JanListCurso(aplGerenciarPessoas);
        else
            janListCurso.recarregarDados();
        janPrincipal.setVisible(false);
        janListCurso.setVisible(true);
    }

    public static void exibirJanListTurma() {
        if (aplGerenciarCurso == null)
            aplGerenciarCurso = new AplGerenciarCurso();

        if (janListTurma == null)
            janListTurma = new JanListTurma(aplGerenciarCurso);
        else
            janListTurma.recarregarDados();
        janPrincipal.setVisible(false);
        janListTurma.setVisible(true);
    }

    public static void exibirJanCadAlunoTurma() {
        if (aplGerenciarCurso == null)
            aplGerenciarCurso = new AplGerenciarCurso();
        if (aplGerenciarPessoas == null)
            aplGerenciarPessoas = new AplGerenciarPessoas();

        if (janCadAlunoTurma == null)
            janCadAlunoTurma = new JanCadAlunoTurma(controlador, aplGerenciarCurso, aplGerenciarPessoas);
        else
            janCadAlunoTurma.recarregarDados();
        janPrincipal.setVisible(false);
        janCadAlunoTurma.setVisible(true);
    }

    public void cadastrarCurso(int IdCurso, String nome, int cargaHoraria) {
        if (aplGerenciarCurso == null) 
            aplGerenciarCurso = new AplGerenciarCurso();
        int r = (aplGerenciarCurso.criarCurso(IdCurso, nome, cargaHoraria));
            if (r == 0) {
                JOptionPane.showMessageDialog(null, "Curso criado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                janCadCurso.dispose();
                janPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O nome do curso deve ter ao menos 4 caracteres", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        
    }

    public void cadastrarAluno(String nome, Date dataNascimento, long CPF) {
        if (aplGerenciarPessoas == null) 
            aplGerenciarPessoas = new AplGerenciarPessoas();
            int a = aplGerenciarPessoas.criarAluno(nome, dataNascimento, CPF);
            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                janCadAluno.dispose();
                janPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O nome do aluno deve ter ao menos 4 caracteres", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        
    }


    public void cadastrarProfessor(String nome, Date dataNascimento, long CPF, String titulacao) {
        if (aplGerenciarPessoas == null) 
            aplGerenciarPessoas = new AplGerenciarPessoas();
            int p = aplGerenciarPessoas.criarProfessor(nome, dataNascimento, CPF, titulacao);
            if (p == 0) {
                JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                janCadProfessor.dispose();
                janPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O nome do professor deve ter ao menos 4 caracteres", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        
    }

    public void cadastrarTurma(String nome, int limiteAlunos, boolean fechada, Date dataInicio, Date dataFim) {
        if (aplGerenciarCurso == null) 
            aplGerenciarCurso = new AplGerenciarCurso();
            int g = aplGerenciarCurso.criarTurma(nome, limiteAlunos, fechada, dataInicio, dataFim);
            if (g == 0) {
                JOptionPane.showMessageDialog(null, "Turma criado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                janCadTurma.dispose();
                janPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O nome da turma deve ter ao menos 4 caracteres", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        
    }

    public void cadastrarTurma(String horario, int limiteAlunos, boolean fechada, Date dataInicio, Date dataFim, int cursoId, long professorCpf) {
        if (aplGerenciarCurso == null)
            aplGerenciarCurso = new AplGerenciarCurso();

        int g = aplGerenciarCurso.criarTurma(horario, limiteAlunos, fechada, dataInicio, dataFim, cursoId, professorCpf);
        if (g == 0) {
            JOptionPane.showMessageDialog(null, "Turma criada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            janCadTurma.dispose();
            janPrincipal.setVisible(true);
        } else if (g == 2) {
            JOptionPane.showMessageDialog(null, "Curso ou professor inválido", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "O horário da turma deve ter ao menos 4 caracteres", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int matricularAlunoEmTurma(int turmaId, long alunoCpf) {
        if (aplGerenciarCurso == null)
            aplGerenciarCurso = new AplGerenciarCurso();
        return aplGerenciarCurso.matricularAlunoEmTurma(turmaId, alunoCpf);
    }

}
