/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passagensrodoviarias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gabrielpaiva
 */
public class BancoDeDados {
     // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USUARIO = "root";
    private static final String SENHA = "SetRootPasswordHere";

    public static boolean inserirDadosNoBanco(String login, String senha, String nome, String email) {
        // Define a flag para indicar se o cadastro foi bem-sucedido
        boolean cadastradoComSucesso = false;

        // Define a instrução SQL para inserir os dados na tabela
        String sql = "INSERT INTO usuarios (login, senha, nome, email) VALUES (?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            // Define os valores dos parâmetros da instrução SQL
            statement.setString(1, login);
            statement.setString(2, senha);
            statement.setString(3, nome);
            statement.setString(4, email);

            // Executa a instrução SQL para inserir os dados
            int linhasAfetadas = statement.executeUpdate();

            // Verifica se algum registro foi inserido
            if (linhasAfetadas > 0) {
                cadastradoComSucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cadastradoComSucesso;
    }
}
