/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ReadCard;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import libraries.My_func;
import libraries.SessionsDP;
import main.RMIConnector;
import models.B_account_type;
import models.B_payment_type;
import models.DBConn;
import models.M_account_type;
import models.M_payment_type;

/**
 *
 * @author umarmukhtar
 */
public class PaparanTerminal extends javax.swing.JFrame {

    private static Thread t1 = new Thread(new ReadCard());
    public static String currentCardID = "";
    
    /**
     * Creates new form PaparanTerminal
     */
    public PaparanTerminal() {
        initComponents();
        
        txt_receiver.setText(SessionsDP.getMe_username());
        
        M_account_type mat = new M_account_type();
        B_account_type bat[] = mat.getAll(2);
        for (int i = 0; i < bat.length; i++) {
            cbx_at.addItem(bat[i]);
        }
        
        M_payment_type mpt = new M_payment_type();
        B_payment_type bpt[] = mpt.getAll(3);
        for (int i = 0; i < bpt.length; i++) {
            cbx_pt.addItem(bpt[i]);
        }
        
        t1.start();
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
        txt_cardid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_papar = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbx_at = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_receiver = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbx_pt = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_notes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DinarPal's Debit Gram Terminal");

        txt_cardid.setEditable(false);
        txt_cardid.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txt_cardid.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Customer Details :-");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setText("<html><center>DinarPal's Debit Gram<br />Merchant Panel</center></html>");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_papar.setEditable(false);
        txt_papar.setColumns(20);
        txt_papar.setRows(5);
        jScrollPane1.setViewportView(txt_papar);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Price of Goods/Services :-");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Account Type : ");

        jLabel5.setText("Amount : ");

        jLabel6.setText("Receiver : ");

        txt_receiver.setEditable(false);

        jLabel7.setText("Payment Type : ");

        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Notes : ");

        txt_notes.setColumns(20);
        txt_notes.setRows(5);
        jScrollPane2.setViewportView(txt_notes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_amount)
                                    .addComponent(cbx_at, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_receiver)
                                    .addComponent(cbx_pt, 0, 142, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_receiver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_at, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbx_pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txt_cardid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cardid, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        t1.interrupt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clearField();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String me_username_from = ReadCard.me_username_from;
        String me_username_to = txt_receiver.getText();
        int at_index = cbx_at.getSelectedIndex();
        String amount = txt_amount.getText();
        int pt_index = cbx_pt.getSelectedIndex();
        String tr_notes = txt_notes.getText();
        
        RMIConnector rmic = new RMIConnector(DBConn.getHost(), DBConn.getPort_rmi());
        ArrayList<String> me_from = rmic.me_getData(me_username_from);
        if (me_from.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid customer!", "Checking Account", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<String> me_to = rmic.me_getData(me_username_to);
        if (me_to.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid merchant!", "Checking Account", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String me_fullname_from = me_from.get(2) + " " + me_from.get(3);
        String me_fullname_to = me_to.get(2) + " " + me_to.get(3);
        int me_id_from = 0;
        int me_id_to = 0;
        try {
            me_id_from = Integer.parseInt(me_from.get(0));
        } catch (Exception e) {
            me_id_from = 0;
            JOptionPane.showMessageDialog(null, "Invalid customer!", "Checking Account", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            me_id_to = Integer.parseInt(me_to.get(0));
        } catch (Exception e) {
            me_id_to = 0;
            JOptionPane.showMessageDialog(null, "Invalid merchant!", "Checking Account", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double tr_amount = 0.0;
        String str_amount = "0.0";
        try {
            tr_amount = Double.parseDouble(amount);
            String tr_amount2 = My_func.getDPGDPSUnit(tr_amount);
            double tr_amount3 = Double.parseDouble(tr_amount2);
            if (tr_amount != tr_amount3) {
                JOptionPane.showMessageDialog(null, "Invalid amount!", "Checking Account", JOptionPane.ERROR_MESSAGE);
                return;
            }
            str_amount = My_func.getStrDPGDPSUnit(tr_amount);
        } catch (Exception e) {
            tr_amount = 0.0;
            str_amount = "0.0";
            JOptionPane.showMessageDialog(null, "Invalid amount!", "Checking Account", JOptionPane.ERROR_MESSAGE);
            return;
        }
        B_account_type bat = (B_account_type) cbx_at.getItemAt(at_index);
        int at_id = 0;
        String at_desc = "";
        try {
            at_id = Integer.parseInt(bat.getAt_id());
            at_desc = bat.getAt_desc();
        } catch (Exception e) {
            at_id = 0;
            at_desc = "";
        }
        B_payment_type bpt = (B_payment_type) cbx_pt.getItemAt(pt_index);
        int pt_id = 0;
        String pt_desc = "";
        try {
            pt_id = Integer.parseInt(bpt.getPt_id());
            pt_desc = bpt.getPt_desc();
        } catch (Exception e) {
            pt_id = 0;
            pt_desc = "";
        }
        
        String str_cust = "";
        try {
            for (int i = 0; i < My_func.STR_LIMIT; i++) {
                str_cust += me_fullname_from.charAt(i);
            }
        } catch (Exception e) {
        }
        if (me_fullname_from.length() > My_func.STR_LIMIT) {
            str_cust += " ...";
        }
        String str_merchant = "";
        try {
            for (int i = 0; i < My_func.STR_LIMIT; i++) {
                str_merchant += me_fullname_to.charAt(i);
            }
        } catch (Exception e) {
        }
        if (me_fullname_to.length() > My_func.STR_LIMIT) {
            str_merchant += " ...";
        }
        String str_notes = "";
        try {
            for (int i = 0; i < My_func.STR_LIMIT; i++) {
                str_notes += tr_notes.charAt(i);
            }
        } catch (Exception e) {
        }
        if (tr_notes.length() > My_func.STR_LIMIT) {
            str_notes += " ...";
        }
        
        ConfirmReceipt cr = new ConfirmReceipt();
        cr.lbl_customer.setText(str_cust);
        cr.lbl_merchant.setText(str_merchant);
        cr.cr_me_id_from = me_id_from;
        cr.cr_me_id_to = me_id_to;
        cr.cr_tr_amount = tr_amount;
        cr.cr_at_id = at_id;
        cr.cr_pt_id = pt_id;
        cr.cr_notes = tr_notes;
        cr.lbl_notes.setText(str_notes);
        cr.lbl_amount.setText(at_desc + " " + str_amount + " grams");
        cr.lbl_pt.setText(pt_desc);
        cr.cr_card_id = currentCardID;
        cr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void clearField() {
        txt_cardid.setText("");
        txt_papar.setText("");
        txt_receiver.setText(SessionsDP.getMe_username());
        cbx_at.setSelectedIndex(0);
        txt_amount.setText("");
        cbx_pt.setSelectedIndex(0);
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PaparanTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PaparanTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PaparanTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PaparanTerminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PaparanTerminal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cbx_at;
    public static javax.swing.JComboBox cbx_pt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField txt_amount;
    public static javax.swing.JTextField txt_cardid;
    public static javax.swing.JTextArea txt_notes;
    public static javax.swing.JTextArea txt_papar;
    public static javax.swing.JTextField txt_receiver;
    // End of variables declaration//GEN-END:variables
}
