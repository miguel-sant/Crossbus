package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author gabrielpaiva
 */
public class MySQLConnection {
    // Informações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USUARIO = "root";
    private static final String SENHA = "SetRootPasswordHere";

    public static void main(String[] args) {
        // Objeto de conexão
        Connection conexao = null;
        // Objeto de declaração para executar consultas SQL
        PreparedStatement stmt = null;

        try {
            // Estabelecer conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            // Query SQL para inserir um novo usuário
            String sql = "INSERT INTO usuarios (nome, cargo, login, senha, email) VALUES (?, ?, ?, ?, ?)";

            // Criar uma declaração preparada com parâmetros
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "Nome do Novo Usuário");
            stmt.setString(2, "Cargo do Novo Usuário");
            stmt.setString(3, "login_novo_usuario");
            stmt.setString(4, "senha_novo_usuario");
            stmt.setString(5, "email_novo_usuario");

            // Executar a declaração preparada para inserir o novo usuário
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Novo usuário inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir novo usuário!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar o objeto de conexão e declaração
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
