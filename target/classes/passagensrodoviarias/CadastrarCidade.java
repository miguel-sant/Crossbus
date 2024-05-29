/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static com.mysql.cj.conf.PropertyKey.USER;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class CadastrarCidade extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCidade
     */
    public CadastrarCidade() {
        initComponents();
        
        setTitle("CADASTRO DE CIDADE");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        cidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        sigla = new javax.swing.JLabel();
        campoSigla = new javax.swing.JTextField();
        uf = new javax.swing.JLabel();
        campoUf = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new java.awt.Color(51, 0, 204));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cidade.setBackground(new java.awt.Color(255, 255, 255));
        cidade.setForeground(new java.awt.Color(255, 255, 255));
        cidade.setText("Cidade");
        painel.add(cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));
        painel.add(campoCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 100, -1));

        sigla.setForeground(new java.awt.Color(255, 255, 255));
        sigla.setText("Sigla");
        painel.add(sigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));
        painel.add(campoSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 100, -1));

        uf.setForeground(new java.awt.Color(255, 255, 255));
        uf.setText("UF");
        painel.add(uf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));
        painel.add(campoUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 100, -1));

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        painel.add(btCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
                                                
        String url = "jdbc:mysql://localhost:3306/passagens";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO cidades (nome_cidade, sigla_ibge, uf) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, campoCidade.getText());
            statement.setString(2, campoSigla.getText());
            statement.setString(3, campoUf.getText());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
            }

            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cidade: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoSigla;
    private javax.swing.JTextField campoUf;
    private javax.swing.JLabel cidade;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel sigla;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
