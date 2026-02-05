
package cgd;

import java.sql.*;

public class Conexao {
   private final String banco;
   private final String usuario;
   private final String senha;

    public Conexao(String banco, String user, String password){
       this.banco = banco;
       this.usuario = user;
       this.senha = password;
    }
   
   public Connection getConnection() {
       Connection conexao = null;
       try {
           String url = "jdbc:postgresql://localhost:5432/" + banco;
           Class.forName("org.postgresql.Driver");
           conexao = DriverManager.getConnection(url, usuario, senha);
       } catch (ClassNotFoundException e) {
           System.out.println("Erro: ODBC Não encontrado.\n" + e.getMessage());
       } catch (SQLException e) {
           System.out.println("Erro: SQL inválido.\n" + e.getMessage());
       }
       return conexao;
   }
}














