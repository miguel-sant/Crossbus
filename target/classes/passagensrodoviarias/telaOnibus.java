/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passagensrodoviarias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALUNO TI
 */
public class telaOnibus extends javax.swing.JFrame {

    /**
     * Creates new form telaOnibus
     */
    
    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
   public telaOnibus() {
        initComponents();
       
        carregarDadosTabela();
        setTitle("INFORMAÇÕES DOS ÔNIBUS");
        setSize(1280, 860);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((DefaultTableCellRenderer)tableVeiculos.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0; i<tableVeiculos.getColumnCount(); i++) {
            tableVeiculos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseClicked(evt);
            }
        });
     
    }
    
    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = tableVeiculos.getSelectedRow();
            if (linhaSelecionada != -1) {
                DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
                String numero = (String) model.getValueAt(linhaSelecionada, 0);

                int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este veículo?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    
                    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                        
                        String sql = "DELETE FROM veiculos WHERE numero = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            
                            pstmt.setString(1, numero);
                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(this, "Dados excluídos com sucesso.");
                                carregarDadosTabela();
                            } else {
                                JOptionPane.showMessageDialog(this, "Nenhum dado foi excluído.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Erro ao excluir dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    
    private void carregarDadosTabela() {
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT numero, placa, motorista, qtd_poltronas FROM veiculos";
         
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
                try (ResultSet rs = pstmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        Object[] rowData = {rs.getString("numero"), rs.getString("placa"), rs.getString("motorista"), rs.getInt("qtd_poltronas")};
                        model.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados da tabela: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void atualizarTabelaVeiculos() {
        DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT numero, placa, modelo, motorista, qtd_poltronas FROM veiculos";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("numero"), rs.getString("placa"),
                            rs.getString("modelo"), rs.getString("motorista"), rs.getInt("qtd_poltronas")});
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar tabela de veículos: " + ex.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        searchNumero = new javax.swing.JTextField();
        searchPlaca = new javax.swing.JTextField();
        excluirVeiculo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();
        buttonVoltar = new javax.swing.JButton();
        adicionarOnibus = new javax.swing.JButton();
        searchVeiculo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchMotorista = new javax.swing.JTextField();
        atualizarTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 255));
        setMinimumSize(new java.awt.Dimension(1280, 860));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CROSSBUS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Placa");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        searchNumero.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNumeroActionPerformed(evt);
            }
        });
        jPanel1.add(searchNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 120, -1));

        searchPlaca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        searchPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(searchPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 130, -1));

        excluirVeiculo.setText("Excluir veículo");
        excluirVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirVeiculoActionPerformed(evt);
            }
        });
        jPanel1.add(excluirVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, 110, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Veículos");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Placa", "Motorista", "QtdPoltrona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableVeiculos.setColumnSelectionAllowed(true);
        tableVeiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableVeiculos);
        tableVeiculos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 780, 480));

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 110, 40));

        adicionarOnibus.setText("Adicionar");
        adicionarOnibus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarOnibusActionPerformed(evt);
            }
        });
        jPanel1.add(adicionarOnibus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 400, 110, 40));

        searchVeiculo.setText("Consultar");
        searchVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchVeiculoActionPerformed(evt);
            }
        });
        jPanel1.add(searchVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 240, 110, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Motorista");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));
        jPanel1.add(searchMotorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 240, 40));

        atualizarTable.setText("Atualizar");
        atualizarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTableActionPerformed(evt);
            }
        });
        jPanel1.add(atualizarTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 510, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPlacaActionPerformed

    }//GEN-LAST:event_searchPlacaActionPerformed

    private void adicionarOnibusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarOnibusActionPerformed
        CadastrarVeiculos cadastrarVeiculos = new CadastrarVeiculos();
        cadastrarVeiculos.setVisible(true); 
    }//GEN-LAST:event_adicionarOnibusActionPerformed

    private void searchNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNumeroActionPerformed
       
    }//GEN-LAST:event_searchNumeroActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void searchVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchVeiculoActionPerformed
        String numero = searchNumero.getText().trim();
        String placa = searchPlaca.getText().trim();
        String motorista = searchMotorista.getText().trim();

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT numero, placa, motorista, qtd_poltronas FROM veiculos WHERE 1=1");
        List<Object> params = new ArrayList<>();
        
        if (!numero.isEmpty()) {
            sqlBuilder.append(" AND numero LIKE ?");
            params.add("%" + numero + "%");
        }
        if (!placa.isEmpty()) {
            sqlBuilder.append(" AND placa LIKE ?");
            params.add("%" + placa + "%");
        }
        if (!motorista.isEmpty()) {
            sqlBuilder.append(" AND motorista LIKE ?");
            params.add("%" + motorista + "%");
        }
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString())) {
                
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            
                try (ResultSet rs = pstmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        Object[] rowData = {rs.getString("numero"), rs.getString("placa"), rs.getString("motorista"), rs.getInt("qtd_poltronas")};
                        model.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao executar consulta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchVeiculoActionPerformed

    private void excluirVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirVeiculoActionPerformed
        excluirDados();
    }//GEN-LAST:event_excluirVeiculoActionPerformed

    private void atualizarTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTableActionPerformed
         atualizarTabelaVeiculos();
    }//GEN-LAST:event_atualizarTableActionPerformed

    private int getLinhaSelecionada() {
        return tableVeiculos.getSelectedRow();
    }
    
    private void excluirDados() {
        int linhaSelecionada = getLinhaSelecionada();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este veículo?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
        String numero = (String) model.getValueAt(linhaSelecionada, 0);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM veiculos WHERE numero = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, numero);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Dados excluídos com sucesso.");
                    carregarDadosTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum dado foi excluído.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(telaOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaOnibus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaOnibus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarOnibus;
    private javax.swing.JButton atualizarTable;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton excluirVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchMotorista;
    private javax.swing.JTextField searchNumero;
    private javax.swing.JTextField searchPlaca;
    private javax.swing.JButton searchVeiculo;
    private javax.swing.JTable tableVeiculos;
    // End of variables declaration//GEN-END:variables

}
