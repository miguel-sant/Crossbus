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
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class telaCompraPassagem extends javax.swing.JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/passagens";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public telaCompraPassagem() {
        initComponents();
        setTitle("CADASTRAR ROTAS");
        setSize(1280, 860);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ((DefaultTableCellRenderer)tablePassagens.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0; i<tablePassagens.getColumnCount(); i++) {
            tablePassagens.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePassagens = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buscarDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buscarOrigem = new javax.swing.JTextField();
        buscarPassagens = new javax.swing.JButton();
        botaoComprar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CROSSBUS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));

        jPanel1.setBackground(new java.awt.Color(51, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CROSSBUS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 64)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Passagens");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        tablePassagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Origem", "Destino", "Data de partida", "Horas de partida", "Ônibus", "Valor", "Poltronas livres"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablePassagens.setColumnSelectionAllowed(true);
        tablePassagens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePassagens);
        tablePassagens.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 780, 480));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Destino");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        buscarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDestinoActionPerformed(evt);
            }
        });
        jPanel1.add(buscarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Origem");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        buscarOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarOrigemActionPerformed(evt);
            }
        });
        jPanel1.add(buscarOrigem, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 160, -1));

        buscarPassagens.setText("Buscar");
        buscarPassagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPassagensActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPassagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, -1, -1));

        botaoComprar.setText("Comprar");
        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 800, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDestinoActionPerformed

    }//GEN-LAST:event_buscarDestinoActionPerformed

    private void buscarPassagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPassagensActionPerformed
        String origem = buscarOrigem.getText().trim();
        String destino = buscarDestino.getText().trim();
        String query = "SELECT passagens.*, veiculos.numero AS numero_onibus, origem.nome_cidade AS origem_cidade, destino.nome_cidade AS destino_cidade " +
                       "FROM passagens " +
                       "JOIN veiculos ON passagens.id_veiculo = veiculos.id " +
                       "JOIN cidades origem ON passagens.id_cidade_origem = origem.id " +
                       "JOIN cidades destino ON passagens.id_cidade_destino = destino.id " +
                       "WHERE origem.nome_cidade LIKE ? AND destino.nome_cidade LIKE ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + origem + "%");
            preparedStatement.setString(2, "%" + destino + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) tablePassagens.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    String valorFormatado = "R$ " + String.format("%.2f", resultSet.getDouble("valor_passagem"));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String dataFormatada = dateFormat.format(resultSet.getDate("data_saida"));
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
                    String horaFormatada = timeFormat.format(resultSet.getTime("hora_saida"));
                    Object[] row = {
                        resultSet.getInt("id"),
                        resultSet.getString("origem_cidade"),
                        resultSet.getString("destino_cidade"),
                        dataFormatada,
                        horaFormatada,
                        resultSet.getString("numero_onibus"),
                        valorFormatado,
                        resultSet.getInt("poltrona")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buscarPassagensActionPerformed

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarActionPerformed
  int selectedRow = tablePassagens.getSelectedRow();
    if (selectedRow != -1) {
        int id = (int) tablePassagens.getValueAt(selectedRow, 0);
        SelecionarPoltrona telaSelecionarPoltrona = new SelecionarPoltrona(id);
        telaSelecionarPoltrona.setVisible(true);
    } else {
        System.out.println("Nenhuma linha selecionada.");
    }
    }//GEN-LAST:event_botaoComprarActionPerformed

    private void buscarOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarOrigemActionPerformed

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
            java.util.logging.Logger.getLogger(telaCompraPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCompraPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCompraPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCompraPassagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCompraPassagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoComprar;
    private javax.swing.JTextField buscarDestino;
    private javax.swing.JTextField buscarOrigem;
    private javax.swing.JButton buscarPassagens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePassagens;
    // End of variables declaration//GEN-END:variables
}
