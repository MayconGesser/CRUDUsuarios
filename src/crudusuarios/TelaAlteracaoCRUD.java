/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudusuarios;

import java.util.HashMap;
import javax.swing.JOptionPane;
import util.Util;

/**
 *
 * @author maycon
 */
public class TelaAlteracaoCRUD extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;
    private TelaPrincipalCRUD pai;
    private Util util;

    /**
     * Creates new customizer TelaAlteracaoCRUD
     */
    public TelaAlteracaoCRUD(HashMap<String,String> dados, TelaPrincipalCRUD pai) {
        initComponents();
        this.pai = pai; 
        this.util = new Util();
        this.ctCod.setText(dados.get("Código"));
        this.ctNome.setText(dados.get("Nome"));
        this.ctTel.setText(dados.get("Telefone"));
        this.ctEmail.setText(dados.get("Email"));
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        ctNome = new javax.swing.JTextField();
        lbTel = new javax.swing.JLabel();
        ctTel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ctEmail = new javax.swing.JTextField();
        btAlt = new javax.swing.JButton();
        lbCod = new javax.swing.JLabel();
        ctCod = new javax.swing.JTextField();
        btSair = new javax.swing.JButton();

        lbNome.setText("Nome");

        lbTel.setText("Telefone");

        jLabel1.setText("Email");

        btAlt.setText("Alterar");
        btAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltActionPerformed(evt);
            }
        });

        lbCod.setText("Código");

        ctCod.setEditable(false);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAlt)
                        .addGap(71, 71, 71)
                        .addComponent(btSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lbTel)
                            .addComponent(lbNome)
                            .addComponent(lbCod))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ctNome)
                            .addComponent(ctTel)
                            .addComponent(ctEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(ctCod, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCod))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(ctNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTel)
                    .addComponent(ctTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ctEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlt)
                    .addComponent(btSair))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltActionPerformed
        
        int resposta = this.util.confirm("Deseja alterar os dados do usuário?");
        if(resposta != JOptionPane.YES_OPTION){return;}
        HashMap<String,String> dados = new HashMap<>();
        dados.put("Nome",this.ctNome.getText());
        dados.put("Email",this.ctEmail.getText());
        String telefone = ""; 
        try{
            long tel = Long.parseLong(this.ctTel.getText());
            telefone = String.valueOf(tel);
        }catch(NumberFormatException e){
            this.util.lancaExcessao("Certifique-se que o campo telefone possui apenas algarismos numéricos");
            return;
        }
        dados.put("Telefone",telefone);
        ControladorBean.alteraUsuario(Integer.parseInt(this.ctCod.getText()), dados);
        this.pai.setDadosTabela(ControladorBean.getUsuarios());
        this.util.lancaMessage("Usuário alterado com sucesso!");
    }//GEN-LAST:event_btAltActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        
    }//GEN-LAST:event_btSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlt;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField ctCod;
    private javax.swing.JTextField ctEmail;
    private javax.swing.JTextField ctNome;
    private javax.swing.JTextField ctTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCod;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTel;
    // End of variables declaration//GEN-END:variables
}
