/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pacote.Tela;

import br.entidade.academia.Cliente;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pacote.clienteDao.ClienteDao;
import pacote.clienteDao.ClienteDaoImp;

/**
 *
 * @author arthu
 */
public class pesquisarTela extends javax.swing.JFrame {

    /**
     * Creates new form pesquisarTela
     */
    // nego veio
    private Cliente cliente;
    private DefaultTableModel tabelaModelo;
    private ClienteDao clienteDao = new ClienteDaoImp();
    private List<Cliente> clientes;

    public pesquisarTela(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
    }

    public pesquisarTela() {
        initComponents();
        getContentPane().setBackground(new Color(70,80,70));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPesq = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCli = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbPesq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPesq.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPesq.setText("Buscar por nome:");

        btPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setToolTipText("");
        btPesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tabelaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "sobreNome", "sexo", "peso", "altura", "endereco", "cidade_estado", "email"
            }
        ));
        jScrollPane2.setViewportView(tabelaCli);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varNome, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesq)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btAlterar))
                .addGap(168, 168, 168))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String nome = varNome.getText().trim();
        if (nome.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite um nome > 3 ! ");
        } else {
            varNome.setText("");
            try {
                clientes = clienteDao.pesquisarNomes(nome);
                popularTabela();
                varNome.setText("");
            } catch (Exception e) {
                System.out.println("Erro ao pesquisar por nome");
            }
        }


    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tabelaCli.getSelectedRow();
        cliente = clientes.get(linhaSelecionada);

        try {
            clienteDao.excluirCliente(cliente.getMatricula());
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            clientes.remove(linhaSelecionada);
            popularTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linhaSelecionada = tabelaCli.getSelectedRow();
        try {
            Cliente cliente = clientes.get(linhaSelecionada);
            new cadastroTela(cliente).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados" + e.getMessage());
        }
    }//GEN-LAST:event_btAlterarActionPerformed
    private void popularTabela() {
        tabelaModelo = (DefaultTableModel) tabelaCli.getModel();
        tabelaModelo.setNumRows(0);
        for (Cliente cliente : clientes) {
            tabelaModelo.addRow(new Object[]{cliente.getMatricula(), cliente.getNomeCliente(),
                 cliente.getSobreNomeCliente(), cliente.getSexoCliente(), cliente.getPesoCliente(),
                 cliente.getAlturaCliente(), cliente.getEndereçoCliente(),
                 cliente.getCidadeEstadoCliente(), cliente.getEmail()});
        }
    }

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
            java.util.logging.Logger.getLogger(pesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pesquisarTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pesquisarTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbPesq;
    private javax.swing.JTable tabelaCli;
    private javax.swing.JTextField varNome;
    // End of variables declaration//GEN-END:variables
}