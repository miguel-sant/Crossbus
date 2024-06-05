/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author miguelvarjao
 */
public class TelaPagamento extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public TelaPagamento() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setSize(720, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ((AbstractDocument) jTextField1.getDocument()).setDocumentFilter(new NumberOnlyFilter(16));

    }
    class NumberOnlyFilter extends DocumentFilter {
    private int maxLength;

    public NumberOnlyFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
            AttributeSet attr) throws BadLocationException {
        String newText = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
            .insert(offset, text).toString();
        if (isNumber(text) && newText.replaceAll("\\D", "").length() <= maxLength) {
        StringBuilder formattedText = new StringBuilder();
        int count = 0;
        for (int i = 0; i < newText.length(); i++) {
            char c = newText.charAt(i);
            if (Character.isDigit(c)) {
                if (count > 0 && count % 4 == 0) {
                    formattedText.append("-");
                }
                formattedText.append(c);
                count++;
            }
        }
        super.insertString(fb, offset, formattedText.toString(), attr);
    }
    }

    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
        if (isNumber(text) && (fb.getDocument().getLength() + text.length() - length <= maxLength)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
    
    
    private boolean isNumber(String text) {
        return text != null && text.matches("\\d+");
    }
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAcessar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/card.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mastercard.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Pagamento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 124, -1, 30));

        jLabel4.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Número do cartão");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 239, -1));

        jLabel5.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nome do proprietário do cartão");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 239, -1));

        jLabel6.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mês");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 270, 60, -1));

        jLabel7.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ano");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 60, -1));

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 60, -1));

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 60, -1));

        jLabel8.setFont(new java.awt.Font("Jamrul", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CVC");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 60, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/credit-card.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        btnAcessar.setBackground(new java.awt.Color(102, 102, 255));
        btnAcessar.setForeground(new java.awt.Color(255, 255, 255));
        btnAcessar.setText("Salvar");
        btnAcessar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcessarMouseClicked(evt);
            }
        });
        btnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 170, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Adicionar novo cartão");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/back.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 60, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnAcessarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcessarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcessarMouseClicked

    private void btnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarActionPerformed
      String numeroCartao = jTextField1.getText().replaceAll("[^0-9]", "");
    String nomeProprietario = jTextField2.getText();
    String mesExpiracao = jTextField3.getText();
    String anoExpiracao = jTextField4.getText();
    String cvv = jTextField6.getText();
    int idUsuario = 1; // Defina o ID do usuário aqui
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passagens", "root", "")) {
        String sql = "INSERT INTO dadoscartao (numero_cartao, nome_proprietario, mes_expiracao, ano_expiracao, cvv, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numeroCartao);
            statement.setString(2, nomeProprietario);
            statement.setString(3, mesExpiracao);
            statement.setString(4, anoExpiracao);
            statement.setString(5, cvv);
            statement.setInt(6, idUsuario);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Dados do cartão salvos com sucesso!");
            } else {
                System.out.println("Falha ao salvar os dados do cartão.");
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAcessarActionPerformed
private void formatarNumeroCartao() {
    String texto = jTextField1.getText().replaceAll("[^0-9]", "");
    StringBuilder formato = new StringBuilder();
    
    for (int i = 0; i < texto.length(); i++) {
        if (i > 0 && i % 4 == 0) {
            formato.append("-");
        }
        formato.append(texto.charAt(i));
    }
    
    jLabel4.setText(formato.toString());
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
