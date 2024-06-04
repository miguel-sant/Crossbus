/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author teste
 */
public class SelecionarCartao extends javax.swing.JFrame {

    /**
     * Creates new form SelecionarCartao
     */
   private ButtonGroup buttonGroup;
    private JButton btnConfirmar;
    private JLabel lblSelecionarCartao;
    private Connection connection;

    public SelecionarCartao() {
        initComponents();
        setSize(720, 560);
        connectToDatabase();
        loadCardsFromDatabase();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

       buttonGroup = new ButtonGroup();
        lblSelecionarCartao = new JLabel("Selecione um cartão:");
        btnConfirmar = new JButton("Confirmar");
        
        // Defina o layout
        setLayout(new GridLayout(0, 1));
        add(lblSelecionarCartao);
        add(btnConfirmar);

        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	 private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passagens", "root", "");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
	private void loadCardsFromDatabase() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dadoscartao");

            while (resultSet.next()) {
                String numeroCartao = resultSet.getString("numero_cartao");
                JRadioButton radioButton = new JRadioButton(numeroCartao);
                buttonGroup.add(radioButton);
                add(radioButton);
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao carregar os cartões do banco de dados: " + e.getMessage());
        }
    }
	
	private void btnConfirmarActionPerformed(ActionEvent evt) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                String numeroCartaoSelecionado = button.getText();
                // Faça algo com o cartão selecionado, como salvar no banco de dados ou prosseguir com a operação desejada
                System.out.println("Cartão selecionado: " + numeroCartaoSelecionado);
                break;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionarCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
