package cdp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas = new ArrayList<>();

    public Curso() {
        // construtor JPA
    }

    public Curso(int id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public String getNomeCurso() {
        return nome;
    }
    public int getChCurso(){
        return cargaHoraria;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
}
