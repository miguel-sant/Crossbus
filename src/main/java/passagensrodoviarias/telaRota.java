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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabrielpaiva
 */
public class telaRota extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    
    public telaRota() {
        initComponents();
        preencherComboBox(selectOrigem);
        preencherComboBox(selectDestino);
        preencherComboBoxOnibus(selectOnibus);
        carregarDadosTabela();
        
        
        setTitle("CADASTRAR ROTAS");
        setSize(1280, 860);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void atualizarTabelaRotas() {
        DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT destino, origem, data_de_partida, horas_da_partida, onibus, preco FROM viagens";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("destino"), rs.getString("origem"),
                            rs.getString("data_de_partida"), rs.getString("horas_da_partida"), rs.getString("onibus"),
                    rs.getDouble("preco")});
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar tabela de rotas: " + ex.getMessage());
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
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRotas = new javax.swing.JTable();
        selectOrigem = new javax.swing.JComboBox<>();
        selectDestino = new javax.swing.JComboBox<>();
        dataPartida = new javax.swing.JTextField();
        cadastrarRota = new javax.swing.JButton();
        horaPartida = new javax.swing.JTextField();
        valorRota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        selectOnibus = new javax.swing.JComboBox<>();
        atualizarRotas = new javax.swing.JButton();
        atualizarRota = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CROSSBUS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ROTAS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 220, -1));

        tableRotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origem", "Destino", "Data de partida", "Horas de partida", "Ônibus", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableRotas.setColumnSelectionAllowed(true);
        tableRotas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableRotas);
        tableRotas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 780, 480));

        selectOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectOrigemActionPerformed(evt);
            }
        });
        jPanel1.add(selectOrigem, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 120, -1));

        selectDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDestinoActionPerformed(evt);
            }
        });
        jPanel1.add(selectDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 120, -1));
        jPanel1.add(dataPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 90, -1));

        cadastrarRota.setText("Cadastrar");
        cadastrarRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarRotaActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrarRota, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, 100, 30));
        jPanel1.add(horaPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 70, -1));
        jPanel1.add(valorRota, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 70, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Origem");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Destino");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Horas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ônibus");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        selectOnibus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(selectOnibus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 110, -1));

        atualizarRotas.setText("Atualizar");
        atualizarRotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarRotasActionPerformed(evt);
            }
        });
        jPanel1.add(atualizarRotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 750, 110, 40));

        atualizarRota.setText("Excluir Rota");
        atualizarRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarRotaActionPerformed(evt);
            }
        });
        jPanel1.add(atualizarRota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 580, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDestinoActionPerformed

    }//GEN-LAST:event_selectDestinoActionPerformed

    private void selectOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectOrigemActionPerformed

    private void cadastrarRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarRotaActionPerformed
        String origem = selectOrigem.getSelectedItem().toString();
        String destino = selectDestino.getSelectedItem().toString();
        String onibus = selectOnibus.getSelectedItem().toString();
        String data = dataPartida.getText();
        String horas = horaPartida.getText();
        String valor = valorRota.getText();

        if (origem.equals("SELECIONE") || destino.equals("SELECIONE") || data.isEmpty() || horas.isEmpty() || valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para cadastrar a rota.");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO viagens (origem, destino, onibus, data_de_partida, horas_da_partida, preco) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, origem);
            stmt.setString(2, destino);
            stmt.setString(3, onibus);
            stmt.setString(4, data);
            stmt.setString(5, horas);
            stmt.setDouble(6, Double.parseDouble(valor));
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Rota cadastrada com sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar a rota: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        limparCampos();
        
    }//GEN-LAST:event_cadastrarRotaActionPerformed

    private void atualizarRotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarRotasActionPerformed
        atualizarTabelaRotas();
    }//GEN-LAST:event_atualizarRotasActionPerformed

    private void atualizarRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarRotaActionPerformed
        excluirDados();
    }//GEN-LAST:event_atualizarRotaActionPerformed
    private void carregarDadosTabela() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT origem, destino, data_de_partida, horas_da_partida, onibus, preco FROM viagens";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                try (ResultSet rs = pstmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        Object[] rowData = {
                            rs.getString("origem"),
                            rs.getString("destino"),
                            rs.getString("data_de_partida"),
                            rs.getString("horas_da_partida"),
                            rs.getString("onibus"),
                            rs.getDouble("preco")
                        };
                        model.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados da tabela: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparCampos() {
        selectOrigem.setSelectedIndex(0);
        selectDestino.setSelectedIndex(0);
        dataPartida.setText("");
        horaPartida.setText("");
        valorRota.setText("");
    }

    /**
     * @param args the command line arguments
     */
    private void preencherComboBoxes() {
        preencherComboBox(selectOrigem);
        preencherComboBox(selectDestino);
    }
    
    private void preencherComboBox(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/passagens";
            String user = "root";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT nome_cidade, uf FROM cidades";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("SELECIONE");

            while (rs.next()) {
                String cidade = rs.getString("nome_cidade");
                String uf = rs.getString("uf");
                String cidadeUf = cidade + "-" + uf;
                comboBox.addItem(cidadeUf);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher ComboBox: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void preencherComboBoxOnibus(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/passagens";
            String user = "root";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT numero FROM veiculos";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            comboBox.removeAllItems();
            comboBox.addItem("SELECIONE");

            while (rs.next()) {
                String numeroOnibus = rs.getString("numero");
                comboBox.addItem(numeroOnibus);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher ComboBox de Ônibus: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private int getLinhaSelecionada() {
        return tableRotas.getSelectedRow();
    }
    
    private void excluirDados() {
        int linhaSelecionada = getLinhaSelecionada();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esta rota?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
        int idRota = Integer.parseInt((String) model.getValueAt(linhaSelecionada, 0));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM viagens WHERE id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idRota);

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(telaRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaRota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarRota;
    private javax.swing.JButton atualizarRotas;
    private javax.swing.JButton cadastrarRota;
    private javax.swing.JTextField dataPartida;
    private javax.swing.JTextField horaPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectDestino;
    private javax.swing.JComboBox<String> selectOnibus;
    private javax.swing.JComboBox<String> selectOrigem;
    private javax.swing.JTable tableRotas;
    private javax.swing.JTextField valorRota;
    // End of variables declaration//GEN-END:variables
}
