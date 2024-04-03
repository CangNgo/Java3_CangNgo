/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab6.bai2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Arrays.fill;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class StudentView extends javax.swing.JFrame {

    boolean addNew = false;
    boolean fill = false;
    Vector data = new Vector();
    Vector header = new Vector();
    Vector col = new Vector();
    Connection con = null;

    PreparedStatement pstDetails = null;
    PreparedStatement pstInsert = null;
    PreparedStatement pstDelete = null;
    PreparedStatement pstUpdate = null;
    String sqlInsert = "Insert into Students ([Name],Address,ParentName,Phone,standard) values(?,?,?,?,?)";
    String sqlDelete = "Delete from Students where Name=?";
    String sqlUpdate = "Update Students set Address=?, ParentName=?,Phone=? ,standard=? where Name=?";
    ResultSet rts;

    public StudentView() {
        initComponents();
        loadCombobox();
        setLocationRelativeTo(null);
        
        try {
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void loadCombobox() {
        String sql1 = "select Standard from STUDENTS";
        try (Connection con = Connec.Connec.openConnectionLab6bai2()) {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql1);
            Vector<String> standards = new Vector<String>();
            Vector<Integer> fees = new Vector<Integer>();
            cbxStand.removeAllItems();
            cbxFees.removeAllItems();
            while (rs.next()) {
                cbxStand.addItem(rs.getString(1));
                cbxFees.addItem(rs.getString("Standard"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.exit(0);
        }
    }

    private void loadData() throws SQLException {
        String sql = "Select Name, standard from Students";
        try (Connection con = Connec.Connec.openConnectionLab6bai2()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            data.removeAllElements();
            if (!fill) {
                //get header
                ResultSetMetaData rsmd = rs.getMetaData();
                int n = rsmd.getColumnCount();

                col.add(rsmd.getColumnName(1));
                col.add(rsmd.getColumnName(2));
            }
            //get data
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                data.add(v);
            }
            DefaultTableModel tbl = new DefaultTableModel(data, col);
            this.tblStudent.setModel(tbl);
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    boolean validates() {
        if (txtName.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "Name ko dc trong ", "Chu y", 1);
            txtName.requestFocus();
            return false;
        }
        String pName = this.txtName.getText().trim();
        Iterator it = data.iterator();
        while (it.hasNext()) {
            Vector v = (Vector) it.next();
            String name = ((String) v.get(0)).trim();
            if (pName.equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this, "Ten Sinh Vien nay da ton tai!");
                this.txtName.grabFocus();
                return false;
            }
        }
        if (txtAddress.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "Address khong duoc de trong ", "Chu y", 1);
            txtAddress.requestFocus();
            return false;
        }
        if (txtParent.getText().matches("^\\w+$") == false) {
            JOptionPane.showMessageDialog(this, "ParentsName khong duoc de trong ", "Chu y", 1);
            txtParent.requestFocus();
            return false;
        }

        if (txtContact.getText().matches("^\\d{7,11}$") == false) {
            JOptionPane.showMessageDialog(this, "Contact(Phone) khong duoc de trong va phai la 7-12 so ", "Chu y", 1);
            txtContact.requestFocus();
            return false;
        }
        if ((cbxStand.getSelectedIndex() == 0)) {
            JOptionPane.showMessageDialog(this, cbxStand.getSelectedItem());
        }
        return true;
    }

    boolean duplicate(String s) {
        if (addNew == false) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            Vector v = (Vector) data.get(i);
            if (s.equalsIgnoreCase((String) v.get(0))) {
                return true;
            }
        }
        return false;
    }

    private void clearForm() {
        txtName.setText("");
        txtAddress.setText("");
        txtParent.setText("");
        txtContact.setText("");
        cbxStand.setSelectedIndex(0);
        cbxFees.setSelectedIndex(0);
        txtName.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExitt = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtParent = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxStand = new javax.swing.JComboBox<>();
        cbxFees = new javax.swing.JComboBox<>();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblStudentMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("Parentname");

        jLabel4.setText("ContactNo");

        jLabel5.setText("Standard");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");

        btnEdit.setText("Edit");

        btnUpdate.setText("Update");

        btnExitt.setText("Exit");
        btnExitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExittActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPre.setText("Previous");

        btnNext.setText("Next");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel6.setText("Fees");

        cbxStand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxStand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStandActionPerformed(evt);
            }
        });

        cbxFees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExitt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContact)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxFees, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtParent, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(cbxStand, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnInsert)
                    .addComponent(btnEdit)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPre)
                    .addComponent(btnDelete)
                    .addComponent(btnExitt))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExittActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExittActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtName.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void cbxStandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStandActionPerformed
        // TODO add your handling code here:
        cbxFees.setSelectedItem(cbxStand.getSelectedIndex());
    }//GEN-LAST:event_cbxStandActionPerformed

    private void cbxFeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFeesActionPerformed
        // TODO add your handling code here:
        cbxStand.setSelectedItem(cbxFees.getSelectedIndex());

    }//GEN-LAST:event_cbxFeesActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        try {
            rts.beforeFirst();
            this.clearForm();
            int row = tblStudent.getSelectedRow();
            String name = (String) tblStudent.getValueAt(row, 0);
            while (rts.next()) {
                String str = rts.getString(2); //JOptionPane.showMessageDialog(null,""+jrs.getString(2)+" "+name);
                if (str.equalsIgnoreCase(name)) {
                    txtName.setText(rts.getString(2));
                    txtAddress.setText(rts.getString(3));
                    txtContact.setText(rts.getInt(5) + "");
                    //String parent=dencry(rts.getString(5));
                    txtParent.setText(rts.getString(4));
                    cbxStand.setSelectedItem(rts.getString(6));
                    //com_fees.setSelectedItem(rts.getInt(7));
                    break;
                }
            }
        } catch (Exception e) {
        }
        txtName.setEnabled(false);
        txtAddress.setEnabled(false);
        txtParent.setEnabled(false);
        txtContact.setEnabled(false);
        cbxStand.setEnabled(false);
        cbxFees.setEnabled(false);
    }//GEN-LAST:event_tblStudentMouseClicked

    private void tblStudentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseReleased
        // TODO add your handling code here:
        if (this.tblStudent.getCellEditor() != null)
            this.tblStudent.getCellEditor().cancelCellEditing();
    }//GEN-LAST:event_tblStudentMouseReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int n;
            if (addNew) {
                //them moi
                //set cac tham so
                pstInsert.setString(1, this.txtName.getText().trim());
                pstInsert.setString(2, txtAddress.getText().trim());
                pstInsert.setString(3, txtParent.getText().trim());
                pstInsert.setString(4, txtContact.getText().trim());
                pstInsert.setString(5, (String) cbxStand.getSelectedItem());
                n = pstInsert.executeUpdate();//thuc thi
                this.loadData();
            } else {
                //update
                //set cac tham so
                pstUpdate.setString(5, this.txtName.getText().trim());
                pstUpdate.setString(2, this.txtAddress.getText().trim());
                pstUpdate.setString(1, this.txtParent.getText().trim());
                pstUpdate.setString(3, this.txtContact.getText().trim());
                pstUpdate.setString(4, (String) cbxStand.getSelectedItem());
                n = pstUpdate.executeUpdate();//thuc thi
                this.loadData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExitt;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxFees;
    private javax.swing.JComboBox<String> cbxStand;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParent;
    // End of variables declaration//GEN-END:variables
}
