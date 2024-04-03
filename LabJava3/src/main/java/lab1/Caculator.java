package lab1;

import javax.swing.JOptionPane;

public class Caculator extends javax.swing.JFrame {
    public Caculator() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean CheckNull() {
        if (txtFrist.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập first number");
            return false;
        }
        if (txtSecond.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập second number");
            return false;
        }
        return true;
    }

    private boolean CheckNumber() {
        try {
            double first = Double.parseDouble(txtFrist.getText());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Xin mời nhập first number là số");
            return false;
        }
        try {
            double second = Double.parseDouble(txtSecond.getText());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Xin mời nhập second number là số");
            return false;
        }
        return true;
    }

    private void Calculus(String cal) {
        if (!CheckNull()) {
            return;
        }
        if (!CheckNumber()) {
            return;
        }
        Double frist = Double.parseDouble(txtFrist.getText());
        Double second = Double.parseDouble(txtSecond.getText());
        double result = 0;
        switch (cal) {
            case "+": {
                result = frist + second;
                break;
            }
            case "-": {
                result = frist - second;
                break;
            }
            case "*": {
                result = frist * second;
                break;
            }
            case "/": {
                result = (frist * 10 / second) * 0.1;
                break;
            }
            default:
                JOptionPane.showMessageDialog(this, "Xin mời chọn lại phép t");
                break;
        }

        txtResult.setText(String.valueOf(result));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFrist = new javax.swing.JTextField();
        txtSecond = new javax.swing.JTextField();
        txtResult = new javax.swing.JTextField();
        btnMinus = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnMulti = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Frist number");

        jLabel2.setText("Second number");

        jLabel3.setText("Result");

        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnMulti.setText("*");
        btnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiActionPerformed(evt);
            }
        });

        btnDiv.setText("/");
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(56, 56, 56)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtSecond)
                                                        .addComponent(txtFrist)
                                                        .addComponent(txtResult, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                151, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(167, 167, 167)
                                                .addComponent(btnMinus)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnMulti)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDiv)))
                                .addContainerGap(91, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(btnAdd)
                                        .addContainerGap(252, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtFrist, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtSecond, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMinus)
                                        .addComponent(btnMulti)
                                        .addComponent(btnDiv))
                                .addContainerGap(81, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(194, Short.MAX_VALUE)
                                        .addComponent(btnAdd)
                                        .addGap(81, 81, 81))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMinusActionPerformed

        Calculus("-");
    }// GEN-LAST:event_btnMinusActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed

        Calculus("+");
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMultiActionPerformed

        Calculus("*");
    }// GEN-LAST:event_btnMultiActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDivActionPerformed

        Calculus("/");
    }// GEN-LAST:event_btnDivActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMulti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtFrist;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtSecond;
    // End of variables declaration//GEN-END:variables
}
