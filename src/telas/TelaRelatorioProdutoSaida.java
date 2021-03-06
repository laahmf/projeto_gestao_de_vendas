/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import bd.DAOException;
import bd.EstoqueSaidaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.EstoqueSaida;

/**
 *
 * @author Lauren
 */
public class TelaRelatorioProdutoSaida extends javax.swing.JFrame {

    private EstoqueSaidaDAO estoqueSaidaDAO;
    /**
     * Creates new form TelaRelatorioProdutoSaida
     */
    public TelaRelatorioProdutoSaida() throws SQLException {
        initComponents();
        estoqueSaidaDAO = new EstoqueSaidaDAO();
        populateTblEstoqueSaida();
    }
    
    private void populateTblEstoqueSaida(){
        try {
            ((DefaultTableModel) tblRelatorioSaida.getModel()).setRowCount(0);
            ArrayList<EstoqueSaida> saidasDeEstoque = estoqueSaidaDAO.buscar();
            for (EstoqueSaida estoqueSaida : saidasDeEstoque) {
                Object[] objs = {estoqueSaida.getProduto().toString(),
                    estoqueSaida.getQuantidade(), estoqueSaida.getDataSaida(),
                    estoqueSaida.getMotivoSaida()
                };
                ((DefaultTableModel) tblRelatorioSaida.getModel()).addRow(objs);
            }
        } catch (DAOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados!");
            ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorioSaida = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        lblRelatorioSaidadeProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblRelatorioSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Qtde", "Data de Saida", "Motivo da Saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRelatorioSaida);
        if (tblRelatorioSaida.getColumnModel().getColumnCount() > 0) {
            tblRelatorioSaida.getColumnModel().getColumn(1).setMaxWidth(50);
            tblRelatorioSaida.getColumnModel().getColumn(3).setMinWidth(200);
        }

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblRelatorioSaidadeProduto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblRelatorioSaidadeProduto.setText("RELATORIO SAIDA DE PRODUTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRelatorioSaidadeProduto)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblRelatorioSaidadeProduto)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       this.populateTblEstoqueSaida();
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorioProdutoSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioProdutoSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioProdutoSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioProdutoSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaRelatorioProdutoSaida().setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar no banco!");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRelatorioSaidadeProduto;
    private javax.swing.JTable tblRelatorioSaida;
    // End of variables declaration//GEN-END:variables
}
