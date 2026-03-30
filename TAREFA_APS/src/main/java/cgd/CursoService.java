package cgd;

import cdp.Curso;
import java.util.List;

public class CursoService {

    public String salvar(int idCurso, String nome, int cargaHoraria) {
        int cod;
        String resposta = "FALHA NA INSERCAO/ALTERACAO DE CURSO!";
        if (nome.isEmpty()) {
            resposta = "ERRO: NOME CURSO NÃO informado.";
        } else {
            CursoDAO cdao = new CursoDAO();
            Curso curso = new Curso(idCurso, nome, cargaHoraria);
            Curso cursoExistente = cdao.get(idCurso);

            if (cursoExistente == null) {
                // O CURSO NÃO existe. INSERIR.
                cod = cdao.save(curso);
                if (cod == 1) {
                    resposta = "CURSO INSERIDO COM SUCESSO.";
                }
            } else {
                // O CURSO JÁ EXISTE. ATUALIZAR.
                cod = cdao.update(curso);
                if (cod == 1) {
                    resposta = "CURSO ATUALIZADO COM SUCESSO.";
                }
            }
        }
        return resposta;
    }

    public List<Curso> listarTodos() {
        CursoDAO cdao = new CursoDAO();
        return cdao.getAll();
    }

    public Curso obter(int id) {
        CursoDAO cdao = new CursoDAO();
        return cdao.get(id);
    }

    public String deletar(int id) {
        CursoDAO cdao = new CursoDAO();
        int cod = cdao.delete(id);
        if (cod == 1) {
            return "CURSO DELETADO COM SUCESSO.";
        }
        return "FALHA AO DELETAR CURSO!";
    }
}