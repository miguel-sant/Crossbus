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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabrielpaiva
 */
public class telaRota extends javax.swing.JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
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
        ((DefaultTableCellRenderer)tableRotas.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0; i<tableRotas.getColumnCount(); i++) {
            tableRotas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
    }
    
    public void atualizarTabelaRotas() {
        DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT id_cidade_origem, id_cidade_destino, data_saida, hora_saida, id_veiculo, valor_passagem, poltrona FROM passagens";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id_cidade_origem"), rs.getInt("id_cidade_destino"),
                        rs.getDate("data_saida"), rs.getTime("hora_saida"), 
                        rs.getInt("id_veiculo"), rs.getDouble("valor_passagem"),
                        rs.getInt("poltrona")
                    });
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
        excluirRota = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();

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
                "Origem", "Destino", "Data de partida", "Horas de partida", "Ônibus", "Valor", "Poltronas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
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

        excluirRota.setText("Excluir Rota");
        excluirRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirRotaActionPerformed(evt);
            }
        });
        jPanel1.add(excluirRota, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 580, 110, 40));

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 110, 40));

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

        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Ônibus: " + onibus);
        System.out.println("Data: " + data);
        System.out.println("Horas: " + horas);
        System.out.println("Valor: " + valor);

        if (origem.equals("SELECIONE") || destino.equals("SELECIONE") || onibus.equals("SELECIONE") || data.isEmpty() || horas.isEmpty() || valor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para cadastrar a rota.");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            int origemId = getCidadeId(origem);
            int destinoId = getCidadeId(destino);
            int onibusId = getVeiculoId(onibus);
            int qtdPoltronas = getQtdPoltronas(onibusId);

            System.out.println("ID de Origem: " + origemId);
            System.out.println("ID de Destino: " + destinoId);
            System.out.println("ID do Ônibus: " + onibusId);
            System.out.println("Quantidade de Poltronas: " + qtdPoltronas);

            String sql = "INSERT INTO passagens (id_cidade_origem, id_cidade_destino, id_veiculo, data_saida, hora_saida, valor_passagem, poltrona) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, origemId);
            stmt.setInt(2, destinoId);
            stmt.setInt(3, onibusId);

            try {
                DateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = inputDateFormat.parse(data);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                DateFormat inputTimeFormat = new SimpleDateFormat("HH:mm");
                java.util.Date utilTime = inputTimeFormat.parse(horas);
                java.sql.Time sqlTime = new java.sql.Time(utilTime.getTime());
          
                stmt.setDate(4, sqlDate);
                stmt.setTime(5, sqlTime);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de data ou hora inválido. Use o formato DD/MM/YYYY para a data e HH:MM para a hora.");
                return;
            }
            
            stmt.setDouble(6, Double.parseDouble(valor));
            stmt.setInt(7, qtdPoltronas);
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

    private void excluirRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirRotaActionPerformed
        int selectedRow = tableRotas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma rota para excluir.");
            return;
        }

        int origem = (int) tableRotas.getValueAt(selectedRow, 0);
        int destino = (int) tableRotas.getValueAt(selectedRow, 1);
        java.sql.Date dataPartida = java.sql.Date.valueOf(tableRotas.getValueAt(selectedRow, 2).toString());
        java.sql.Time horasPartida = java.sql.Time.valueOf(tableRotas.getValueAt(selectedRow, 3).toString());
        int onibus = (int) tableRotas.getValueAt(selectedRow, 4);

        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esta rota?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "DELETE FROM passagens WHERE id_cidade_origem = ? AND id_cidade_destino = ? AND data_saida = ? AND hora_saida = ? AND id_veiculo = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, origem);
                    pstmt.setInt(2, destino);
                    pstmt.setDate(3, dataPartida);
                    pstmt.setTime(4, horasPartida);
                    pstmt.setInt(5, onibus);
                    pstmt.executeUpdate();
                }

                DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Rota excluída com sucesso.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir a rota: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_excluirRotaActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonVoltarActionPerformed
    private void carregarDadosTabela() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT origem.nome_cidade AS origem, destino.nome_cidade AS destino, data_saida, hora_saida, id_veiculo, valor_passagem, poltrona " +
                         "FROM passagens " +
                         "JOIN cidades AS origem ON passagens.id_cidade_origem = origem.id " +
                         "JOIN cidades AS destino ON passagens.id_cidade_destino = destino.id";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) tableRotas.getModel();
                    model.setRowCount(0);
                    while (rs.next()) {
                        String cidadeOrigem = rs.getString("origem");
                        String cidadeDestino = rs.getString("destino");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String dataSaidaFormatted = dateFormat.format(rs.getDate("data_saida"));
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                        String horaSaidaFormatted = timeFormat.format(rs.getTime("hora_saida"));
                        int idVeiculo = rs.getInt("id_veiculo");
                        String valorPassagemFormatted = "R$ " + String.format("%.2f", rs.getDouble("valor_passagem"));
                        int poltrona = rs.getInt("poltrona");
                        Object[] rowData = {cidadeOrigem, cidadeDestino, dataSaidaFormatted, horaSaidaFormatted, idVeiculo, valorPassagemFormatted, poltrona};
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
   
    
    private int getCidadeId(String cidadeUf) {
        String[] partes = cidadeUf.split("-");
        String cidade = partes[0];
        String uf = partes[1];

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT id FROM cidades WHERE nome_cidade = ? AND uf = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, cidade);
                pstmt.setString(2, uf);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("id");
                    } else {
                        throw new SQLException("Cidade não encontrada.");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    private int getVeiculoId(String onibusNumero) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT id FROM veiculos WHERE numero = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, onibusNumero);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("id");
                    } else {
                        throw new SQLException("Ônibus não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    private void preencherComboBox(JComboBox<String> comboBox) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/passagens";
            String user = "root";
            String password = "";

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
            String password = "";

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
    
    private int getQtdPoltronas(int veiculoId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT qtd_poltronas FROM veiculos WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, veiculoId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("qtd_poltronas");
                    } else {
                        throw new SQLException("Veículo não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaRota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarRotas;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton cadastrarRota;
    private javax.swing.JTextField dataPartida;
    private javax.swing.JButton excluirRota;
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
