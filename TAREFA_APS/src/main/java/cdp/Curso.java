package cdp;

public class Curso {
    private final int id;
    private String nome;
    private int cargaHoraria;

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
}
