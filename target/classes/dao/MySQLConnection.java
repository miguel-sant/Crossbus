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

    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static void main(String[] args) {

        Connection conexao = null;

        PreparedStatement stmt = null;

        try {

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            String sql = "INSERT INTO usuarios (nome, cargo, login, senha, email) VALUES (?, ?, ?, ?, ?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "Nome do Novo Usuário");
            stmt.setString(2, "Cargo do Novo Usuário");
            stmt.setString(3, "login_novo_usuario");
            stmt.setString(4, "senha_novo_usuario");
            stmt.setString(5, "email_novo_usuario");

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Novo usuário inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir novo usuário!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
     
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
