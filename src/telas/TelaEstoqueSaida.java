/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import bd.DAOException;
import bd.EstoqueSaidaDAO;
import bd.ProdutoDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.EstoqueSaida;
import modelos.Produto;

/**
 *
 * @author Lauren
 */
public class TelaEstoqueSaida extends javax.swing.JFrame {

    private final EstoqueSaidaDAO estoqueSaidaDAO;
    private final ProdutoDAO produtoDAO;
    private Produto produtoSelecionado;

    /**
     * Creates new form TelaCadastroEstoqueSaida
     */
    public TelaEstoqueSaida() throws SQLException {
        initComponents();
        estoqueSaidaDAO = new EstoqueSaidaDAO();
        produtoDAO = new ProdutoDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtIdProdutoSaida = new javax.swing.JTextField();
        lblCadastroEstoqueSaida = new javax.swing.JLabel();
        lblIdProdutoSaida = new javax.swing.JLabel();
        lblDataSaida = new javax.swing.JLabel();
        txtQuantidadeEstoque = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtProdutoSelecionado = new javax.swing.JTextField();
        txtDataSaida = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        lblMotivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalvar.setText("Registrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Quantidade");

        lblCadastroEstoqueSaida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCadastroEstoqueSaida.setText("SA??DA DE ESTOQUE");

        lblIdProdutoSaida.setText("Id Produto");

        lblDataSaida.setText("Data de Sa??da");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtProdutoSelecionado.setEditable(false);
        txtProdutoSelecionado.setFocusable(false);

        try {
            txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Descri????o Produto");

        lblMotivo.setText("Motivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(lblCadastroEstoqueSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtProdutoSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIdProdutoSaida)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtIdProdutoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscar))))
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblQuantidade))
                            .addGap(56, 56, 56)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDataSaida))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMotivo)
                                .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCadastroEstoqueSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblIdProdutoSaida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProdutoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProdutoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(lblDataSaida)
                    .addComponent(lblMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(btnSalvar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar() {
        txtIdProdutoSaida.setText("");
        txtProdutoSelecionado.setText("");
        txtDataSaida.setValue(null);
        txtQuantidadeEstoque.setText("");
        txtMotivo.setText("");
        produtoSelecionado = null;
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String quantidade = txtQuantidadeEstoque.getText();
            String dataSaida = txtDataSaida.getText();
            String motivo = txtMotivo.getText();
            if (produtoSelecionado != null && !quantidade.equals("") && 
                    txtDataSaida.getValue() != null && !motivo.equals("")) {
                EstoqueSaida e = new EstoqueSaida(produtoSelecionado, Integer.parseInt(quantidade), dataSaida, motivo);
                this.estoqueSaidaDAO.incluir(e);
                JOptionPane.showMessageDialog(null, "Saida de estoque registrada com sucesso!");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            }
        } catch (DAOException | SQLException e1) {
            JOptionPane.showMessageDialog(null, "Erro na conex??o com o Banco de dados!");
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            int idProduto = Integer.parseInt(txtIdProdutoSaida.getText());
            Produto p = produtoDAO.buscarPorId(idProduto);
            if (p != null) {
                txtProdutoSelecionado.setText(p.toString());
                produtoSelecionado = p;
            } else {
                JOptionPane.showMessageDialog(null, "Produto n??o encontrado!");
                txtProdutoSelecionado.setText("");
                produtoSelecionado = null;
            }
        } catch (DAOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto!");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEstoqueSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoqueSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaEstoqueSaida().setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar no banco!");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCadastroEstoqueSaida;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblIdProdutoSaida;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtIdProdutoSaida;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtProdutoSelecionado;
    private javax.swing.JTextField txtQuantidadeEstoque;
    // End of variables declaration//GEN-END:variables
}
