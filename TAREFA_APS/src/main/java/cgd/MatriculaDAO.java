package cgd;

import cdp.Matricula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {
    private Connection conexao;
    private PreparedStatement pstmt;
    private String sql;
    private Statement comando;
    private ResultSet rs;

    public MatriculaDAO() {
        Conexao driver = new Conexao("meu_exemplo", "postgres", "isadora");
        conexao = driver.getConnection();
    }

    public int save(Matricula matricula, long alunoCpf, int turmaId) {
        int cod = -1;
        sql = "INSERT INTO matricula (aluno_cpf, turma_id, nota, data_matricula) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, alunoCpf);
            pstmt.setInt(2, turmaId);
            pstmt.setInt(3, matricula != null ? matricula.getNota() : 0);
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar matrícula: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return cod;
    }

    public Matricula get(long alunoCpf, int turmaId) {
        Matricula matricula = null;
        sql = "SELECT * FROM matricula WHERE aluno_cpf = ? AND turma_id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, alunoCpf);
            pstmt.setInt(2, turmaId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int nota = rs.getInt("nota");
                java.sql.Timestamp timestamp = rs.getTimestamp("data_matricula");
                java.util.Date dataMatricula = new java.util.Date(timestamp.getTime());
                matricula = new Matricula(nota, dataMatricula);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar matrícula: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return matricula;
    }

    public List<Matricula> getAlunoMatriculas(long alunoCpf) {
        List<Matricula> matriculas = new ArrayList<>();
        sql = "SELECT * FROM matricula WHERE aluno_cpf = ? ORDER BY data_matricula DESC";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, alunoCpf);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int nota = rs.getInt("nota");
                java.sql.Timestamp timestamp = rs.getTimestamp("data_matricula");
                java.util.Date dataMatricula = new java.util.Date(timestamp.getTime());
                matriculas.add(new Matricula(nota, dataMatricula));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar matrículas do aluno: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return matriculas;
    }

    public List<Matricula> getTurmaMatriculas(int turmaId) {
        List<Matricula> matriculas = new ArrayList<>();
        sql = "SELECT * FROM matricula WHERE turma_id = ? ORDER BY data_matricula DESC";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, turmaId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int nota = rs.getInt("nota");
                java.sql.Timestamp timestamp = rs.getTimestamp("data_matricula");
                java.util.Date dataMatricula = new java.util.Date(timestamp.getTime());
                matriculas.add(new Matricula(nota, dataMatricula));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar matrículas da turma: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return matriculas;
    }

    public int update(Matricula matricula, long alunoCpf, int turmaId) {
        int cod = -1;
        sql = "UPDATE matricula SET nota = ? WHERE aluno_cpf = ? AND turma_id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, matricula.getNota());
            pstmt.setLong(2, alunoCpf);
            pstmt.setInt(3, turmaId);
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar matrícula: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return cod;
    }

    public int delete(long alunoCpf, int turmaId) {
        int cod = -1;
        sql = "DELETE FROM matricula WHERE aluno_cpf = ? AND turma_id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, alunoCpf);
            pstmt.setInt(2, turmaId);
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar matrícula: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return cod;
    }

    public int getAlunosMatriculados(int turmaId) {
        int quantidade = 0;
        sql = "SELECT COUNT(*) as total FROM matricula WHERE turma_id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, turmaId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                quantidade = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao contar alunos: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return quantidade;
    }
}
