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
    private static final String PASSWORD = "password";
    
    public telaOnibus() {
        initComponents();
       
        carregarDadosTabela();
        setTitle("INFORMAÇÕES DOS ÔNIBUS");
        setSize(1280, 860);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseClicked(evt);
            }
        });
     
    }
    
    private void tableVeiculosMouseClicked(java.awt.event.MouseEvent evt) {
        // se o click for igual a duas vezes
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
                    // Jogar dados da celula qtd poltronas para esquerda.
                    tableVeiculos.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
                        {
                            setHorizontalAlignment(SwingConstants.LEFT);
                        }
                    });
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
                // Preenche a tabela com os dados dos veículos
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

        tituloEmpresa = new javax.swing.JLabel();
        tituloTela = new javax.swing.JLabel();
        painel = new javax.swing.JPanel();
        numero = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        placa = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JTextField();
        motorista = new javax.swing.JLabel();
        campoMotorista = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        resultConsulta = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 255));
        setMinimumSize(new java.awt.Dimension(1280, 860));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloEmpresa.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        tituloEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        tituloEmpresa.setText("CROSSBUS");
        getContentPane().add(tituloEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        tituloTela.setFont(new java.awt.Font("Segoe UI Black", 0, 64)); // NOI18N
        tituloTela.setForeground(new java.awt.Color(255, 255, 255));
        tituloTela.setText("Veículos");
        getContentPane().add(tituloTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        painel.setBackground(new java.awt.Color(51, 0, 204));
        painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numero.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        numero.setForeground(new java.awt.Color(255, 255, 255));
        numero.setText("Número");
        painel.add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        campoNumero.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumeroActionPerformed(evt);
            }
        });
        painel.add(campoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 120, -1));

        placa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        placa.setForeground(new java.awt.Color(255, 255, 255));
        placa.setText("Placa");
        painel.add(placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, -1, -1));

        campoPlaca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        campoPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPlacaActionPerformed(evt);
            }
        });
        painel.add(campoPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 130, -1));

        motorista.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        motorista.setForeground(new java.awt.Color(255, 255, 255));
        motorista.setText("Motorista");
        painel.add(motorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, -1, -1));
        painel.add(campoMotorista, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 240, 40));

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        painel.add(btConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 240, 110, 40));

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        painel.add(btAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 400, 110, 40));

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        painel.add(btAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 510, 110, 40));

        btExcluir.setText("Excluir veículo");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        painel.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, 110, 40));

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        painel.add(btVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 720, 110, 40));

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
        resultConsulta.setViewportView(tableVeiculos);
        tableVeiculos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        painel.add(resultConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 780, 480));

        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPlacaActionPerformed

    }//GEN-LAST:event_campoPlacaActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        
        CadastrarVeiculos cadastrarVeiculos = new CadastrarVeiculos();
        cadastrarVeiculos.setVisible(true);
        
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void campoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumeroActionPerformed
       
    }//GEN-LAST:event_campoNumeroActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed

        String numero = campoNumero.getText().trim();
        String placa = campoPlaca.getText().trim();
        String motorista = campoMotorista.getText().trim();

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT numero, placa, motorista, qtd_poltronas FROM veiculos WHERE 1=1");
        List<Object> params = new ArrayList<>();
        
        if (!numero.isEmpty()) {
            sqlBuilder.append(" AND numero LIKE ?");
            params.add("%" + numero + "%"); // Adiciona o caractere '%' para pesquisar por substrings
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
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excluirDados();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
         atualizarTabelaVeiculos();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private int getLinhaSelecionada() {
        return tableVeiculos.getSelectedRow();
    }
    
    private void excluirDados() {
        // Obter a linha selecionada
        int linhaSelecionada = getLinhaSelecionada();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar exclusão com o usuário
        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este veículo?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return; // Cancelar exclusão se o usuário escolher não
        }

        // Obter os dados associados à linha selecionada
        DefaultTableModel model = (DefaultTableModel) tableVeiculos.getModel();
        String numero = (String) model.getValueAt(linhaSelecionada, 0); // Supondo que o número do veículo esteja na primeira coluna

        // Conectar ao banco de dados e excluir os dados
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Instrução SQL para excluir os dados
            String sql = "DELETE FROM veiculos WHERE numero = ?";

            // Preparar a instrução SQL
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, numero);

                // Executar a instrução SQL
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Dados excluídos com sucesso.");
                    // Recarregar os dados na tabela
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
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField campoMotorista;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JLabel motorista;
    private javax.swing.JLabel numero;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel placa;
    private javax.swing.JScrollPane resultConsulta;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JLabel tituloEmpresa;
    private javax.swing.JLabel tituloTela;
    // End of variables declaration//GEN-END:variables

}
