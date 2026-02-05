package cgd;

import cdp.Curso;


public class CursoService {

    public String salvar(int idCurso, String nome, int cargaHoraria) {
        int cod;
        String resposta = "FALHA NA INSERCAO/ALTERACAO DE CURSO!";
        if (nome.isEmpty()) {
            resposta = "ERRO: NOME CURSO NÃO informado.";
        } else {
            //Verificando se CURSO já existe
            CursoDAO cdao = new CursoDAO();
            Curso c;
            Curso curso = new Curso(idCurso, nome, cargaHoraria);

            c = cdao.get(String.valueOf(curso.getId()));

            if (c == null) {
                //O CURSO NÃO existe AINDA. Decisão: INSERIR.
                cod = cdao.save(curso);

                if (cod == 1) resposta = "CURSO INSERIDO COM SUCESSO.";

            } else {
                //O CURSO JÁ EXISTE.

            }

        }
        return resposta;
    }
}