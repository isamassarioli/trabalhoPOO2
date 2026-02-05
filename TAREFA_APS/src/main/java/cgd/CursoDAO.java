package cgd;

import cdp.Curso;

import java.sql.*;

public class CursoDAO {
    private Connection conexao;
    private PreparedStatement pstmt;
    private String sql;
    private Statement comando;
    private ResultSet rs;

    public CursoDAO() {
        Conexao driver;
        // TODO: no primeiro parâmetro você vai colocar o nome do seu banco de dados
        driver = new Conexao("meu_exemplo", "postgres", "postgre");
        conexao = driver.getConnection();
    }

    public int save(Curso curso) {
        int cod = -1;
        // TODO: essas três colunas são da tabela curso (o arquivo dela está na cgd)
        sql = "insert into curso (id, nome, carga_horaria) values (?, ?, ?)";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, curso.getId());
            pstmt.setString(2, curso.getNomeCurso());
            pstmt.setInt(3, curso.getChCurso());
            cod = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: SQL inválido: " + e.getMessage());
        }
        return cod;
    }

    public Curso get(String id) {
        Curso curso = null;
        sql = "select * from curso = '" + id + "'";
        try {
            comando = conexao.createStatement();
            rs = comando.executeQuery(sql);
            if (rs.next()) {
                int id_curso = rs.getInt("id");
                String nome = rs.getString("nome");
                int carga_horaria = rs.getInt("carga_horaria");
                curso = new Curso(id_curso, nome, carga_horaria);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: SQL inválido: " + e.getMessage());
        }
        return curso;
    }
}

















