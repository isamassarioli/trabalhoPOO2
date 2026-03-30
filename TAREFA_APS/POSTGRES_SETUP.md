# Integração PostgreSQL - TAREFA_APS

## Configuração do Banco de Dados

### 1. Pré-requisitos
- PostgreSQL 12+ instalado
- Usuário PostgreSQL com permissões de criação de banco de dados

### 2. Criar o banco de dados

```sql
-- Conectar como superusuário (padrão: postgres)
CREATE DATABASE meu_exemplo OWNER postgres;
```

### 3. Executar o script SQL

Abra o arquivo `src/main/java/cgd/meu_exemplo.sql` no gerenciador do PostgreSQL (pgAdmin, DBeaver, etc.) e execute todas as instruções, ou via terminal:

```bash
psql -U postgres -d meu_exemplo -f src/main/java/cgd/meu_exemplo.sql
```

### 4. Configurar credenciais

Os DAOs usam as seguintes credenciais padrão (localizado em `cgd/Conexao.java`):
- **Banco**: `meu_exemplo`
- **Usuário**: `postgres`
- **Senha**: `postgre`

Para alterar, modifique os parâmetros ao instanciar a classe `Conexao`:
```java
Conexao driver = new Conexao("nome_banco", "usuario", "senha");
```

## Estrutura de Dados

### Tabelas

1. **pessoa** - Base para Aluno e Professor
   - cpf (PK)
   - nome
   - data_nascimento

2. **aluno** - Herda de pessoa
   - cpf (PK, FK → pessoa)

3. **professor** - Herda de pessoa
   - cpf (PK, FK → pessoa)
   - titulacao

4. **curso**
   - id (PK)
   - nome
   - carga_horaria

5. **turma**
   - id (PK, Auto-increment)
   - horario
   - limite_alunos
   - fechada
   - data_inicio
   - data_fim
   - curso_id (FK → curso)
   - professor_cpf (FK → professor)

6. **matricula** - Relação Aluno ↔ Turma
   - aluno_cpf (PK, FK → aluno)
   - turma_id (PK, FK → turma)
   - nota
   - data_matricula

## DAOs Disponíveis

Todos os DAOs encontram-se em `src/main/java/cgd/`:

### CursoDAO
```java
CursoDAO dao = new CursoDAO();
dao.save(curso);          // Inserir
Curso c = dao.get(1);     // Buscar por ID
List<Curso> todos = dao.getAll();  // Listar todos
dao.update(curso);        // Atualizar
dao.delete(1);            // Deletar
```

### AlunoDAO
```java
AlunoDAO dao = new AlunoDAO();
dao.save(aluno);          // Inserir
Aluno a = dao.get(12345678901L);  // Buscar por CPF
List<Aluno> todos = dao.getAll();  // Listar todos
dao.update(aluno);        // Atualizar
dao.delete(12345678901L); // Deletar
```

### ProfessorDAO
```java
ProfessorDAO dao = new ProfessorDAO();
dao.save(professor);      // Inserir
Professor p = dao.get(98765432101L);  // Buscar por CPF
List<Professor> todos = dao.getAll();  // Listar todos
dao.update(professor);    // Atualizar
dao.delete(98765432101L); // Deletar
```

### TurmaDAO
```java
TurmaDAO dao = new TurmaDAO();
dao.save(turma);          // Inserir
Turma t = dao.get(1);     // Buscar por ID
List<Turma> todas = dao.getAll();  // Listar todas
dao.update(turma, 1);     // Atualizar (precisa do ID da turma)
dao.delete(1);            // Deletar
```

### MatriculaDAO
```java
MatriculaDAO dao = new MatriculaDAO();
dao.save(matricula, alunoCpf, turmaId);  // Inserir
Matricula m = dao.get(12345678901L, 1);  // Buscar matrícula específica
List<Matricula> doAluno = dao.getAlunoMatriculas(12345678901L);  // Matrículas do aluno
List<Matricula> daTurma = dao.getTurmaMatriculas(1);  // Matrículas da turma
dao.update(matricula, alunoCpf, turmaId);  // Atualizar nota
dao.delete(alunoCpf, turmaId);  // Deletar matrícula
int total = dao.getAlunosMatriculados(turmaId);  // Contar alunos em turma
```

## Exemplo de Uso Completo

```java
import cdp.*;
import cgd.*;
import java.util.Date;

public class ExemploUso {
    public static void main(String[] args) {
        // Criar e salvar um curso
        Curso curso = new Curso(1, "Java Avançado", 40);
        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.save(curso);

        // Criar e salvar um professor
        Professor prof = new Professor("João Silva", new Date(), 12345678901L, "Mestrado");
        ProfessorDAO profDAO = new ProfessorDAO();
        profDAO.save(prof);

        // Criar e salvar uma turma
        Turma turma = new Turma("14:00-15:30", 30, false, new Date(), new Date(), curso, prof);
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.save(turma);

        // Criar e salvar um aluno
        Aluno aluno = new Aluno("Maria Santos", new Date(), 98765432101L);
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.save(aluno);

        // Matricular aluno em turma
        Matricula matricula = new Matricula(0, new Date());
        MatriculaDAO matriculaDAO = new MatriculaDAO();
        matriculaDAO.save(matricula, aluno.getCPF(), 1); // turmaId = 1 (assumindo auto-incremented)

        // Atualizar nota
        Matricula m = matriculaDAO.get(aluno.getCPF(), 1);
        if (m != null) {
            m.setNota(85);
            matriculaDAO.update(m, aluno.getCPF(), 1);
        }
    }
}
```

## Tratamento de Erros

Todos os DAOs implementam tratamento básico de exceções SQL. Para logging mais detalhado, considere:
1. Adicionar um logger (SLF4J, Log4j)
2. Implementar uma classe de exceção customizada
3. Adicionar pool de conexões (HikariCP) para melhor desempenho

## Próximos Passos

1. **Validação de dados**: Adicionar validações nas camadas de serviço
2. **Pool de conexões**: Implementar HikariCP para melhor performance
3. **Transações**: Adicionar suporte a múltiplas operações em uma transação
4. **Interface gráfica**: Atualizar as janelas do Swing para usar os novos DAOs
