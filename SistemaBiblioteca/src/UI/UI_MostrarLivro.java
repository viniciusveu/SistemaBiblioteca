/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import sistemabiblioteca.Biblioteca;

/**
 *
 * @author vedovotto
 */
public class UI_MostrarLivro extends javax.swing.JInternalFrame {
    Biblioteca b;
    /**
     * Creates new form UI_MostrarLivro
     */
    public UI_MostrarLivro(Biblioteca b) {
        initComponents();
        this.b = b;
        txtRelatorio.setText(b.listarLivros());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLabel = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Relatório Livros");

        lblLabel.setText("Todos os Livros");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos os Livros", "Livros Disponíveis", "Livros Emprestados", "Livros Atrasados" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        txtRelatorio.setColumns(20);
        txtRelatorio.setRows(5);
        jScrollPane1.setViewportView(txtRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLabel)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        int selecionado = cbxTipo.getSelectedIndex();

        switch (selecionado) {
            case 0:
            lblLabel.setText("Todos os Livros");
            txtRelatorio.setText(b.listarLivros());
            break;
            case 1:
            lblLabel.setText("Livros Emprestados");
            txtRelatorio.setText(b.listarAlunos());
            break;
            case 2:
            lblLabel.setText("Livros Atrasados");
            txtRelatorio.setText(b.listarProfessor());
            break;
            default:
            txtRelatorio.setText("Não implementado");

        }
    }//GEN-LAST:event_cbxTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLabel;
    private javax.swing.JTextArea txtRelatorio;
    // End of variables declaration//GEN-END:variables
}
