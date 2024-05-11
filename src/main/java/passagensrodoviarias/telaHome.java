/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

/**
 *
 * @author gabrielpaiva
 */
import javax.swing.JOptionPane;
public class telaHome extends javax.swing.JFrame {
    
    /**
     * Creates new form telaHome
     */
    public telaHome() {
        initComponents();
         setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeDoUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        manterVeiculos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nomeDoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MENU");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CROSSBUS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        Logout.setText("Sair");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 780, 150, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.magenta, java.awt.Color.magenta, java.awt.Color.magenta, java.awt.Color.magenta));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("VEICULOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel7.setText("VIAGENS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, -1));

        jLabel10.setText("PASSAGENS VENDIDAS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 140, 20));

        jLabel12.setText("FATURAMENTO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        manterVeiculos.setIcon(new javax.swing.ImageIcon("C:\\Users\\gabri\\OneDrive\\Documentos\\PassagensRodoviarias\\src\\main\\java\\imagens\\bus-stop.png")); // NOI18N
        manterVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manterVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manterVeiculosMouseClicked(evt);
            }
        });
        jPanel1.add(manterVeiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\gabri\\OneDrive\\Documentos\\PassagensRodoviarias\\src\\main\\java\\imagens\\ponteiro-de-parada-de-onibus(1).png")); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\gabri\\OneDrive\\Documentos\\PassagensRodoviarias\\src\\main\\java\\imagens\\grafico-de-crescimento.png")); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\gabri\\OneDrive\\Documentos\\PassagensRodoviarias\\src\\main\\java\\imagens\\forma-de-pagamento(1).png")); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 120, 100));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 780, 470));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação de Logout", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            this.dispose();

            telaLogin login = new telaLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void manterVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manterVeiculosMouseClicked
        telaOnibus telaOnibus = new telaOnibus();
        telaOnibus.setVisible(true);
    }//GEN-LAST:event_manterVeiculosMouseClicked

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
            java.util.logging.Logger.getLogger(telaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel manterVeiculos;
    private javax.swing.JLabel nomeDoUsuario;
    // End of variables declaration//GEN-END:variables
}