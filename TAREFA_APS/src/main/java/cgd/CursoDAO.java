package cgd;

import cdp.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private Connection conexao;
    private PreparedStatement pstmt;
    private String sql;
    private Statement comando;
    private ResultSet rs;

    public CursoDAO() {
        Conexao driver;
        driver = new Conexao("meu_exemplo", "postgres", "isadora");
        conexao = driver.getConnection();
    }

    public int save(Curso curso) {
        int cod = -1;
        sql = "INSERT INTO curso (id, nome, carga_horaria) VALUES (?, ?, ?)";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, curso.getId());
            pstmt.setString(2, curso.getNomeCurso());
            pstmt.setInt(3, curso.getChCurso());
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar curso: " + e.getMessage());
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

    public Curso get(int id) {
        Curso curso = null;
        sql = "SELECT * FROM curso WHERE id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id_curso = rs.getInt("id");
                String nome = rs.getString("nome");
                int carga_horaria = rs.getInt("carga_horaria");
                curso = new Curso(id_curso, nome, carga_horaria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar curso: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                }
            }
        }
        return curso;
    }

    public List<Curso> getAll() {
        List<Curso> cursos = new ArrayList<>();
        sql = "SELECT * FROM curso";
        try {
            comando = conexao.createStatement();
            rs = comando.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int carga_horaria = rs.getInt("carga_horaria");
                cursos.add(new Curso(id, nome, carga_horaria));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        } finally {
            if (comando != null) {
                try {
                    comando.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar Statement: " + e.getMessage());
                }
            }
        }
        return cursos;
    }

    public int update(Curso curso) {
        int cod = -1;
        sql = "UPDATE curso SET nome = ?, carga_horaria = ? WHERE id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, curso.getNomeCurso());
            pstmt.setInt(2, curso.getChCurso());
            pstmt.setInt(3, curso.getId());
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar curso: " + e.getMessage());
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

    public int delete(int id) {
        int cod = -1;
        sql = "DELETE FROM curso WHERE id = ?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar curso: " + e.getMessage());
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
}

















