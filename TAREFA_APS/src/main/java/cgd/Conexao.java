
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
           System.out.println("✓ Conexão estabelecida com sucesso ao banco: " + banco);
       } catch (ClassNotFoundException e) {
           System.out.println("❌ Erro: Driver PostgreSQL não encontrado.\n" + e.getMessage());
           e.printStackTrace();
       } catch (SQLException e) {
           System.out.println("❌ Erro de conexão com banco de dados.");
           System.out.println("   Banco: " + banco);
           System.out.println("   Usuário: " + usuario);
           System.out.println("   Mensagem: " + e.getMessage());
           e.printStackTrace();
       }
       return conexao;
   }
}














