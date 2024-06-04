/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author teste
 */
public class SelecionarPoltrona extends javax.swing.JFrame {
     private int idPassagem; // Adiciona o campo idPassagem
    /**
     * Creates new form SelecionarPoltrona
     */
    public SelecionarPoltrona(int idPassagem) {
        this.idPassagem = idPassagem;
        initComponents();
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     public static void atualizarCorBotao(int numeroPoltrona, JButton botao) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passagens", "root", "")) {
            // SQL para recuperar o estado da poltrona do banco de dados
            String sql = "SELECT poltrona_comprada FROM passagens WHERE poltrona = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Define o número da poltrona na consulta SQL
                statement.setInt(1, numeroPoltrona);
                
                // Executa a consulta
                ResultSet resultSet = statement.executeQuery();
                
                // Se houver resultados, atualiza a cor do botão de acordo com o estado da poltrona
                if (resultSet.next()) {
                    int poltronaComprada = resultSet.getInt("poltrona_comprada");
                    if (poltronaComprada == 1) {
                        botao.setBackground(Color.RED);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botao33 = new javax.swing.JButton();
        botao1 = new javax.swing.JButton();
        botao5 = new javax.swing.JButton();
        botao9 = new javax.swing.JButton();
        botao13 = new javax.swing.JButton();
        botao17 = new javax.swing.JButton();
        botao21 = new javax.swing.JButton();
        botao25 = new javax.swing.JButton();
        botao29 = new javax.swing.JButton();
        botao34 = new javax.swing.JButton();
        botao30 = new javax.swing.JButton();
        botao26 = new javax.swing.JButton();
        botao22 = new javax.swing.JButton();
        botao18 = new javax.swing.JButton();
        botao14 = new javax.swing.JButton();
        botao10 = new javax.swing.JButton();
        botao6 = new javax.swing.JButton();
        botao2 = new javax.swing.JButton();
        botao35 = new javax.swing.JButton();
        botao36 = new javax.swing.JButton();
        botao32 = new javax.swing.JButton();
        botao31 = new javax.swing.JButton();
        botao27 = new javax.swing.JButton();
        botao28 = new javax.swing.JButton();
        botao24 = new javax.swing.JButton();
        botao23 = new javax.swing.JButton();
        botao19 = new javax.swing.JButton();
        botao20 = new javax.swing.JButton();
        botao16 = new javax.swing.JButton();
        botao15 = new javax.swing.JButton();
        botao11 = new javax.swing.JButton();
        botao12 = new javax.swing.JButton();
        botao8 = new javax.swing.JButton();
        botao7 = new javax.swing.JButton();
        botao3 = new javax.swing.JButton();
        botao4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CROSSBUS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 27, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FundoOnibusCompra.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        botao33.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao33.setText("34");
        botao33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao33ActionPerformed(evt);
            }
        });
        jPanel1.add(botao33, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 40, 30));

        botao1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao1.setText("1");
        botao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1ActionPerformed(evt);
            }
        });
        jPanel1.add(botao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 40, 30));

        botao5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao5.setText("5");
        botao5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao5ActionPerformed(evt);
            }
        });
        jPanel1.add(botao5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 40, 30));

        botao9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao9.setText("9");
        botao9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao9ActionPerformed(evt);
            }
        });
        jPanel1.add(botao9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 40, 30));

        botao13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao13.setText("13");
        botao13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao13ActionPerformed(evt);
            }
        });
        jPanel1.add(botao13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 40, 30));

        botao17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao17.setText("17");
        botao17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao17ActionPerformed(evt);
            }
        });
        jPanel1.add(botao17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 40, 30));

        botao21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao21.setText("21");
        botao21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao21ActionPerformed(evt);
            }
        });
        jPanel1.add(botao21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 40, 30));

        botao25.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao25.setText("25");
        botao25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao25ActionPerformed(evt);
            }
        });
        jPanel1.add(botao25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 40, 30));

        botao29.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao29.setText("29");
        botao29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao29ActionPerformed(evt);
            }
        });
        jPanel1.add(botao29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 40, 30));

        botao34.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao34.setText("34");
        botao34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao34ActionPerformed(evt);
            }
        });
        jPanel1.add(botao34, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 40, 30));

        botao30.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao30.setText("30");
        botao30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao30ActionPerformed(evt);
            }
        });
        jPanel1.add(botao30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 40, 30));

        botao26.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao26.setText("26");
        botao26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao26ActionPerformed(evt);
            }
        });
        jPanel1.add(botao26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 40, 30));

        botao22.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao22.setText("22");
        botao22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao22ActionPerformed(evt);
            }
        });
        jPanel1.add(botao22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 40, 30));

        botao18.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao18.setText("18");
        botao18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao18ActionPerformed(evt);
            }
        });
        jPanel1.add(botao18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 40, 30));

        botao14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao14.setText("14");
        botao14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao14ActionPerformed(evt);
            }
        });
        jPanel1.add(botao14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 40, 30));

        botao10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao10.setText("10");
        botao10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao10ActionPerformed(evt);
            }
        });
        jPanel1.add(botao10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 40, 30));

        botao6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao6.setText("6");
        botao6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao6ActionPerformed(evt);
            }
        });
        jPanel1.add(botao6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 40, 30));

        botao2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao2.setText("2");
        botao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2ActionPerformed(evt);
            }
        });
        jPanel1.add(botao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 40, 30));

        botao35.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao35.setText("35");
        botao35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao35ActionPerformed(evt);
            }
        });
        jPanel1.add(botao35, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 40, 30));

        botao36.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao36.setText("36");
        botao36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao36ActionPerformed(evt);
            }
        });
        jPanel1.add(botao36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 40, 30));

        botao32.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao32.setText("32");
        botao32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao32ActionPerformed(evt);
            }
        });
        jPanel1.add(botao32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 40, 30));

        botao31.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao31.setText("31");
        botao31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao31ActionPerformed(evt);
            }
        });
        jPanel1.add(botao31, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 40, 30));

        botao27.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao27.setText("27");
        botao27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao27ActionPerformed(evt);
            }
        });
        jPanel1.add(botao27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 40, 30));

        botao28.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao28.setText("28");
        botao28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao28ActionPerformed(evt);
            }
        });
        jPanel1.add(botao28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 40, 30));

        botao24.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao24.setText("24");
        botao24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao24ActionPerformed(evt);
            }
        });
        jPanel1.add(botao24, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 40, 30));

        botao23.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao23.setText("23");
        botao23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao23ActionPerformed(evt);
            }
        });
        jPanel1.add(botao23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 40, 30));

        botao19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao19.setText("19");
        botao19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao19ActionPerformed(evt);
            }
        });
        jPanel1.add(botao19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 40, 30));

        botao20.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao20.setText("20");
        botao20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao20ActionPerformed(evt);
            }
        });
        jPanel1.add(botao20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 40, 30));

        botao16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao16.setText("16");
        botao16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao16ActionPerformed(evt);
            }
        });
        jPanel1.add(botao16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 40, 30));

        botao15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao15.setText("15");
        botao15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao15ActionPerformed(evt);
            }
        });
        jPanel1.add(botao15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 40, 30));

        botao11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao11.setText("11");
        botao11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao11ActionPerformed(evt);
            }
        });
        jPanel1.add(botao11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 40, 30));

        botao12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao12.setText("12");
        botao12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao12ActionPerformed(evt);
            }
        });
        jPanel1.add(botao12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 40, 30));

        botao8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao8.setText("8");
        botao8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao8ActionPerformed(evt);
            }
        });
        jPanel1.add(botao8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 40, 30));

        botao7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao7.setText("7");
        botao7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao7ActionPerformed(evt);
            }
        });
        jPanel1.add(botao7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 40, 30));

        botao3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao3.setText("3");
        botao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao3ActionPerformed(evt);
            }
        });
        jPanel1.add(botao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 40, 30));

        botao4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        botao4.setText("4");
        botao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao4ActionPerformed(evt);
            }
        });
        jPanel1.add(botao4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 638));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao33ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 33; 
    
    botao33.setBackground(Color.RED); // Define a cor de fundo do botão como vermelho
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao33ActionPerformed

    private void botao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao1ActionPerformed
         int numeroPoltronaSelecionada = 1;
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao1ActionPerformed

    private void botao5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao5ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 5; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao5ActionPerformed

    private void botao9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao9ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 9; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao9ActionPerformed

    private void botao13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao13ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 13; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao13ActionPerformed

    private void botao17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao17ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 17; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao17ActionPerformed

    private void botao21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao21ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 21; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao21ActionPerformed

    private void botao25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao25ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 25; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao25ActionPerformed

    private void botao29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao29ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 29; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao29ActionPerformed

    private void botao34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao34ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 34; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao34ActionPerformed

    private void botao30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao30ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 30; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao30ActionPerformed

    private void botao26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao26ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 26;
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao26ActionPerformed

    private void botao22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao22ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 22; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao22ActionPerformed

    private void botao18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao18ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 18; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao18ActionPerformed

    private void botao14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao14ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 14; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao14ActionPerformed

    private void botao10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao10ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 10; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao10ActionPerformed

    private void botao6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao6ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 6; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao6ActionPerformed

    private void botao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao2ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 2; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao2ActionPerformed

    private void botao35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao35ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 35; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao35ActionPerformed

    private void botao36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao36ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 36; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao36ActionPerformed

    private void botao32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao32ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 32; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao32ActionPerformed

    private void botao31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao31ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 31; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao31ActionPerformed

    private void botao27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao27ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 27;
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao27ActionPerformed

    private void botao28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao28ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 28; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao28ActionPerformed

    private void botao24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao24ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 24; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao24ActionPerformed

    private void botao23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao23ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 23; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao23ActionPerformed

    private void botao19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao19ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 19; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao19ActionPerformed

    private void botao20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao20ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 20; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao20ActionPerformed

    private void botao16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao16ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 16; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao16ActionPerformed

    private void botao15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao15ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 15; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao15ActionPerformed

    private void botao11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao11ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 11;
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao11ActionPerformed

    private void botao12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao12ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 12; 
    
   
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao12ActionPerformed

    private void botao8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao8ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 8;
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao8ActionPerformed

    private void botao7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao7ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 7; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao7ActionPerformed

    private void botao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao3ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 3; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao3ActionPerformed

    private void botao4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao4ActionPerformed
        // TODO add your handling code here:
         int numeroPoltronaSelecionada = 4; 
    
    dispose();
    TelaPagamento telaPagamento = new TelaPagamento();
    telaPagamento.setVisible(true);
    }//GEN-LAST:event_botao4ActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionarPoltrona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarPoltrona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarPoltrona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarPoltrona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionarPoltrona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao1;
    private javax.swing.JButton botao10;
    private javax.swing.JButton botao11;
    private javax.swing.JButton botao12;
    private javax.swing.JButton botao13;
    private javax.swing.JButton botao14;
    private javax.swing.JButton botao15;
    private javax.swing.JButton botao16;
    private javax.swing.JButton botao17;
    private javax.swing.JButton botao18;
    private javax.swing.JButton botao19;
    private javax.swing.JButton botao2;
    private javax.swing.JButton botao20;
    private javax.swing.JButton botao21;
    private javax.swing.JButton botao22;
    private javax.swing.JButton botao23;
    private javax.swing.JButton botao24;
    private javax.swing.JButton botao25;
    private javax.swing.JButton botao26;
    private javax.swing.JButton botao27;
    private javax.swing.JButton botao28;
    private javax.swing.JButton botao29;
    private javax.swing.JButton botao3;
    private javax.swing.JButton botao30;
    private javax.swing.JButton botao31;
    private javax.swing.JButton botao32;
    private javax.swing.JButton botao33;
    private javax.swing.JButton botao34;
    private javax.swing.JButton botao35;
    private javax.swing.JButton botao36;
    private javax.swing.JButton botao4;
    private javax.swing.JButton botao5;
    private javax.swing.JButton botao6;
    private javax.swing.JButton botao7;
    private javax.swing.JButton botao8;
    private javax.swing.JButton botao9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
